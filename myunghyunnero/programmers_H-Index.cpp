#include <string>
#include <vector>
#include <iostream>
using namespace std;


int solution(vector<int> citations) {
    int answer = 0;
    int len = citations.size();
    int left = 0;
    int right = 10000;
    while(left<=right){
        int mid = (left + right)/2;
        int cnt = 0;
        for(int i : citations){
            if(i>=mid){
                cnt++;
            }
        }
        if(cnt>=mid){
            answer=mid;
            left = mid+1;
        }else{
            right = mid-1;
        }
        
    }
    return answer;
}