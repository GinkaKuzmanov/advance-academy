package auto_advertisement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdFrame extends JFrame implements ActionListener {
    //create first car, then an ad for this car using components for input params
    private JButton createCarAdButton, deleteCarAdButton;
    private JTextField carYearProducedField, carBrandField, carModelField;
    private JTextField adTitleField;
    private JTextArea adDescriptionField;
    private JLabel showInfoLabel;
    private ArrayList<CarAdvertisement> carAdsList = new ArrayList<>();

    public AdFrame() {
        //components for car
        super("Car advertisements");
        showInfoLabel = new JLabel("Car specifications:");
        add(showInfoLabel);
        JLabel yearLbl = new JLabel("Year");
        add(yearLbl);
        carYearProducedField = new JTextField();
        carYearProducedField.setPreferredSize(new Dimension(100, 20));
        add(carYearProducedField);

        JLabel brandLabel = new JLabel("Brand");
        add(brandLabel);
        carBrandField = new JTextField();
        carBrandField.setPreferredSize(new Dimension(100, 20));
        add(carBrandField);

        JLabel modelLabel = new JLabel("Model");
        add(modelLabel);
        carModelField = new JTextField();
        carModelField.setPreferredSize(new Dimension(100, 20));
        add(carModelField);

        JLabel titleLabel = new JLabel("Title");
        add(titleLabel);
        adTitleField = new JTextField();
        adTitleField.setPreferredSize(new Dimension(100, 20));
        add(adTitleField);

        JLabel descLabel = new JLabel("Description");
        add(descLabel);
        adDescriptionField = new JTextArea();
        adDescriptionField.setPreferredSize(new Dimension(100, 50));
        add(adDescriptionField);

        //components for info;
        createCarAdButton = new JButton("Create Advert");
        add(createCarAdButton);
        createCarAdButton.addActionListener(this);

        deleteCarAdButton = new JButton("Delete Adverts");
        add(deleteCarAdButton);
        deleteCarAdButton.addActionListener(this);


        pack();
    }

    public CarAdvertisement createAdvertisementAction() {
        String adTitle = adTitleField.getText();
        String adDescription = adDescriptionField.getText();
        CarAdvertisement carAdvertisement = new CarAdvertisement(adTitle, adDescription, createCarAction());
        carAdsList.add(carAdvertisement);
        return carAdvertisement;
    }

    private Car createCarAction() {
        String brand = carBrandField.getText();
        String model = carModelField.getText();
        String year = carYearProducedField.getText();

        return new Car(brand, model, year);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createCarAdButton) {
            if (!carYearProducedField.getText().matches("^\\d{4}$")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid year!",
                        "Warning", JOptionPane.ERROR_MESSAGE);
                return;
            }
            System.out.println(createAdvertisementAction());
            carYearProducedField.setText("");
            carModelField.setText("");
            carBrandField.setText("");
            adTitleField.setText("");
            adDescriptionField.setText("");
        }

        if (e.getSource() == deleteCarAdButton) {
            if (carAdsList.size() > 0) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete ads?", "Delete",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    carAdsList.clear();
                    carYearProducedField.setText("");
                    carModelField.setText("");
                    carBrandField.setText("");
                    adTitleField.setText("");
                    adDescriptionField.setText("");
                    System.out.println("Adverts Deleted!");
                }

            }
        }
    }

}
