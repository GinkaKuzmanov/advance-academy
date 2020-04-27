package managers;

import com.google.gson.Gson;

import entities.Candidate;
import entities.JobAdvertisement;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

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
        candidate.setFirm(adKeyToConnect.getFirmName());
        adKeyToConnect.increaseCandidatesCount();
        this.candidates.add(candidate);
        try {
            this.candidateFileDatabaseManager.insertCandidateInto(json.toJson(this.candidates));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadCandidatesFromDatabase(String firm) {
        this.candidates = this.candidateFileDatabaseManager.readDataFromFile();
        filterCandidatesByFirm(firm);
    }


    public void filterCandidatesByFirm(String firm){
        this.candidatesModel.setRowCount(0);
        for (Candidate c : candidates) {
            if(c.getFirm().equals(firm)){
                updateTableModelCandidates(c);
            }
        }
    }



    private void updateTableModelCandidates(Candidate c) {
        Object[] cDetails = new Object[4];
        cDetails[0] = c.getFName() + " " + c.getMName() + " " + c.getSName();
        cDetails[1] = c.getPhoneNumber();
        cDetails[2] = c.getWorkExperience();
        cDetails[3] = c.getCoverLetter();
        this.candidatesModel.addRow(cDetails);
    }


}
