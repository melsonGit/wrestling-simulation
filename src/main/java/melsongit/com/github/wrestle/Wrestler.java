package melsongit.com.github.wrestle;

import melsongit.com.github.wrestle.utils.FightRecord;

public class Wrestler {

    public int id;
    int abilityScore;
    public FightRecord fightRecord = new FightRecord();
    public int weightClass;
    int weight;

    public Wrestler(int weightClass, int weight, int id, int abilityScore) {
        this.weightClass = weightClass;
        this.weight = weight;
        this.id = id;
        this.abilityScore = abilityScore;
    }

    public FightRecord getFightRecord() {
        return fightRecord;
    }

    public int getAbilityScore() {
        return abilityScore;
    }
    public int getWeightClass() {
        return weightClass;
    }
    public int getId() {
        return id;
    }
}
