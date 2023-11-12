package d0ri123;

import java.util.Stack;

/**
 * 택배 배달과 수거하기
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/150369
 */
class Home {
    int quantity;
    int idx;

    public Home(int quantity, int idx) {
        this.quantity = quantity;
        this.idx = idx;
    }
}


public class Programmers34 {

    public static void main(String[] args) {
        Programmers34 sol = new Programmers34();
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

//        int cap = 2;
//        int n = 7;
//        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
//        int[] pickups = {0, 2, 0, 1, 0, 2, 0};

        System.out.println(sol.solution(cap, n, deliveries, pickups));
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Home> delivery = new Stack<>();
        Stack<Home> pickup = new Stack<>();
        //cap은 한정적으로 올릴 수 있는 물건 갯수
        long answer = 0;

        for(int i=0; i<n; i++) {
            if(deliveries[i] != 0) delivery.push(new Home(deliveries[i], i));
            if(pickups[i] != 0) pickup.push(new Home(pickups[i], i));
        }

        while(!delivery.isEmpty() || !pickup.isEmpty()){
            // 만약 두 스택 중 하나가 다 비었다면 무조건 남은 친구를 뽑고 그 수의 *2 만큼 answer 더하기

            // 1. 배달 스택이 비었을 경우 : 수거 스택만 뽑은 후 그 수의 *2 만큼 더하기
            if(delivery.isEmpty()){
                int adder = pickup.pop().idx;
                answer += (long) (adder+1)*2;

                // 택배
            }
            // 2. 수거 스택이 비었을 경우 : 배달 스택만 뽑은 후 그 수의 *2 만큼 더하기
            else if(pickup.isEmpty()){
                int adder = delivery.pop().idx;
                answer += (long) (adder+1)*2;
            }
            // 3. 둘 다 비어있지 않을 경우 : 더 큰 수의 *2 만큼 더하기
            else{
                int deliveriesPeek = getAdder(delivery,cap);
                int pickupsPeek = getAdder(pickup,cap);
                int adder = Math.max(deliveriesPeek, pickupsPeek);
                answer += (long) (adder+1)*2;
            }

        }

        return answer;
    }

    public static int getAdder(Stack<Home> home, int cap) {
        int curCap = 0;
        int adder = 0;

        while(cap > curCap){
            // 만약 스택이 비었다면 종료
            if(home.isEmpty()) break;

            Home peek = home.peek();
            adder = Math.max(adder, peek.idx);

            // 만약 현재 집에서 싣을 수 있는 택배 수를 넘었을 경우
            if(peek.quantity + curCap > cap){
                // 차이만큼 더하고 pop 하지 않고 deliveries[] 값을 차이만큼 뺀다
                int diff = cap - curCap;
                peek.quantity -= diff;
                curCap = cap;
            }

            // 만약 현재 집에서 싣을 수 있는 택배 수를 넘지 않았을 경우
            else{
                // currCap에 해당값 그대로 더하고 pop
                curCap += peek.quantity;
                home.pop();
            }
        }
        return adder;
    }

}
