// filename: Student.java
// author: Chiebuka V. Lebechi
// modified: 21 SEPT 2020
// Student class for COSC 3317 Assignment 2


public class Student
{
    private String fullName;
    private double GPA;
    private double balance;
    private String mealPlan;
    private String scholarshipApplication;

    String getFullName(){return fullName;}
    double getGPA(){return GPA;}
    double getBalance(){return balance;}
    String getMealPlan(){return mealPlan;}
    String getApplication(){return scholarshipApplication;}


    void setFullName(String name){fullName = name;}
    void setGPA(double gpa){GPA = gpa;}
    void setBalance(double newBalance){balance = newBalance;}
    void setMealPlan(String newMealPlan){mealPlan = newMealPlan;}
    void setApplication(String newApplication){scholarshipApplication = newApplication;}

    void reportInfo()
    {
        System.out.printf("%s%s%n","Name: ",this.fullName);
        System.out.printf("%s%.2f%n","GPA: ", this.GPA);
        System.out.printf("%s%.2f%n", "Balance: ", this.balance);
        System.out.printf("%s%s%n", "Meal Plan: ", this.mealPlan);
        System.out.printf("%s%s%n", "Scholarship Application Status: ", this.scholarshipApplication);
    }

    Student(String name, double gpa, double startBalance)
    {
        this.fullName = name;
        this.GPA = gpa;
        this.balance = startBalance;
        this.mealPlan = "Not Chosen";
        this.scholarshipApplication = "Void";
    }
}