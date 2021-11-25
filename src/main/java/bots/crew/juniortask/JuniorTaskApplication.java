package bots.crew.juniortask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JuniorTaskApplication implements CommandLineRunner {
    public static boolean exit = true;
    private final App app;

    public JuniorTaskApplication(App app) {
        this.app = app;
    }

    public static void main(String[] args) {
        SpringApplication.run(JuniorTaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (exit) {
            app.run();
        }
    }
}
