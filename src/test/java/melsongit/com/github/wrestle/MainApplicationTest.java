package melsongit.com.github.wrestle;

import org.junit.Test;

public class MainApplicationTest {

    @Test
    public void runApplicationMultipleTimes() {
        String[] args = new String[]{""};

        for (int i = 0; i < 100; i++) {
            MainApplication.main(args);
        }
    }
}
