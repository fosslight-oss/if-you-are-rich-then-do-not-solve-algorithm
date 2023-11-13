import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder ans = new StringBuilder();
        static int N, M;

        public static void main(String[] args) throws IOException {


                String input = br.readLine();
                int [] pos = new int[]{0,0,1,0};


                ArrayDeque<Character> queue = new ArrayDeque<>();
                ArrayDeque<Character> buffer = new ArrayDeque<>();
                Stack<Character> stack = new Stack<>();
                String answer = "PPAP";

                int idx = 0;
                for (int i = 0; i < input.length(); i++) {
                        stack.push(input.charAt(i));
                        StringBuilder sb = new StringBuilder();

                        if (stack.size() < 4) continue;

                        for (int j = 0; j < 4; j++) {
                                sb.append( stack.get(stack.size()-1-j) );
                        }
                        if (sb.toString().equals("PAPP")){
                                int cnt = 0;
                                while (++cnt <= 3) stack.pop();
                        }
                }
                System.out.println((stack.size()==1 && stack.get(0)=='P')? "PPAP" : "NP");



        }



}