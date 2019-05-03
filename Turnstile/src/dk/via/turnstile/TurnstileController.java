package dk.via.turnstile;

public interface TurnstileController {
	void unlock();
	void lock();
	void alarm();
	void returnCoin();
}
