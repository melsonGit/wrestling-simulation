package melsongit.com.github.wrestle;

public class Tournament {
}

//class Tournament
//{
//    public:
//    Tournament(Conference& conference, int weightClass): conf(&conference), wtClass(weightClass)
//    {
//        for (int i = 0; i < 8; ++i)
//        {
//            int id = (*conf).schools[i].getWrestler(weightClass);
//            if (id > -1)
//                participants.push_back((*conf).schools[i].wrestlers[id % 100]);
//        }
//        seed();
//    }
//
//    void seed()
//    {
//        Comp comp(*conf);
//        sort(participants.begin(), participants.end(), comp);
//    }
//
//    void simulate()
//    {
//        matches.push_back(Match(participants[0], participants[7]));
//        matches.push_back(Match(participants[4], participants[3]));
//        matches.push_back(Match(participants[2], participants[5]));
//        matches.push_back(Match(participants[1], participants[6]));
//        matches.push_back(Match(matches[0].winner, matches[1].winner));
//        matches.push_back(Match(matches[2].winner, matches[3].winner));
//        matches.push_back(Match(matches[0].looser, matches[1].looser));
//        matches.push_back(Match(matches[2].looser, matches[3].looser));
//        matches.push_back(Match(matches[4].looser, matches[7].winner));
//        matches.push_back(Match(matches[5].looser, matches[6].winner));
//        matches.push_back(Match(matches[6].looser, matches[7].looser));
//        matches.push_back(Match(matches[8].looser, matches[9].looser));
//        matches.push_back(Match(matches[9].winner, matches[10].winner));
//        matches.push_back(Match(matches[5].winner, matches[6].winner));
//    }
//    void printWinner()
//    {
//        cout << "And the winner in the weight class " << wtClass << " is number " << matches[13].winner.id << endl;
//    }
//    vector<Wrestler> participants;
//    vector<Match> matches;
//    Conference* conf;
//    int wtClass;
//};
