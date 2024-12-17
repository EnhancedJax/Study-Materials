import java.io.*;
"""
SERALIZATION:
- Process of converting an obj into a byte stream
- De-s is the reverse process
- When obj serialized, all referenced obj also serialized
- Transient fields are NOT serialized
- Default vals given to transient fields upon de-s

VERSION CONTROL:
- serialVersionID will be generated & checked during de-s
- if we set this variable, it will pass the check
Changes to a class -> change serialVersionUID:
* Delete instance var
* Change non-transient -> transient
* Change type of instance var
* Change instance variable to static
The following modifications are ok:
* Add instance var
* Change access modifier of instance var
* Change transient -> non-transient
* Change access modifier of instance var
* Add / remove classes from inheritance hierarchy
"""
// Must implement the Serializable interface
class SerializableStudent implements Serializable {
    private String name;
    private int age;
    private transient String temporaryData; // ignored
    private static final long serialVersionUID = 1L; // version control
    Student() {...} // constructor... 
}
// Example of serialization and de-s
public class SerializationExample {
    public static void main(String[] args) {
        SerializableStudent student = new SerializableStudent("Alice", 20);
        // Serialization: Writing to file
        try {
            FileOutputStream fileOut = new FileOutputStream("student.ser");
            ObjOutputStream out = new ObjOutputStream(fileOut)
            out.writeObj(student); // not NotSerializableException
            out.close(); // automatically closes fileOut
        } catch (IOException i) {}
        // Deserialization: Reading from file
        try {
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjInputStream in = new ObjInputStream(fileIn)
            SerializableStudent deserializedStudent = (SerializableStudent) in.readObj();
            in.close(); // automatically closes fileIn
        } catch (IOException i) {}
    }
}
"""
WRITING TO FILE:
- FileWriting writes each thing passed to file everytime: less efficient
- BufferedWriter writes in chunks: more efficient
"""
try { // Writing to
    FileWriter fileWriter = new FileWriter("file.txt");
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.write("Hello");
    bufferedWriter.newLine();
    bufferedWriter.write("World");
    bufferedWriter.close();
} catch (IOException e) {...};

try { // Reading from
    FileReader fileReader = new FileReader("file.txt");
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
    }
    bufferedReader.close();
} catch (IOException e) {...};

try { // Scanner reader
    File file = new File("file.txt");
    Scanner scanner = new Scanner(file);
    while (scanner.hasNext()) {
        String word = scanner.next();
        System.out.println(word);
    }
    scanner.close();
} catch (FileNotFoundException e) {...}
