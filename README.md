# Online Voting System

An Online Voting System built using Java Swing for the User Interface, where users can vote for candidates in an election, and an admin can add candidates and view election results. The project utilizes Java Generics, Interfaces, Exception Handling, and Swing for UI components.
## Features
### Admin Panel:
-Add candidates to the election.<br>
-View real-time election results.<br>
### User Panel:
-Users can register by entering their name and age.<br>
-Users can vote for a candidate from a list of candidates (displayed in a table).<br>
-Only users above 18 years of age can vote.<br>
-Each user can only vote once.<br>
-Names are validated to allow only alphabetic characters.<br>
### Validations:
-Users under the age of 18 are restricted from voting.<br>
-User names containing invalid characters (e.g., numbers, special characters) are rejected.<br>
-Exception handling for invalid inputs.<br>
## Technologies Used
-Java Swing: For building the graphical user interface (UI).
-Java Generics: Used to create flexible and reusable components.
-Java Interfaces: Applied to define the behavior of voting systems.
-Exception Handling: To handle invalid inputs and errors gracefully.
-Regular Expressions (RegEx): For name validation, ensuring only alphabetic characters are allowed.
## Project Structure
```
my-voting-system/
├── src/
    └── votingsystem/
        ├── User.java
        ├── Admin.java
        ├── InvalidRoleException.java
        └── VotingSystemUI.java
```
### Explanation of Files:
-User.java: Represents the User who casts a vote.
-Admin.java: Represents the Admin who manages the election by adding candidates and viewing results.
-InvalidRoleException.java: Custom exception for handling invalid role inputs.
-VotingSystemUI.java: The main class that handles the user interface and overall voting system logic.
## How to Run

1)Clone this repository to your local machine:<br>
```
git clone https://github.com/your-username/online-voting-system.git<br>
```
2)Navigate to the project directory:<br>
```
cd my-voting-system<br>
```
3)Compile the project using a Java compiler (from the src/ directory):<br>
```
javac votingsystem/*.java<br>
```
4)Run the application:<br>
```
java votingsystem.VotingSystemUI<br>
```
5)The application will launch with a graphical user interface (GUI) where you can choose to log in as either a User or an Admin.<br>

## Usage
### Admin:
-Click the "Admin" button to add candidates to the election.<br>
-After adding candidates, click "Show Results" to see the current voting status.<br>
### User:
-Click the "User" button to vote for a candidate.<br>
-Enter your name and age, then select a candidate from the table.<br>
-If your age is valid and you have not voted already, your vote will be cast.<br>
## Validations
-Age: Users must be 18 years or older to vote.<br>
-Name: Names must contain only alphabetic characters. Invalid names (e.g., "123", ".", or "@user") are rejected.<br>
-Single Vote: A user can vote only once in an election. Duplicate votes are not allowed.<br>
## Future Improvements
-Persist voting data using a database to handle larger elections and maintain history.<br>
-Add user authentication for more secure voting.<br>
-Implement a more sophisticated voting algorithm.<br>
## Screenshots
### User Voting Screen
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/1tKnH7QD/Screenshot-2024-09-06-002658.png' border='0' alt='Screenshot-2024-09-06-002658'/></a>)
### Admin Panel
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/RhFFTMGz/Screenshot-2024-09-06-002707.png' border='0' alt='Screenshot-2024-09-06-002707'/></a>

## License
This project is licensed under the MIT License - see the LICENSE file for details.

