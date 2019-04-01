package dk.via.bowling;

public class LastFrame extends Frame{
	@Override
	public boolean isPlayed() {
		return isScored();
	}
	
	@Override
	public int getRemainingPins() {
		if (isStrike())
			return 10;
		else if (isSpare() && rolls == 2)
			return 10;
		else
			return super.getRemainingPins();
	}
}
