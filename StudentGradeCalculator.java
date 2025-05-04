import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static double calculateAverageGrade(String filename) {
        double total = 0;
        int count = 0;

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String name = scanner.next();
                if (name.equalsIgnoreCase("Average")) {
                    break;
                }
                if (scanner.hasNextInt()) {
                    int grade = scanner.nextInt();
                    total += grade;
                    count++;
                }       
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
            return 0;
        }

        return count > 0 ? total / count : 0;
    }

    public static void printStudentGrades(String filename) {
        System.out.println("Student Grades:");
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String name = scanner.next();
                if (name.equalsIgnoreCase("Average")) {
                    break;
                }
                if (scanner.hasNextInt()) {
                    int grade = scanner.nextInt();
                    System.out.println(name + ": " + grade);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        }
    }

    public static void main(String[] args) {
        String filename = "grades.txt";
        printStudentGrades(filename);
        double average = calculateAverageGrade(filename);
        System.out.printf("Average Grade: %.2f\n", average);
    }
}