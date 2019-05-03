package dk.via.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game game;
	
	@Before
	public void setUp() {
		game = new Game(10);
	}

	private void rollOpenFrame() {
		game.roll(7);
		game.roll(2);
	}
	
	@Test
	public void gameStartsAtZeroPoints() {
		assertEquals(0, game.getPoints());
	}

	@Test
	public void gameStartsAtFrameOne() {
		assertEquals(1, game.getFrameNumber());
	}
	
	@Test
	public void incompleteFrameIsNotScored() {
		game.roll(7);
		assertEquals(0, game.getPoints());
	}
	
	@Test
	public void incompleteFrameHasZeroPoints() {
		game.roll(7);
		assertEquals(0, game.getPoints(1));
	}
	
	@Test 
	public void incompleteFrameDoesNotAdvanceFrameNumber() {
		game.roll(7);
		assertEquals(1, game.getFrameNumber());
	}
	
	@Test
	public void openFrameIsScoredImmediately() {
		rollOpenFrame();
		assertEquals(9, game.getPoints());
	}

	@Test 
	public void gameMoveOnToFrameTwoAfterOpenFirstFrame() {
		rollOpenFrame();
		assertEquals(2, game.getFrameNumber());
	}
	
	@Test
	public void gameMovesToFrameThreeAfterTwoOpenFrames() {
		rollOpenFrame();
		rollOpenFrame();
		assertEquals(3, game.getFrameNumber());
	}
	
	@Test
	public void gameKeepsScoreForEveryFrame() {
		rollOpenFrame();
		rollOpenFrame();
		assertEquals(9, game.getPoints(1));
		assertEquals(9, game.getPoints(2));
	}
	
	@Test
	public void totalScoreIsTheSumOfTheFrameScores() {
		rollOpenFrame();
		rollOpenFrame();
		assertEquals(game.getPoints(1) + game.getPoints(2), game.getPoints());
	}
	
	@Test
	public void aSpareIsNotScoredImmediately() {
		rollSpare();
		assertEquals(0, game.getPoints());
	}
	
	@Test
	public void aSpareMovesToNextFrame() {
		rollSpare();
		assertEquals(2, game.getFrameNumber());
	}
	
	@Test
	public void aSpareIsScoredAfterNextThrow() {
		rollSpare();
		game.roll(4);
		assertEquals(14, game.getPoints(1));
	}

	private void rollSpare() {
		game.roll(7);
		game.roll(3);
	}
	
	private void rollStrike() {
		game.roll(10);
	}
	
	@Test
	public void aStrikeIsNotScoredImmediately() {
		rollStrike();
		assertEquals(0, game.getPoints());
	}
	
	@Test
	public void aStrikeMovesToNextFrame() {
		rollStrike();
		assertEquals(2, game.getFrameNumber());
	}
	
	@Test
	public void aStrikeIsScoredAfterNextTwoThrows() {
		rollStrike();
		rollOpenFrame();
		assertEquals(19, game.getPoints(1));
	}
	
	@Test
	public void twoStrikesAreScoredAfterNextTwoThrows() {
		rollStrike();
		rollStrike();
		game.roll(7);
		game.roll(2);
		assertEquals(27, game.getPoints(1));
		assertEquals(19, game.getPoints(2));
	}
	
	@Test
	public void extraThrowSpareLastFrame() {
		game = new Game(1);
		game.roll(4);
		game.roll(6);
		assertEquals(1, game.getFrameNumber());
		game.roll(3);
		assertEquals(2, game.getFrameNumber());
	}
	
	@Test
	public void twoExtraThrowsStrikeLastFrame() {
		game = new Game(1);
		game.roll(10);
		assertEquals(1, game.getFrameNumber());
		game.roll(4);
		assertEquals(1, game.getFrameNumber());
		game.roll(3);
		assertEquals(2, game.getFrameNumber());
	}
	
	@Test
	public void maximumScoreIs300() {
		for(int i = 0; i < 12; i++) rollStrike();
		assertEquals(300, game.getPoints());
	}
	
	@Test(expected=IllegalStateException.class)
	public void itsIllegalToThrowPastFinalFrame() {
		game = new Game(1);
		game.roll(3);
		game.roll(6);
		game.roll(3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void itsIllegalToThrowNegativePins() {
		game.roll(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void itsIllegalToThrowMoreThan10pins() {
		game.roll(11);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void itsIllegalToThrowMoreThanRemainingNumberOfPins() {
		game.roll(5);
		game.roll(6);
	}
	
	@Test
	public void theLastFrameHas10RemainingPinsAfterASpare() {
		game = new Game(1);
		game.roll(6);
		game.roll(4);
		game.roll(10);
		assertEquals(20, game.getPoints());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void theLastFrameDoesNotHaveMoreThan10RemainingPinsAfterASpare() {
		game = new Game(1);
		game.roll(6);
		game.roll(4);
		game.roll(11);
	}
	
	@Test
	public void theLastFrameHas10RemainingPinsAfterAStrike() {
		game = new Game(1);
		game.roll(10);
		game.roll(10);
		assertEquals(1, game.getFrameNumber());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void theLastFrameDoesNotHaveMoreThan10RemainingPinsAfterAStrike() {
		game = new Game(1);
		game.roll(10);
		game.roll(11);
	}
	
	@Test
	public void theLastFrameHas10RemainingPinsAfterTwoStrikes() {
		game = new Game(1);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		assertEquals(30, game.getPoints());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void theLastFrameDoesNotHaveMoreThan10RemainingPinsAfterTwoStrikes() {
		game = new Game(1);
		game.roll(10);
		game.roll(10);
		game.roll(11);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void theLastFrameDoesNotAllowThrowingMoreThanRemainingPinsAfterAStrikeAndAnOpenThrow() {
		game = new Game(1);
		game.roll(10);
		game.roll(7);
		game.roll(4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void itsIllegalToHaveLessThanOneFrame() {
		new Game(0);
	}
}
