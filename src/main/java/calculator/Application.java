package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = getNumberArray(input).stream().mapToInt(Integer::intValue).sum();

        System.out.println("결과 : " + sum);
    }

    // 문자열 배열에서 숫자를 분리하고, 배열에 추가하여 반환
    public static List<Integer> getNumberArray(String input) {
        // 문자열에서 음수, 양수 둘 다 추출하여 문자열 배열에 추가
        String[] numbers = input.split("[^0-9-]+");

        List<Integer> values = new ArrayList<>();

        for(String number : numbers) {
            if(number.isEmpty()) {
                continue;
            }

            int num = Integer.parseInt(number);

            if(num < 0) {
                throw new IllegalArgumentException();
            }

            values.add(num);
        }

        return values;
    }
}
