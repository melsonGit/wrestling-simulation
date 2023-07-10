package melsongit.com.github.wrestle.utils;

import melsongit.com.github.wrestle.Conference;
import melsongit.com.github.wrestle.Wrestler;

public class Competition {

    Conference conference;

    Competition(Conference conference){
        this.conference = conference;
    }

    boolean winnerCheck(Wrestler w1, Wrestler w2) {
        return true;
    }


}
//
//        bool operator()(Wrestler w1, Wrestler w2)
//        {
//        if (w1.record.wins < w2.record.wins)
//        return true;
//        if (w2.record.wins < w1.record.wins)
//        return false;
//
//        if (conference.advantageMatrix[w1.wtClass][w1.id / 100][w2.id / 100] < 0)
//        return true;
//        else
//        return false;
//
//        }
