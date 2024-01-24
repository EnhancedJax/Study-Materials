FLAGS = -pedantic-errors -std=c++11 # flags to pass in when compiling

gcd.o: gcd.cpp gcd.h # target: dependencies
    g++ $(FLAGS) -c gcd.cpp # <tab> action
# Target: gcd.o
# Dependencies: gcd.cpp gcd.h
# Action: Compile gcd.cpp into gcd.o

gcd_main.o: gcd_main.cpp gcd.h
    g++ $(FLAGS) -c $< # $< represents is the first dependency

gcd: gcd.o gcd_main.o
    g++ $(FLAGS) $^ -o $@ # $^: all dependencies, $@: target

clean: # a shorthand function to clean up
    rm -f gcd gcd.o gcd_main.o gcd.tgz

tar: # a shorthand function to tar (compress) the files
    tar -czvf gcd.tgz *.cpp *.h

.PHONY: clean tar # Declare clean and tar targets as phony targets, which are not files by rather shorthands