import java.util.ArrayList;

//School Class
public class School {

    //Arraylists for Teacher, Student, and Courses
    private ArrayList<Teacher> teacherlist = new ArrayList<>();
    private ArrayList<Student> studentlist = new ArrayList<>();
    private ArrayList<String> coursesList = new ArrayList<>();

    //Fields: schoolName, district, location, and courses
    private String schoolName;
    private double district;
    private String location;
    private String courses;

    //The constructor used to setup our School object with desired parameters
    public School(String schoolName, double district, String location){
        this.schoolName = schoolName;
        this.district = district;
        this.location = location;
    }

    //Getter for SchoolName
    public String getSchoolName() {
        return schoolName;
    }

    //Setter for SchoolName
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    //Getter for District
    public double getDistrict() {
        return district;
    }

    //Setter for District
    public void setDistrict(double district) {
        this.district = district;
    }

    //Getter for Location
    public String getLocation() {
        return location;
    }

    //Setter for Location
    public void setLocation(String location) {
        this.location = location;
    }

    //Getter for Courses
    public String getCourses() {
        return courses;
    }

    //Setter for Courses
    public void setCourses(String courses) {
        this.courses = courses;
    }

    //Add Teacher to teacherList
    public void addTeacher(Teacher teacher) {
        teacherlist.add(teacher);
    }

    //Add Student to studentList
    public void addStudent(Student student) {
        studentlist.add(student);
    }

    //Remove Teacher from teacherList as long as size of teacherList is more than 0
    public void remTeacher() {
        if(teacherlist.size()>0) {
            teacherlist.remove(teacherlist.size() - 1);
        }
    }

    //Remove Student from studentList as long as size of studentlist is more than 0
    public void remStudent() {
        if(studentlist.size()>0) {
            studentlist.remove(studentlist.size() - 1);
        }
    }

    //Add courses to courseList
    public void addCourses(String courses){
        coursesList.add(courses);
    }

    //Show coursesList
    public ArrayList<String> getCoursesList(){
        return coursesList;
    }

    //Show teacherList
    public ArrayList<Teacher> getTeacherList() {
        return teacherlist;
    }

    //Show studentList
    public ArrayList<Student> getStudentList() {
        return studentlist;
    }

}