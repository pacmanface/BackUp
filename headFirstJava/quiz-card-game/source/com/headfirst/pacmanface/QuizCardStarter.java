package com.headfirst.pacmanface;

public class QuizCardStarter {
    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();

        QuizCardPlayer player = new QuizCardPlayer();
        player.go();
    }
}
