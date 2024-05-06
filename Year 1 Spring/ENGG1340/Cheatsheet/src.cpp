/* ---------- Declarations ---------- */
int a, b, c;                    // Multiple declarations
int a[10];                      // Array of 10 ints (a[0] through a[9])
int a[]={0,1,2};                // Initialized array (or a[3]={0,1,2}; )
int a[2][3]={{1,2,3},{4,5,6}};  // Array of array of ints
char s[]="hello";               // String (6 elements including '\0')
int func(int x, bool y)         // func accepting int, bool returning int

/* ---------- Control flow ---------- */

if (x < 0) {                    // If statement
    cout << "Negative" << endl;
} else if (x == 0) {            // Else if statement
    cout << "Zero" << endl;
} else {                        // Else statement
    cout << "Positive" << endl;
}

while (x < 10) {                // While loop
    cout << x << endl;
    x++;
} // Prints 0 to 9

for (int i = 0; i < 10; i++) {   // For loop
    cout << i << endl;
} // Prints 0 to 9

/* ----------- Characters ----------- */

char c = 'a';                   // Character
c = 97;                         // ASCII value of 'a'
c = c - 'a' + 'A';              // Convert to uppercase
c = c + 'a' - 'A';              // Convert to lowercase
c = '0' + 5;                    // Convert digit to char ('5')
isalpha(c), isdigit(c);          // Check if c is letter, digit
tolower(c), toupper(c);          // Convert to lowercase, uppercase

/* ------------ Libraries ----------- */
// IOSTREAM
cin >> x >> y;                  // Read words x and y (any type) from stdin 
cout << "x=" << x << endl;      // Write line to stdout 
// IOMANIP
cout << setprecision(2) << fixed << 3.14159; // Write 3.14 to stdout
// CSTDLIB
rand () % N + 1;                // Random number between 1 and N
// ALGORITHM
sort(a, a+n);                   // Sort array a of size n
// String
string s1, s2="hello";          // Create strings
s1.size(), s2.size();           // Number of characters: 0, 5
s1 += s2 + ' ' + "world";       // Concatenation
s1 == "hello world"             // Comparison, also <, >, !=, etc.
s1[0];                          // 'h'
s1.substr(m, n);                // Substring of size n starting at s1[m]
s1.c_str();                     // Convert to const char*
s1.erase(m, n);                 // Erase n characters starting at s1[m]
s1.find(s2)                     //  Check if s2 is in s1
s1.find(s2, m)                  //  Check if s2 is in s1 starting at m
s1.rfind(s2)                    //  Check if s2 is in s1 from the end
getline(cin, s);                // Read line ending in '\n'

"String comparisons are carried out character by character, by ANSCII val";
string msg1 = "Apple", msg2 = "apple";
string msg3 = "apples", msg4 = "orange";
bool c1 = msg1 == msg2;         // false
bool c2 = msg3 != msg4;         // true
bool c3 = msg1 < msg2;          // true (A < a)
bool c4 = msg2 < msg3;          // true (0 < s)
bool c5 = msg4 > msg3;          // true (o > a)

/* ---------- Lib: Streams ---------- */
// fstream
ifstream fin("input.txt");          // Declare fin
ofstream fout("output.txt");        // Delcare fout
fin.open("input.txt");              // Open file for reading
fout.open("output.txt");            // Open / create file for writing
fout.open("output.txt", ios::app);  // Open file for appending

while (fin >> x) {                  // Read words from file
    cout << x << endl;
} // Prints words from file

while (getline(fin, line)) {        // Read lines from file
    cout << line << endl;
} // Prints lines from file

fout << "Hello, world!" << endl;    // Write to file
fin.close(); fout.close();          // Close file

// sstream
string str = "123 456 789";
istringstream iss(str);     // Read from string
while (iss >> x) {          // Read words from string
    cout << x << endl;
} // Prints 123\n456\n789

/* ----- Lib: Vector, List, Maps ---- */
list<int> l;                    // List of ints
vector<int> v;                  // Vector of ints
v.push_back(5);                 // Add element to end
v.size();                       // Number of elements
v[0];                           // First element
v.pop_back();                   // Remove last element
v.pop_front();                  // Remove first element
sort(v.begin(), v.end());       // Sort elements
map<string,int> m;              // Map from string to int
m = {{"a",1},{"b",2}};          // Initialize map
m["a"];                         // Access value
m["c"] = 3;                     // Insert value
m.count("a");                   // Number of elements with key "a"
m.erase("a");                   // Remove element with key "a"

