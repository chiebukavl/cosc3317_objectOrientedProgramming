// filename: Project.java
// author: Chiebuka Lebechi
// modified: 29 OCT 2020
// purpose: cosc 3317 assignment 4

import java.util.Scanner;

public class Project
{
    public enum Project_ID {GSCP, AP, SSP, USCP};
    public enum Project_Status {OPEN, CLOSED};
    
    private Project_ID pID;
    private Project_Status pStatus;

    private String projectLeader;
    private Student[] teamMembers;

    private final int maxCap = 5;
    private int teamCount;

    Project(String projectLeader, Project_ID pID, Project_Status pStatus)
    {
        this.projectLeader = projectLeader;
        this.pID = pID;
        this.pStatus = pStatus;

        teamMembers = new Student[maxCap];
        teamCount = 0;
    }

    // getters and setters
    public Project_ID getID(){return pID;}
    public Project_Status getStatus(){return pStatus;}
    public String getLeader(){return projectLeader;}
    public Student[] getMembers(){return teamMembers;}
    public int getMax(){return maxCap;}

    public void setID(Project_ID pID){this.pID = pID;}
    public void setStatus(Project_Status pStatus){this.pStatus = pStatus;}
    public void setLeader(String leader){projectLeader = leader;}
    public void setMembers(Student[] members){teamMembers = members;}
    public void setTeamCount(int teamCount){this.teamCount = teamCount;}

    public static boolean isQualified(Project_ID pID, Student.Student_Status stStatus)
    {
        switch(pID)
        {
         
            case GSCP: 
                if(stStatus == Student.Student_Status.GRAD)
                {
                    return true;
                }
                else {break;}

            case AP:
                if(stStatus == Student.Student_Status.ATHLETE)
                {
                    return true;
                }
                else{break;}

            case SSP:
                System.out.printf("Are you currently a full time student?%n");
                System.out.printf("1.\tYes\n");
                System.out.printf("2.\tNo\n");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch(choice)
                {
                    case 1:
                        return true;

                    case 2:
                        System.out.println("You must be a full-time student to qualify for this project.");
                        break;
                }

            case USCP:
                Scanner scan = new Scanner(System.in);

                System.out.print("Please enter your GPA. \n");
                double gpa = scan.nextDouble();

                if(stStatus == Student.Student_Status.HONOR)
                {
                    return true;
                }
                else if(gpa >= 3.5)
                {
                    return true;
                }
                else{break;}
        }
        
        System.out.printf("Unfortunately you do not meet the criteria for this project.\n");
        return false;
    }

    public void displayTeamMembers()
    {
        if(teamCount != 0)
        {
            System.out.printf("Team Members:\n");
            for(Student s : teamMembers)
            {
                System.out.println(s);
            }
        }
        else 
        {
            System.out.printf("There are no members in this team.\n\n");
        }
    }

    public void addMember(Student newMember)
    {
        teamMembers[teamCount] = newMember;
        teamCount++;
        
        if(teamCount == maxCap)
        {
            pStatus = Project_Status.CLOSED;
        }
    }

    public String toString()
    {
        return "Project ID:\t" + pID + "\t"  + pStatus + "\n";
    }
}