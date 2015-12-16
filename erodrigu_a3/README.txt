###################################################################################

			    CIS*2430 (Fall 2015) Assignment three

###################################################################################

author: Eduardo Rodrigues Duarte Neto
StudentID: 0903934
course: CIS*2430 F15 (01) Object Oriented Programming


1. What is it about?

In this program we are building a basic system for Library Search, where the user will be able to add and search for journals and books in the library database. This assignment is an extension from the assignments one and two. For this specific assignment we are having to add a GUI interface and exception handling. 

2. How does it work?

Once the program is running. The first window will present some basic instructions, where the user will be able to chose from the menu three operations: add, search or quit. Choosing add the program will open another window. By default, the window open will be the one for add a book. If the user choose another type of reference from the comboBox, the program will open another window. The user also can choose make a search request, where will be open another window. All the operations will provide a feedback in the message box in all window, except in the first one.

3. Limitation

The program was design according to the specifications required by the assignment.

4. Plan of test
    Testing showing the windows according to the option selected by the user. 
	a)add,search,quit;
	b)comboBox selection:book or journal;
	c)message displayed in the message box;

    Testing inputing
	a)For the main loop(Menu loop):
		1. Valid(add,search,quit,Add,Search,Quit) and invalid inputs.
		2. Check for enter the right option when asked, including check of invalid type of variable.
		3. Check all options to make sure the program will run as expect, going from one loop to another.

	b)adding Book or Journal:
		1.Inputing required and not fields.
	c)search:
		1.Check for inputting in the field asked.

     Test correctness while running:

	a)adding book and journals:
		1.Check the integrity of the list after adding new books and journals.
		2.Check the integrity of the list after reading from a input file.

	c)search: 
			
    		1. Checking for search an item(journal or book):
               2. Passing all the possible search criteria: callNumber, title and period.
        	3. Passing not all or none of the possible criteria.
        	4. Checking the search for an item that is in the beguine or at the end of the list or at the middle.
        	5. Checking the search passing names in wrong order, or using upper case as title.
        	6. Checking the search passing the different possible of period(2014, 2014-,-2014 and 2014-2018).



5. Internal Documentation
--------------

The documentation available as of the date of this release is included in HTML format
in the javadoc directory as requested.

###################################################################################
