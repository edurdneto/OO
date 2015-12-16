###################################################################################

			    CIS*2430 (Fall 2015) Assignment two

###################################################################################

author: Eduardo Rodrigues Duarte Neto
StudentID: 0903934
course: CIS*2430 F15 (01) Object Oriented Programming


1. What is it about?

In this program we are building a basic system for Library Search, where the user will be able to add and search
for journals and books in the library database. For this specific assignment We are having to create an Superclass called Reference, which extends the classes Book and Journal. Also the LibrarySearch class now has as atribute an ArrayList of references instead of two ArrayList. Some functions had been changed now that we have this superclass, avoiding unnecessary duplicate code. The search function of the librarySearch class has been update to a more efficient search using a Hash map to check the title match.

2. How does it work?

Once the program is being executed the user will be ask for select one of 3 options: add, search or quit. If the
user choose to add it will be asked to select btw book or journal to add. Then it will be asked to input corresponding
fields for each kind of item(book or journal) you are adding. If the user choose to search, it will also asked to input
the search criteria. During the execution of the program, it will produce feedback for the user.

3. Limitation

The program was design according to the specifications required by the assignment.

4. Plan of test

    a)selecting of the menu options(add,search and quit):
    -Inputing an invalid type, or selecting an invalid choice in any of the selections menu.
    -Giving an empty input for the required fields.
    b)testing correctness:
    -Checking for add book and add journal in the LibrarySearch
    -Checking for search an item(journal or book):
        -Passing all the possible search criteria: callNumber, title and period.
        -Passing not all or none of the possible criteria.
        -Checking for an item that isnt in the list. That is in the beguine or at the end of the list.
        -Checking for correctness of the search passing names in wrong order as title.
        -Checking for correctness of the search passing the different possible of period(2014, 2014-,-2014 and 2014-2018).


5. Internal Documentation
--------------

The documentation available as of the date of this release is included in HTML format
in the javadoc directory as requested.

###################################################################################
