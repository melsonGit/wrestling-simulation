package melsongit.com.github.wrestle;

public class MainApplication {

    public static void main(String[] args) {

        Conference conf = new Conference();
        for (int i = 0; i < 2; ++i)
            conf.simulateSeason();

        System.out.println("Conference winner: the team of " + conf.bestSchool() + " school with the score of ");
        System.out.printf("%.3f! Congrats!\n", conf.getBestScore());

        for (int i = 1; i < 13; ++i) {
            Tournament tournament = new Tournament(conf, i);
            tournament.simulate();
            tournament.printWinner();
        }
    }
}