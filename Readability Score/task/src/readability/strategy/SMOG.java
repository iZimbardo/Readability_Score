package readability.strategy;

public class SMOG implements Algorithm {
    @Override
    public double getScore(Text text) {
        return 1.043 * Math.sqrt(text.getPolysyllables() * (30.0 / text.getSentences())) + 3.1291;
    }
}
