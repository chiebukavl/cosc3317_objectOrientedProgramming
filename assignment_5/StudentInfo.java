// filename: StudentInfo.java
// author: Chiebuka Lebechi
// modified: 6 NOV 2020
// purpose:

class StudentInfo
{
    private String fullName;
    private String studentID;   // assume a 3-digit ID

    public String getName(){return fullName;}
    public void setName(String name){fullName = name;}

    public String getID(){return studentID;}
    public void setID(String id){studentID = id;}

    StudentInfo(String name, String id)
    {
        fullName = name;
        studentID = id;
    }

    public String toString()
    {
        return String.format("%s %d", fullName, studentID);
    }
}
