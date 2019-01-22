package threads.nonBlockingCache;

public class OptimisticException extends RuntimeException {
    public OptimisticException (String message) {
        super(message);
    }
}
