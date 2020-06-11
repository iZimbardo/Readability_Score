package readability.strategy;

public class AutomatedReadability implements Algorithm {

    @Override
    public double getScore(Text text) {
        return  4.71 * (text.getCharacters() / text.getWords()) + 0.5 * (text.getWords() / text.getSentences()) - 21.43;
    }
}
