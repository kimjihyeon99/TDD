
public class Game {
	
	private int rolls[] = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score=0;
		int frameIndex=0;
		for(int frame=0;frame<10;frame++) {
			if(isStrike(frameIndex)) {
				score+= 10+ strikeBonus(frameIndex);
				frameIndex++;
			}
			else if(isSpare(frameIndex)) {
				score+= 10+ spareBonus(frameIndex);//bonus
				frameIndex+=2;
			}else {
				score+= sumOfBallsInFrame(frameIndex);
				frameIndex+=2;
				
			}
		}
		return score;
	}

	public int spareBonus(int frameIndex) {
		return rolls[frameIndex+2];
	}

	public int strikeBonus(int frameIndex) {
		return rolls[frameIndex+1]+spareBonus(frameIndex);
	}

	public int sumOfBallsInFrame(int frameIndex) {
		return rolls[frameIndex]+rolls[frameIndex+1];
	}

	public boolean isStrike(int frameIndex) {
		return rolls[frameIndex]==10;
	}

	public boolean isSpare(int frameIndex) {
		return sumOfBallsInFrame(frameIndex) ==10;
	}

}
