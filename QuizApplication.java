import java.util.Scanner;
class Question {
    String questionText;
    String[] options;
    int correctOption; 
    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
    public boolean askQuestion(Scanner sc) {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your answer (1-4): ");
        int userChoice = sc.nextInt();
        return (userChoice - 1 == correctOption);
    }
}
public class QuizApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question[] quiz = {
            new Question("Which language is platform-independent?", 
                         new String[]{"C", "C++", "Java", "Python"}, 2),
            new Question("What is the size of int in Java?", 
                         new String[]{"2 bytes", "4 bytes", "8 bytes", "Depends on OS"}, 1),
            new Question("Which keyword is used to inherit a class in Java?", 
                         new String[]{"this", "super", "extends", "implements"}, 2),
            new Question("Which of these is not OOP principle?", 
                         new String[]{"Encapsulation", "Polymorphism", "Abstraction", "Compilation"}, 3),
            new Question("Which company developed Java?", 
                         new String[]{"Microsoft", "Sun Microsystems", "Google", "Oracle"}, 1)
        };
        int score = 0;
        System.out.println("===== Welcome to the Java Quiz =====");
        for (Question q : quiz) {
            if (q.askQuestion(sc)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong!");
            }
        }
        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + quiz.length);
        if (score == quiz.length) {
            System.out.println("🎉 Excellent! Full Score!");
        } else if (score >= quiz.length / 2) {
            System.out.println("👍 Good Job! Keep practicing.");
        } else {
            System.out.println("📖 You need more practice. Try again!");
        }
        sc.close();
    }
}
