# wow, my first sed scenario to uppercase distros list 
# and change date type from mm-dd-yyyy to yyyy-mm-dd

1 i\
\
Linux Distributions Report\
s/\([0-9]\{2\}\)/\([0-9]\{2\}\)/\([0-9]\{4\}\)$/\3-\1-\2/
y/abcdefghijklmnopqrstuvwxyz/ABCDEFGHIJKLMNOPQRSTUVWXYZ/
