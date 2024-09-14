// Demonstration of Object-Oriented Programming (OOP) Concepts in Java

// 1. Encapsulation
class BankAccount {
    private double balance;  // Private field for data hiding

    // Constructor
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

// 2. Inheritance
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("The animal makes a sound");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks");
    }
}

// 3. Polymorphism
interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// 4. Abstraction
abstract class Vehicle {
    abstract void start();
    
    public void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car started");
    }
}

// Main class to demonstrate OOP concepts
public class OOP {
    public static void main(String[] args) {
        // Encapsulation
        BankAccount account = new BankAccount(0);
        account.deposit(1000);
        System.out.println("Balance: $" + account.getBalance());

        // Inheritance and Polymorphism
        Animal dog = new Dog("Buddy");
        dog.makeSound();

        // Polymorphism with interfaces
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());

        // Abstraction
        Vehicle car = new Car();
        car.start();
        car.stop();
    }
}
