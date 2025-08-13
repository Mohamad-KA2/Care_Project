package cwk4;

import java.util.ArrayList;


public class Vizier{
    private final String name;
    private int treasury = 1000;
    private ArrayList<Champion> team = new ArrayList<Champion>();
    private boolean hasChampions;
    private boolean isTreasuryInDebt;

    public Vizier (String name){
        this.name = name;
        hasChampions = false;
        isTreasuryInDebt = false;
    }

    public int getTreasury(){
        return treasury;
    }

    public void addReward(int num){
        this.treasury += num;
    }

    public void payReward(int num){
        this.treasury -= num;
    }



    public String getVizierName(){
        return name;
    }

    public boolean hasChampion(Champion champion){
        for (Champion temp: team){
            if (temp.equals(champion)){
                return true;
            }
        }
        return false;
    }

    public String getChampion(Champion champ){
        String s = "";
        for (Champion champion : team){
            s += champion.toString();
        }
        return s;
    }

    public String getTeam(){
        String s = "";
        for (Champion champion : team){
            s += champion.toString();
        }
        return s;
    }

    public boolean isTreasuryInDebt(){
        return treasury < 0;
    }

    public void addChampion(Champion c){
        team.add(c);
    }

    public void removeChampion(Champion c){
        team.remove(c);
        int gold = c.getEntryFee()/2;
        treasury += gold;
    }

    public ArrayList<Champion> getChamps(){
        return team;
    }



    public String toString(){
        return "Vizier name: " + getVizierName() +
                "\nTreasury: " + getTreasury() +
                "\nTeam contains Champions? " + hasChampions +
                "\nIs Vizier in debt? " + isTreasuryInDebt +
                "\nVizier Team: " + getTeam();
    }
}
