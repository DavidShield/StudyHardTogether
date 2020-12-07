package com.david.StudyHardTogether.BowlingGame;

public class Frame {
    int roundNum;
    int[] hits;
    int frameNumebr;
    int numberOfRoll;
    int frameScore;

    int firstExtraHit = 0;
    int secondExtraHit = 0;

    Frame(int round) {
        this.roundNum = round;
        hits = new int[2];
        frameNumebr = 0;
        numberOfRoll = 0;
        frameScore = 0;
    }

    public void add(int score) {
        hits[numberOfRoll++] = score;
        addFrameScore(score);
    }

    public boolean isStrike() {
        return hits[0] == 10;
    }

    public boolean isSpare() {
        return !isStrike() && hits[0] + hits[1] == 10;
    }

    public void setFirstExtraHit(int num) {
        numberOfRoll++;
        this.firstExtraHit = num;
    }

    public void setSecondExtraHit(int num) {
        numberOfRoll++;
        this.secondExtraHit = num;
    }

    public void addFrameScore(int score) {
        this.frameScore += score;
    }

    public int getRoundNum() {
        return roundNum;
    }

    public int[] getHits() {
        return hits;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public int getNumberOfRoll() {
        return numberOfRoll;
    }

    public int getFirstExtraHit() {
        return firstExtraHit;
    }

    public int getSecondExtraHit() {
        return secondExtraHit;
    }
}
