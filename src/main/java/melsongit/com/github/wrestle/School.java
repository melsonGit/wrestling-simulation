package melsongit.com.github.wrestle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class School {

    int name;
    int numberOfWrestlers;
    List<Wrestler> wrestlers;

    public School(int Name, int numWrs) {

        name = Name;
        numberOfWrestlers = numWrs;
        wrestlers = new ArrayList<>(numberOfWrestlers);

        Set<Integer> wtClasses;
        double random = Math.random() * 49 + 1; // replace e2 with this

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

            int abilityScore = max(static_cast<int>(round<int>(distributionAbility(e2))), 0);
            wrestlers[i] = Wrestler(cl, wt, name + i + 1, abilityScore);
            wtClasses.insert(cl);
        }
    }

    public int getWrestler(int wtClass) {
        for (int i = 0; i < numberOfWrestlers; ++i)
            if (wrestlers[i].wtClass == wtClass)
                return i;
        return -1;
    }

    public float totalSchoolScore() {
        int wins = 0;
        int loses = 0;

        for (int i = 0; i < numberOfWrestlers; ++i) {
            wins += wrestlers[i].record.wins;
            loses += wrestlers[i].record.loses;
        }

        return float(wins) / (wins + loses);
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
