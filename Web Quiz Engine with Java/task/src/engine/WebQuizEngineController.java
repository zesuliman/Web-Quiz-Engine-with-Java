package engine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class WebQuizEngineController{
    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final List<Quiz> quizzes = new ArrayList<>();


    @GetMapping("/quiz")
    public Quiz quiz (){
        Quiz quiz = new Quiz("The Java Logo",
                              "What is depicted on the Java logo?",
                new ArrayList<String>(List.of("Robot","Tea leaf","Cup of coffee","Bug")));
        try {
            jsonMapper.writeValueAsString(quiz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return quiz;
    }

    @PostMapping("/quiz")
    public Answer quiz(@RequestParam int answer){
        return (answer==2?new Answer(true):new Answer(false));
    }
}