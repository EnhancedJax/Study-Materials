/**
 * This class demonstrates the core usage of JavaDoc.
 * JavaDoc is a documentation generator for Java that generates API documentation in HTML format from Java source code.
 */
public class Docs {

    /**
     * This is a field variable with a JavaDoc comment.
     */
    private int exampleField;

    /**
     * This is the constructor for JavaDocDemo.
     * @param initialValue The initial value for exampleField.
     */
    public Docs(int initialValue) {
        this.exampleField = initialValue;
    }

    /**
     * This method demonstrates parameter and return value documentation.
     * @param input The input value to be processed.
     * @return The processed value.
     * @throws IllegalArgumentException If the input is negative.
     */
    public int exampleMethod(int input) throws IllegalArgumentException {
        if (input < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        return input * 2;
    }

    /**
     * This method demonstrates how to document a method that doesn't return a value.
     * @param newValue The new value to set for exampleField.
     */
    public void setExampleField(int newValue) {
        this.exampleField = newValue;
    }

    /**
     * This method demonstrates how to use the {@code @link} tag to link to other parts of the documentation.
     * @see #exampleMethod(int)
     * @return The current value of {@link #exampleField}
     */
    public int getExampleField() {
        return this.exampleField;
    }
}

// Note: To generate JavaDoc, use the command:
// javadoc -d doc JavaDocDemo.java
