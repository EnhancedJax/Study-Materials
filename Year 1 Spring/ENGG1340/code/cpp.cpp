// include different libraries
#include <iostream>  // iostream provides basic io functions
using namespace std; // use the "std" namespace
int main()
{                                  
    // code to be ran when program starts
}
int a = 1, b = 2, c = 3; // declare vars with vales
double a, b, c; // empty declaration

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
int a[2][2] = {{1, 2}, {3, 4}}; // 2D array of 2x2 integers
char a[] = "Hello"; // array of 5 characters




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

int main() {
  int a = 10, b = 20;
  swapnum(a, b);                  // a = 20, b = 10
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

rand() % N; // random number between 1 and N-1

void zeroize(int a[], int n) { 
    for (int i = 0; i < n; i++) {
        a[i] = 0;
    }
}
int[5] a = {1, 2, 3, 4, 5};
zeroize(a, 5); // a = {0, 0, 0, 0, 0}

void zeroize(int a[][5], int n) { 
...}

char letter = 'a';
int val = letter; // 97
cout << 'b' - 'a'; // 98 - 97 = 1
letter++ // 'b'
isdigit('1') // 1
isalpha('a') // 1
isalnum('1') // 1
isupper('A') // 1
islower('a') // 1
toupper('a') // 'A'
tolower('A') // 'a'

char hi[] = "Hello"; // hi[6] = {'H', 'e', 'l', 'l', 'o', '\0'}
hi = "World"; // raises compilation error

#include <string>
string hi = "Hello"; 
string who = "World";
string message = hi + " " + who; // "Hello World"
string message = "Hello" + " World" // raises compilation error

string msg1 = "Apple", msg2 = "apple";
string msg3 = "apples", msg4 = "orange";
bool c1 = msg1 == msg2; // false
bool c2 = msg3 != msg4; // true
bool c3 = msg1 < msg2; // true (A < a)
bool c4 = msg2 < msg3; // true (0 < s)
bool c5 = msg4 > msg3; // true (o > a)

a = "Hello World!";

a.length(); // 12
a.empty(); // false

a.erase(6, 6); // (from, n) "Hello "
a.insert(5, "New "); // (after, string) "Hello New World!"
a.replace(6, 5, "Universe"); // (from, n, string) "Hello Universe!"

a.substr(6, 5); // (from, n) "World"
a.substr(6); // "World!"

a.find("World"); // (string, start) 6 (starting index)
a.find("World", 7); // -1 (not found)
a.rfind("o"); // 7 (search from the end)

int i = 0;
int * iPtr = &i; // iPtr = address of i
cout << *iPtr; // 0 (dereference -> value of i)

int * a = nullptr, * b = 0; // declare multiple empty pointers

int n = 0;
int & i = n; // reference to n
n++;
cout << i; // 1

int i = 0;
char * badPtr = &i; // raises compile-time error

struct Data {
    int a = 1;
}
Data data;
Data * dataPtr = & data;
cout << dataPtr->a; // 1

void swapnum(int *i, int *j) {    // pass by reference
  int temp = *i;
  *i = *j;
  *j = temp;
}
int main() {
  int a = 10, b = 20;
  swapnum(&a, &b);                  // a = 20, b = 10
}

char x[10];
char * xPtr = x; // pointer to x
char * xPtr = &x[0]; // reference to x[0], same as above 
xPtr[0] = 'a'; // x[0] = 'a'

int * i = new int (42); // allocate memory for an integer
cout << *i; // 42
delete i; // free memory
i = 0;

int n = 10;
int * a = new int [n]; // allocate memory for an array of 10 integers
delete [] a; // free memory

int a[2] = {0, 1};
int * aPtr = a;
cout << *aPtr << ' ';
cout << *(aPtr+1) << endl; // 0 1

struct Node 
{
    int data;
    Node * next;
};

Node * head = new Node;
Node * node1 = new Node;

head->data = 1;
head->next = node1;
node1->data = 2;
node1->next = nullptr;

cout << head->data << ' ' << head->next->data << endl; // 1 2

Node * current = head; // remember head is a pointer
while (current != nullptr) {
    cout << current->data << ' ';
    current = current->next;
} // 1 2

Node* reverseLinkedList(Node* head) {
    Node* prev = nullptr;
    Node* current = head;
    Node* next = nullptr;

    while (current != nullptr) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }

    return prev;
}

int recursion(int var) {
    if (basecase) {
        return var;
    } else {
        return recursion(var - 1);
    }
}