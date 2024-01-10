#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int start = 1;
    int end=1;
    int sum=0;
    for(int i=1;i<=n;i++){
        sum+=end;
        end++;
        if(sum==n){
            answer++;
        }else if(sum>n){
            for(int j=start;j<end;j++){
                sum-=start;
                start++;
                if(sum==n){answer++;}
                if(sum<n){
                    break;
                }
            }
        }
    }
    
    return answer;
}