package homework.task_7_strings;

//5*
import java.util.Random;
import java.util.Scanner;

public class Task5 {
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        random = new Random();
        scanner = new Scanner(System.in);

        int randomIndex = random.nextInt(words.length);
        String randomWord = words[randomIndex];
        System.out.println("Random word: " + randomWord); // для облегчения понимания случайно загаданного слова

        quessWord(randomWord);
    }

    public static void quessWord(String randomWord) {
        char[] guessedLetters = new char[15];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '#';
        }

        boolean wordGuessed = false;

        while (!wordGuessed) {
            System.out.println("Enter your word: ");
            String myWord = scanner.nextLine();
            if (myWord.equalsIgnoreCase(randomWord)) {
                wordGuessed = true;
            } else {
                for (int i = 0; i < randomWord.length(); i++) {
                    if (myWord.length() > i && myWord.charAt(i) == randomWord.charAt(i)) {
                        guessedLetters[i] = randomWord.charAt(i);
                    }
                }
                System.out.println("You guessed part of the word: " + new String(guessedLetters));
            }
        }
        System.out.println("Congratulation! You guessed the word " + randomWord);
    }
}
