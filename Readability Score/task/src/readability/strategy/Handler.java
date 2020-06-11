package readability.strategy;

import java.util.Scanner;

public class Handler {
    private static final Scanner scanner = new Scanner(System.in);
    private Text text;
    private AlgorithmSelection algorithm;

    public Handler(Text text) {
        this.text = text;
    }

    public void execute() {
        textInfo();
        selectOption();
    }

    private void textInfo() {
        System.out.printf("Words: %.0f\n",  text.getWords());
        System.out.printf("Sentences: %.0f\n", text.getSentences());
        System.out.printf("Characters: %.0f\n",  text.getCharacters());
        System.out.printf("Syllables: %.0f\n", text.getSyllables());
        System.out.printf("Polysyllables: %.0f\n", text.getPolysyllables());
    }

    private void selectOption() {
        algorithm = new AlgorithmSelection();
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        String option = scanner.nextLine();

        switch (option) {
            case "ARI":
                algorithm.setAlgorithm(new AutomatedReadability());
                System.out.printf("Automated Readability Index: %.2f (about %d year olds)\n",  algorithm.getScore(text),  getAge(algorithm.getScore(text)));
                break;
            case "FK":
                algorithm.setAlgorithm(new FleschKincaid());
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds)\n",  algorithm.getScore(text),  getAge(algorithm.getScore(text)));
                break;
            case "SMOG":
                algorithm.setAlgorithm(new SMOG());
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds)\n",  algorithm.getScore(text),  getAge(algorithm.getScore(text)));
                break;
            case "CL":
                algorithm.setAlgorithm(new ColemanLiau());
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds)\n",  algorithm.getScore(text),  getAge(algorithm.getScore(text)));
                break;
            case "all":
                double average = 0;
                algorithm.setAlgorithm(new AutomatedReadability());
                System.out.printf("Automated Readability Index: %.2f (about %d year olds)\n",  algorithm.getScore(text),  getAge(algorithm.getScore(text)));
                average += getAge(algorithm.getScore(text));

                algorithm.setAlgorithm(new FleschKincaid());
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds)\n",  algorithm.getScore(text),  getAge(algorithm.getScore(text)));
                average += getAge(algorithm.getScore(text));

                algorithm.setAlgorithm(new SMOG());
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds)\n",  algorithm.getScore(text),  getAge(algorithm.getScore(text)));
                average += getAge(algorithm.getScore(text));

                algorithm.setAlgorithm(new ColemanLiau());
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds)\n",  algorithm.getScore(text),  getAge(algorithm.getScore(text)));
                average += getAge(algorithm.getScore(text));

                System.out.printf("\nThis text should be understood in average by %.2f year olds.", (average / 4.0));
                break;
            default:

        }
    }

    private static int getAge(double score) {
        if (score > 14) {
            return 25;
        }
        int[] ages = {6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24, 25};
        if (Math.floor(score) > 9) {
            return ages[(int) (Math.ceil(score - 1))];
        } else {
            return ages[(int) (Math.floor(score - 1))];
        }
    }
}
