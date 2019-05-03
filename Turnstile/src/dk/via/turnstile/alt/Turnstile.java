package dk.via.turnstile.alt;

public class Turnstile {
	private TurnstileState state;
	private TurnstileController controller;
	
	public Turnstile(TurnstileController controller) {
		this.controller = controller;
	}
	
	public void coin() {
		state.onCoin();
	}
	
	public void pass() {
		state.onPass();
	}
	public void setState(TurnstileState state) {
		state.onExit();
		this.state = state;
		state.onEntry();
	}

	public void unlock() {
		controller.unlock();
	}

	public void lock() {
		controller.lock();
	}

	public void alarm() {
		controller.alarm();
	}

	public void returnCoin() {
		controller.returnCoin();
	}
}
