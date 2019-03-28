package dk.via.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	private Game game;
	
	@Before
	public void setUp() {
		game = new Game(10);
	}

	@Test
	public void gameStartsAt0Points() {
		assertEquals(0, game.getPoints());
	}
	
	@Test
	public void gameStartsAtFrame1() {
		assertEquals(1, game.getFrame());
	}

	@Test
	public void incompleteFrameIsNotScoredYet() {
		game.roll(7);
		assertEquals(0, game.getPoints());
	}
	
	@Test
	public void incompleteFrameIsNotScoredInFrameScore() {
		game.roll(7);
		assertEquals(0, game.getPoints(1));
	}
	
	@Test
	public void anOpenFrameIsScoredImmediately() {
		game.roll(7);
		game.roll(2);
		assertEquals(9, game.getPoints());
	}
	
	@Test
	public void anOpenFrameIsScoredInTheFrameScore() {
		game.roll(7);
		game.roll(2);
		assertEquals(9, game.getPoints(1));
	}
	
	@Test
	public void gameMovesToNextFrameAfterOpenFrame() {
		game.roll(7);
		game.roll(2);
		assertEquals(2, game.getFrame());
	}
	
	@Test
	public void gameMovesToFrameThreeAfterTwoOpenFrames() {
		game.roll(7);
		game.roll(2);
		game.roll(7);
		game.roll(2);
		assertEquals(3, game.getFrame());
	}
	
	@Test
	public void totalScoreIsTheSumOfTheFrameScores() {
		game.roll(7);
		game.roll(2);
		game.roll(7);
		game.roll(2);
		assertEquals(18, game.getPoints());
	}

	
	@Test
	public void gameKeepsScoreAfterStartingNextFrame() {
		game.roll(7);
		game.roll(2);
		game.roll(7);
		assertEquals(9, game.getPoints());
	}
	
	@Test
	public void gameKeepsFrameOneScoreAfterScoringTwoFrames() {
		game.roll(7);
		game.roll(2);
		game.roll(7);
		game.roll(2);
		assertEquals(9, game.getPoints(1));
	}
	
	@Test
	public void gameAllowsFetchingAnyFrameScore() {
		game.roll(7);
		game.roll(2);
		game.roll(5);
		game.roll(1);
		assertEquals(6, game.getPoints(2));
	}
	
	@Test
	public void aSpareIsNotScoredImmediatelyInTotalScore() {
		game.roll(7);
		game.roll(3);
		assertEquals(0, game.getPoints());
	}
	
	@Test
	public void aSpareIsNotScoredImmediatelyInFrameScore() {
		game.roll(7);
		game.roll(3);
		assertEquals(0, game.getPoints(1));
	}
	
	@Test
	public void aSpareMovesToNextFrame() {
		game.roll(7);
		game.roll(3);
		assertEquals(2, game.getFrame());
	}
	
	@Test
	public void aSpareIsScoredAfterNextThrow() {
		game.roll(7);
		game.roll(3);
		game.roll(5);
		assertEquals(15, game.getPoints(1));
	}
	
	@Test
	public void aSpareIsScoredInTotalScore() {
		game.roll(7);
		game.roll(3);
		game.roll(5);
		assertEquals(15, game.getPoints());
	}
	
	@Test
	public void aSpareIsScoredAfterNextThrowEvenIfItIsAGutterball() {
		game.roll(7);
		game.roll(3);
		game.roll(0);
		assertEquals(10, game.getPoints(1));
	}
	
	@Test
	public void aStrikeIsNotScoredImmediately() {
		game.roll(10);
		assertEquals(0, game.getPoints(1));
	}
	
	@Test
	public void aStrikeMovesToNextFrame() {
		game.roll(10);
		assertEquals(2, game.getFrame());
	}
	
	@Test
	public void aStrikeIsScoredAfterNextTwoThrows() {
		game.roll(10);
		game.roll(7);
		game.roll(2);
		assertEquals(19, game.getPoints(1));
	}
	
	@Test
	public void twoStrikesAreScoredAfterTwoNextThrows() {
		game.roll(10);
		game.roll(10);
		game.roll(7);
		game.roll(2);
		assertEquals(27, game.getPoints(1));
		assertEquals(19, game.getPoints(2));
	}
	
	@Test
	public void spareLastFrameRequiresOneMoreThrow() {
		game = new Game(1);
		game.roll(7);
		game.roll(3);
		assertEquals(1, game.getFrame());
		game.roll(10);
		assertEquals(2, game.getFrame());
	}
	
	@Test
	public void strikeLastFrameRequiresTwoMoreThrows() {
		game = new Game(1);
		game.roll(10);
		assertEquals(1, game.getFrame());
		game.roll(3);
		game.roll(10);
		assertEquals(2, game.getFrame());
	}
	
	@Test
	public void maxScoreIs300() {
		for(int i = 0; i < 12; i++) {
			game.roll(10);
		}
		assertEquals(300, game.getPoints());
	}
}
