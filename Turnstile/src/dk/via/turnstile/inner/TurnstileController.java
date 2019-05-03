package dk.via.turnstile.inner;

public interface TurnstileController {
	void lock();
	void unlock();
	void returnCoin();
	void alarm();
}
