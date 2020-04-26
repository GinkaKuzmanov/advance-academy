package managers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import entities.Candidate;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CandidateFileDatabaseManager {
    public String fileForCandidates = "candidatesInfo.txt";
    public Gson gson = new Gson();

    //insert into file

    public void insertCandidateInto(String myData) throws IOException {
        File candidatesFile = new File(fileForCandidates);
        if (!candidatesFile.exists()) {
            candidatesFile.createNewFile();
        }
        candidatesFile.delete();
        //Writes with a buffer, must use try-with-resources
        try (FileWriter adWriter = new FileWriter(candidatesFile.getAbsoluteFile(), true);
             BufferedWriter bufferedWriter = new BufferedWriter(adWriter)) {
            bufferedWriter.write(myData);
        }
    }

    //May not work through interface, rather than HashMap
    public ArrayList<Candidate> readDataFromFile() {
        File candidatesFile = new File(fileForCandidates);
        if (!candidatesFile.exists()) {
            System.out.println("File doesn't exist");
        }

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(candidatesFile),
                StandardCharsets.UTF_8); JsonReader jReader = new JsonReader(reader)) {

            Type mapType = new TypeToken<ArrayList<Candidate>>() {
            }.getType();
            //returns a Map<JobAdvertisement, ArrayList<Candidate>>>
            log("Data loaded successfully" + fileForCandidates);
            return new Gson().fromJson(reader, mapType);
        } catch (IOException npe) {
            log("an exception occurred.");
            return null;
        }
    }

    //remove user from file
//    public void removeCandidateFrom(JobAdvertisement ad, Candidate person) {
//        File adFile = new File(fileForCandidates);
//        if (!adFile.exists()) {
//            log("File not existing");
//        }
//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(adFile), "UTF-8");
//             JsonReader jsReader = new JsonReader(isr)) {
//
//            Type mapType = new TypeToken<HashMap<JobAdvertisement, ArrayList<Candidate>>>() {
//            }.getType();
//            HashMap<JobAdvertisement, ArrayList<Candidate>> candidatesMap = new Gson().fromJson(jsReader, mapType);
//
//            candidatesMap.get(ad).removeIf(candidate -> {
//                String cName = candidate.getFName() + candidate.getSName();
//                String pName = person.getFName() + person.getSName();
//                return cName.equals(pName);
////            });
//
//            insertCandidateInto(gson.toJson(candidatesMap,HashMap.class));
//            log("Removed:" + person.getFName() + " " + person.getSName() + "from database");
//
//
//        } catch (IOException e) {
//            log("error");
//        }
//
//    }


    public void log(String string) {
        System.out.println(string);
    }

}
