import java.util.*;
class Solution {
    public String[] solution(String[] reports, int time){
        ArrayList<String> candidates = new ArrayList<>();
        HashMap<String, Integer> usedTime = new HashMap<>();
        for (String rep : reports){
            String name = rep.split(" ")[0];
            int useTime = toTime(rep.split(" ")[1]);
            String flag = rep.split(" ")[2];

            if (usedTime.containsKey(name) && usedTime.get(name) > time) continue;
            if (flag.equals("in")) usedTime.put(name, usedTime.getOrDefault(name,0) - useTime );
            if(flag.equals("out")) usedTime.put(name, usedTime.getOrDefault(name,0) + useTime );
            if (usedTime.get(name) > time) candidates.add(name);
        }
        Collections.sort(candidates);

        return candidates.toArray(new String[candidates.size()]);
    }
    private int toTime(String str){
        return Integer.parseInt(str.split(":")[0]) * 60
                + Integer.parseInt(str.split(":")[1]);
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}