public class Student {

    private String name;
    private String surname;
    private int score;

    // Constructor
    public Student(String name, String surname, int score) {
        this.name = name;
        this.surname = surname;
        this.score = score;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // toString
    @Override
    public String toString() {
        return "Student{name='" + name + "', surname='" + surname + "', score=" + score + "}";
    }
}