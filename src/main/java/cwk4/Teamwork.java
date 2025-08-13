package cwk4;


/**
 * Details of your team
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];

    public Teamwork()
    {   // in each line replace the contents of the String
        // with the details of your team member
        // Please list the member details alphabetically by surname
        // i.e. the surname of member1 should come alphabetically
        // before the surname of member 2...etc
        details[0] = "045";

        details[1] = "Bellenie";
        details[2] = "Bailey";
        details[3] = "21049096";

        details[4] = "Khir-Allah";
        details[5] = "Mohamad";
        details[6] = "20073192";

        details[7] = "Milewska";
        details[8] = "Paulina";
        details[9] = "21047360";

        details[10] = "Shah";
        details[11] = "Naweed";
        details[12] = "20049751";
    }

    public String[] getTeamDetails()
    {
        return details;
    }

    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}

