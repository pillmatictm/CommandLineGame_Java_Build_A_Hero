package org.pursuit;


import java.util.HashMap;

public class Question {

    private HashMap<String, Answer> heroTypeHashMap = new HashMap<>();

    private String promptQuestion;

    public Question(String promptQuestion) {
        this.promptQuestion = promptQuestion;

    }

    public String getPromptQuestion() {
        return promptQuestion;
    }

    public void addAnswer(String key, Answer answer) {
        this.heroTypeHashMap.put(key, answer);

    }

    public Answer getAnswer(String key) {

        return heroTypeHashMap.get(key);

    }

    public void printAnswer() {
        for (String answer : heroTypeHashMap.keySet()) {
            System.out.println(answer + " " + heroTypeHashMap.get(answer).answerString);

        }
    }
}

