package views;

import entities.JobAdvertisement;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.ArrayList;

//TODO:Dva butona pokaji kandidati i pokaji vsichki obqvi

public class JobsPanel extends JPanel {
    //za da imam dostap do modeli i view
    public MainFrame mainFrame;

    public JTextField searchField;
    public JButton searchBtn;

    public JTable allAdsTable;
    public JTable firmsTable;

    public JButton applicantsButton;

    public JButton goToAdvertPanelBtn;

    public JButton filterAdTableButton;

    public JButton removeAdFromTableBtn;

    public JButton showAllAdvertisementsBtn;

    public JButton showAllCandidatesBtn;


    public JobsPanel(MainFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;
        //opcia za tarsene po poziciq

        this.searchField = new JTextField("Search:");
        add(searchField);

        this.searchBtn = new JButton("Find position");
        this.searchBtn.addActionListener(e -> {
            String searched = this.searchField.getText();
            mainFrame.dataManager.searchByPosition(searched);
            this.searchField.setText("Search:");
        });
        add(searchBtn);


        //TODO: through button apply now I will add the jobOffer to my Map
        //TODO: only if index != -1 switch views and go to candidatePanel
        this.applicantsButton = new JButton("APPLY FOR");
        this.applicantsButton.addActionListener(e -> {
            int index = this.allAdsTable.getSelectedRow();
            if (index != -1) {
//                setOfferToCandidate();
                mainFrame.hideJobsPanel();
                mainFrame.showCandidatePanel();
            }
        });
        add(this.applicantsButton);

        this.goToAdvertPanelBtn = new JButton("ADD JOB OFFER");
        this.goToAdvertPanelBtn.addActionListener(e ->
        {
            mainFrame.hideJobsPanel();
            mainFrame.showAdvertPanel();
        });
        add(this.goToAdvertPanelBtn);

        this.filterAdTableButton = new JButton("FILTER BY FIRM");
        this.filterAdTableButton.addActionListener(e -> filterContent());
        add(this.filterAdTableButton);

        this.removeAdFromTableBtn = new JButton("REMOVE SELECTED JOB OFFER");
        this.removeAdFromTableBtn.addActionListener(e -> removeContentFromAdTable());
        add(this.removeAdFromTableBtn);

        this.showAllAdvertisementsBtn = new JButton("ALL ADVERTISEMENTS");
        this.showAllAdvertisementsBtn.addActionListener(e -> mainFrame.dataManager.updateAdTableData());
        add(this.showAllAdvertisementsBtn);

        this.showAllCandidatesBtn = new JButton("ALL CANDIDATES");
        this.showAllCandidatesBtn.addActionListener(e -> {
            int index = this.allAdsTable.getSelectedRow();
            if(index != -1) {
                mainFrame.hideJobsPanel();
                mainFrame.candidateDataManager.loadCandidatesFromDatabase();
                mainFrame.showAllCandidatesPanel();
            }
        });
        add(this.showAllCandidatesBtn);




        //tablica s obiavite
        this.allAdsTable = new JTable();
        this.allAdsTable.setDefaultEditor(Object.class, null);
        JScrollPane pane = new JScrollPane();

        this.allAdsTable.setModel(mainFrame.dataManager.model);
        pane.setViewportView(this.allAdsTable);
        add(pane);


        //tablica s firmite
        this.firmsTable = new JTable();
        this.firmsTable.setDefaultEditor(Object.class, null);
        JScrollPane firmPane = new JScrollPane();

        this.firmsTable.setModel(mainFrame.dataManager.firmsOnlyModel);
        firmPane.setViewportView(this.firmsTable);
        add(firmPane);

        mainFrame.dataManager.loadFromDatabase();

        mainFrame.dataManager.loadFirmsFromDatabase();

      

        setVisible(true);
    }



    private void removeContentFromAdTable(){
        int index = this.allAdsTable.getSelectedRow();

        if(index != -1) {
            mainFrame.dataManager.removeAdTableData(index);
        }
    }

    private void filterContent() {
        //ot tablicata s firmite vzimame indexa na reda;

        int index = this.firmsTable.getSelectedRow();
        TableModel firmModel = this.firmsTable.getModel();

        if(index != -1) {
            String selectedFirm = (String) firmModel.getValueAt(index, 0);
            mainFrame.dataManager.searchByFirmName(selectedFirm);
        }
    }

//    private void setOfferToCandidate() {
//        ArrayList<JobAdvertisement> temp = mainFrame.dataManager.getJobAds();
//        int selectedIdx = this.allAdsTable.getSelectedRow();
//        mainFrame.candidateDataManager.adKeyToConnect = temp.get(selectedIdx);
//    }

}
