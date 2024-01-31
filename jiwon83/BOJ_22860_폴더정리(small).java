import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static HashMap<String, List<String>> graph = new HashMap<>();
    static HashMap<String, HashSet<String>> fileTypesMap = new HashMap<>();
    static HashMap<String, Integer> fileCntMap = new HashMap<>();
    static HashMap<String, Boolean> folderVisit = new HashMap<>();

    static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <N+M; i++){
            st = new StringTokenizer(br.readLine());
            String path = st.nextToken();
            String target = st.nextToken();
            String type = st.nextToken();
            if(!fileTypesMap.containsKey(path)) fileTypesMap.put(path, new HashSet<>());
            if (!fileCntMap.containsKey(path)) fileCntMap.put(path, 0);
            if( !graph.containsKey(path)) graph.put(path, new ArrayList<>());
            folderVisit.put(path, false);

            if (type.equals("0")){ //is file
                fileTypesMap.get(path).add(target);
                fileCntMap.put(path, fileCntMap.get(path) + 1);
            }else{ // folder
                folderVisit.put(target, false);
                if( !graph.containsKey(target)) graph.put(target, new ArrayList<>());
                if( !fileCntMap.containsKey(target)) fileCntMap.put(target, 0);
                if( !fileTypesMap.containsKey(target)) fileTypesMap.put(target, new HashSet<>());
                graph.get(path).add(target);
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++){
            String folder =getLastFolderName(br.readLine());
            dfs(folder);
            sb.append(fileTypesMap.get(folder).size()+" "+ fileCntMap.get(folder)).append("\n");
        }

    }
    static String getLastFolderName(String str){
        String [] folders = str.split("/");
        return folders[folders.length-1];
    }
    static void dfs(String folder) {
        // 자식이 return하는 값을 갱신한다.
        if (folderVisit.get(folder)) return;

        folderVisit.put(folder, true);

        int childFilesCnt = 0;
        for(String child : graph.get(folder)){
            if(!folderVisit.get(child)) dfs(child);

            for (String childFiles : fileTypesMap.get(child)){
                fileTypesMap.get(folder).add(childFiles);
            }
            childFilesCnt += fileCntMap.get(child);
        }
        fileCntMap.put(folder, fileCntMap.getOrDefault(folder, 0) + childFilesCnt);

    }
    public static void main(String[] args) throws IOException{
        input();
        System.out.println(sb);
    }

}