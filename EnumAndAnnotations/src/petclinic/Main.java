package petclinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //for helping structures of data;\
        Map<String, Pet> pets = new LinkedHashMap<>();
        Map<String, Clinic> clinics = new LinkedHashMap<>();


        int lines = Integer.parseInt(reader.readLine());
        while (lines-- > 0) {
            String line = reader.readLine();
            String[] cmdArgs = line.split("\\s+");
            String command = cmdArgs[0];
            switch (command) {
                case "Create":
                    if (cmdArgs[1].equals("Pet")) {
                        Pet pet = new Pet(cmdArgs[2], Integer.parseInt(cmdArgs[3]), cmdArgs[4]);
                        pets.put(pet.getName(), pet);
                    } else if (cmdArgs[1].equals("Clinic")) {
                        try {
                            Clinic clinic = new Clinic(cmdArgs[2], Integer.parseInt(cmdArgs[3]));
                            clinics.put(clinic.getName(), clinic);
                        } catch (UnsupportedOperationException uoe) {
                            System.out.println(uoe.getMessage());
                        }
                    }
                    break;
                case "Add":
                    //shte vzemem imeto ot console input;
                    System.out.println(clinics.get(cmdArgs[2]).addPetInClinic(pets.get(cmdArgs[1])));
                    break;

                case "Release":
                    System.out.println(clinics.get(cmdArgs[1]).releasePetFromClinic());
                    break;

                case "HasEmptyRooms":
                    System.out.println(clinics.get(cmdArgs[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if(cmdArgs.length == 3){
                        clinics.get(cmdArgs[1]).printSpecificRoom(Integer.parseInt(cmdArgs[2]));
                    }else{
                        clinics.get(cmdArgs[1]).printAllRooms();
                    }
                    break;
            }


        }


    }
}
