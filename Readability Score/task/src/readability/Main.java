package readability;

import readability.strategy.Handler;
import readability.strategy.Text;

public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler(new Text(args[0]));
        handler.execute();
    }
}