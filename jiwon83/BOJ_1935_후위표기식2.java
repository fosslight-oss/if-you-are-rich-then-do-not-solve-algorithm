import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int [] arr;
    static String exp ;
    static int N;
    static int seq;

    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        exp = br.readLine();
        arr = new int[N];
        for (int i= 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

    }
    public static void main(String[] args) throws IOException{
        input();

        ArrayDeque<Double> stack = new ArrayDeque<>();
        for (char c : exp.toCharArray()){
            if (isAlpha(c)){
                stack.addLast((double)toNumber(c));
            }else{
                double b = stack.pollLast();
                double a = stack.pollLast();
//                System.out.println("a = "+ a);
//                System.out.println("b = "+ b);
                double result = calculate(c, a, b);
//                System.out.println(result);
                stack.addLast(result);
            }
        }
        System.out.printf("%.2f\n", stack.peekLast());
    }
    static boolean isAlpha(char c){
        return c >= 'A' && c <= 'Z';
    }
    static int toNumber(char c){
        int idx = c - 'A';
        return arr[idx];
    }
    static double calculate(char oper, double a, double b){
        switch(oper){
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '+':
                return a + b;

            case '-':
                return a-b;

        }
        return -1;
    }

}