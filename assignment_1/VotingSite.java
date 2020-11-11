// filename: VotingSite.java
//   author: Chiebuka V. Lebechi
// modified: 06 September 2020
//  purpose: assignment 1 for COSC 3317: Object Oriented Programming

import java.util.Scanner;

public class VotingSite
{
    /**
     * whatAge method calculates the age of the voter using the current year and the voter's birth year as parameters
     * @param currentYear
     * @param birthYear
     * @return
     */
    static int whatAge(final int currentYear, int birthYear)
    {
        int voterAge = currentYear - birthYear;
        return voterAge;
    }

    /**
     * votingFor_POTUS_Message method outputs a message dependent on the age of the voter
     * @param voterAge
     */
    static void votingFor_POTUS_Message(int voterAge)
    {
        if(voterAge >= 18 && voterAge <= 21)
        {
            System.out.println("This is the first time you are eligible to vote in a presidential election.");
        }

        System.out.println("Thanks for practicing your very important civic duty.");
    }


    public static void main(String[] args)
    {
        System.out.println("This program determines voter eligibility based on user input.");
        
        final int CURRENT_YEAR = 2020;

        // instatiation of Voter object
        Voter voter = new Voter();
        
        // initialize voter.fullName and voter.birthYear with user input
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        voter.setName(scan.nextLine());

        System.out.print("Enter your birth year: ");
        voter.setBirthYear(scan.nextInt());

        scan.close();

        System.out.println(); // formatting
        
        // checks voter eligibility
        if(voter.eligibleToVote(CURRENT_YEAR))
        {
            int age = whatAge(CURRENT_YEAR, voter.getBirthYear());
            votingFor_POTUS_Message(age);
        }
        else
        {
            voter.ineligibleToVoteMessage(CURRENT_YEAR);
        }
    }
}