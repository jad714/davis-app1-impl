To-Do List Application
======================

This user guide will familiarize you (the user) with the To-Do List Application.

Familiarization
===============

Upon launching the program, the user will be met with a blank table prompting you to enter values into the left-hand
"item description" field and to select a date using the "Due Date" field. All of the buttons and controls on this side will be
laid out below, from top to bottom.

	a) Empty List - The "Empty List" button will clear all to-do-list items currently being viewed from the application upon being clicked TWICE.
This is to ensure that a user who has not read this guide does not haphazardly clear their list without intending to. Upon first click, the user will be
prevented with a warning (appearing in the seemingly blank space beneath) to explain the consequences of the action. Upon second click, the action will be carried out,
and the data associated lost forever if not previously saved.

	b) Save As... - The "Save As..." button functions much as one would expect a "save as" function to work. According to the user's operating system, the file chooser
dialog will be opened, allowing for cross-platform use and a simple, easy-to-grasp method of saving information. The data will be parsed into a form that the To-Do-List application
can load later on. Files are restricted to .txt, but otherwise, the user can specify the name of the file they would like, as well as the directory information.

	c) View Options - There are three radio buttons here: All, Completed, and Incomplete. Assuming a populated list of items in the table to the right, these toggle buttons allow you
to EXCLUSIVELY select a viewing option for said table. The "All" button will populate the table with all items in the user's virtual list, the "Completed" button will populate the table only with
those items marked complete, and the "Incomplete" button will populate the table with only those items marked incomplete. NOTE: THESE OPTIONS DO NOT ALTER THE VIRTUAL LIST ITSELF, ONLY WHAT IS BEING
DISPLAYED IN THE TABLE.

	d) Item Description Text Box - The text field labeled "Item Description" allows the user to type a description (between 1 and 256 characters, inclusive), of their choosing. As implied previosuly,
this field CANNOT be blank and CANNOT contain more than 256 characters. This field's content will be cleared each time a list is edited or added, and any text that was previously typed will be added to the list,
providing it met the previously stated requirements. A warning box pertaining to this field and the below date picker will appear in case of an error. WARNING! DO NOT INCLUDE "_" CHARACTERS IN THE ITEM DESCRIPTION
AS THIS CHARACTER IS RESERVED FOR SAVE FILE FORMATTING. FAILURE TO OBSERVE THIS WARNING WILL RESULT IN A REJECTION OF INPUT.

	e) Due Date - The date picker below the Item Description text box labeled "Due Date" allows the user to click the small button on the right side to select a valid Gregorian Calendar date. The attached text box
is there for user convenience for the visual aid of the user once they've chosen a date, and should not be used to directly input a date (text input content will be ignored by the program). It should be noted that a date is
not required to be selected to add an item to the list. Like the item description text box, this field's value will return to a null value once the add or edit button is pressed.

	f) Add Item to List - The "Add Item to List" button will add an item containing the data in the Item Description Text Box and, (if applicable), the data in the Due Date date picker.  The task will fail (and an error appear above)
if the Item Description requirements have not been met (See item d). By default, all new items have a completed status of "No".

	g) Edit Selected - The "Edit Selected" button changes the item at the selected location on the table to match what was typed in the above fields. Once again, no date is required, and the Item Description requirements remain unchanged.
The completion status remains the same as it was previously and mark/unmark complete buttons can be used to change this field.

	h) Load List - This is similar to "Save As..." in terms of end-user functionality. It will create a file chooser dialog window according to the user's operating system and allow the user to select a file to load (WARNING! DO NOT ATTEMPT TO LOAD
AN IMPROPERLY FORMATTED FILE, NOR LOAD MULTIPLE FILES AS UNDEFINED BEHAVIOR, INCLUDING A FATAL ERROR CAN OCCUR).

	i) Table - The Table on the right with "Due Date", "Description", and "Completed" columns will display the data the user enters into the list, with the application of the view filter specified in the "View Options" block.
The Due Date column, by default, sorts the data in ascending order, but clicking the "Due Date" tab twice (so that the carrot is facing downward) sorts the list in DESCENDING order (later dates appear first). According to default sizes,
it is possible that sufficiently long descriptions will be cut off by the table. The data is as typed, providing there were no errors, so if the user wants to view the entire thing, they can resize the table as necessary by extending the tabs at the top.

	j) Mark Complete and Mark Incomplete - The "Mark Complete" and "Mark Incomplete" buttons do just that. They adjust the selected item's "Completed" field by replacing that item in the virtual list with an item with the same fields and the appropriate
completion status. Clicking these buttons with no selection target in the table does nothing.

	k) Delete - The "Delete" button allows the user to delete the selected item from the virtual list. It really is that simple. If pressed with no selection target, the delete button does nothing.

*** FINAL TIP ***
It is recommended that descriptions are kept as brief as possible for easy viewing, and that all lists are saved prior to closing the program.