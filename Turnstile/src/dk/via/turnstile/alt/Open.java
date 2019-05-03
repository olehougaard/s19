package dk.via.turnstile.alt;

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
		turnstile.setState(new Closed(turnstile));
	}

	@Override
	public void onEntry() {
		turnstile.unlock();
	}

	@Override
	public void onExit() {
	}
}
