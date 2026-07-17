package com.example.splitwise_jul_2026;

import com.example.splitwise_jul_2026.commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseJul2026Application implements CommandLineRunner {

    private final CommandExecutor commandExecutor;

    public SplitwiseJul2026Application(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseJul2026Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("======= Splitwse CLI App =========");
        System.out.println("Enter commands (type 'exit' to quit)");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;
            if (input.equalsIgnoreCase("exit")) break;

            commandExecutor.execute(input);
        }
    }
}
