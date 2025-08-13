package cwk4;

public class Challenge {

    private int id;
    private String enemyName;
    private ChallengeType type;
    private int skillLevel;
    private int reward;

    public Challenge(int id, String enemyName, ChallengeType type, int skillLevel, int reward){
        this.id = id;
        this.enemyName = enemyName;
        this.type = type;
        this.skillLevel = skillLevel;
        this.reward = reward;
    }

    /**
     * To get the ID for a particular challenge
     * @return int - Challenge ID number
     */
    public int getId()
    {
        return id;
    }

    /**
     * To get the name of the enemy
     * @return String - Enemy Name
     */
    public String getEnemyName()
    {
        return enemyName;
    }

    /**
     * To get the enemy type
     * @return String - Type of enemy
     */
    public ChallengeType getType()
    {
        return this.type;
    }

    /**
     * To get the required skill level for the challenge
     * @return int - Skill Level requirement
     */
    public int getSkillLevel()
    {
        return skillLevel;
    }

    /**
     * To get the reward for the challenge
     * @return int - Reward for completing the challenge
     */
    public int getReward()
    {
        return reward;
    }


    /**
     * Presents a string of all the details of the challenge
     * @return String - details for the entire challenge
     */
    public String toString(){
        String s = "Challenge ID: " + this.id + "\n" +
                "Enemy Type: " + this.type + "\n" +
                "Enemy Name: " + this.enemyName + "\n" +
                "Skill Level: " + this.skillLevel + "\n" +
                "Reward: " + this.reward;
        return s;
    }


}
