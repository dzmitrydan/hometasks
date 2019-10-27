package exceptions;

import exceptions.objects.Faculty;
import exceptions.objects.Group;
import exceptions.objects.Student;
import exceptions.objects.University;

import java.util.ArrayList;

public class MainTask {
    public static void main(String[] args) throws Exception {

        University universityAABB = createDataAboutUniversity();

        averageScoreInAllCoursesForStudents(universityAABB);
        averageScoreForCourseInClassAtFaculty("Course2", 124, "AA", universityAABB);
        averageScoreInCourseForUniversity("Course2", universityAABB);
    }

    private static University createDataAboutUniversity() throws Exception {
        Student student1 = new Student("Student 1");
        student1.setCourse("Course1", 8);
        student1.setCourse("Course2", 4);
        student1.setCourse("Course3", 7);
        Student student2 = new Student("Student 2");
        student2.setCourse("Course1", 2);
        student2.setCourse("Course2", 1);
        student2.setCourse("Course3", 3);
        Student student3 = new Student("Student 3");
        student3.setCourse("Course1", 3);
        student3.setCourse("Course2", 6);
        student3.setCourse("Course3", 5);

        Group group124 = new Group(124);
        group124.setStudent(student1);
        group124.setStudent(student2);
        group124.setStudent(student3);

        Student student4 = new Student("Student 4");
        student4.setCourse("Course1", 10);
        student4.setCourse("Course2", 8);
        student4.setCourse("Course4", 9);
        Student student5 = new Student("Student 5");
        student5.setCourse("Course1", 6);
        student5.setCourse("Course2", 4);
        student5.setCourse("Course4", 6);

        Group group125 = new Group(125);
        group125.setStudent(student4);
        group125.setStudent(student5);

        Faculty facultyAA = new Faculty("AA");
        facultyAA.setGroup(group124);
        facultyAA.setGroup(group125);

        Student student6 = new Student("Student 6");
        student6.setCourse("Course2", 6);
        student6.setCourse("Course5", 6);
        Student student7 = new Student("Student 7");
        student7.setCourse("Course2", 2);
        student7.setCourse("Course5", 4);

        Group group325 = new Group(325);
        group325.setStudent(student6);
        group325.setStudent(student7);

        Faculty facultyBB = new Faculty("BB");
        facultyBB.setGroup(group325);

        University university = new University("AABB");
        university.setFaculty(facultyAA);
        university.setFaculty(facultyBB);

        return university;
    }


    private static void averageScoreInCourseForUniversity(String courseName, University university) throws Exception {
        double totalScore = 0.0;
        double totalNumberOfStudents = 0.0;

        for(Faculty faculty : university.getFaculties()) {
            for (Group group : faculty.getGroups()) {
                totalNumberOfStudents += group.getStudents().size();
                for (Student student : group.getStudents()) {
                    totalScore += student.getAllCourses().get(courseName);
                }
            }
        }
        double averageScoreInCourseForUniversity = totalScore / totalNumberOfStudents;
        System.out.println("Average score in the course " + courseName + " for the University" + university.getName() + " = " + averageScoreInCourseForUniversity);
    }

    private static void averageScoreForCourseInClassAtFaculty(String courseName, int groupName, String facultyName, University university){
        ArrayList<Student> students = university.getFacultyByName(facultyName).getGroupByName(groupName).getStudents();
        double totalScore = 0.0;
        for (Student student : students) {
            totalScore += (double) student.getAllCourses().get(courseName);
        }
        double averageScoreForCourseInClassAtfaculty = totalScore / (double) students.size();
        System.out.println("Average score for a course " + courseName + " in a group " +  groupName + " and at a faculty " + facultyName + " = " + averageScoreForCourseInClassAtfaculty);
    }

    private static void averageScoreInAllCoursesForStudents(University university) throws Exception {
        System.out.println("Average score in all courses for a student:");
        for(Faculty faculty : university.getFaculties()){
            for(Group group : faculty.getGroups()){
                for(Student student : group.getStudents()){
                    System.out.println("\t" + student.getName() + " = " + student.getAverageScoreForStudent());
                }
            }
        }
    }
}
