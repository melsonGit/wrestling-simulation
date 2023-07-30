package melsongit.com.github.wrestle;

import lombok.NoArgsConstructor;
import melsongit.com.github.wrestle.utils.FightRecord;

@NoArgsConstructor
public class Wrestler {

    int id;
    int abilityScore;
    FightRecord fightRecord;
    int weightClass;
    int weight;

    public Wrestler(int weightClass, int weight, int id, int abilityScore) {
        this.weightClass = weightClass;
        this.weight = weight;
        this.id = id;
        this.abilityScore = abilityScore;
    }

}
