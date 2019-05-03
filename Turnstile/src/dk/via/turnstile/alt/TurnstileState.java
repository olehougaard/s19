package dk.via.turnstile.alt;

public interface TurnstileState {
	void onEntry();
	void onCoin();
	void onPass();
	void onExit();
}
