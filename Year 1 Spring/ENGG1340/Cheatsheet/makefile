# ------------- Makefile ------------- #
gcd.o: gcd.cpp gcd.h 
# target: dependencies
    g++ $(FLAGS) -c gcd.cpp # action
# Compiles gcd.cpp into gcd.o without linking
gcd_main.o: gcd_main.cpp gcd.h
    g++ $(FLAGS) -c $< # $< first dependency
gcd: gcd.o gcd_main.o # Links the object files
    g++ $(FLAGS) $^ -o $@ 
    # $^: all dependencies (gc.o gcd_main.o)
    # $@: target (gcd)
clean: # a shorthand function to clean up
    rm -f gcd gcd.o gcd_main.o gcd.tgz
.PHONY: clean tar # Declare shorthands