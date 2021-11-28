package subway;

import subway.controller.FrontController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        FrontController controller = SubwayInitializer.init();

        boolean run = true;
        while (run) {
            run = controller.run();
        }
    }
}
