package exceptions.objects;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class University {
    private String name;
    private ArrayList<Faculty> faculties;

    public University(String name) {
        this.name = name;
        faculties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setFaculty(Faculty faculty) throws Exception {

        if(faculty.getGroups().size() == 0){
            throw new Exception("Absence of groups at the faculty " + faculty.getName());
        }faculties.add(faculty);
    }

    public Faculty getFacultyByName(String facultyName){
        return faculties.stream().filter(s -> s.getName().equals(facultyName)).collect(Collectors.toList()).get(0);
    }

    public ArrayList<Faculty> getFaculties() throws Exception {
        if (faculties.size() == 0) {
            throw new Exception("There are no faculties in the University " + name);
        } else return faculties;
    }
}
