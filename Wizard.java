package cwk4;

/**
 * Write a description of class Wizard here.
 *
 * @author (your name)
 * @version (a version number or a date) add subclass necromancer
 */
public class Wizard extends Champion {
    private final String specialitySpell;
    private final boolean isNecromancer;
    private final int entryFee;

    /** constructor
     * @param nme - name of the wizard
     * @param skill - skill level
     * @param fee - fee amount
     * @param isNecro - true if the wizard is also a necromancer
     * @param spell - the name of the speciality spell
     */
    public Wizard(String nme, int skill, boolean isNecromancer, String spell)
    {
        super(nme, skill);
        this.isNecromancer = isNecromancer;
        this.specialitySpell = spell;
        this.entryFee = calculateEntryFee();
    }

    /** Implements setEntryFee from Champion class
     *
     * @return the wizard entry fee
     */
    public int calculateEntryFee()
    {
        if (this.isNecromancer)
        {
            return 400;
        }else{
            return 300;
        }
    }

    @Override
    public boolean canFight(ChallengeType challenge) {
        return true;
    }

    @Override
    public int getEntryFee() {
        return entryFee;
    }

    @Override
    /** Implements toString from Champion class
     *
     * @return the wizard information as a String
     */
    public String toString()
    {
        String s = "Class: Wizard || State: " +
                super.toString() +
                "Necromancer: " + isNecromancer + "\n" +
                "Speciality spell: " + this.specialitySpell + "\n" +
                "Entry Fee: " + this.entryFee + "\n";
        return s;
    }

}
