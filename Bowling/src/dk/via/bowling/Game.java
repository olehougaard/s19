package dk.via.bowling;

public class Game {
	private int frameNumber;
	private Frame[] frames;
	
	public Game(int numberOfFrames) {
		if (numberOfFrames < 1) throw new IllegalArgumentException(String.format("Game requires at least 1 frame (was %d).", numberOfFrames));
		this.frameNumber = 1;
		this.frames = new Frame[numberOfFrames];
		for(int i = 0; i < frames.length - 1; i++) {
			frames[i] = new Frame();
		}
		frames[frames.length - 1] = new LastFrame();
	}

	public int getPoints() {
		int points = 0;
		for(int i = 0; i < frames.length; i++)
			points += frames[i].getPoints();
		return points;
	}

	public int getFrameNumber() {
		return frameNumber;
	}

	public void roll(int pins) {
		checkPreconditions(pins);
		for(int i = 0; i < frameNumber; i++)
			if (!frames[i].isScored()) frames[i].roll(pins);
		if (frames[frameNumber - 1].isPlayed()) {
			frameNumber++;
		}
	}

	private void checkPreconditions(int pins) {
		if (frameNumber > frames.length) 
			throw new IllegalStateException("Game has ended.");
		if (pins < 0 || pins > 10) 
			throw new IllegalArgumentException(String.format("Can only roll from 0 to 10 pins (was %d).", pins));
		int remainingPins = frames[frameNumber - 1].getRemainingPins();
		if (pins > remainingPins) 
			throw new IllegalStateException(String.format("Cannot roll more than remaining pins. %d > %d", pins, remainingPins));
	}

	public int getPoints(int frameNumber) {
		return frames[frameNumber - 1].getPoints();
	}
}
