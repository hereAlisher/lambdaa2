import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentMain {

    public static List<Student> readStudentsFromFile(String fileName) {
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0].trim();
                    String surname = data[1].trim();
                    int score = Integer.parseInt(data[2].trim());
                    studentList.add(new Student(name, surname, score));
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return studentList;
    }

    public static void main(String[] args) {

        List<Student> students = readStudentsFromFile("studentsEN.txt");

        System.out.println("Students with grade 5:");
        students.stream()
                .filter(s -> s.getScore() == 5)
                .forEach(System.out::println);

        double averageScore = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage grade: " + averageScore);

        long countGrade5 = students.stream()
                .filter(s -> s.getScore() == 5)
                .count();
        System.out.println("Number of students with grade 5: " + countGrade5);
    }
}