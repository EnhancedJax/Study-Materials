"Compared to C++, C does not have:";
// Classes and objects
// New/delete operators (use malloc/free instead)
// Namespace
// String class
// Pass by reference (use pointers instead)

/* ------------ I/O in C ------------ */
#include <stdio.h>                          // Include standard I/O library
int x, y;                                   // Declare variables
gets(s);                                    // Read line from stdin
scanf("%d %d", &x, &y);                     // Read integers x and y from stdin
printf("x=%d\n", x);                        // Write line to stdout
"%d"    // Integer
".3%f"    // Float with 3 decimal places
"%g"    // No trailing 0 (scientific notation)
"%lf"   // Double
"%c"    // Character
"%s"    // String

/* ---------- Strings in C ---------- */
#include <string.h>                         // Include string library
char s[100];                                // Allocate memory for a string
char s[] = "hello";                         // Declare and initialize a string
char a[] = ['h', 'e', 'l', 'l', 'o', '\0']; // Same as above
strlen(s);                                  // Number of characters: 5
strcpy(s, "world");                         // Copy "world" to s
strcmp(s, "world");                         // <: -1, =: 0, >: 1
sprintf(s, "%d", 123);                      // Convert int to string
sprintf(s, "%s%d", "hello", 123);           // Concatenate string and int

/* - Dynamic memory allocation in C - */
#include <stdlib.h>                         // Include standard library
int *a = (int*) malloc(10 * sizeof(int));   // Allocate memory for 10 integers
// A is an array of 10 integers
free(a);                                    // Free memory

int main(int argc, char *argv[]) {} 
// argc number of arguments (including program name)
// argv array of arguments