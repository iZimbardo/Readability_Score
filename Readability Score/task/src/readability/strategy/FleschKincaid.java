package readability.strategy;

public class FleschKincaid implements Algorithm {
    @Override
    public double getScore(Text text) {
        return 0.39 * text.getWords() / text.getSentences() + 11.8 * text.getSyllables() / text.getWords() - 15.59;
    }
}
