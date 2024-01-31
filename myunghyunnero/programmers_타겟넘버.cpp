#include <string>
#include <vector>

using namespace std;
int targets;
vector<int> number;
int len;
int answer;
void dfs(int n,int sum) {
    if(n==len){
        if(sum == targets){
            answer++;
        }
        return;
    }
    dfs(n+1,sum+number[n]);
    dfs(n+1,sum-number[n]);
}
int solution(vector<int> numbers, int target) {
    number = numbers;
    len = numbers.size();
    targets = target;
    dfs(0,0);
    return answer;
}