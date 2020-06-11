package readability.strategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private String text;
    private double characters;
    private double words;
    private double sentences;

    public Text(String filePath) {
        readTextFromFile(filePath);
    }

    private void readTextFromFile(String filePath) {
        try {
            text = Files.readString(Paths.get(filePath));
            characters = text.replaceAll("\\s+", "").length();
            words = text.split("\\s+").length;
            sentences = text.split("[!?.]").length;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getSyllables() {
        double sylCount = 0;

        Pattern pattern = Pattern.compile("(?!e\\b)[aeiouy]{1,}|\\b[0-9qwrtplkjhgfdszxcvbnm]+\\b|\\bthe\\b");

        for(String word : text.split("\\s+")) {
            int count = 0;

            Matcher matcher = pattern.matcher(word.toLowerCase());
            while (matcher.find()) {
                count += 1.0;
            }

            sylCount += count;
        }
        return sylCount;
    }

    public double getPolysyllables() {
        double polyCount = 0;

        Pattern pattern = Pattern.compile("(?!e\\b)[aeiouy]{1,}|\\b[0-9qwrtplkjhgfdszxcvbnm]+\\b|\\bthe\\b");

        for(String word : text.split("\\s+")) {
            int count = 0;

            Matcher matcher = pattern.matcher(word.toLowerCase());
            while (matcher.find()) {
                count += 1;
            }

            if(count > 2) {
                polyCount++;
            }
        }

        return polyCount;
    }

    public double getCharacters() {
        return characters;
    }

    public double getWords() {
        return words;
    }

    public double getSentences() {
        return sentences;
    }

    public String getText() {
        return text;
    }
}
