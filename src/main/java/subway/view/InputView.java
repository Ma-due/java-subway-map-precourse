package subway.view;

import subway.vo.MenuType;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputOpt() {
        return scanner.nextLine();
    }

    public static String inputName() {
        return scanner.nextLine();
    }

    public static String inputIndex() {
        return scanner.nextLine();
    }
}
