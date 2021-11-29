package bots.crew.juniortask;

import static bots.crew.juniortask.App.isExit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JuniorTaskApplication implements CommandLineRunner {
    private final App app;

    public JuniorTaskApplication(App app) {
        this.app = app;
    }

    public static void main(String[] args) {
        SpringApplication.run(JuniorTaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (isExit()) {
            app.run();
        }
    }
}
