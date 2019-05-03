package dk.via.bowling;

public class Frame {
	protected int[] points;
	protected int rolls;
	
	public Frame() {
		this.points = new int[3];
		this.rolls = 0;
	}
	
	public void roll(int pins) {
		points[rolls] = pins;
		rolls++;
	}
	
	protected boolean isStrike() {
		return points[0] == 10;
	}
	
	protected boolean isSpare() {
		return !isStrike() && points[0] + points[1] == 10;
	}
	
	public int getRemainingPins() {
		return 10 - totalPoints() % 10;
	}
	
	public boolean isPlayed() {
		return isStrike() || rolls == 2;
	}

	public boolean isScored() {
		if (isStrike()) 
			return rolls == 3;
		else if (isSpare())
			return rolls == 3;
		else
			return rolls == 2;
	}

	public int getPoints() {
		if (isScored())
			return totalPoints();
		else
			return 0;
	}

	private int totalPoints() {
		return points[0] + points[1] + points[2];
	}
}
