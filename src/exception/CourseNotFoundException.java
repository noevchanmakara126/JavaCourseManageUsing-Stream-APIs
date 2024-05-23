package exception;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException() {
        super("------ស្វែងរកវគ្គសិក្សាមិនឃើញ---------");
    }
    public CourseNotFoundException(String message) {

    }
}
