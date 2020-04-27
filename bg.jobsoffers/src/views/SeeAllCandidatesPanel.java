package views;

//TODO: Таблица с всичките кандидати ще се показва когато селектираме дадена обява и натиснем
//бутона "Покажи кандидати". На тази таблица ще се показва всичко, което при
//кандидатстване е било въведено. -> through Jobs Panel /Mainframe that contains all managers./


import javax.swing.*;

public class SeeAllCandidatesPanel extends JPanel {

    private final MainFrame mainFrame;

    public JTable candidateTable;

    public JButton returnButton;

    public SeeAllCandidatesPanel(MainFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;

        this.returnButton = new JButton("RETURN");
        this.returnButton.addActionListener(e -> {
            mainFrame.hideAllCandidatesPanel();
            mainFrame.showJobsPanel();
        });
        add(this.returnButton);

        JScrollPane pane = new JScrollPane();
        this.candidateTable = new JTable();

        this.candidateTable.setModel(mainFrame.candidateDataManager.candidatesModel);
        pane.setViewportView(this.candidateTable);
        add(pane);


    }


}
