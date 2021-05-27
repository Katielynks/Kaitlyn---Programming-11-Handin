//Teacher Class
public class Teacher {

    // Fields: firstName, lastName, and subject
    private String firstName;
    private String lastName;
    private String subject;

    //The constructor used to setup our Teacher object with desired parameters
    public Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
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

    //Getter for Subject
    public String getSubject() {
        return subject;
    }

    //Getter for Subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    //Returns Full Name and Subject
    public String toString() {
        return "Name: " + this.getFullName() + "  Subject: " + this.getSubject();
    }
}