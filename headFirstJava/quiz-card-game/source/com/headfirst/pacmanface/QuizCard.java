package com.headfirst.pacmanface;

public class QuizCard {
    private String answer;
    private String question;

    public QuizCard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }
    
}
