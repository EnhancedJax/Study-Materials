# ----------- Declarations ----------- #
#!/bin/bash
read varname # Read input into varname
# variable declaration explicitly no space around =
varname="hello"
varname=1
varname=$(command)
varname=$((1+2))

# ------------- Arguments ------------ #
$0 # Command
$1 # First argument
$# # Number of arguments

# ----------- Conditionals ----------- #
if [ $n -# $n ]             # $n is eq/ne/lt/le/gt/ge than $n
if [ "$var" ]               # $var is not empty
if [ "$var" = "hello" ]     # $var is equal to "hello"
if [ "$var" != "hello" ]    # $var is not equal to "hello"
if [ "$var" \> "hello" ]    # $var is sorted after "hello"
if [ "$var" \< "hello" ]    # $var is sorted before "hello"
if [ -e dir ]               # dir exists
if [ -d dir ]               # dir is a directory
if [ -f file ]              # file is a regular file
if [ -r file ]              # file is readable
if [ -w file ]              # file is writable
if [ -x file ]              # file is executable
if [ -s file ]              # file is not empty

if [ condition1 ]
then
    # 
elif [ condition2 ]
then
    # 
else
    #
fi

# ------ Piping and redirection ------ #
command1 | command2     # Pipe output of command1 to input of command2
command > file          # Redirect output of command to file
command < file          # Redirect input of command from file
command >> file         # Append output of command to file
command 2> file         # Redirect error of command to file
command < file1 > file2 # Redirect input from file1 and output to file2

# --------- String operations -------- #
s="hello"
${#s}      # Length of string
${s:1:4}   # Substring: "ello"
${s//o/a}  # Replace all o with a
${s/o/a}   # Replace first o with a
# The replacements are case sensitive

# ---------- Basic commands ---------- #
g++ input.cpp -o output # Compile input.cpp to output

echo "$varname world"   # hello world
echo '$varname world'   # $varname world

pwd             # Print working directory
ls              # List files in directory
ls -l           # List files in directory with details
ls -a           # List all files in directory
ls -al          # List all files in directory with details
ls *.txt        # List all txt files
cd path         # Change directory to path
mv old new      # Rename old to new
cp old new      # Copy old to new
cp -r old new   # Copy old to new recursively
rm file         # Remove file
touch file      # Create file
cat file        # Print file content
man command     # Manual for command

# --- File reading and modification -- #
chmod [u/g/o][+/-/=][r/w/x] file    # Change file permissions
chmod 777 file                      # Give all permissions to file
# for each digit, it is made up of the sum of numbers 4, 2, 1
# for each number used in the sum, the represents permission r, w, x
# the digits represents u, g, o

cat file                # File content
wc                      # Word count
wc -l                   # Line count
wc -w                   # Word count
wc -m                   # Character count
cut -d' ' -f1           # Gets only first column
sort                    # Sort alphabetically
sort -nr                # Sort numerically reversed
sort -t',' -k2          # Sort by second column with delimiter ','
uniq                    # Remove adjacent duplicate lines
uniq -c                 # Prefix each output line w/ count of repeat
grep 'text'             # Print lines containing 'text'
grep -E 'regex'         # Print lines matching regex
grep -oE 'regex'        # Print only matching text on differnet lines
head -n 5               # Print first 5 lines
tr '[:upper:]' '[:lower:]' # Convert uppercase to lowercase
tr -s '[:space:]' '\n'  # Replace spaces with newlines
sed 's/old/new/g'       # Replace old with new
awk '{print $1}'        # Print first column separated by space
awk -F',' '{print $2}'  # Print second column separated by comma
awk '/super/ {print $1}' # Print first column of lines containing 'super'
awk -v max="$max_count" '$1 == max {print $2}'
# Print second column of lines with first column equal to max_count

while read -r line; do
    for word in $line; do
        echo "$word"
    done
done < "myfile.txt"

# ------------- Examples ------------- #
cat file | uniq -c | sort -nr | head -n 5 
# Top 5 most frequent lines with count prefix
s = "hi HI hi hi1"
echo $s | tr '[:upper:]' '[:lower:]' # hi hi hi hi1
echo $s | grep -oE 'hi' # hi\n hi\n hi
echo $s | grep -E 'hi' # hi HI hi hi1 (matches line)
echo $s | grep -oE '\bhi\b' # hi\nhi

# Get each word in the file
words=$(cat myfile.txt | tr -s '[:space:]' '\n')
# Count the occurrence of each word
word_counts=$(echo "$words" | sort | uniq -c)
# Sort the word counts in descending order
sorted_counts=$(echo "$word_counts" | sort -nr)
# Find the maximum count
max_count=$(echo "$sorted_counts" | head -n 1 | awk '{print $1}')]
# Filter the words with the maximum count 
frequent=$(echo "$sorted_counts" | awk -v max="$max_count" '$1 == max {print $2}')
# Sort the most frequent words alphabetically
sorted_words=$(echo "$frequent" | sort)
# Print the most frequent words
echo "$sorted_words"