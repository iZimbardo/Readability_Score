package readability.strategy;

public class ColemanLiau implements Algorithm {
    @Override
    public double getScore(Text text) {
        double L = text.getCharacters() / text.getWords() * 100;
        double S = text.getSentences() / text.getWords() * 100;
        return 0.0588 * L - 0.296 * S - 15.8;
    }
}
