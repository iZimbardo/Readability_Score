package readability.strategy;

public class AlgorithmSelection {

    private Algorithm algorithm;

    public AlgorithmSelection() {}

    public double getScore(Text text) {
        return algorithm.getScore(text);
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
