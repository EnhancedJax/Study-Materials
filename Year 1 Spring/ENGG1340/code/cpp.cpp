#include <iostream>  // lib provides the cout, endl funcs
using namespace std; // use the standard namespace
int main()
{                                  // functions are contained in {}
    char a;                        // limits the input to be a char
    cin >> a;                      // read input from user
    cout << "Hello " << a << endl; // prints Hello <input>
    return 0;                      // return 0
}

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
