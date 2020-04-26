package managers;

import com.google.gson.Gson;
import entities.Candidate;
import entities.JobAdvertisement;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CandidateDataManager {

    private ArrayList<Candidate> candidates;

    //set
    public JobAdvertisement adKeyToConnect;
    //set
    public DefaultTableModel candidatesModel;

    public CandidateFileDatabaseManager candidateFileDatabaseManager = new CandidateFileDatabaseManager();

    public Gson json = new Gson();


    public CandidateDataManager() {
        this.candidates = new ArrayList<>();
    }


    public void addCandidate(String fName, String mName, String sName, String number, int jobXp,
                             String coverLetter) {

        Candidate candidate = new Candidate(fName, mName, sName, number, jobXp, coverLetter);

        try {
            this.candidateFileDatabaseManager.insertCandidateInto(json.toJson(this.candidates));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadCandidatesFromDatabase() {

        updateCandidateTable();
    }


    public void updateCandidateTable() {
        this.candidatesModel.setRowCount(0);
        //ot tuk shte update tablicata s vsichki kandidati na opredelena oferta
        ArrayList<Candidate> cList = this.candidateFileDatabaseManager.readDataFromFile();
        //"Names","Phone","Work Experience","Cover Letter"
        for (Candidate candidate : cList) {
            Object[] cDetails = new Object[4];
            cDetails[0] = candidate.getFName() + " " + candidate.getMName() + " " + candidate.getSName();
            cDetails[1] = candidate.getPhoneNumber();
            cDetails[2] = candidate.getWorkExperience();
            cDetails[3] = candidate.getCoverLetter();
            this.candidatesModel.addRow(cDetails);
        }
    }



}
