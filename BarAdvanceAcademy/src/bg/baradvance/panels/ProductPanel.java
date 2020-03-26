package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;
import bg.baradvance.models.Product;
import bg.baradvance.repositories.ProductRepo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProductPanel extends JPanel {
    ProductRepo productRepo = new ProductRepo();
    List<Product> productList = productRepo.getProductList();
    AdvanceAcademyBarFrame barFrame;
    JButton eraseOrder;

    public ProductPanel(AdvanceAcademyBarFrame barFrame){
        super(new FlowLayout());
        this.barFrame = barFrame;
        for (Product product : productList) {
            this.add(new JButton(product.getName() + " " + product.getQuantity()));
        }
        eraseOrder = new JButton("Erase Order");
        add(eraseOrder);
        eraseOrder.addActionListener(e -> {
            int res =JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the order?","Deletion",
                    JOptionPane.YES_NO_OPTION);
//            if(res == JOptionPane.YES_OPTION){
//
//            }
        });

    }

}
