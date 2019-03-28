package dk.via.bowling;

public class Game {
	private int points;
	private int frame;
	private Frame[] frames;
	
	public Game(int noOfFrames) {
		this.points = 0;
		this.frame = 1;
		this.frames = new Frame[noOfFrames];
		for(int i = 0; i < frames.length - 1; i++) {
			frames[i] = new Frame();
		}
		frames[noOfFrames-1] = new FinalFrame();
	}

	public int getPoints() {
		return points;
	}

	public void roll(int pins) {
		for(int i = 0; i < frame; i++) {
			if (!frames[i].isScored()) {
				frames[i].roll(pins);
				if (frames[i].isScored()) points += frames[i].getPoints();
			}
		}
		if (frames[frame - 1].isPlayed()) frame++;
	}

	public int getFrame() {
		return frame;
	}

	public int getPoints(int i) {
		return frames[i - 1].getPoints();
	}
}
