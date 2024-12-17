public static void main(String[] args) {} 
"""
args: string array of arguments passed to the program
A source code *java file must declare 1 class with the same name 
Java: Simple, Object-oriented, Platform-independent, Architectural neutral, Portable, Robust, Multi-threaded
Object encapsulates data and behavior
"""
/* ----------- Primitives ----------- */
// Variable can use $, _, or letters, can't start with num
// primitive var: store literal values.
// non-primitive var: store references to objects.
boolean bool = true;
byte b = 100; // -128 to 127
short s = 10; // -32,768 to 32,767
int i = 10;
long l = 10L; // big numbers
float f = 10.5f; // small decimal numbers
double d = 10.5; // big decimal numbers
char c = 'A'; 
"""
WRAPPER CLASSES: Treat primitives like object
Cached classes obj w/ val in cached range: 
Will ref cached obj instead of creating new obj
Cached: Byte Short Integer (-128..127) Boolean (TF) Char (0..127)

Create new obj each time:
Uncached: Long, Float, Double

New objects will be created when value changes, unless in cached range.
"""
/* ---------- Type casting ---------- */
int n1 = 10; long n2 = n1; // widening
long n3 = 10; int n4 = (int) n3; // narrowing
double n = (int) 2 * 1.1; // 2.2
// runtime error if not compatible. E.g. int n = (int)"10";
| From/to | b | s | i | l | f | d | c |
| byte    | - | A | A | A | A | A | A |
| short   | C | - | A | A | A | A | C |
| int     | C | C | - | A | A | A | C |
| long    | C | C | C | - | A | A | C |
| float   | C | C | C | C | - | A | C |
| double  | C | C | C | C | C | - | C |
| char    | C | C | C | C | C | C | - |
// a - assignable, c - cast required

// to cast strings to other types, use WrapperClass.parseX()
int a = Integer.parseInt("10");
/* --------- Non-Primitives --------- */
String str = "Hello";
// format strings
String.format("Hello %s", "World"); // Hello World
String.format("%,d", 1000000); // 1,000,000
String.format("%.2f", 10.12345); // 10.12
String.format("%,.2f", 10000.12345); // 10,000.12
String.format("%c", 65); // A
/* ------------- Arrays ------------- */
// A collection of data of the same type
// Arrays are objects, possible usages:
int[] array;
array = new int[3]; // array of size 3
int[] array = {1, 2, 3}; 
int[1] = 1;
int[][] map = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // 2D array
int[][] map2 = new int[3][]; // 2D arr 3 rows, uninitialized cols
System.out.println(map[0].length); // 3

array = new int[] // illegal, must declare size

import java.util.ArrayList; // dynamic array
ArrayList<String> list = new ArrayList<String>(); 
// dynamic array: must use wrapper classes
list.add("Hello"); list.remove(0);
/* ------------- Compare ------------ */
// == compares references, .equals() compares values
String str1 = "Hello"; String str2 = "Hello";
boolean isRefEqual = str1 == str2; // true
String str3 = new String("Hello"); String str4 = new String("Hello");
boolean isRefEqual2 = str3 == str4; // false
boolean isValEqual = str3.equals(str4); // true
/* --------- String methods --------- */
length, toUpperCase, toLowerCase, indexOf, charAt, substring, replace, split
/* ---------- String concat --------- */
String str2 = "World";
System.out.println(str + str2); // HelloWorld
int num = 1;
String num2 = "2";
System.out.println(num + num2); // 12
/* -------------- Loops ------------- */
for (int i = 0; i < 10; i++) {}
for (int i : array) {}
while (condition) {}
/* -------------- Input ------------- */
import java.util.Scanner; // import scanner class
Scanner scanner = new Scanner(System.in);
String name = scanner.nextLine(); // read a line of text from the console
String[] params = scanner.nextLine().split(" "); 
int n = Integer.parseInt(params[0]);
scanner.close(); // close the scanner
/* -------------- Print ------------- */
System.out.println("a"+"b"+"c"); // abc, creates 1 String obj everytime
/* ---------------------------------- */
/*             Exceptions             */
/* ---------------------------------- */
"""
Checked exceptions: Inherits from Throwable, must be caught or declared in a throws caluse, else will not compile
E.g. IOException when seralization

Unchecked exceptions: Inherits from RuntimeException, optional to be caught or declared, will crash if not caught
E.g. NullPointerException - access null object,
ArrayIndexOutOfBoundsException - access array out of bounds,
ArithmeticException - divide by zero,
NumberFormatException - parse invalid string to number
"""
int[] arr = {1, 2, 3}; System.out.println(arr[3]); 
// This throws an ArrayIndexOutOfBoundsException
try {
    throw new ArithmeticException(); // "return" a custom error
    throw new Exception("This is an error");
} catch (ArithmeticException e) {
    // more specific errors must be caught first
    e.printStackTrace(); // print the error trace
} catch (Exception e) {
    // this will not run as already caught
} finally {
    // code that will always execute
}

try {} finally {} // is valid
"""
Errors are not exceptions, they are problems that arise beyond the control of the user or the programmer. Cannot catch
E.g. OutOfMemoryError, StackOverflowError
"""
/* --------- other keywords --------- */
// strictfp, synchronized, transient, volatile, assert, enum, native, super, this, void, const, goto, package, throws, instanceof