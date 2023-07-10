package melsongit.com.github.wrestle;

import umontreal.ssj.rng.MT19937;

public class Conference {

    MT19937 mt19937;
}

    public:
    Conference()
    {

        std::random_device rd;

        std::mt19937 e2(rd());

        //std::normal_distribution<double> distribution(10, 1);
        for (int schoolName = 100; schoolName < 900; schoolName += 100)
        {
            int numberOfWrestlers = 12;//min(static_cast<int>(round<int>(distribution(e2))), 12);
            schools.push_back(School(schoolName, numberOfWrestlers));
        }

        for (int i = 0; i < 12; ++i)
            for (int j = 0; j < 8; ++j)
                for (int k = 0; k < 8; ++k)
                    advantageMatrix[i][j][k] = 0;
    }
    void simulateSeason()
    {
        for (int i = 0; i < 8; ++i)
            for (int j = i + 1; j < 8; ++j)
                schoolsMatch(i, j);
    }

    int bestSchool()
    {
        int bestSchool = -1;
        for (int i = 0; i < 8; ++i)
        {
            if (schools[i].totalSchoolScore() > bestScore)
            {
                bestScore = schools[i].totalSchoolScore();
                bestSchool = (i + 1) * 100;
            }
        }

        return bestSchool;
    }

    int wrestlersMatch(int wrestler1, int wrestler2)
    {
        if (wrestler1 % 100 < 1 || wrestler2 % 100 < 1)
            return 0;
        Wrestler& w1 = schools[wrestler1 / 100 - 1].wrestlers[wrestler1 % 100 - 1];
        Wrestler& w2 = schools[wrestler2 / 100 - 1].wrestlers[wrestler2 % 100 - 1];

        float sigma = max(abs(w1.abilityScore - w2.abilityScore) / 3.f, 15.f);

        std::random_device rd;

        std::mt19937 e2(rd());

        std::normal_distribution<double> distribution1(w1.abilityScore, sigma);
        std::normal_distribution<double> distribution2(w2.abilityScore, sigma);
        float score1 = distribution1(e2);
        float score2 = distribution2(e2);

        if (score1 > score2)
        {
            w1.record.wins++;
            w2.record.loses++;
            advantageMatrix[w1.wtClass][wrestler1 / 100 - 1][wrestler2 / 100 - 1]++;
            advantageMatrix[w1.wtClass][wrestler2 / 100 - 1][wrestler1 / 100 - 1]--;
            return 1;
        }
        else
        {
            w1.record.loses++;
            w2.record.wins++;
            advantageMatrix[w1.wtClass][wrestler1 / 100 - 1][wrestler2 / 100 - 1]--;
            advantageMatrix[w1.wtClass][wrestler2 / 100 - 1][wrestler1 / 100 - 1]++;
            return -1;
        }
    }
    void schoolsMatch(int school1, int school2)
    {
        for (int i = 1; i < 13; ++i)
        {
            int w1 = 100 * (school1 + 1) + schools[school1].getWrestler(i) + 1;
            int w2 = 100 * (school2 + 1) + schools[school2].getWrestler(i) + 1;
            wrestlersMatch(w1, w2);
        }
    }
    vector<School> schools;
    float bestScore;
    int advantageMatrix[13][8][8];
};

