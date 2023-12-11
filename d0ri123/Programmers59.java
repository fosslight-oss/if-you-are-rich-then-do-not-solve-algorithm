package d0ri123;

import java.util.ArrayList;
import java.util.HashMap;

public class Programmers59 {
    public static void main(String[] args) {
        Programmers59 sol = new Programmers59();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList<String>> closet = new HashMap<>();

        for(String[] clothing : clothes) {
            closet.putIfAbsent(clothing[1], new ArrayList<>());
            closet.get(clothing[1]).add(clothing[0]);
        }

        for(String kind : closet.keySet()) {
            int possibleCase = closet.get(kind).size();
            answer *= (possibleCase+1);
        }

        return answer-1;
    }

}
