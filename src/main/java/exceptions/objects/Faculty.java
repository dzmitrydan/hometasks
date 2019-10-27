package exceptions.objects;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Faculty {

    private String name;
    private ArrayList<Group> groups;

    public Faculty(String name) {
        this.name = name;
        groups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroup(Group group) throws Exception {
        if(group.getStudents().size() == 0){
            throw new Exception("Absence of students in the group " + group.getName());
        } else groups.add(group);
    }

    public Group getGroupByName(int name){
        return groups.stream().filter(s -> s.getName() == name).collect(Collectors.toList()).get(0);
    }

}
