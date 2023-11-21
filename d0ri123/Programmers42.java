package d0ri123;

import java.util.Arrays;

/**
 * 카운트다운
 * 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/131129
 */
public class Programmers42 {
    int[][] dp;
    int INF = 100001;

    public static void main(String[] args) {
        Programmers42 sol = new Programmers42();
        int target = 21;

        System.out.println(Arrays.toString(sol.solution(target)));
    }

    public int[] solution(int target) {
        dp = new int[target + 1][2]; // 0: 다트 수 1: 싱글/불 횟수

        for (int i = 1; i <= target; i++) {
            dp[i][0] = INF;
        }

        return throwDart(target);
    }

    int[] throwDart(int n) {
        if (dp[n][0] == INF) {
            if (n >= 50) { // 불 맞추기
                int[] temp = throwDart(n - 50);
                updateDartCount(n, temp[0] + 1, temp[1] + 1);
            }

            int start = Math.min(n, 20);
            for (int i = start; i >= 1; i--) {
                for (int j = 1; j <= 3; j++) { // 싱글, 더블, 트리플
                    if (n >= i * j) {
                        int[] temp = throwDart(n - i * j);
                        int cnt = (j == 1) ? 1 : 0; // 싱글일 경우 카운트하기
                        updateDartCount(n, temp[0] + 1, temp[1] + cnt);
                    }
                }
            }
        }

        return dp[n];
    }

    void updateDartCount(int n, int newDartCount, int newSingleCount) {
        if (newDartCount == dp[n][0] && newSingleCount > dp[n][1]) {
            dp[n][0] = newDartCount;
            dp[n][1] = newSingleCount;
        }
    }

}
