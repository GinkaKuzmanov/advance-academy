package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;
import bg.baradvance.models.Order;
import bg.baradvance.models.Product;
import bg.baradvance.repositories.ProductRepo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProductPanel extends JPanel  {
    AdvanceAcademyBarFrame barFrame;
    ProductRepo productRepo = new ProductRepo();
    List<Product> productList = productRepo.getProductList();
    Order order;
    JButton eraseOrder;
    JButton applyButton;
    JButton pBtn;

    //to save the state of buttons
    JButton [] buttonsArray = new JButton[productList.size()];


    public ProductPanel(AdvanceAcademyBarFrame barFrame) {
        super(new FlowLayout());
        this.barFrame = barFrame;
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            pBtn = new JButton
                    (product.getName() + " " + product.getQuantity());
            pBtn.addActionListener(e -> {
                this.barFrame.products.add(product);
            });
            buttonsArray[i] = pBtn;
            barFrame.add(buttonsArray[i]);
        }
        eraseOrder = new JButton("Erase Order");
        add(eraseOrder);
        eraseOrder.addActionListener(e -> {
            int res = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the order?", "Deletion",
                    JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION){
                barFrame.repo.remove(barFrame.currentTableNumber);
                JOptionPane.showMessageDialog(null,
                        "Order deleted",
                        "Deletion"
                ,JOptionPane.INFORMATION_MESSAGE);
            }
        });
        applyButton = new JButton("Apply");
        add(applyButton);
        applyButton.addActionListener(e -> {
                //TODO:to put the order into the map
           int result = JOptionPane.showConfirmDialog(null
                   ,"Do you want to apply this order"
                   ,"Confirm"
            ,JOptionPane.OK_CANCEL_OPTION);
           if(result == JOptionPane.OK_OPTION) {
               order = new Order(barFrame.currentTableNumber
                       ,barFrame.currentWaiter,
                       this.barFrame.products);
               barFrame.repo.save(order);
               //TODO: fix the showing of panels
               barFrame.returnToOperation();
           }
        });

    }

}
