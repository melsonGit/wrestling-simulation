package melsongit.com.github.wrestle;
;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public class Tournament {

    List<Wrestler> participants = new ArrayList<>();
    List<Match> matches = new ArrayList<>();
    Conference conf;
    int wtClass;

    public Tournament(Conference conference, int weightClass) {
        conf = conference;
        wtClass = weightClass;

        for (int i = 0; i < 7; ++i) {
            int id = conf.schools.get(i).getWrestler(weightClass);
            if (id > -1)
                participants.add(conf.schools.get(i).wrestlers.get(id % 100));
        }
        seed();
    }

    private void seed() {
        Competition comp = new Competition(conf);
        participants.sort(comp.wrestlerComparator);
    }

    public void simulate() {
        matches.add(new Match(participants.get(0), participants.get(6)));
        matches.add(new Match(participants.get(4), participants.get(3)));
        matches.add(new Match(participants.get(2), participants.get(5)));
        matches.add(new Match(participants.get(1), participants.get(6)));
        matches.add(new Match(matches.get(0).winner, matches.get(1).winner));
        matches.add(new Match(matches.get(2).winner, matches.get(3).winner));
        matches.add(new Match(matches.get(0).loser, matches.get(1).loser));
        matches.add(new Match(matches.get(2).loser, matches.get(3).loser));
        matches.add(new Match(matches.get(4).loser, matches.get(7).winner));
        matches.add(new Match(matches.get(5).loser, matches.get(6).winner));
        matches.add(new Match(matches.get(6).loser, matches.get(7).loser));
        matches.add(new Match(matches.get(8).loser, matches.get(9).loser));
        matches.add(new Match(matches.get(9).winner, matches.get(10).winner));
        matches.add(new Match(matches.get(5).winner, matches.get(6).winner));
    }
    public void printWinner() {
        System.out.println("And the winner in the weight class " + wtClass + " is number " + matches.get(13).winner.id);
    }

    private static class Competition {

        Conference conference;
        public Competition(Conference conference){
            this.conference = conference;
        }

        public Comparator<Wrestler> wrestlerComparator = new Comparator<Wrestler>() {
            @Override
            public int compare(Wrestler w1, Wrestler w2) {
                if (w1.getFightRecord().getWins() < w2.getFightRecord().getWins()) {
                    return -1;
                } else if (w2.getFightRecord().getWins() < w1.getFightRecord().getWins()) {
                    return 1;
                }

                int id1 = w1.getId() / 100;
                int id2 = w2.getId() / 100;

                return Integer.compare
                        (conference.advantageMatrix[w1.getWeightClass()][id1][id2], 0);
            }
        };
    }
}