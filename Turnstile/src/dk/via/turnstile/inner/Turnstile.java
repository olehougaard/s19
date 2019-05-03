package dk.via.turnstile.inner;

public class Turnstile {
	private TurnstileController controller;
	private TurnstileState state;
	
	public Turnstile(TurnstileController controller) {
		state = new Closed(this);
		this.controller = controller;
	}
	
	public void coin() {
		state.onCoin();
	}
	
	public void pass() {
		state.onPass();
	}
	
	private void setState(TurnstileState state) {
		this.state = state;
	}
	
	private void lock() {
		controller.lock();
	}
	
	private void unlock() {
		controller.unlock();
	}
	
	private void returnCoin() {
		controller.returnCoin();
	}
	
	private void alarm() {
		controller.alarm();
	}

	private static interface TurnstileState {
		void onCoin();
		void onPass();
	}

	private static class Open implements TurnstileState {
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

	private static class Closed implements TurnstileState {
		private Turnstile turnstile;
		
		public Closed(Turnstile turnstile) {
			this.turnstile = turnstile;
		}
		
		@Override
		public void onCoin() {
			turnstile.unlock();
			Open openState = new Open(turnstile);
			turnstile.setState(openState);
		}

		@Override
		public void onPass() {
			turnstile.alarm();
			turnstile.setState(this);
		}

	}
}
