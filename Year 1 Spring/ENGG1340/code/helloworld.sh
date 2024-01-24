#!/bin/bash
val="world"
echo "Hello $val" # Hello world
echo 'Hello $val' # Hello $val

if [ condition1 ]
then
      echo "condition 1 met"
elif [ condition2 ]
then
      echo "condition 2 met"
else
      echo "No condition met"
fi 

#!/bin/bash
# backup.sh
list="`ls *.cpp`"
for fileName in $list
do
 cp $fileName $fileName.backup
done