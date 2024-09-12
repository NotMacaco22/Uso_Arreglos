package models.inventory;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> products;

    // Constructor
    public Inventory() {
        this.products = new ArrayList<>();
    }

    // Method ~ Add New Product
    public void addProduct(Product newProduct) {
        this.products.add(newProduct);
    }

    public void getProducts() {
        if (products.isEmpty()){
            System.out.println("There are no Products in the Inventory");
        } else {
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

    public void editingProducts(String search, String newName, String newPrice, String newQuantity) {

        for (Product product : products){
            if(product.getName().equals(search)){
                System.out.println("Before Changes");
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());

                if (newName != null && !newName.isEmpty()) {product.setName(newName);}
                if (newPrice != null && !newPrice.isEmpty()) {product.setPrice(Float.parseFloat(newPrice));}
                if (newQuantity != null && !newQuantity.isEmpty()) {product.setQuantity(Integer.parseInt(newQuantity));}

                System.out.println("\nAfter Changes");
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
                return;
            }
        }
        System.out.println("Couldn't find Product");
    }

    public boolean isEmpty(){
        return products.isEmpty();
    }

}
