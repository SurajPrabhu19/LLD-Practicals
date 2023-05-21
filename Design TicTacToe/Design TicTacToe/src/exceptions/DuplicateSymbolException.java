package exceptions;

public class DuplicateSymbolException extends RuntimeException {

    public DuplicateSymbolException(Character character) {
        super();
        System.out.println("Duplicate Symbol Exception: " + character);
    }

}