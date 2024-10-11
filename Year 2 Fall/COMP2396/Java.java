public static void print(String str) {
    System.out.println(str); // println is a method that prints a line of text to the console
}
print("Hello World");

public static void main(String[] args) {} // entry point of the program
// args: string array of arguments passed to the program

//#region Data Type
/* ---------------------------------- */
/*           Java Data Type           */
/* ---------------------------------- */
/* ----------- Primitives ----------- */
boolean bool = true;

byte b = 100; // small numbers
short s = 10;
int i = 10;
long l = 10L; // big numbers
float f = 10.5f; // small decimal numbers
double d = 10.5; // big decimal numbers

char c = 'A';

/* --------- Wrapper classes -------- */
Boolean boolObj;

Byte bObj;
Short sObj;
Integer iObj;
Long lObj;
Float fObj;
Double dObj;

Character cObj;

/* ---------- Type casting ---------- */
int a = 10;
double b = 10.5;

b = a; // implicit casting
a = (int) b; // explicit casting

// to cast strings to other types, use WrapperClass.parseX()
int a = Integer.parseInt("10");

/* --------- Non-Primitives --------- */
String str = "Hello";

/* ------------- Arrays ------------- */
int[] array = {1, 2, 3}; 
int[] array2 = new int[3]; // empty array of size 3
int[][] map = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // 2D array
int[][] map2 = new int[3][]; // 2D array of size 3 * variable
print(map[0].length); // 3

import java.util.ArrayList; // dynamic array

ArrayList<Integer> list = new ArrayList<Integer>(); // dynamic array: must use wrapper classes
list.add(1);

//#region String
/* ---------------------------------- */
/*               String               */
/* ---------------------------------- */
str.length();
str.toUpperCase();
str.toLowerCase();
str.indexOf('H');
str.charAt(0);
str.substring(0, 1);
str.replace('H', 'h');
str.split(" ");
str.length();

/* ---------- String concat --------- */
String str2 = "World";
print(str + str2); // HelloWorld
int num = 1;
String num2 = "2";
print(num + num2); // 12

//#region User Input
/* ---------------------------------- */
/*             User input             */
/* ---------------------------------- */
import java.util.Scanner; // import scanner class

Scanner scanner = new Scanner(System.in);
String name = scanner.nextLine(); // read a line of text from the console
String[] params = scanner.nextLine().split(" "); 
int n = Integer.parseInt(params[0]);
scanner.close(); // close the scanner

//#region Syntax
/* ---------------------------------- */
/*               Syntax               */
/* ---------------------------------- */
/* ------------ For loops ----------- */
for (int i = 0; i < 10; i++) {
    print(i);
} // same as C++

/* ---------- For each loop --------- */
for (int i : array) {
    print(i);
}

/* ------------ Try catch ----------- */
// "Exception" is a runtime error (error)
int[] arr = {1, 2, 3}; print(arr[3]); // ArrayIndexOutOfBoundsException
// "throw" is used to create custom errors
try {
    throw new Exception("This is an error");
} catch (Exception e) {
    // code to handle the exception
    print("Error: " + e);
} finally {
    // code that will always execute
}

/* -------- List of modifiers ------- */
public, private, protected, static, final, abstract, synchronized, volatile, transient
extends, implements

/* ------------- Classes ------------ */

package examplepackage; // package is a collection of classes, defined in a folder

public class Programme {
    String attribute = "Hello"; // attribute of the class (variable)
    static int num = 1; // value is shared across all instances of the class
    static final int num2 = 2; // constant value that cannot be changed

    /* -------- Access modifiers -------- */

    public int var1; // accessible by all with Programme.var1
    int var2; // accessible to classes in the same package
    private int var3; // accessible within this class only

    /* ----------- Constructor ---------- */
    Programme(int startValue) { // constructor
        var1 = startValue;
    }

    /* ------------- Methods ------------ */
    // a method (of the Programme class) (function)
    static int methodName(String str, int i) { // parameters str, i
        print(str + i);
        return 1;
    }
    // int is the return type, method is the name

    static final void methodName2() { // final method cannot be overridden
        print("This is a final method");
    }

    /* ----------- Overloading ---------- */
    // same method name, different parameters
    static int methodName(int i) {
        print(i);
        return 1;
    }
}

Programme programme = new Programme(10); // create an instance calling constructor

//#region OOP
/* ---------------------------------- */
/*                 OOP                */
/* ---------------------------------- */
/* ---------- Encapsulation --------- */
// hide the implementation details 
// -> provide public methods to interact with private attributes

public class Person {
    private String name;

    public String getName() {
        return name;
    }   

    public void setName(String name) {
        this.name = name; // this refers to the current object
    }

    public void sayMyName() {
        print("I am a person: " + name);
    }
}

/* ---------- Inheritance ---------- */
// reuse code from a parent class
// -> extends

