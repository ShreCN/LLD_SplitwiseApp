package lld.design.splitwiseapp;

import lld.design.splitwiseapp.command.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseAppApplication implements CommandLineRunner {

    private CommandExecutor commandExecutor;
    private Scanner sc = new Scanner(System.in);
    public SplitwiseAppApplication(){
    }
    @Override
    public void run(String... args) throws Exception {
        while (true){
            String input = sc.nextLine();
            commandExecutor.execute(input);
        }
    }

    public static void main(String[] args) {

        SpringApplication.run(SplitwiseAppApplication.class, args);
    }

}
