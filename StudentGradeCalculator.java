import java.util.Scanner;
public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int sub = sc.nextInt();
        System.out.println("Enter marks (1-100) ");

        int[] marks = new int[sub];
        for (int i = 0; i < sub; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
        }

        int Marks = totalMarks(marks);
        double avgPer = calcAvgPercentage(Marks, sub);
        char grade = calcGrade(avgPer);

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + Marks);
        System.out.println("Average Percentage: " + avgPer + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }

    private static int totalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double calcAvgPercentage(int Marks, int sub) {
        return (double) Marks / sub;
    }

    private static char calcGrade(double avgPer) {
        if (avgPer >= 90) {
            return 'A';
        } else if (avgPer >= 80) {
            return 'B';
        } else if (avgPer >= 70) {
            return 'C';
        } else if (avgPer >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
