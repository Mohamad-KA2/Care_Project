package cwk4;

import java.util.*;
import java.io.*;
/**
 * This interface specifies the behaviour expected from CARE
 * as required for 5COM2007 Cwk 4
 * 
 * @author 
 * @version 
 */

public class Tournament implements CARE
{
    private ArrayList<Champion> reserveList = new ArrayList<Champion>();
    private ArrayList<Challenge> challengeList = new ArrayList<Challenge>();
   
    private String vizier;
    private Vizier player;


//**************** CARE ************************** 
    /** Constructor requires the name of the vizier
     * @param viz the name of the vizier
     */  
    public Tournament(String viz)
    {
        player = new Vizier(viz);
        
       setupChampions();
       setupChallenges();
    }
    
    /** Constructor requires the name of the vizier and the
     * name of the file storing challenges
     * @param viz the name of the vizier
     * @param filename name of file storing challenges
     */  
    public Tournament(String viz, String filename)  //Task 3.5
    {
        Vizier player = new Vizier(viz);
        
       setupChampions();
       readChallenges(filename);
    }
    
    
    /**Returns a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * 
     * @return a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     **/
    public String toString()
    {
        String s = player.toString();
        
        return s;
    }
    
    
    /** returns true if Treasury <=0 and the vizier's team has no 
     * champions which can be retired. 
     * @returns true if Treasury <=0 and the vizier's team has no 
     * champions which can be retired. 
     */
    public boolean isDefeated()
    {
        if (this.player.getChamps() == null && this.player.getTreasury() <= 0 ) {
            return true;
        }else{
            return false;
        }
    }
    
    /** returns the amount of money in the Treasury
     * @returns the amount of money in the Treasury
     */
    public int getMoney()
    {
        return player.getTreasury();
    }
    
    
    /**Returns a String representation of all champions in the reserves
     * @return a String representation of all champions in the reserves
     **/
    public String getReserve()
    {   
        String s = "************ Champions available in reserves********\n";
        for (Champion champion : this.reserveList){
            s += champion.toString();
            s += "\n";
        }
        
        return s;
    }
    
        
    /** Returns details of the champion with the given name. 
     * Champion names are unique.
     * @return details of the champion with the given name
     **/
    public String getChampionDetails(String nme)
    {
        for(Champion c : this.reserveList){
            if (Objects.equals(c.getName(), nme)){
                return c.toString();
            }
        }
        for (Champion c : this.player.getChamps()){
            if (Objects.equals(c.getName(), nme)){
                return c.toString();
            }
        }
       
        return "\nNo such champion";
    }    
    
    /** returns whether champion is in reserve
    * @param nme champion's name
    * @return true if champion in reserve, false otherwise
    */
    public boolean isInReserve(String nme)
    {
        for(Champion c : this.reserveList){
            if (Objects.equals(c.getName(), nme)){
                return true;
            }
        }
        return false;
    }
 
    // ***************** Team champions ************************   
     /** Allows a champion to be entered for the vizier's team, if there 
     * is enough money in the Treasury for the entry fee.The champion's 
     * state is set to "active"
     * 0 if champion is entered in the vizier's team, 
     * 1 if champion is not in reserve, 
     * 2 if not enough money in the treasury, 
     * -1 if there is no such champion 
     * @param nme represents the name of the champion
     * @return as shown above
     **/        
    public int enterChampion(String nme)
    {
        for(Champion c : this.reserveList){
            if (c.getName().equals(nme)){
                if (c.getEntryFee() <= this.player.getTreasury()){
                    c.setState(ChampionState.ENTERED);
                    this.player.addChampion(c);
                    this.reserveList.remove(c);
                    return 0;
                }else{
                    return 2;
                }
            }
        }
        for (Champion c : this.player.getChamps()) {
            if (Objects.equals(c.getName(), nme)) {
                return 1;
            }
        }
        return -1;
    }
        
     /** Returns true if the champion with the name is in 
     * the vizier's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the vizier's team, false otherwise.
     **/
    public boolean isInViziersTeam(String nme)
    {
        for (Champion c : this.player.getChamps()) {
            if (Objects.equals(c.getName(), nme)) {
                return true;
            }
        }
        return false;
    }
    
    /** Removes a champion from the team back to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is retired to reserves
     * 1 - if champion not retired because disqualified
     * 2 - if champion not retired because not in team
     * -1 - if no such champion
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int retireChampion(String nme)
    {
        for (Champion c : this.player.getChamps()){
            if(Objects.equals(c.getName(), nme)){
                if (c.getState() == ChampionState.DISQUALIFIED){
                    return 1;
                }else{
                    this.player.removeChampion(c);
                    this.reserveList.add(c);
                    return 0;
                }
            }
        }
        if (!isInViziersTeam(nme)){
            return 2;
        }
        return -1;
    }
    
    
        
    /**Returns a String representation of the champions in the vizier's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the vizier's team
     **/
    public String getTeam()
    {
        String s = "************ Vizier's Team of champions********\n";
        if(this.player.getChamps() == null){
            s += "No champions entered";
            return s;
        }
        s += this.player.getTeam();
        return s;
    }
    
     /**Returns a String representation of the disqualified champions in the vizier's team
     * or the message "No disqualified champions "
     * @return a String representation of the disqualified champions in the vizier's team
     **/
    public String getDisqualified()
    {
        String s = "************ Vizier's Disqualified champions********";
        for (Champion c : this.player.getChamps()){
            if (c.getState() == ChampionState.DISQUALIFIED){
                s += c.toString();
            }else{
                s += "\nNo disqualified champions.";
            }
        }
        return s;
    }
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the  number of the challenge
     * @return true if the  number represents a challenge
     **/
     public boolean isChallenge(int num)
     {
         for (Challenge c : this.challengeList){
             if(c.getId() == num){
                 return true;
             }
         }
         return (false);
     }    
   
