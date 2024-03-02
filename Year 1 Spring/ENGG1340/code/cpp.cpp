// include different libraries
#include <iostream>  // iostream provides basic io functions
using namespace std; // use the "std" namespace
int main()
{                                  
    // code to be ran when program starts
}
int a = 1, b = 2, c = 3;
double a, b, c; // empty initialization

int i = 1;
int n = 0;

n = ++i;     // equiv to i = i + 1, n = i;
n = i++;     // equiv to n = i, i = i + 1;
n = 1 && 0;  // logical and
n = 1 || 0;  // logical or
n = !3;      // logical not, converts any number > 0 to 0 (!3 => 0)
    
// C++ contains the usual operators: +, -, *, /, %
10 / 3 // If both types are integers, the result is an integer (3)
10.0 / 3 // If either type is a float, the result is a float (3.3333)

char 'b' // only one character
int 1 // integer
float 1.0 // floating point number
double 1.0 // double precision floating point number
bool true // boolean

const int a = 1; // constant variable that cannot be changed

if (a == 1) {
    // do something
} else if (a == 2) {
    // do something else
} else {
    // do something else
}

switch (ctrl_expr) { 
    case const_1: // if ctrl_expr == const_1
        break; // man
    case const_2: // if ctrl_expr != const_1 && ctrl_expr == const_2
        break;
    default: // if no case matches (optional)
        break;
}

(condition ? if_true : else_false) // returns the corresponding expression

for (int i = 0; i < 10; i++) { // initialize, check conditions, increment
    // do something 10 times
    continue;   // skip the rest of the loop
    break;      // break out of the loop
}

while (a < 10) { // check conditions first
    // do something 
}

do { // execute first
    // do something
} while (a < 10); //then check conditions

//return_type func_name (type var1, type var2)
double func_name (int a, int b) { 
    return a + b;
}

int a[10]; // array of 10 integers
int a[] = {1, 2, 3, 4, 5}; // array of 5 integers
int a[10][10]; // 2D array of 10x10 integers
char a[] = "Hello"; // array of 5 characters

#include <string>
string a = "Hello"; // string class

cin >> name >> age; // read multiple inputs to variables
cout << "Hello " << name << endl; // Hello <name>

#include <iomanip>                // include iomanip library
cout << fixed << setprecision(2);  // set precision to 2 decimal places
cout << 3.14159;                  // 3.14

void swapnum(int &i, int &j) {    // pass by reference
  int temp = i;
  i = j;
  j = temp;
}

int main(void) {
  int a = 10;
  int b = 20;

  swapnum(a, b);                  // a = 20, b = 10
  return 0;
}

cout << setw(6) << "123" << endl; // "   123"
cout << setfill('%') << setw(6) << "123" << endl; // "%%%123"
cout << left << setw(6) << "123" << endl; // "123   "

#include <fstream>
#include <string>

ifstream fin; // file input stream
fin.open("input.txt"); // open file for reading
if (fin.is_open()) { // check if file is open
    string line;
    while (getline(fin, line)) { // read line by line
        cout << line << endl;
    }
    fin.close();
} else {
    cout << "Unable to open file for reading.";
}

ofstream fout; // file output stream
fout.open("output.txt"); 
if (fout.is_open()) { 
    fout << "Hello World!" << endl;
    fout.close();
} else {
    cout << "Unable to open file for writing.";
}

fout.open("output.txt", ios::app); // open file for appending

#include <sstream>
#include <string>

string str = "Hello World!";
istringstream line_in(str); // string stream

while (line_in >> word) { 
    cout << word << endl; // "Hello\nWorld!"
}

#include <cmath>
int a = pow(2, 3); // 2^3 = 8
int b = sqrt(16); // square root of 16 = 4
int c = abs(-10); // absolute value of -10 = 10

#include <algorithm>
int a[] = {1, 2, 3, 4, 5};
reverse(a, a + 5); // a = {5, 4, 3, 2, 1}
sort(a, a + 5); // a = {1, 2, 3, 4, 5}
a.start() // pointer to the first element
a.end() // pointer to the last element

struct Point {
    int x, y;
};

Point p1 = {1, 2};
Point p2 = {1}; // p2.x = 1, p2.y = 0
Point p3 = {1, 2, 3} // raises compilation error
cout << p1.x; // 1

struct Circle {
    Point center;
    int radius;

    double area() {
        return 3.14 * radius * radius;
    }
};

Circle c1 = {{1, 2}, 3};

a.length(); // 5
a[0]; // 'H'
a.substr(0, 2); // "He"
a.find("l"); // 2
a.replace(2, 2, "p"); // "Helpo"
a.append(" World"); // "Hello World"

#include <vector>

vector<int> v; // empty vector
vector<int> v(5); // vector of 5 integers
vector<int> v(5, 1); // vector of 5 integers with value 1
v.push_back(1); // add 1 to the end of the vector
v.pop_back(); // remove the last element
v.size(); // 5
v[0]; // 1
v.clear(); // remove all elements
v.front(); // first element
v.back(); // last element

int a[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
