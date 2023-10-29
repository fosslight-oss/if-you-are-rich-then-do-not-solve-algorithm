import java.util.*;
class Solution {
    public String[] solution(String[] reports, String times){

        ArrayList<String> ans = new ArrayList<>();
        int startTime = reverTimeFromStr(times.split(" ")[0]);
        int endTime = reverTimeFromStr(times.split(" ")[1]);

        // 시간 순 정렬
        Arrays.sort(reports, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int time1 = reverTimeFromStr(o1.split(" ")[1]);
                int time2 = reverTimeFromStr(o2.split(" ")[1]);
                return time1 - time2;
            }
        });

        for (String report : reports){
            String [] parsed = report.split(" ");
            int time = reverTimeFromStr(parsed[1]);
            if (startTime > time) continue;
            if (endTime < time ) break;
            ans.add(parsed[0]);
        }
        return ans.toArray(new String[ans.size()]);
    }
    public int reverTimeFromStr(String str){
        String [] timeStr = str.split(":");
        return Integer.parseInt(timeStr[0])*60 + Integer.parseInt(timeStr[1]);
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}