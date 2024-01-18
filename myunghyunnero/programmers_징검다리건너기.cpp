#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
vector<vector<int>> v;
int solution(vector<int> stones, int k) {
    int left = 0;
    int right = 200000000;
    int size = stones.size();
    while(left<=right){
        int mid = (left+right)/2;
        int count = 0;
        for(int i=0;i<size;i++){
            if(stones[i]-mid<=0){
                count++;
            }else{
                count=0;
            }
            if(count==k) break;
        }
        if(count == k) right = mid-1;
        else left=mid+1;
    }
    
    return left;
}