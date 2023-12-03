import java.util.*;
class Solution {
  static class Std{
    int idx, ban, score;
    public Std(int idx, int ban, int score){
      this.idx = idx;
      this.ban = ban;
      this.score = score;
    }

  }
  static String al = "qwertyuiopasdfghjklzxcvbnm";
  static List<Std> allStdList = new ArrayList<>();
  static int banCnt = al.length();
  static List<Integer> [] banScores = new List[banCnt];
  static HashMap<Integer, Integer> banPointers = new HashMap<>();
  static int [] banSubSum = new int[banCnt];// a ~ z [0~25]]

  static void banPointers(){
    for (int i=0; i<banCnt; i++){
      System.out.println("ban :"+i + " pointer :" + banPointers.get(i) + " - "+  banScores[i]);
    }
  }

  static void init(String[] students){
    allStdList = new ArrayList<>();
    banPointers = new HashMap<>();
    banSubSum = new int[banCnt];
    for (int i = 0; i<banCnt; i++){
      banScores[i] = new ArrayList<>();
      banScores[i].add(0);
      banPointers.put(i, 0);
    }
    for (int i = 0; i<students.length; i++){
      String [] input = students[i].split(" ");
      int ban = input[0].charAt(0)-'a';
      int sc = Integer.parseInt(input[1]);
      allStdList.add( new Std(i, ban , sc) );
      banScores[ban].add(sc);
      banSubSum[ban] += sc;
    }
    for (int i = 0; i<banCnt; i++){
      banScores[i].sort(Collections.reverseOrder());
    }
  }

  public int[] solution(String[] students){
    init(students);
    int n = students.length;
    int[] answer = new int[n];

    allStdList.sort((o1,o2) -> ( o2.score - o1.score));

    for (int i = 0; i< allStdList.size(); i++){
      Std student = allStdList.get(i);
//      banPointers();
      for (int j = 0; j < banCnt; j++){
        if( student.ban == j ) continue;
        //각 반에 대해 포인터 값 확인
        if (banScores[j].get(banPointers.get(j)) == student.score){
          answer[student.idx] += banSubSum[j] - banScores[j].get(banPointers.get(j));
        }else{
          answer[student.idx] +=  banSubSum[j];
        }
      }
      banSubSum[student.ban] -= banScores[student.ban].get(banPointers.get(student.ban));
      banPointers.put(student.ban, banPointers.get(student.ban)+1 );
    }
    return answer;
  }

  public static void main(String[] args){
    Solution T = new Solution();
    System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
    System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
    System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
    System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
  }
}