package exceptions.objects;

import java.util.*;

public class Group {
    private int name;
    private ArrayList<Student> students;

    public Group(int name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public int getName() {
        return name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudent(Student student) throws Exception {

        if (student.getAllCourses().size() == 0){
            throw new Exception("The student " + student.getName() + " has no courses (must have at least one)");
        } else students.add(student);

    }
}
