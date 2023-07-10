package melsongit.com.github.wrestle;

public class School {
}

//class School
//{
//    public:
//    School(int Name, int numWrs):name(Name), numberOfWrestlers(numWrs)
//    {
//        wrestlers.resize(numberOfWrestlers);
//        set<int> wtClasses;
//        srand(time(0));
//
//        std::random_device rd;
//
//        std::mt19937 e2(rd());
//
//        normal_distribution<double> distributionAbility(100, 15);
//        for (int i = 0; i < numberOfWrestlers; ++i)
//        {
//            int cl = 0;
//            int wt = 0;
//            while (wtClasses.find(cl) != wtClasses.end() || cl < 1)
//            {
//                wt = rand() % 192 + 94;
//                for (int j = 1; j < 13; ++j)
//                {
//                    if (wt > weightClasses[j - 1] && wt <= weightClasses[j])
//                    {
//                        cl = j;
//                        break;
//                    }
//                }
//            }
//            int abilityScore = max(static_cast<int>(round<int>(distributionAbility(e2))), 0);
//            wrestlers[i] = Wrestler(cl, wt, name + i + 1, abilityScore);
//            wtClasses.insert(cl);
//        }
//    };
//
//    int getWrestler(int wtClass)
//    {
//        for (int i = 0; i < numberOfWrestlers; ++i)
//            if (wrestlers[i].wtClass == wtClass)
//                return i;
//        return -1;
//    }
//
//    float totalSchoolScore()
//    {
//        int wins = 0;
//        int loses = 0;
//        for (int i = 0; i < numberOfWrestlers; ++i)
//        {
//            wins += wrestlers[i].record.wins;
//            loses += wrestlers[i].record.loses;
//        }
//
//        return float(wins) / (wins + loses);
//    }
//
//    int name;
//    int numberOfWrestlers;
//    vector<Wrestler> wrestlers;
//};
