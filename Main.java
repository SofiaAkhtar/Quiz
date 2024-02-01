import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            question.displayQuestion();
            question.displayOptions();
            question.checkAnswer(scanner);
        }

        scanner.close();
    }
}

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println(questionText);
    }

    public void displayOptions() {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public void checkAnswer(Scanner scanner) {
        System.out.print("Enter your answer (1-" + options.size() + "): ");
        int userAnswer = scanner.nextInt();

        if (userAnswer == correctOption) {
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect. The correct answer is: " + correctOption + ".\n");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Add questions to the quiz
        Question question1 = new Question("What is the capital of France?",
                Arrays.asList("Berlin", "Paris", "Madrid", "Rome"), 2);

        Question question2 = new Question("Which programming language is used for Android development?",
                Arrays.asList("Java", "Python", "C#", "Swift"), 1);

        // Add questions to the quiz
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);

        // Start the quiz
        quiz.startQuiz();
    }
}
