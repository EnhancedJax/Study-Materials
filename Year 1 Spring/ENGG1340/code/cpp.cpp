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