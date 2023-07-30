package melsongit.com.github.wrestle;

import java.util.List;

public class Tournament {

    List<Wrestler> participants;
    List<Match> matches;
    Conference conf;
    int wtClass;

    public Tournament(Conference conference, int weightClass) {
        conf = conference;
        wtClass = weightClass;

        for (int i = 0; i < 8; ++i) {
            int id = (*conf).schools[i].getWrestler(weightClass);
            if (id > -1)
                participants.push_back((*conf).schools[i].wrestlers[id % 100]);
        }
        seed();
    }

    public void seed() {
        Comp comp(*conf);
        sort(participants.begin(), participants.end(), comp);
    }

    public void simulate() {
        matches.push_back(Match(participants[0], participants[7]));
        matches.push_back(Match(participants[4], participants[3]));
        matches.push_back(Match(participants[2], participants[5]));
        matches.push_back(Match(participants[1], participants[6]));
        matches.push_back(Match(matches[0].winner, matches[1].winner));
        matches.push_back(Match(matches[2].winner, matches[3].winner));
        matches.push_back(Match(matches[0].loser, matches[1].loser));
        matches.push_back(Match(matches[2].loser, matches[3].loser));
        matches.push_back(Match(matches[4].loser, matches[7].winner));
        matches.push_back(Match(matches[5].loser, matches[6].winner));
        matches.push_back(Match(matches[6].loser, matches[7].loser));
        matches.push_back(Match(matches[8].loser, matches[9].loser));
        matches.push_back(Match(matches[9].winner, matches[10].winner));
        matches.push_back(Match(matches[5].winner, matches[6].winner));
    }
    public void printWinner() {
        cout << "And the winner in the weight class " << wtClass << " is number " << matches[13].winner.id << endl;
    }
}