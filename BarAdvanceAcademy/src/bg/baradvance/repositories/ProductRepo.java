package bg.baradvance.repositories;

import bg.baradvance.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepo {

    List<Product> productList;
    Product product = new Product("Vodka", "50ml", 4.0);
    Product product1 = new Product("Wine", "100ml", 6.0);
    Product product2 = new Product("Whiskey", "50ml", 5.0);
    Product product3 = new Product("Whiskey", "100ml", 7.0);
    Product product4 = new Product("Rakia", "700ml", 30.0);
    Product product5 = new Product("Water", "500ml", 3.0);

    public ProductRepo() {
        this.productList = new ArrayList<>();
        Collections.addAll(productList, product, product1, product2,
                product3, product4, product5);
    }


    public List<Product> getProductList() {
        return this.productList;
    }
}







