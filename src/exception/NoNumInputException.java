package exception;

public class NoNumInputException extends Exception {
    public NoNumInputException() {
        super("----------សូមបញ្ចូលតែអក្សរ!!!!---------");
    }
    public NoNumInputException(String message) {}
}
