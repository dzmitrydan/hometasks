package exceptions.objects;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private final String name;
    private final Map<String, Integer> allCourses;

    public Student(String name) {
        this.name = name;
        allCourses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getAllCourses() {
        return allCourses;
    }

    public void setCourse(String course, int score) throws Exception {
        if (score < 0 || score > 10) {
            throw new Exception("The score must be below 0 and above 10");
        } else allCourses.put(course, score);
    }

    public double getAverageScoreForStudent() {
        double totalScore = 0.0;
        for (int score : allCourses.values()) {
            totalScore += score;
        }
        return totalScore / (double) allCourses.size();
    }
}
