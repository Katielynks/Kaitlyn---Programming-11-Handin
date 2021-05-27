//Student Class
public class Student {

    //Fields: firstName, lastName, grade, studentNumber
    private String firstName;
    private String lastName;
    private String grade;
    int studentNumber;

    //unique number to assign to studentNumber
    static int count = 1;

    //The constructor used to setup our Student object with desired parameters
    public Student(String firstName, String lastName, String grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentNumber = count;
        count++;
    }

    //Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    //Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Getter for lastName
    public String getLastName() {
        return lastName;
    }

    //Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Getter for fullName
    public String getFullName() {
        return firstName + " " + lastName;
    }

    //Getter for Grade
    public String getGrade() {
        return grade;
    }

    //Setter for Grade
    public void setGrade(String grade) {
        this.grade = grade;
    }

    //Getter for studentNumber
    public int getStudentNumber() {
        return studentNumber;
    }

    //Returns Full Name and Grade
    public String toString() {
        return "Name: " + this.getFullName() + "  Grade: " + this.getGrade();
    }
}
