// filename: TestSlip.java
// author: Chiebuka Lebechi
// modified: 6 NOV 2020
// purpose:

import java.util.Random;

class TestSlip
{
    private StudentInfo data;
    private final int numOfQuestions = 20;
    private int[] answers;  // random values 1-4
    private int score;

    TestSlip(StudentInfo studentData)
    {
        data = studentData;

        answers = new int[numOfQuestions];

        Random r = new Random();

        for(int i: answers)
        {
            i = r.nextInt(4) + 1;
        }
    }

    public void computeGrade(int[] a)
    {

    }

    public String toString()
    {
        
    }


}