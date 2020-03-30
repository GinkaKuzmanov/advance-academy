package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;
import bg.baradvance.models.Order;
import bg.baradvance.models.Product;
import bg.baradvance.repositories.ProductData;

import javax.swing.*;
import java.util.List;

public class ProductPanel extends JPanel {

    AdvanceAcademyBarFrame barFrame;
    ProductData productData = new ProductData();
    List<Product> productList = productData.getProductList();
    Order order = new Order();
    JButton eraseOrder;
    JButton applyButton;
    JButton jButtonProducts;
    //to save the state of buttons


    public ProductPanel(AdvanceAcademyBarFrame barFrame) {
        this.barFrame = barFrame;
        //GENERATING PRODUCT BUTTONS BASED ON PRODUCTS COUNT
        for (Product product : productList) {
            jButtonProducts = new JButton
                    (product.getName() + " " + product.getQuantity());
            jButtonProducts.addActionListener(
                    e -> {
                        this.barFrame.products.add(product);
                        order.setChosenProducts(this.barFrame.products);
                        if (AdvanceAcademyBarFrame.operationState == 2) {
                            order.addToExistingOrder(product);
                        }
                    });
            add(jButtonProducts);

        }


        eraseOrder = new JButton("Erase Order");
        add(eraseOrder);

        applyButton = new JButton("Apply");

        eraseOrder.addActionListener(e -> {
            int res = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the order?", "Deletion",
                    JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                barFrame.repo.remove(barFrame.currentTableNumber);
                //REMOVE THE INSTANCE
                order = null;
                JOptionPane.showMessageDialog(null,
                        "Order deleted",
                        "Deletion"
                        , JOptionPane.INFORMATION_MESSAGE);
                barFrame.hideProductPanel();
                barFrame.showOperationPanel();

            }
        });
        //Finishes the order and returns to login

        add(applyButton);
        applyButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null
                    , "Do you want to apply this order"
                    , "Confirm"
                    , JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                order.setTableNumber(this.barFrame.currentTableNumber);
                order.setWaiter(this.barFrame.currentWaiter);

                barFrame.repo.save(order);
                //removing the product panel
               barFrame.hideProductPanel();
               barFrame.showLoginPanel();
            }
        });

    }

}
