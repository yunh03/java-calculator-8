package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 값 설정
        String input = Console.readLine();

        // 기본 구분자 설정
        String seperator = "[,:]";

        // 기본 출력 값 설정
        int sum = 0;

        // 입력 값이 "//"로 시작하고, "\\n"이 포함되어 있을 때
        if(input.startsWith("//") && input.contains("\\n")) {
            // 커스텀 구분자 종료 위치
            int index = input.indexOf("\\n");

            // 커스텀 구분자 추출
            String customSeperator = input.substring(2, index);

            // 커스텀 구분자 이후로 사용자 입력 값 변경
            input = input.substring(index + 2);

            // 기본 구분자에 커스텀 구분자 추가
            seperator = "[,:]|" + customSeperator;
        }

        // 구분자를 이용해 사용자 입력 값 자르기
        String[] numbers = input.split(seperator);

        for(String number : numbers){
            // 빈 값이 아닐 때
            if(!number.trim().isEmpty()){
                // String 값에서 Int 형식으로 변환
                int num = Integer.parseInt(number.trim());

                // 음수면 IllegalArgumentException 던지기
                if(num < 0) throw new IllegalArgumentException();

                // 정상적인 값으면 합에 추가
                sum += num;
            }
        }

        System.out.println("결과 : " + sum);
    }
}
