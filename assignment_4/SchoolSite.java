// filename: SchoolSite.java
// author: Chiebuka Lebechi
// modified: 29 OCT 2020
// purpose: cosc 3317 assignment 4

import java.util.Scanner;

public class SchoolSite
{
    final static int MAX_PROJECTS = 4;
    static Project[] projects = new Project[MAX_PROJECTS];

    final static Project.Project_ID[] projectID = {Project.Project_ID.GSCP, Project.Project_ID.AP, Project.Project_ID.SSP, Project.Project_ID.USCP};

    final static Student.Student_Status[] studentStatus = {Student.Student_Status.UNDERGRAD, Student.Student_Status.GRAD, Student.Student_Status.ATHLETE, Student.Student_Status.HONOR};

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        boolean loop = true;

        do
        {
            System.out.printf("Please select an option below:\n");
            System.out.printf("1.\tFaculty\n");
            System.out.printf("2.\tStudent\n");
            System.out.printf("3.\tExit\n");

            int choice = scan.nextInt();

            switch(choice)
            {
                case 1:
                    projectMenu();
                    continue;
                
                case 2:
                    studentStatusMenu();
                    continue;
                
                case 3:
                    System.out.printf("Exiting program..\n");
                    loop = false;
                    continue;
            }
        } while(loop);

        scan.close();
    }

    public static void projectMenu()
    {
        String fullName;
        boolean loop = true;
        int choice;

        Scanner scan = new Scanner(System.in);

        do
        {
            System.out.printf("1.\tRegister a project\n");
            System.out.printf("2.\tView the projects' full information\n");
            System.out.printf("3.\tBack to main menu\n");
            
            choice = scan.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.printf("Please enter your full name:\n");
                    String trash = scan.nextLine();
                    fullName = scan.nextLine();

                    System.out.printf("Please choose the project type:\n");
                    System.out.printf("List of Projects:\n");

                    System.out.printf("1.\tGraduate Science Project (GSCP)\n");
                    System.out.printf("2.\tAthletic Project (AP)\n");
                    System.out.printf("3.\tSocial Studies Project (SSP)\n");
                    System.out.printf("4.\tUndergraduate Science Project (USCP)\n");

                    int type = scan.nextInt();
                    int index = type -1;

                    if(projects[index] == null)
                    {
                        projects[index] = new Project(fullName, projectID[index], Project.Project_Status.OPEN);
                    }
                    else 
                    {
                        System.out.printf("This project is already registered.\n");
                    }

                    System.out.printf("\n");
                    continue;

                case 2:
                    for(int i = 0; i < projects.length; i++)
                    {
                        if(projects[i] != null)
                        {
                            System.out.printf("Project ID:\t" + projects[i].getID() + "\n");
                            System.out.printf("\tProject Leader: " + projects[i].getLeader() + "\n");
                            System.out.printf("\tProject Status: " + projects[i].getStatus() + "\n");
                            System.out.printf("\t");
                            projects[i].displayTeamMembers();
                        }
                        else
                        {
                            System.out.printf("Project ID:\t" + projectID[i] + "\tNOT REGISTERED.\n");
                        }
                    }

                    System.out.printf("\n");                    
                    continue;
    
                
                case 3:
                    loop = false;
                    break;
            }
        } while(loop);
    }

    public static void studentStatusMenu()
    {
        Student.Student_Status status;
        String studentName;
        int pID;
        boolean loop = true;
        Scanner scan = new Scanner(System.in);

        System.out.printf("What is your status:\n");

        System.out.printf("1.\tUndergraduate\n");
        System.out.printf("2.\tGraduate\n");
        System.out.printf("3.\tStudent Athlete\n");
        System.out.printf("4.\tHonor Student\n");

        
        int choice = scan.nextInt();

        int index = choice -1;
        status = studentStatus[index];

        do
        {
            System.out.printf("1.\tView the projects' status\n");
            System.out.printf("2.\tApply for a project\n");
            System.out.printf("3.\tBack to main menu\n");

            choice = scan.nextInt();

            switch(choice)
            {
                case 1:
                    for(int i = 0; i < projects.length; i++)
                    {
                        if(projects[i] != null)
                        {
                            System.out.printf("Project ID:\t" + projects[i].getID() + "\t" + projects[i].getStatus() + "\n");
                        
                        }
                        else
                        {
                            System.out.printf("Project ID:\t" + projectID[i] + "\tNOT REGISTERED.\n");
                        }
                    }

                    System.out.printf("\n");
                    break;

                case 2:
                    System.out.printf("List of Projects:\n");
                    System.out.printf("1.\tGraduate Science Project (GSCP)\n");
                    System.out.printf("2.\tAthletic Project (AP)\n");
                    System.out.printf("3.\tSocial Studies Project (SSP)\n");
                    System.out.printf("4.\tUndergraduate Science Projects (USCP)\n");

                    pID = scan.nextInt();
                    int temp = pID -1;

                    if(Project.isQualified(projectID[temp], status))
                    {
                        System.out.printf("Please enter your full name:\n");
                        studentName = scan.nextLine();

                        Student student = new Student(studentName, status);

                        projects[temp].addMember(student);

                        System.out.printf("You have been added to project " + projects[temp].getID());
                    }

                    System.out.printf("\n");
                    break;

                case 3:
                    loop = false;
                    break;

            }
        } while(loop);
    }
}

