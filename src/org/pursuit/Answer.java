package org.pursuit;

public class Answer {
    HeroType heroType;
    String answerString;


    public Answer(String answerString, HeroType heroType) {
        this.heroType = heroType;
        this.answerString = answerString;

    }

    public HeroType getHeroType() {
        return heroType;
    }
}

