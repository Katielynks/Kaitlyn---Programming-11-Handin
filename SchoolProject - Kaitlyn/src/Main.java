//Import the scanner for user input
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // School Project by Kaitlyn Shoemaker
        //    I have created an interactive program which allows the user to add/remove/display teachers and students
        //    depending on what they entered.

        //Create a divider
        System.out.println("\n\n* * * * * * * * * * * * * * * * * * * *\n");

        //Create a new instance of School object
        School school = new School("The Vancouver Learning Network", 39, "Vancouver");

        //Display the actions we are about to take
        System.out.println("Table of contents: \n");
        System.out.println("First, add 10 students");
        System.out.println("Second, Add 3 teachers");
        System.out.println("Third, remove 2 teachers");
        System.out.println("Fourth, remove 1 teacher");
        System.out.println("Fifth, display both lists");
        System.out.println("Retry or end program");

        //Create a divider
        System.out.println("\n* * * * * * * * * * * * * * * * * * * *\n");

        //Variable to determine when to escape the program
        boolean escapeProgram = true;

        //The program loops while escapeProgram is true
        while (escapeProgram) {

            //Indicate the step we are going to undergo first
            System.out.println("Add the students to the list: \n");

            //Integer variable to determine when to escape the adding student while loop
            int iEscape = 1;

            //This section loops as long as the integer iEscape is greater than 0
            while (iEscape > 0) {

                //Direction: User inputs the first name of the student
                System.out.println("Please input the first name of the student: ");

                    //Create the variable to hold the user input
                    String inputFirstName;

                    //Add in the scanner
                    Scanner first = new Scanner(System.in);

                    //Put the scanned user input into the variable inputFirstName
                    inputFirstName = first.next();

                //Direction: User inputs the last name of the student
                System.out.println("Please input the last name of the student: ");

                    //Create the variable to hold the user input
                    String inputLastName;

                    //Add in the scanner
                    Scanner last = new Scanner(System.in);

                    //Put the scanned user input into the variable inputLastName
                    inputLastName = last.next();

                //Direction: User inputs the grade of the student
                System.out.println("Please input the grade of the student: ");

                    //Create the variable to hold user input
                    String inputGrade;

                    //Add in the scanner
                    Scanner grade = new Scanner(System.in);

                    //Put the scanned user input into the variable inputGrade and convert it into an integer
                        inputGrade = grade.next();

                //Add a new student to the list made from the user inputs
                school.addStudent(new Student(inputFirstName, inputLastName, inputGrade));

                    //Print the full student list
                    System.out.println("Students:" + school.getStudentList());


                //Direction: Type 'y' if you want to stop adding students or any other letter to continue
                System.out.println("Type 'y' if you want to stop adding students or any other letter to continue:");

                    //Add in the scanner
                    Scanner end = new Scanner(System.in);

                    //If user says y, then end the while loop by decrementing the determining variable
                    if (end.next().toUpperCase().equals("Y")) {
                        iEscape--;
                    }

                    //If user says any other letter, then continue while loop by keeping iEscape = 1
                    else {
                        iEscape = 1;
                    }

            }


            //Create a divider
            System.out.println("\n - - - - - - - - - - - - - - - - - - - ");

            //Indicate the step we are going to undergo second
            System.out.println("Add the teachers to the list: \n");

            //Integer to determine the when to escape the adding teacher while loop
            iEscape = 1;

            //This section loops as long as the integer iEscape is greater than 0
            while (iEscape > 0) {

                //Direction: User inputs the first name of the teacher
                System.out.println("Please input the first name of the teacher:");

                    //Create the variable to hold user input
                    String inputFirstName;

                    //Add in the scanner
                    Scanner first = new Scanner(System.in);

                    //Put the scanned user input into the variable inputFirstName
                    inputFirstName = first.next();

                //Direction: User inputs the last name of the teacher
                System.out.println("Please input the last name of the teacher:");

                    //Create the variable to hold user input
                    String inputLastName;

                    //Add in the scanner
                    Scanner last = new Scanner(System.in);

                    //Put the scanned user input into the variable inputLastName
                    inputLastName = last.next();

                //Direction: User inputs the subject of the teacher
                System.out.println("Please input the subject of the teacher:");

                    //Create the variable to hold user input
                    String inputSubject;

                    //Add in the scanner
                    Scanner subject = new Scanner(System.in);

                    //Put the scanned user input into the variable inputSubject
                    inputSubject = (subject.next());

                //Add a new teacher to the list made from the user inputs
                school.addTeacher(new Teacher(inputFirstName, inputLastName, inputSubject));

                    //Print the full student list
                    System.out.println("Teachers: " + school.getTeacherList());

                //Direction: Type 'y' if you want to stop adding teachers or any other letter to continue
                System.out.println("Type 'y' if you want to stop adding teachers or any other letter to continue: ");

                    //Add in the scanner
                    Scanner end = new Scanner(System.in);

                    //If user says y, then end the while loop by decrementing the determining variable
                    if (end.next().toUpperCase().equals("Y")) {
                        iEscape--;
                    }

                    //If user says any other letter, then continue while loop by keeping iEscape = 1
                    else {
                        iEscape = 1;
                    }

            }

                //Integer to determine the when to escape the remove student while loop
                iEscape = 1;

                //This section loops as long as the integer iEscape is greater than 0
                while (iEscape > 0) {

                    //Create a divider
                    System.out.println("\n - - - - - - - - - - - - - - - - - - - ");

                    //Indicate the step we are going to undergo third
                    System.out.println("Remove a student: \n");

                        //Remove one student from the list
                        school.remStudent();

                    //Print the new student list
                    System.out.println("New Student List:" + school.getStudentList());

                    //Direction: Type 'y' if you want to stop removing students or any other letter to continue
                    System.out.println("Type 'y' if you want to stop removing students or any other letter to continue:");

                        //Add in the scanner
                        Scanner remove = new Scanner(System.in);

                        //If user says y, then end the while loop by decrementing the determining variable
                        if (remove.next().toUpperCase().equals("Y")) {
                            iEscape--;
                        }

                        //If user says any other letter, then continue while loop by keeping iEscape = 1
                        else {
                            iEscape = 1;
                        }
                    }

                    //Integer to determine the when to escape the remove teacher while loop
                    iEscape = 1;

                    //This section loops as long as the integer iEscape is greater than 0
                    while (iEscape > 0) {

                        //Create a divider
                        System.out.println("\n - - - - - - - - - - - - - - - - - - - ");

                        //Indicate the step we are going to fourthly undergo
                        System.out.println("\nRemove a teacher: \n");

                            //Remove one teacher from the list
                            school.remTeacher();

                        //Print the new teacher list
                        System.out.println("New Teacher List:" + school.getTeacherList());

                        //Direction: Type 'y' if you want to stop removing teachers or any other letter to continue
                        System.out.println("Type 'y' if you want to stop removing teachers or any other letter to continue:");

                            //Add in the scanner
                            Scanner delete = new Scanner(System.in);

                            //If user says y, then end the while loop by decrementing the determining variable
                            if (delete.next().toUpperCase().equals("Y")) {
                                iEscape--;
                            }

                            //If user says any other letter, then continue while loop by keeping iEscape = 1
                            else {
                                iEscape = 1;

                            }
                    }

                    //Create a divider
                    System.out.println("\n - - - - - - - - - - - - - - - - - - - ");

                    //Indicate the step we are going to fifthly undergo and question the user if they would like to undergo the step
                    System.out.println("Would you like to print the student list?");

                    //Direction: Type y for yes or any other letter for no
                    System.out.println("Type y for yes or any other letter for no");

                        //Add in the scanner
                        Scanner students = new Scanner(System.in);

                        //If user says y, then end the while loop by decrementing the determining variable
                        if (students.next().toUpperCase().equals("Y")) {

                            //Print the new student list
                            System.out.println("New Student List:" + school.getStudentList());
                        }

                        //If user says any other letter, then notify the user that the list has not been printed
                        else {
                            System.out.println("The student list has not been printed");
                        }


                    //Create a divider
                    System.out.println("\n - - - - - - - - - - - - - - - - - - - ");

                    //Indicate the step we are going to sixthly undergo and question the user if they would like to undergo the step
                    System.out.println("Would you like to print the teacher list?");

                    //Direction: Type y for yes or any other letter for no
                    System.out.println("Type y for yes or any other letter for no");

                        //Add in the scanner
                        Scanner teachers = new Scanner(System.in);

                        //If user says y, then end the while loop by decrementing the determining variable
                        if (teachers.next().toUpperCase().equals("Y")) {

                            //Print the new teacher list
                            System.out.println("New Teacher List:" + school.getTeacherList());
                        }

                        //If user says any other letter, then notify the user that the list has not been printed
                        else {
                        System.out.println("The Teacher List has not been printed");
                        }


            //Create a divider
            System.out.println("\n\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

            //Ask the user if they would like to start over and add or remove from the existing list they created
            System.out.println("Would you like to start over?");

            //Directions: Type 'y' to start over or any other letter to end the program
            System.out.println("Type 'y' to start over or any other letter to end the program:");

                //Add in the scanner
                Scanner start = new Scanner(System.in);

                //If user says y, then change escapeProgram to true so that the program will re-run
                if (start.next().toUpperCase().equals("Y")) {
                    escapeProgram = true;

                    //Create a divider from the previous program
                    System.out.println("\n\n* * * * * * * * * * * * * * * * * * * * \n\n"); }

                //If the user says any other letter, then end the program
                else {
                    escapeProgram = false;
                }

        }

    }

}
