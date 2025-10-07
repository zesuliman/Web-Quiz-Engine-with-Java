//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package engine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebQuizEngineController {
    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final QuizRepository quizRepository;

    @Autowired
    public WebQuizEngineController(QuizRepository repository) {
        this.quizRepository = repository;
    }

    @GetMapping({"/quizzes"})
    public String quizzes() {
        String jsonResponse = "";
        Iterable<Quiz> retrievedQuizzes = this.quizRepository.findAll();

        try {
            jsonResponse = this.jsonMapper.writeValueAsString(retrievedQuizzes);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return jsonResponse;
    }

    @GetMapping({"/quizzes/{id}"})
    public String quizzes(@PathVariable(name = "id") Long id) {
        Quiz foundQuiz = (Quiz)this.quizRepository.findById(id).orElseThrow(QuizNotFoundException::new);
        String response = "";

        try {
            response = this.jsonMapper.writeValueAsString(foundQuiz);
            return response;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping({"/quizzes"})
    public String quizzes(@RequestBody Quiz newQuiz) {
        Quiz savedQuiz = (Quiz)this.quizRepository.save(newQuiz);
        String jsonResponse = "";

        try {
            jsonResponse = this.jsonMapper.writeValueAsString(savedQuiz);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return jsonResponse;
    }

    @PostMapping({"/quizzes/{id}/solve"})
    public QuizAnswer solveQuiz(@PathVariable Long id, @RequestParam int answer) {
        Quiz quiz = this.quizRepository.findById(id).orElseThrow(QuizNotFoundException::new);
        return answer == quiz.getAnswer() ? new QuizAnswer(true) : new QuizAnswer(false);
    }
}
