package dk.via.turnstile.alt;

public class Closed implements TurnstileState {
	private Turnstile turnstile;

	public Closed(Turnstile turnstile) {
		this.turnstile = turnstile;
	}

	@Override
	public void onCoin() {
		turnstile.setState(new Open(turnstile));
	}

	@Override
	public void onPass() {
		turnstile.alarm();
		turnstile.setState(this);
	}

	@Override
	public void onEntry() {
		turnstile.lock();
	}

	@Override
	public void onExit() {
	}

}
