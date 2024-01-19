import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.;
TIP To bRunb code, press shortcut actionId=Run or
click the icon src=AllIcons.Actions.Execute icon in the gutter.

소수점 출력 시 그냥 print 하면 안됨 - E 사용한 표현식으로 출력된다.
        String.format()으로 해야함

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static MapString, Integer tm = new TreeMap();
    static int N;

    static void input() throws IOException{
        String key;
        while ( (key=br.readLine())!=null && !key.isEmpty()){
            N++;
            tm.put(key, tm.getOrDefault(key, 0)+1);
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        해당 종의 나무 갯수  전체 나무의 갯수
        char = 2 bytes  30
        60  10,000 = 600,000 B = 600 KB = 0.6MB = ok
        treeMap 시간복잡도 = O(logN) = ok
        for(Map.EntryString,Integer entry  tm.entrySet()){
            double val = Math.round(((double)entry.getValue())N 100 10000)  (double)10000;  0.567 - 2  56.7 - 57 - 57100
            sb.append(entry.getKey()+ + String.format(%.4f, (float)entry.getValue()N100)).append(n);
        }
        System.out.println(sb);
    }

}