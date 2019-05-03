package dk.via.turnstile;

public class Turnstile {
	private TurnstileState state;
	private TurnstileController controller;
	
	public Turnstile(TurnstileController controller) {
		this.controller = controller;
		this.state = new Closed(this);
	}
	
	public void coin() {
		state.onCoin();
	}
	
	public void pass() {
		state.onPass();
	}
	void setState(TurnstileState state) {
		this.state = state;
	}

	void unlock() {
		controller.unlock();
	}

	void lock() {
		controller.lock();
	}

	void alarm() {
		controller.alarm();
	}

	void returnCoin() {
		controller.returnCoin();
	}
}
