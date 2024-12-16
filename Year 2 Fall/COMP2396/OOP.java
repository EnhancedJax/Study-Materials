
/* ---------------------------------- */
/*               Classes              */
/* ---------------------------------- */
package examplepackage; 
// package is a collection of classes, defined in a folder
"""
(in class):
STATIC keyword:
√ Methods & variables can be accessed without creating an instance
╳ Methods can NOT access instance variables

FINAL keyword:
╳ Variables can not be changed after initialization, must be initialized with value
╳ Methods can not be overridden
╳ Classes can not be extended

Constant: Static + Final
"""
public class P {
    String attribute = "Hello"; // attribute of the class (variable)

    /* ------- Instance variables ------- */
    // variables that are unique to each instance of class
    public int var1; // accessible by all with P.var1
    int var2; // accessible to classes in the same package
    private int var3; // accessible within this class only

    /* ----------- Constructor ---------- */
    // method with no type and same name as class
    P(int startValue) { 
        var1 = startValue;
    }

    // instance initializer block, runs everytime instance created
    {
        System.out.println("Instance initializer block");
    }

    /* ------------- Methods ------------ */
    // a method (of the P class) (function)
    static int methodName(String str, int i) { // parameters str, i
        System.out.println(str + i);
        return 1;
    }

    static final void methodName2() { // can't override
        System.out.println("This is a final method");
    }

    /* ----------- Overloading ---------- */
    // same method name, different (number of) parameters
    static int methodName(int i) {
        System.out.println(i);
        return 1;
    }

    // can also overload constructors
    P() {
        this(0); // call another constructor
    }

    /* ----- Static anonymous block ----- */
    // runs when the class is loaded in memory 
    // (does not have to be instantiated)
    static {}
}

P p = new P(10); // create an instance calling constructor

/* ------ Access modifier table ----- */
Level | Class | Package | Subclass | World
-----------------------------------------
public | YYYY
protected | YYYN
no modifier | YYNN
private | YNNN

/* ---- Common method of objects ---- */
// override these methods to customize object behaviour
obj.equals(obj2); // compares two objects for equality
obj.hashCode(); // returns a hash code value
obj.toString(); // returns hexadeciaml representation
obj.getClass(); // returns the runtime class of the object

/* ---------------------------------- */
/*                 OOP                */
/* ---------------------------------- */
// Modularity, info hiding, code reuse, pluggability
"""
ENCAPSULATION:
- Hide implementation details
- Provide public methods to interact with private attributes
"""
public class Person {
    private String name;

    // getter setters: must be public methods
    // to access private attributes
    public String getName() { 
        return name;
    }   
    // set private attributes
    public void setName(String name) { 
        this.name = name; 
        // 'this' refers to the current object
    }

    public void sayMyName() {
        System.out.println("I am a person: " + name);
    }
}
"""
ABSTRACTION:
- Specify public API / represent features without details
> abstract / interface

X Abstract classes / interfaces CANNOT be instantiated without subclassing
"""
public abstract class Animal {
    private String name;

    // concrete method
    public string getName() {
        return name;
    }
    
    // abstract methods must be implemented
    public abstract void makeSound(); 

    Animal(string name) {
        this.name = name;
    }
}
Animal animal = new Animal(); 
// error: cannot instantiate abstract class
public class Dog extends Animal {
    // abstract methods must be implemented
    public void makeSound() {
        System.out.println("Bark");
    }
}
// Interfaces must be implemented, key difference is multiple implementations vs single extension
public interface FirstInterface {
    public void method1(); 
    // interface methods must be public
}   

public interface SecondInterface {
    public void method2();
}
// use the implement keyword
public class DemoClass implements FirstInterface, SecondInterface {
    int attribute = 1;
    
    public void method1() {
        System.out.println("method1");
    }
    public void method2() {
        System.out.println("method2");
    }
}
"""
INHERITANCE:
- Reuse code from a parent class
> "extends" or "implements"
"""
// Student is a __subclass__ of Person (__superclass__ of Student)
public class Student extends Person {
    // Student has all the attributes and methods of Person
    private int id;

    Student(int id, String name) {
        // constructor of super (super()) is called implicitly
        this.id = id;
        setName(name); // method from Person
        System.out.println(super.name); // access superclass attribute
        // super() placed after will compile error
    }
}
// Construction: SUPER -> SUB
"""
POLYMORPHISM:
- Objs sharing behaviors, taking > 1 form
> @Override, "general / anything"
"""
public class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override // error: no makeSound2
    public void makeSound2() {
        System.out.println("Meow");
    }
}