vector<int>::iterator it;       // Iterator for vector of ints
for (itr = input.begin(); itr != input.end(); itr++) {
    cout << *itr << endl;
} // Iterate through vector

map<string,int>::iterator it;   // Iterator for map of string to int
for (it = m.begin(); it != m.end(); it++) {            
    cout << it->first << " " << it->second << endl;
} // Iterate through map

/* ------------- Structs ------------ */
struct Point { int x, y; };     // Define struct
Point p; p.x = 1; p.y = 2;       // Create instance
Point p = {1, 2};                // Create instance

bool operator <(const Point& a, const Point& b) {
    return a.x < b.x || (a.x == b.x && a.y < b.y);
} // Define comparison operator

/* ----- Pointers and References ---- */
int v = 5;
int* p;             // declares a pointer to int
p = &v;             // stores address of v into p (p is a pointer to int)
int& r = v;         // r is an alias of v 
cout << v << ", " << r << endl;     // prints 5, 5
cout << &v << &r << endl;           // prints address of v twice
cout << *p << endl;                 // dereferences p to get value of v
"Pointers must have the same type as the variable they point to";
"Pointers must point to something or a" nullptr;

char x[10];
char* p = x;            // p points to the first element of x
p++;                    // p points to the next element of x
cout << p[-1] << endl;  // prints the first element of x
cout << *p << endl;     // prints the second element of x
cout << *(p+1) << endl; // prints the third element of x

void swap(int& a, int& b) { // Pass by reference 
    int temp = a; a = b; b = temp; 
} // Swaps a and b

void swap(int* a, int* b) { // Pass by pointer
    int temp = *a; *a = *b; *b = temp;
} // Swaps a and b

void func(int p[])      // if p is modified, the original is affected

/* -------- Memory allocation ------- */
int* p = new int;       // allocate memory for an int
delete p;               // deallocate memory


/* ---------- Linked lists ---------- */
struct Node { int data; Node* next; };  // Define struct
Node* head = nullptr;                   // Empty linked list
Node* n = new Node; n->data = 5;        // Create node
head = n;                               // Insert at front

Node* current = head;                   // Traverse linked list
while (current != nullptr) {            // Loop until end of list
    cout << current->data << endl;
    current = current->next;
} // Prints all elements

void insertAtBack(Node* head, int data) { // Insert at back
    Node* current = head, *n = new Node;  // Initialize pointers
    n->data = data; n->next = nullptr;    // Initialize new node
    if (current == nullptr) head = n;     // Insert at front
    else {
        while (current->next != nullptr) { // Traverse list
            current = current->next;
        }
        current->next = n; // Insert at back
    }
}

void doSomethingAfterFinding(Node* head, int data) { // Find node with data
    Node* current = head; // Initialize pointer
    while (current != nullptr) { // Traverse list
        if (current->data == data) {
            // Do something
            return;
        }
        current = current->next;
    }
}

void remove(Node* head, int data) { // Remove node with data
    Node* current = head, *prev = nullptr;
    while (current != nullptr) {
        if (current->data == data) {
            if (prev == nullptr) head = current->next;
            else prev->next = current->next;
            delete current;
            return;
        }
        prev = current;
        current = current->next;
    }
}

void reverse(Node*& head) { // Reverse linked list
    Node* prev = nullptr, *current = head, *next; // Initialize pointers
    while (current != nullptr) { // Traverse list
        next = current->next; 
        current->next = prev; 
        prev = current;     
        current = next;     
    }
    head = prev;
}

void deleteList(Node*& head) { // Delete linked list
    Node* current = head, *next; // Initialize pointers
    while (current != nullptr) { // Traverse list
        next = current->next; 
        delete current; 
        current = next; 
    }
    head = nullptr;
}

/* ---------- Recursion ---------- */

"Recursion is a function that calls itself";
"Recursion must have a base case to stop the recursion";

int binarySearch(int arr[], int l, int r, int x) {
    if (r >= l) { // Base case
        int mid = l + (r - l) / 2; // Calculate mid
        if (arr[mid] == x) return mid; // Found x
        if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x); // Search left
        return binarySearch(arr, mid + 1, r, x); // Search right
    }
    return -1; // Not found
}
