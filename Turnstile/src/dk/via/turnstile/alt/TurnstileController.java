package dk.via.turnstile.alt;

public interface TurnstileController {
	void unlock();
	void lock();
	void alarm();
	void returnCoin();
}
