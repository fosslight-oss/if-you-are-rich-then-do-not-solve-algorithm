#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n) {
    int answer = 0;
    string str = "";
    int cnt = n+1;
    int ansNum =0;
    while(n!=0){
        if(n%2==1) ansNum++;
        n/=2;
    }
    while(cnt<=1000000){
        int num = cnt;
        int oneCnt = 0;
        while(num!=0){
            if(num%2==1) oneCnt++;
            num/=2;
        }
        if(ansNum == oneCnt){
            answer=cnt;
            break;
        }
        cnt++;
    }
    
    return answer;
}