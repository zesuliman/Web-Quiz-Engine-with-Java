package engine;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
@JsonPropertyOrder({"title","text","options"})
public class Quiz{
    private String title;
    private String text;
    private ArrayList<String> options;

    public Quiz() {
    }

    public Quiz(String title, String text, ArrayList<String> options) {
        this.title = title;
        this.text = text;
        this.options = options;
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