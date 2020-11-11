// filename: SalesTest.java
// author: Chiebuka Lebechi
// modified: 05 OCT 2020
// purpose: COSC 3317 assignment3

import java.util.Scanner;

public class SalesTest 
{
    public static void main(String[] args) 
    {
        // create and initialize objects of class Product
        Product p1 = new Product("A", "Blue", 10.50);
        Product p2 = new Product("A", "Red", 9.99);
        Product p3 = new Product("B", "Blue", 12.75);
        Product p4 = new Product("B", "Red", 14.99);

        System.out.printf("%s", "Please enter the name of the shopping site: ");

        Scanner scan = new Scanner(System.in);
        String siteName = scan.nextLine();
        
        SalesSite branch = new SalesSite(siteName);

        // create branch inventory
        branch.createInventory(p1, p2, p3, p4);

        System.out.printf("%n%s%s%s%n%n", "Welcome to our ", siteName, " site.");

        int choice;
        while(true)
        {
            choice = branch.orderMenu();
            
            if(choice == 1)     // place an order for product A
            {
                System.out.printf("%s%n", "Please choose the color: ");
                System.out.printf("%s%n","  1.  Blue");
                System.out.printf("%s%n","  2.  Red");
                int c = scan.nextInt();

                System.out.printf("%s%n", "Please enter an amount: ");
                int a = scan.nextInt();

                if(c == 1)
                {
                    if(branch.checkAndProcess(p1, a))
                    {
                        System.out.printf("%s%n", "Order successfully processed.");
                    }
                    else{
                        System.out.printf("%s%n", "Sorry, your order could not be fulfilled at this time.");
                    }
                }
                else if(c == 2)     
                {
                    if(branch.checkAndProcess(p2, a))
                    {
                        System.out.printf("%s%n", "Order successfully processed.");
                    }
                    else{
                        System.out.printf("%s%n", "Sorry, your order could not be fulfilled at this time.");
                    }
                }
                
            }
            else if(choice == 2)        // place an order for product B
            {
                System.out.printf("%s%n", "Please choose the color: ");
                System.out.printf("%s%n","  1.  Blue");
                System.out.printf("%s%n","  2.  Red");
                int c = scan.nextInt();

                System.out.printf("%s%n", "Please enter an amount: ");
                int a = scan.nextInt();

                if(c == 1)
                {
                    if(branch.checkAndProcess(p3, a))
                    {
                        System.out.printf("%s%n", "Order successfully processed.");
                    }
                    else{
                        System.out.printf("%s%n", "Sorry, your order could not be fulfilled at this time.");
                    }
                }
                else if(c == 2)
                {
                    if(branch.checkAndProcess(p4, a))
                    {
                        System.out.printf("%s%n", "Order successfully processed.");
                    }
                    else{
                        System.out.printf("%s%n", "Sorry, your order could not be fulfilled at this time.");
                    }
                }
            }
            else if(choice == 3)        // view order report
            {
                branch.orderReport(p1, p2, p3, p4);
            }
            else if(choice == 4)        // view product inventory
            {
                p1.productInventoryInfo();
                p2.productInventoryInfo();
                p3.productInventoryInfo();
                p4.productInventoryInfo();
            }
            else if(choice == 5)        // view bill
            {
                System.out.printf("%s%.2f", "The total charge is $",       branch.theCharge(p1, p2, p3, p4));
            }
            else if(choice == 6)        // exit program
            {
                System.out.printf("%s%n", "Thanks for shopping!");
                break;
            }
            else
            {
                System.out.printf("%s%n", "Invalid input! Try again.");
            }
            
            System.out.printf("%n%s%n", "...");
        }
       scan.close();

    }
}
