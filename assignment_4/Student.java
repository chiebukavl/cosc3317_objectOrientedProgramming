// filename: Student.java
// author: Chiebuka Lebechi
// modified: 22 OCT 2020
// purpose: cosc 3317 assignment 4

public class Student
{
    public enum Student_Status {UNDERGRAD, GRAD, ATHLETE, HONOR};

    private Student_Status stStatus;
    private String fullName;

    Student(String fullName, Student_Status stStatus)
    {
        this.fullName = fullName;
        this.stStatus = stStatus;
    }
    
    // getters and setters
    public String getName(){return fullName;}
    public void setName(String fullName){this.fullName = fullName;}

    public Student_Status getStatus(){return stStatus;}
    public void setStatus(Student_Status stStatus){this.stStatus = stStatus;}

    public String toString()
    {
        return "Name: " + fullName + "\tStatus: " + stStatus;
    }

}