# miniJavaFrontEnd
It's a miniJava Compiler Front End.

Usage:

1. Build a IntelliJ IDEA project including all the java files under the "src" folder

2. Put configurations like *.in under /src/input

3. Build the project and Run

Configurations:
bail_or_not.in :   
   "false":   use default Antlr 4 error recovery

   "true":    pause parsing upon the first lexical(syntax) error

file_path.in :
   src/input/origin.in    no bail out

   src/input/mismatch.in  bail out case 1

   src/input/noalter.in   bail out case 2

The code uses a google standard HashBasedTable to save triplets into a table, so potention build error may 
result from the following two instructions:

import com.google.common.collect.HashBasedTable;

import com.google.common.collect.Table;

which remains a unsolved problem.