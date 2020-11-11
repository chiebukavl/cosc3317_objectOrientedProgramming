// filename: Product.java
// author: Chiebuka Lebechi
// modified: 05 OCT 2020
// purpose: COSC 3317 assignment3


public class Product
{
    private String pID; // A or B
    private String color; // Blue or Red
    private int numInventory;
    private int numOrdered = 0;
    private double pricePerUnit; 

    Product(String id, String c, double num)
    {
        this.pID = id;
        this.color = c;
        this.pricePerUnit = num;
    }

    void setNumInventory(int n){this.numInventory = n;}
    void setNumOrdered(int n){this.numOrdered += n;}

    String getID(){return pID;}
    String getColor(){return color;}
    int getNumInventory(){return numInventory;}
    int getNumOrdered(){return numOrdered;}
    double getPrice(){return pricePerUnit;}


    void productOrderInfo()     // prints info about products ordered
    {
        System.out.printf("%s%s%s%s%s%d%n", "Product ID: ", this.pID, " - Color: ", this.color, " - Units Ordered: ", this.numOrdered);
    }

    void productInventoryInfo()     // prints info about products in stock
    {
        System.out.printf("%s%s%s%s%s%d%n", "Product ID: ", this.pID, " - Color: ", this.color, " - Units in Stock: ", this.numInventory);
    }

    double totalProductCharge()     // returns total price of ordered product
    {
        return this.numOrdered * this.pricePerUnit;
    }
}