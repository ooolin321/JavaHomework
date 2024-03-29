package unitTest;

public class BowlingGame {
    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins; //紀錄每球打的瓶數
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        int frame;
        for (frame = 0; frame < 10; frame++) { //frame:局數 frameIndex:第幾球
            if (isStrike(frameIndex)) {
                score += 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2];
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + rolls[frameIndex + 2];
                frameIndex += 2;
            } else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;
            }


        }


        return score;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }
}
