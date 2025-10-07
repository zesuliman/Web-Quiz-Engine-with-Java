package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.ArrayList;
@JsonPropertyOrder({"title","text","options"})
@Entity
public class Quiz{
    @Id
    @SequenceGenerator(
            name="quiz_id_generator",
            sequenceName = "quiz_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_id_generator")
    private Long ID;
    private String title;
    private String text;
    private ArrayList<String> options;
    private Integer answer;


    public Quiz() {
    }

    public Quiz(Long ID, String title, String text, ArrayList<String> options, Integer answer) {
        this.ID = ID;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public Quiz(String title, String text, ArrayList<String> options) {
        this.title = title;
        this.text = text;
        this.options = options;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    @JsonIgnore
    public Integer getAnswer() {
        return answer;
    }
    @JsonProperty("answer")
    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}