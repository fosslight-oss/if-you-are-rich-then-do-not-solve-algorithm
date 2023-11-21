package d0ri123;

import static d0ri123.Number.ZERO;

import java.util.Arrays;

enum Number {
    ZERO(0, "zero"),
    ONE(1, "one"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine");

    private final int integerNumber;
    private final String stringNumber;

    Number(int integerNumber, String stringNumber) {
        this.integerNumber = integerNumber;
        this.stringNumber = stringNumber;
    }

    public int getIntegerNumber() {
        return integerNumber;
    }

    public String getStringNumber() {
        return stringNumber;
    }

    public static String checkParsedInput(String s) {
        return Arrays.stream(Number.values())
            .filter(number -> s.contains(number.getStringNumber()))
            .reduce(s, (result, number) ->
                result.replace(number.getStringNumber(), String.valueOf(number.getIntegerNumber())),
                (result1, result2) -> result2);
    }

}

class Input {
    private String input;
    private Integer result;

    public Input(String s) {
        //TODO: 모두 숫자인지 검증한다. 그럼 바로 그냥 return
        if (checkOnlyPureInteger(s)) {
            return;
        }
        if(validateLength(s) && validatePrefix(s)) {
            input = s;
        }
    }

    private boolean checkOnlyPureInteger(String s) {
        try {
            result = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateLength(String s) {
        return s.length() >= 1 && s.length() <= 50;
    }

    private boolean validatePrefix(String s) {
        return !s.startsWith(ZERO.getStringNumber())
            && !s.startsWith(String.valueOf(ZERO.getIntegerNumber()));
    }

    public String getInput() {
        return input;
    }

    public Integer getResult() {
        return result;
    }
}

public class Programmers43 {
    public static void main(String[] args) {
        Programmers43 sol = new Programmers43();

        String s = "one4seveneight";
//        String s = "23four5six7";
//        String s = "2three45sixseven";
//        String s = "123";

        System.out.println(sol.solution(s));
    }

    public int solution(String s) {
        Input input = new Input(s);

        if (input.getResult() != null) {
            return input.getResult();
        }

        return Integer.parseInt(Number.checkParsedInput(s));
    }

}
