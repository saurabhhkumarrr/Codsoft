import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static String[] questions = {
            "Ques 1: What does CPU stand for?",
            "Ques 2: What is the primary purpose of RAM in a computer?",
            "Ques 3: Which company developed the Java programming language?"
    };
    private static String[][] options = {
            { "A. Central Process Unit", "B. Central Processing Unit", "C. Central Processor Unit",
                    "D. Central Processing Unit" },
            { "A. To store data permanently", "B. To run the operating system", "C. To store data temporarily",
                    "D. To connect to the internet" },
            { "A. Microsoft", "B. Apple", "C. Sun Microsystems", "D. Google" }
    };
    private static char[] answers = { 'B', 'C', 'C' };
    private static int current = 0;
    private static int score = 0;
    private static boolean answered = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n<---------You have only 10 seconds to answer every ques.---------->\n");
        for (current = 0; current < questions.length; current++) {
            askQues(scanner);
        }
        System.out.println("Game Over..........");

        result();
        scanner.close();
    }

    private static void askQues(Scanner scanner) {
        System.out.println(questions[current]);
        for (String option : options[current]) {
            System.out.println(option);
        }

        answered = false;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("Your Time's up!");
                    checkAnswer(' ');
                }
            }
        }, 10000);

        String answer = scanner.nextLine().toUpperCase();
        if (!answered) {
            timer.cancel();
            checkAnswer(answer.length() > 0 ? answer.charAt(0) : ' ');
        }
    }

    private static void checkAnswer(char answer) {
        answered = true;
        if (answer == answers[current]) {
            score++;
        }
    }

    private static void result() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.length);
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i] + " - Correct Answer: " + answers[i]);
        }
    }
}
