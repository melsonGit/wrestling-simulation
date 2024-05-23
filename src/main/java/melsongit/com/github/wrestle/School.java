package melsongit.com.github.wrestle;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

import static java.lang.Math.max;

@Getter
@Setter
public class School {

    private final int name;
    private final int numberOfWrestlers;
    List<Wrestler> wrestlers;

    public School(int Name, int numWrs) {

        name = Name;
        numberOfWrestlers = numWrs;
        wrestlers = new ArrayList<>(numberOfWrestlers);

        Set<Integer> wtClasses = new HashSet<>();
        int random = (int) (Math.random() * 49 + 1); // replace e2 with this

        for (int i = 0; i < numberOfWrestlers; ++i) {

            int cl = 0;
            int wt = 0;
            Random rand = new Random();

            while (wtClasses.contains(cl) || cl < 1) {
                wt = rand.nextInt(192) + 94;
                for (int j = 1; j < 13; ++j) {
                    if (wt > WeightClasses.weightClassCategory[j - 1] && wt <= WeightClasses.weightClassCategory[j]) {
                        cl = j;
                        break;
                    }
                }
            }

            int abilityScore = max(random, 0);
            wrestlers.add(new Wrestler(cl, wt, name + i + 1, abilityScore));
            wtClasses.add(cl);
        }
    }

    public int getWrestler(int wtClass) {
        for (int i = 0; i < numberOfWrestlers; ++i)
            if (wrestlers.get(i).weightClass == wtClass)
                return i;
        return -1;
    }

    public float totalSchoolScore() {
        int wins = 0;
        int losses = 0;

        for (int i = 0; i < numberOfWrestlers; ++i) {
            wins += wrestlers.get(i).fightRecord.getWins();
            losses += wrestlers.get(i).fightRecord.getLosses();
        }

        return (float) wins / (wins + losses);
    }

    public static class WeightClasses {

        static final int[] weightClassCategory = {
                94,
                106,
                113,
                120,
                126,
                132,
                138,
                145,
                152,
                167,
                189,
                220,
                285
        };
    }
}
