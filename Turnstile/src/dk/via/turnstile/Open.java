package dk.via.turnstile;

public class Open implements TurnstileState {
	private Turnstile turnstile;

	public Open(Turnstile turnstile) {
		this.turnstile = turnstile;
	}

	@Override
	public void onCoin() {
		turnstile.returnCoin();
		turnstile.setState(this);
	}

	@Override
	public void onPass() {
		turnstile.lock();
		turnstile.setState(new Closed(turnstile));
	}
}
