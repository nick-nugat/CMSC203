# NNguyen - Assignment 2
## Test plan/screenshots
### Running from command line/IDE
#### Case 1
> [!check] Passed!
> ![[Attachments/Pasted image 20230927184643.png]]

#### Case 2
> [!check] Passed!
> ![[Attachments/Pasted image 20230927185019.png]]

#### Case 3
> [!check] Passed!
> ![[Attachments/Pasted image 20230927185432.png]]

#### Case 4
> [!check] Passed!
> ![[Attachments/Pasted image 20230927190015.png]]

### In Github
![[Attachments/Pasted image 20230927214538.png|500]]

## UML diagram
![[Attachments/UMLDiagram_Assignment2.png]]


## Pseudocode
### `Patient`
- instance variables for first name, middle name, last name, state address, city, state, zip code, emergency contact name, and emergency phone number
- no-arg constructor
- parameterized constructor with first name, middle name, and last name
- parameterized constructor with all attributes
- getters and setters for every attribute
- buildFullName() method that returns full name (uses getter methods)
- buildAddress() method that returns complete address with address, city, state, and zip code variables (uses getter methods)
- buildEmergencyContact() method that returns contact name and number (uses getter methods)
- toString() method (uses build methods)

### `Procedure`
- instance variables for name, date, practitioner, and charges
- no-arg constructor
- parameterized constructor with name and date variables
- parameterized constructor with all variables
- getters and setters for all variables
- toString() method using getters

### `PatientDriverApp`
- main method
	- `Patient` object
	- three `Procedure` objects
	- print info using display methods and calculate total charges method (implemented after)
- displayPatient() method with `Patient` object parameter that returns `Patient` class toString()
- displayPatient() method with `Procedure` object parameter that returns `Procedure` class toString()
- calculateTotalCharges() with three `Procedure` parameters that returns the sum of the procedure charges with the getCharges() method from its class


## Questions to answer
> [!question] Write about your Learning Experience, highlighting your lessons learned and learning experience from working on this project.
> I had a pretty good learning experience with this project. I learned that persistence really helps in figuring out code. Although it may be frustrating debugging code, the feeling when you finally figure out the problem(s) is great.


> [!question] What have you learned?
> I learned how to properly write a program using multiple classes. I also learned how to implement overloaded constructors (this is something I did in my AP Java course, but I was glad to get more practice in).


> [!question] What did you struggle with?
>  I struggled with getting my code to compile. Using command line to get my code to compile didn't seem to work properly, so I ended up running it with the help of Visual Studio Code. By default, running my code through VS Code compiles every `.java` file, the `.class` files landing in the `bin` directory.