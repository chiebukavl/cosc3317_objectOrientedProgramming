// filename: Voter.java
//   author: Chiebuka V. Lebechi
// modified: 06 September 2020
//  purpose: assignment 1 for COSC 3317: Object Oriented Programming

public class Voter
{
    // attributs of a voter
    private String fullName;
    private int birthYear;
    static final int LEGAL_AGE = 18;

    // getters and setters for fullName and birtYear
    String getName(){return fullName;}
    int getBirthYear(){return birthYear;}
    void setName(String name){fullName = name;}
    void setBirthYear(int year){birthYear = year;}

    /**
     * eligibleToVote method recieves the current year as defined in main method. It can then 
     * determine whether the voter is eligible to vote. This method returns a boolean value
     * 
     * @param currentYear
     * @return
     */
    boolean eligibleToVote(final int currentYear)
    {
        if(currentYear - birthYear >= LEGAL_AGE)
        {
            return true;
        }   
        return false;
    }

    /**
     * ineligibleToVoteMessage method outpouts message regarding voter status using the current
     * year as a parameter
     * @param currentYear
     */
    void ineligibleToVoteMessage(final int currentYear)
    {
        if (!eligibleToVote(currentYear))
        {
            System.out.println("You are currently ineligible to vote.");
        }

        // calculates years until voting age
        int years = LEGAL_AGE - (currentYear - birthYear);

        System.out.println("You will be eligible to vote in " + years + " year(s).");
    }
}