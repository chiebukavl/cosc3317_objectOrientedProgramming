// filename: Registrar.java
// author: Chiebuka V. Lebechi
// modified: 22 SEP 2020
// purpose: Registrar class for COSC 3317 Assignment 2

import java.util.Scanner;

public class Registrar
{
    static void menu()
    {
        System.out.println("--------------------------------------------------");       // formatting
        System.out.println("Please choose an option from the following menu: ");
        System.out.println("1. Purchase meal plan");
        System.out.println("2. Apply for scholarship");
        System.out.println("3. View the account balance");
        System.out.println("4. View the record information");
        System.out.printf("%s%n%n","5. Exit");
    }

    static void meal_submenu()
    {
        System.out.printf("%s%n%n","Please choose the meal plan: ");
        System.out.printf("%s%n%s%n%n", "1. $250 (Plan A)", "2. $300 (Plan B)");
    }

    public static void main(String[] args)
    {
        String name;
        double gpa;
        double depositAmount;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        name = scan.nextLine();

        System.out.print("Enter your GPA: ");
        gpa = scan.nextDouble();

        System.out.print("Enter the deposit ammount: ");
        depositAmount = scan.nextDouble();

        Student student = new Student(name, gpa, depositAmount); // creates and initializes Student object using constructor

        System.out.printf("%n%s%n","Congratulations! Your student account is successfully activated.");
    

        while(true)
        {
            menu();
            System.out.print("Menu Selection: ");
            int choice = scan.nextInt();
            System.out.println();

            if(choice == 1)
            {
                meal_submenu();
                System.out.print("Meal Plan Selection: ");
                int mealChoice = scan.nextInt();

                if(student.getMealPlan() == "Not Chosen")
                {
                    
                    
                    if(mealChoice == 1 && student.getBalance() >= 250)
                    {
                        student.setBalance(student.getBalance() - 250);
                        student.setMealPlan("A");
                        System.out.printf("%n%s%s%n", "You have successfully added meal plan ", student.getMealPlan(), " to your record.");
                    }
                    else if(mealChoice == 2 && student.getBalance() >= 300)
                    {
                        student.setBalance(student.getBalance() - 300);
                        student.setMealPlan("B");
                        System.out.printf("%n%s%s%n", "You have successfully added meal plan ", student.getMealPlan(), " to your record.");
                    }
                    else
                    {
                        System.out.printf("%n%s%n", "Unfortunately, your account balance is not sufficient for this plan.");

                        System.out.printf("%s%n", "Please choose an option");
                        System.out.printf("%s%n%s%n%n", "1. Return to menu.", "2. Make a deposit.");

                        System.out.printf("%s", "Submenu Selection: ");
                        int submenu = scan.nextInt();

                        if(submenu == 1)
                        {
                            continue;
                        }
                        else if(submenu == 2)
                        {
                            System.out.printf("%n%s%n", "Please enter the amount you would like to deposit in your account: ");
                            double deposit = scan.nextDouble();

                            student.setBalance(student.getBalance() + deposit);
                            continue;
                        }


                    } 

                }
                else
                {
                    System.out.printf("%n%s%s%s%n", "You already have meal plan ", student.getMealPlan(), " associated with your account.");
                }

            
            }
            else if(choice == 2)
            {
                if(student.getGPA() >= 3.5)
                {
                    System.out.printf("%s%n", "Congratulations! You meet the criteria for scholarship. Your name is added to the list of prospective recipients.");

                    student.setApplication("Added");
                }
                else
                {
                    System.out.printf("%s%n", "The GPA cut for schoarship qualification is 3.5 and higher.");
                }

            }
            else if(choice == 3)
            {
                System.out.printf("%s%n%.2f%n", "Account Balance: ", student.getBalance());

            }
            else if(choice == 4)
            {
                System.out.printf("%s%n", "STUDENT RECORD INFORMATION");
                student.reportInfo();

            }
            else 
            {
                System.out.printf("%s%n", "Have a great semester!");
                scan.close();
                break;
            }
         

        }
        

    }


}