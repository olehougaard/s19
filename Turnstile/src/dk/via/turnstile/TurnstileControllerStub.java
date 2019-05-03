package dk.via.turnstile;

import java.io.PrintStream;

public class TurnstileControllerStub implements TurnstileController {
	private PrintStream out;

	public TurnstileControllerStub(PrintStream out) {
		this.out = out;
	}

	public void unlock() {
		out.println("unlock");
	}

	@Override
	public void lock() {
		out.println("lock");
	}

	@Override
	public void alarm() {
		out.println("alarm");
	}

	@Override
	public void returnCoin() {
		out.println("Return coin");
	}
	
	
}
