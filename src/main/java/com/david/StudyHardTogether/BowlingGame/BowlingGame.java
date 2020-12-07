package com.david.StudyHardTogether.BowlingGame;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BowlingGame {
    public static final String STRIKE = "Strike";
    public static final String SPARE = "Spare";
    public static final String MISS = "Miss";
    public static final int TOTAL_ROUND = 10;

    private int inTimeScore;
    private int previousScore;

    private int currentRound;
    private boolean firstHit;

    Frame[] frames;

    public BowlingGame() {
        firstHit = true;
        inTimeScore = 0;

        frames = new Frame[TOTAL_ROUND];
    }

    /**
     * Throw A ball
     * @param num number of pins are knocked
     */
    public void throwTheBall(String num) throws Exception {
        if(isNumeric(num)) {
            throwTheBall(Integer.valueOf(num));
        } else {
            switch (num) {
                case STRIKE:
                    throwTheBall(10);
                    break;
                case "X":
                    throwTheBall(10);
                    break;
                case "x":
                    throwTheBall(10);
                    break;
                case SPARE:
                    throwTheBall(10 - previousScore);
                    break;
                case "/":
                    throwTheBall(10 - previousScore);
                    break;
                case MISS:
                    throwTheBall(0);
                    break;
                case "-":
                    throwTheBall(0);
                    break;
                default:
                    System.out.println("Unknown Input");
                    throw new Exception("Invalid Format");
            }
        }
    }

    /**
     * Throw A ball
     * @param num number of pins are knocked
     */
    public void throwTheBall(int num) throws Exception {
        if(num > 10)
            throw new Exception("Value bigger than 10");
        if(currentRound < 10) {
            if (firstHit) {
                // First hit. Calc in-time score
                frames[currentRound] = new Frame(currentRound);
                if(currentRound > 0) {
                    if(frames[currentRound - 1].isStrike() || frames[currentRound - 1].isSpare()) {
                        inTimeScore += num;
                        frames[currentRound - 1].addFrameScore(num);
                    }
                    if(currentRound > 1 && frames[currentRound - 1].isStrike() && frames[currentRound - 2].isStrike()) {
                        inTimeScore += num;
                        frames[currentRound - 2].addFrameScore(num);
                    }
                }
                frames[currentRound].add(num);
                if (num != 10) {
                    firstHit = false;
                } else {
                    currentRound++;
                }
            } else {
                // second hit. Calc in-time score
                if(currentRound > 0) {
                    if(frames[currentRound - 1].isStrike()) {
                        inTimeScore += num;
                        frames[currentRound - 1].addFrameScore(num);
                    }
                }
                frames[currentRound].add(num);
                currentRound++;
                firstHit = true;
            }
            inTimeScore += num;
        } else {
            if(currentRound == 10) {
                // First last hit
                if(frames[currentRound - 1].isStrike()) {
                    if(currentRound > 1 && frames[currentRound - 2].isStrike()) {
                        inTimeScore += num;
                        frames[currentRound - 2].addFrameScore(num);
                    }
                }
                frames[TOTAL_ROUND - 1].setFirstExtraHit(num);
                currentRound++;
            }
            else {
                frames[TOTAL_ROUND - 1].setSecondExtraHit(num);
            }
            frames[TOTAL_ROUND - 1].addFrameScore(num);
            inTimeScore += num;
        }

        System.out.println("current score: " + inTimeScore);
        previousScore = num;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Frame[] getFrames() {
        return Arrays.stream(frames)
                .filter(r -> r != null)
                .toArray(Frame[]::new);
    }

    public int getInTimeScore() {
        return inTimeScore;
    }
}
