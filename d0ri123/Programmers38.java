package d0ri123;

import java.util.Arrays;

/**
 * 단속카메라
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */

class Car implements Comparable<Car> {
    int in;
    int out;

    public Car(int in, int out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public int compareTo(Car car) {
        if(this.in == car.in) {
            return this.out - car.out;
        }
        return this.in - car.in;
    }
}

public class Programmers38 {
    public static void main(String[] args) {
        Programmers38 sol = new Programmers38();
        int[][] routes = {{-20,-15}, {-14,-}, {-18,-13}, {-5,-3}};

        System.out.println(sol.solution(routes));
    }

    public int solution(int[][] routes) {
        int answer = 1;
        Car[] arr = new Car[routes.length];
        for(int i=0; i<routes.length ; i++) {
            Car car = new Car(routes[i][0], routes[i][1]);
            arr[i] = car;
        }

        Arrays.sort(arr);
        int bound = arr[0].out;

        for(int i=1; i<arr.length; i++) {
            if(bound >= arr[i].out) {
                bound = arr[i].out;
            }
            if(bound < arr[i].in) {
                answer ++;
                bound = arr[i].out;
            }
        }

        return answer;
    }
}
