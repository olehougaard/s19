package dk.via.bowling;

public class Frame {
	private int rolls;
	private int points;
	private int[] pins;
	
	public Frame() {
		this.rolls = 0;
		this.points = 0;
		pins = new int[3];
	}
	
	private boolean isSpare() {
		return pins[0] + pins[1] == 10;
	}
	
	private boolean isStrike() {
		return pins[0] == 10;
	}

	public int getPoints() {
		return isScored() ? points : 0;
	}

	public void roll(int pins) {
		this.pins[rolls] = pins;
		rolls++;
		points += pins;
	}

	
	public boolean isPlayed() {
		return isStrike() || rolls == 2;
	}

	public boolean isScored() {
		if (isSpare() || isStrike()) 
			return rolls == 3;
		else 
			return rolls == 2;
	}
}
