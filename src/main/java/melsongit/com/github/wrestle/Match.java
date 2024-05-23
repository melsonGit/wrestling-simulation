package melsongit.com.github.wrestle;

import java.util.Random;

public class Match {

    Wrestler w1;
    Wrestler w2;
    Wrestler winner;
    Wrestler loser;

    public Match(Wrestler wr1, Wrestler wr2)
    {
        w1 = wr1;
        w2 = wr2;

        float sigma = Math.max(Math.abs(w1.abilityScore - w2.abilityScore) / 3.f, 15.f);

        Random rd = new Random();
        float score1 = (float) (rd.nextGaussian() * sigma + w1.abilityScore);
        float score2 = (float) (rd.nextGaussian() * sigma + w2.abilityScore);

        if (score1 > score2) {
            winner = w1;
            loser = w2;
        }
        else {
            winner = w2;
            loser = w1;
        }
    }
}
