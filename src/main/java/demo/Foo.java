package demo;

public class Foo {

    private final String message;

    public Foo(String message) {
        System.out.println("Foo is constructed");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
