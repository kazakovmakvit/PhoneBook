import java.util.Scanner;

public class UserInput {
    Scanner s = new Scanner(System.in);

    public String input() {
        return s.nextLine().replace(" ", "");
    }
}
