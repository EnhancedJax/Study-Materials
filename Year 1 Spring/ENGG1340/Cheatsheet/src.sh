# ----------- Declarations ----------- #
read varname # Read input into varname

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
if [ -# dir ]               # dir e/f/d/r/w/x

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
echo ${#s}      # Length of string
echo ${s:1:4}   # Substring: "ello"
echo ${s//o/a}  # Replace all o with a
echo ${s/o/a}   # Replace first o with a

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
wc file                 # Word count
wc -l file              # Line count
wc -w file              # Word count
cut -d' ' -f1 file      # Cut first column of file
cut -d' ' -f1,2 file    # Cut first and second column of file
sort file               # Sort file alphabetically
sort -nr file           # Sort file numerically reversed
sort -t',' -k2 file     # Sort file by second column with delimiter ','
uniq file               # Remove adjacent duplicate lines
grep 'text' file        # Print lines containing 'text'
grep -E 'regex' file    # Print lines matching regex
head -n 5 file          # Print first 5 lines of file

