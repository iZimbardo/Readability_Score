public class Main {
    public static void main(String[] args) {
        Secret[] secrets = Secret.values();

        int count = 0;
        for (Secret s : secrets) {
            if (s.toString().toUpperCase().startsWith("STAR")) {
                count++;
            }
        }

        System.out.println(count);
    }
}

// At least two constants start with STAR
enum Secret {
    STAR, CRASH, START, // ...
}
