package readability.strategy;

public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler(new Text("D:\\Intellij_Projects\\Readability Score\\Readability Score\\task\\src\\readability\\test.txt"));
        handler.execute();
    }
}
