package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String input;
        int result = 0;
        char seperator = ',';

        // 출력 양식 1
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 사용자 입력
        input = Console.readLine();

        // 커스텀 구분자
        if(input.startsWith("//")) {
            seperator = input.charAt(2);
            System.out.println("커스텀 구분자: " + seperator);
        }

        // 숫자 합 계산
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
