// filename: SalesSite.java
// author: Chiebuka Lebechi
// modified: 05 OCT 2020
// purpose: COSC 3317 assignment3

import java.util.Scanner;
import java.util.Random;

public class SalesSite 
{
    private String branch;

    SalesSite(String branchName)
    {
        this.branch = branchName;
    }

    void setBranch(String newBranch){this.branch = newBranch;}
    String getBranch(){return branch;}

    // creates an inventory of products with random quantities
    void createInventory(Product p1, Product p2, Product p3, Product p4)
    {
        Random r = new Random();

        p1.setNumInventory(r.nextInt((100-10) + 1) + 10);
        p2.setNumInventory(r.nextInt((100-10) + 1) + 10);
        p3.setNumInventory(r.nextInt((100-10) + 1) + 10);
        p4.setNumInventory(r.nextInt((100-10) + 1) + 10);
    }

    int orderMenu()
    {
        System.out.printf("%s%n%n", "Please choose an option:");
        System.out.printf("%s%n","  1.  Place an order for Product A");
        System.out.printf("%s%n","  2.  Place an order for Product B");
        System.out.printf("%s%n","  3.  View order report");
        System.out.printf("%s%n","  4.  View inventory");
        System.out.printf("%s%n","  5.  View the bill");
        System.out.printf("%s%n","  6.  Exit.");

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        //a.close();

        return choice;
    }

    // makes sure items are in stock before placing order
    boolean checkAndProcess(Product p, int n) 
    {
        if(p.getNumInventory() >= n)
        {
            p.setNumOrdered(n);
            p.setNumInventory(p.getNumInventory() - n);
            return true;
        }
        else
        {
            return false;
        }

    }

    // displays info about ordered products
    void orderReport(Product p1, Product p2, Product p3, Product p4)
    {
        boolean empty = true;

        if(p1.getNumOrdered() > 0)
        {
            empty = false;
            p1.productOrderInfo();
        }

        if(p2.getNumOrdered() > 0)
        {
            empty = false;
            p2.productOrderInfo();
        }

        if(p3.getNumOrdered() > 0)
        {
            empty = false;
            p3.productOrderInfo();
        }

        if(p4.getNumOrdered() > 0)
        {
            empty = false;
            p4.productOrderInfo();
        }

        if(empty == true)
        {
            System.out.printf("%s%n", "Your shopping cart is empty.");
        }

    }

    // calculates and returns total price of ordered items
    double theCharge(Product p1, Product p2, Product p3, Product p4)
    {
        double totalCharge = 0;

        if(p1.getNumOrdered() > 0)
        {
            p1.productOrderInfo();
            totalCharge += p1.totalProductCharge();
        }

        if(p2.getNumOrdered() > 0)
        {
            p2.productOrderInfo();
            totalCharge += p2.totalProductCharge();
        }

        if(p3.getNumOrdered() > 0)
        {
            p3.productOrderInfo();
            totalCharge += p3.totalProductCharge();
        }

        if(p4.getNumOrdered() > 0)
        {
            p4.productOrderInfo();
            totalCharge += p4.totalProductCharge();
        }

        return totalCharge;
    }
}
