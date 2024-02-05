import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static MyQueue queue;
    static int N;

    static class MyQueue{
        private LinkedList<Integer> store;

        public MyQueue(){
            store = new LinkedList<>();
        }
        void push(int num){
            store.add(num);
        }
        int pop(){
            if(store.size() ==0 ) return -1;
            else return store.poll();
        }
        int size(){
            return store.size();
        }
        int empty(){
          if(this.size() == 0) return 1;
          else return 0;
        }
        int front(){
            if (empty()==1) return -1;
            else return store.peekFirst();

        }
        int back(){
            if(this.empty()==1) return -1;
            else return store.peekLast();
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int data = -1;
            if(st.hasMoreTokens()) data = Integer.parseInt(st.nextToken());
            doCmd(queue, cmd, data);
        }
    }
    static void doCmd(MyQueue queue, String cmd, int data){
        switch (cmd){
            case "push":
                queue.push(data);
                break;
            case "pop":
                sb.append(queue.pop()).append("\n");
                break;
            case "size":
                sb.append(queue.size()).append("\n");
                break;
            case "empty":
                sb.append(queue.empty()).append("\n");
                break;
            case "front":
                sb.append(queue.front()).append("\n");
                break;
            case "back":
                sb.append(queue.back()).append("\n");
                break;
        }
    }
    static void sol(){

    }
    public static void main(String[] args) throws IOException{
        queue = new MyQueue();
        input();
        System.out.println(sb);

    }
}