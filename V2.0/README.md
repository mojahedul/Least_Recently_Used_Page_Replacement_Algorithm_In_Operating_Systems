Least Recently Used(LRU) Page Replacement algorithm
===============================================

Category : Operating System

An implementation of LRU Page Replacement algorithm.

Description
============

This version contains various feature updates & bug fixes to enhance more usability with it's regular bug fixes as a part of continuous integration


Added in LRU v2.0
--------------------------
   
 - Addresses an issue that caused to generate NoSuchFileException for the input of free frame number variable with bigger than 3
 - Updates for catching every separate error with it's scope in a separate sandbox to designate with better details
 - Addresses an issue that caused wrong output if more than 2 page hit occurs(i.e: for the value that already exists)
 - Updates for output presentation. Such as, if no page fault occurs, it now shows "No change" 
 - Updates some variable names that contains a part designates as temp as to follow proper rules to avoid smelly code..
 - Addresses an issue that caused the program to shutdown unexpectedly without showing any reasons or error logs 
 - Separates the process to inilize the free frames cell at the first time
 - It now prints the current values while there is a no change condition for greater understanding
 - And some other fixes & cosmetic changes

 
 Examles :
 ---------
 
    Enter reference string (separating with space): 7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1
    Enter free frames number: 3

    You entered:
    3
    7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1

    Outputs for Least Recently Used page replacement algorithm:
    ----------------------------------------------------------

    7----
    7--0--
    7--0--1
    2--0--1
    No change.. = 2--0--1
    2--0--3
    No change.. = 2--0--3
    4--0--3
    4--0--2
    4--3--2
    0--3--2
    No change.. = 0--3--2
    No change... = 0--3--2
    1--3--2
    No change.. = 1--3--2
    1--0--2
    No change.. = 1--0--2
    1--0--7
    No change.. = 1--0--7
    No change... = 1--0--7


    Reference string length: 20
    Page hit: 8
    Page fault number = Total page number - Page hit number
    Page fault number = 12
    Page fault rate = 60.00 %



 
 
 Conclusion
 ===========
 
 This version mainly focuses on to follow software engineering guidelines and some fixes to solve issues
 
 As the problems/bugs found, fix(s) tried to make it better
 
 And the new versions contains that fixes, optimizations ...
