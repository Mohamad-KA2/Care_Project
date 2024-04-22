package cwk4;

public class Dragon extends Champion{
    private boolean canTalk;
    private final int entryFee;

    /** constructor
     * @param nme - name of the dragon
     * @param talk - boolean to indicate whether the dragon can talk
     */
    public Dragon(String nme, boolean canTalk)
    {
        super(nme, 7);
        this.canTalk = canTalk;
        this.entryFee = 500;
    }

    @Override
    public boolean canFight(ChallengeType type) {
        if (type == ChallengeType.FIGHT){
            return true;
        }else if (type == ChallengeType.MYSTERY && this.canTalk){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int getEntryFee() {
        return entryFee;
    }

    @Override
    /** Implements toString from Champion class
     *
     * @return the dragon information as a String
     */
    public String toString()
    {
        String s = "Class: Dragon || State: " +
                super.toString() +
                "Can Talk: " + canTalk + "\n" +
                "Entry Fee: " + this.entryFee + "\n";
        return s;
    }

}
