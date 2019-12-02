package ladder.view;

import java.util.Scanner;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-02
 */
public class InputView {
    public static String inputTopItems(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요, all은 사용할 수 없습니다.)");
        return scanner.nextLine();
    }

    public static String inputResultItems(Scanner scanner) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputHeight(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static String inputReward(Scanner scanner) {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
