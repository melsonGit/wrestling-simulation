package melsongit.com.github.wrestle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Conference {

    List<School> schools = new ArrayList<>();
    private float bestScore;
    public int[][][] advantageMatrix = new int[13][8][8];

    public Conference() {

        double random = Math.random() * 49 + 1;

        for (int schoolName = 100; schoolName < 900; schoolName += 100) {

            int numberOfWrestlers = 12;
            schools.add(new School(schoolName, numberOfWrestlers));
        }
    }

    public void simulateSeason() {
        for (int i = 0; i < 8; ++i)
            for (int j = i + 1; j < 8; ++j)
                schoolsMatch(i, j);
    }

    public void schoolsMatch(int school1, int school2) {
        for (int i = 1; i < 13; ++i) {
            int wrestler1 = 100 * (school1 + 1) + schools.get(school1).getWrestler(i) + 1;
            int wrestler2 = 100 * (school2 + 1) + schools.get(school2).getWrestler(i) + 1;
            wrestlersMatch(wrestler1, wrestler2);
        }
    }

    public void wrestlersMatch(int wrestler1, int wrestler2)
    {
        if (wrestler1 % 100 < 1 || wrestler2 % 100 < 1)
            return;

        Wrestler w1 = schools.get(wrestler1 / 100 - 1).wrestlers.get(wrestler1 % 100 - 1);
        Wrestler w2 = schools.get(wrestler2 / 100 - 1).wrestlers.get(wrestler2 % 100 - 1);

        float sigma = Math.max(Math.abs(w1.getAbilityScore() - w2.getAbilityScore()) / 3.f, 15.f);

        Random rd = new Random();
        float score1 = (float) (rd.nextGaussian() * sigma + w1.getAbilityScore());
        float score2 = (float) (rd.nextGaussian() * sigma + w2.getAbilityScore());

        if (score1 > score2)
        {
            if (w1.getFightRecord().getWins() == 0)
                w1.getFightRecord().setWins(1);
            else
                w1.getFightRecord().setWins(w1.getFightRecord().getWins() + 1);

            if (w2.getFightRecord().getLosses() == 0)
                w2.getFightRecord().setLosses(1);
            else
                w2.getFightRecord().setLosses(w2.getFightRecord().getLosses() + 1);

            advantageMatrix[w1.getWeightClass()][wrestler1 / 100 - 1][wrestler2 / 100 - 1]++;
            advantageMatrix[w1.getWeightClass()][wrestler2 / 100 - 1][wrestler1 / 100 - 1]--;
        }
        else
        {

            if (w1.getFightRecord().getLosses() == 0)
                w1.getFightRecord().setLosses(1);
            else
                w1.getFightRecord().setLosses(w1.getFightRecord().getLosses() + 1);

            if (w2.getFightRecord().getWins() == 0)
                w2.getFightRecord().setWins(1);
            else
                w2.getFightRecord().setWins(w2.getFightRecord().getWins() + 1);

            advantageMatrix[w1.getWeightClass()][wrestler1 / 100 - 1][wrestler2 / 100 - 1]--;
            advantageMatrix[w1.getWeightClass()][wrestler2 / 100 - 1][wrestler1 / 100 - 1]++;
        }
    }

    public int bestSchool() {
        int bestSchool = -1;
        for (int i = 0; i < 8; ++i)
        {
            if (schools.get(i).totalSchoolScore() > bestScore)
            {
                bestScore = schools.get(i).totalSchoolScore();
                bestSchool = (i + 1) * 100;
            }
        }

        return bestSchool;
    }

    public float getBestScore() {
        return bestScore;
    }
}

