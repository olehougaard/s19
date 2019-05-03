package dk.via.turnstile;

public class Closed implements TurnstileState {
	private Turnstile turnstile;

	public Closed(Turnstile turnstile) {
		this.turnstile = turnstile;
	}

	@Override
	public void onCoin() {
		turnstile.unlock();
		turnstile.setState(new Open(turnstile));
	}

	@Override
	public void onPass() {
		turnstile.alarm();
		turnstile.setState(this);
	}

}
