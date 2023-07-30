package melsongit.com.github.wrestle;

public class MainApplication {

    public static void main(String[] args) {

        Conference conf;
        for (int i = 0; i < 2; ++i)
            conf.simulateSeason();

        cout << "Conference winner: the team of " << conf.bestSchool() << " school with the score of ";
        cout.precision(3);
        cout << conf.bestScore << "! Congrats!" << endl;

        for (int i = 1; i < 13; ++i) {
            Tournament tournament(conf, i);
            tournament.simulate();
            tournament.printWinner();
        }
    }
}