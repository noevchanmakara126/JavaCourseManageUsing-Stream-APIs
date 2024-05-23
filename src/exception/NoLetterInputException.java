package exception;

public class NoLetterInputException extends Exception{
    public NoLetterInputException(){
        super("----------សូមបញ្ចូលលលេខសម្គាល់វគ្គសិក្សាតែជាប្រភេទលេខ[Number Only]-----------------");
    }
    public NoLetterInputException(String message){
        super(message);
    }
}