    /** Provides a String representation of an challenge given by 
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num)
    {
        for (Challenge c : this.challengeList){
            if(c.getId() == num){
                return c.toString();
            }
        }
        return "\nNo such challenge";
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges()
    {
        String s = "\n************ All Challenges ************\n";

        for (Challenge c : this.challengeList){
            s = s + "\n";
            s = s + c.toString();
        }
        return s;
    }

    /** Retrieves the challenge represented by the challenge
     * number.Finds a champion from the team who can meet the 
     * challenge. The results of meeting a challenge will be 
     * one of the following:  
     * 0 - challenge won by champion, add reward to the treasury, 
     * 1 - challenge lost on skills  - deduct reward from
     * treasury and record champion as "disqualified"
     * 2 - challenge lost as no suitable champion is  available, deduct
     * the reward from treasury 
     * 3 - If a challenge is lost and vizier completely defeated (no money and 
     * no champions to withdraw) 
     * -1 - no such challenge 
     * @param chalNo is the number of the challenge
     * @return an int showing the result(as above) of fighting the challenge
     */ 
    public int meetChallenge(int chalNo)
    {
        int outcome;
        if(isChallenge(chalNo)){
            for (Challenge c : this.challengeList){
                if (c.getId() == chalNo){
                    for (Champion ch : this.player.getChamps()){
                        if (ch.canFight(c.getType())){
                            if (ch.getSkillLvl() >= c.getSkillLevel()){
                                this.player.addReward(c.getReward());
                                return 0;
                            } else {
                                ch.setState(ChampionState.DISQUALIFIED);
                                this.player.payReward(c.getReward());
                                return 1;
                            }
                        } else {
                            this.player.payReward(c.getReward());
                            return 2;
                        }
                    }
                }
            }
        }
        if(isDefeated()){
            return 3;
        }
        //Nothing said about accepting challenges when bust
        outcome = -1 ;
        
        return outcome;
    }
 

    //****************** private methods for Task 3 functionality*******************
    //*******************************************************************************
    private void setupChampions()
    {
        Dragon gary = new Dragon("Gary", true);
        this.reserveList.add(gary);
        Dragon barry = new Dragon("Barry", false);
        this.reserveList.add(barry);
        Wizard mary = new Wizard("Mary", 4, true, "Levitation");
        this.reserveList.add(mary);
        Wizard larry = new Wizard("Larry", 2, false, "Transmutation");
        this.reserveList.add(larry);
        Warrior terry = new Warrior("Terry", 2, "Bucket");
        this.reserveList.add(terry);
        Warrior jerry = new Warrior("Jerry", 5, "Mop");
        this.reserveList.add(jerry);
   }

    private void setupChallenges()
    {
        Challenge borgMag = new Challenge(1, "Borg", ChallengeType.MAGIC, 3,100);
        Challenge huns = new Challenge(2, "Huns", ChallengeType.FIGHT, 3, 120);
        Challenge ferengi = new Challenge(3, "Ferengi", ChallengeType.MYSTERY, 3, 150);
        Challenge vandals = new Challenge(4, "Vandals", ChallengeType.MAGIC, 9, 200);
        Challenge borgMys = new Challenge(5, "Borg", ChallengeType.MYSTERY, 7, 90);
        Challenge goths = new Challenge(6, "Goths", ChallengeType.FIGHT, 8, 45);
        Challenge franks = new Challenge(7, "Franks", ChallengeType.MAGIC, 10, 200);
        Challenge sith = new Challenge(8, "Sith", ChallengeType.FIGHT, 10, 150);
        Challenge cardashian = new Challenge(9, "Cardashian", ChallengeType.MYSTERY, 9, 300);
        Challenge jute = new Challenge(10, "Jute", ChallengeType.FIGHT, 2, 300);
        this.challengeList.add(borgMag);
        this.challengeList.add(huns);
        this.challengeList.add(ferengi);
        this.challengeList.add(vandals);
        this.challengeList.add(borgMys);
        this.challengeList.add(goths);
        this.challengeList.add(franks);
        this.challengeList.add(sith);
        this.challengeList.add(cardashian);
        this.challengeList.add(jute);
    }
        
    // Possible useful private methods
//     private Challenge getAChallenge(int no)
//     {
//         
//         return null;
//     }
//    
//     private Champion getChampionForChallenge(Challenge chal)
//     {
//         
//         return null;
//     }

    //*******************************************************************************
    //*******************************************************************************
  
    /************************ Task 3.5 ************************************************/  
    
    // ***************   file write/read  *********************
    /**
     * reads challenges from a comma-separated textfile and stores in the game
     * @param filename of the comma-separated textfile storing information about challenges
     */
    public void readChallenges(String filename)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    ChallengeType type = ChallengeType.valueOf(parts[0].trim());
                    String name = parts[1].trim();
                    int level = Integer.parseInt(parts[2].trim());
                    int reward = Integer.parseInt(parts[3].trim());

                    String counterStr = String.valueOf(counter);
                    counter ++;

                    Challenge x = new Challenge(counter, name, type, level, reward);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    
     /** reads all information about the game from the specified file 
     * and returns a CARE reference to a Tournament object, or null
     * @param fname name of file storing the game
     * @return the game (as a Tournament object)
     */
    public Tournament loadGame(String fname)
    {   // uses object serialisation 
        Tournament game = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname))) {
            game = (Tournament) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return game;
   } 
   
   /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
   public void saveGame(String fname){
        // uses object serialisation

       try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname))) {
           oos.writeObject(this);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
 

}


