package engine;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class WebQuizEngine {
    @Component
    class Runner implements ApplicationRunner {
        private final QuizRepository quizRepository;

        Runner(QuizRepository quizRepository){
            this.quizRepository=quizRepository;
        }
        @Override
        public void run(ApplicationArguments args){

        }
    }

    public static void main(String[] args) {
        SpringApplication.run(WebQuizEngine.class, args);

    }

}
