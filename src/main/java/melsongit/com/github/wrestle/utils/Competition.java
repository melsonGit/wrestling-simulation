package melsongit.com.github.wrestle.utils;

import melsongit.com.github.wrestle.Conference;
import melsongit.com.github.wrestle.Wrestler;

public class Competition {

    Conference conference;

    public Competition(Conference conference){
        this.conference = conference;
    }

    public boolean winnerCheck(Wrestler w1, Wrestler w2) {
        return true;
    }

    public boolean compareWrestlers(Wrestler w1, Wrestler w2) {
        if (w1.record.wins < w2.record.wins) {
            return true;
        } else if (w2.record.wins < w1.record.wins) {
            return false;
        }

        return conference.advantageMatrix[w1.wtClass][w1.id / 100][w2.id / 100] < 0;
    }
}