// Student is a __subclass__ of Person (__superclass__ of Student)
public class Student extends Person {
    // Student has all the attributes and methods of Person
    private int id;

    Student(int id, String name) {
        this.id = id;
        setName(name); // method from Person
        print(super.name); // access superclass attribute
    }
}

public final class ClassName { // final class cannot be extended
    // final class methods cannot be overridden
    public void methodName() {
        print("This is a final method");
    }
}

/* ---------- Polymorphism ---------- */
// same method name but different classes
// -> method overriding

public class Student extends Person {
    @Override // for annotation only - not necessary but good to have
    public void sayMyName() {
        print("I am a student: " + getName());
    }
}

/* ----------- Abstraction ---------- */
// only show important details: specify public API
// -> abstract / interface
// functions has no body

//// Abstract classes must be extended
public abstract class Animal {
    // methods must be abstract
    public abstract void makeSound(); 
}
Animal animal = new Animal(); // error: cannot instantiate abstract class

public class Dog extends Animal {
    public void makeSound() {
        print("Bark");
    }
}

//// Interfaces must be implemented, key difference is multiple implementations
public interface FirstInterface {
    public void method1();
}

public interface SecondInterface {
    public void method2();
}

// use the implement keyword
public class DemoClass implements FirstInterface, SecondInterface {
    int attribute = 1;
    
    public void method1() {
        print("method1");
    }
    public void method2() {
        print("method2");
    }
}

//#region Memory
/* ---------------------------------- */
/*         Java Heap vs Stack         */
/* ---------------------------------- */

/* Stack */
// Stores local variables and method call information
// Fast access, limited size

int x = 5; // Primitive types are stored directly on the stack
Student student = new Student(); // References is stored on the stack

/* Heap */
// Stores objects and class instances
// Slower access, larger size
// Managed by __Garbage Collector__: Automatically frees memory (unlike C++ needs manual delete)

// Objects are stored on the heap
Student anotherStudent = new Student(); // 'anotherStudent' reference on stack, object on heap
String str = "Hello"; 

// Example of memory allocation
public void exampleMethod() {
    int localVar = 10; // Stored on stack
    Student localStudent = new Student(); // Reference on stack, object on heap
    // When method ends, localVar and localStudent reference are removed from stack
    // The Student object remains on heap until garbage collected
}

// Note: The actual Student object for both 'student' and 'anotherStudent'
// are stored on the heap, while their references are on the stack

//#region Serialization
/* ---------------------------------- */
/*            Serialization           */
/* ---------------------------------- */

import java.io.*;

// Serialization is the process of converting an object into a byte stream
// Deserialization is the reverse process

// To make a class serializable, it must implement the Serializable interface
class SerializableStudent implements Serializable {
    private String name;
    private int age;
    private transient String temporaryData; // transient fields are not serialized

    public SerializableStudent(String name, int age) {
        this.name = name;
        this.age = age;
        this.temporaryData = "This won't be serialized";
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

// Example of serialization and deserialization
public class SerializationExample {
    public static void main(String[] args) {
        SerializableStudent student = new SerializableStudent("Alice", 20);

        // Serialization
        try (FileOutputStream fileOut = new FileOutputStream("student.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(student);
            System.out.println("Serialized data is saved in student.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserialization
        try (FileInputStream fileIn = new FileInputStream("student.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            SerializableStudent deserializedStudent = (SerializableStudent) in.readObject();
            System.out.println("Deserialized Student: " + deserializedStudent);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("SerializableStudent class not found");
            c.printStackTrace();
        }
    }
}

//#region GUI
/* ---------------------------------- */
/*                 GUI                */
/* ---------------------------------- */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// inheritance: reuse JFrame code
public class GUIExample extends JFrame {
    public GUIExample() {
        // Set up the frame
        setTitle("JPanel Example"); // title
        setSize(400, 300); // size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add a title label
        JLabel titleLabel = new JLabel("Welcome to JPanel Example", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Create a text area with scroll pane
        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Create a panel for drawing shapes
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(10, 10, 50, 50);
                g.setColor(Color.BLUE);
                g.fillRect(70, 10, 50, 50);
            }
        };
        drawingPanel.setPreferredSize(new Dimension(150, 0));
        mainPanel.add(drawingPanel, BorderLayout.EAST);

        // Add action listeners to buttons
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button 1 clicked!\n");
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button 2 clicked!\n");
            }
        });

        // Add main panel to frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater is used to create the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIExample().setVisible(true);
            }
        });
    }
}

//#region JavaDoc
/* ---------------------------------- */
/*               JavaDoc              */
/* ---------------------------------- */

import java.util.*;

/**
 * This method is used to sort an ArrayList of integers
 * @param ArrayList<Integer> the list of integers to be sorted
 * @return the sorted list
 */
public ArrayList<Integer> sort(ArrayList<Integer> list) {
    Collections.sort(list); 
    return list;
}