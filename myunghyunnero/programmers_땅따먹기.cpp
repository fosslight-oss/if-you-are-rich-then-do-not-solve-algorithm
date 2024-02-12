#include <iostream>
#include <vector>
using namespace std;
int dp[100001][4];
int solution(vector<vector<int> > land)
{
    int answer = 0;
    int len = land.size();
    dp[0][0] = land[0][0];
    dp[0][1] = land[0][1];
    dp[0][2] = land[0][2];
    dp[0][3] = land[0][3];
    for(int i = 1;i<len;i++){
        for(int j=0;j<4;j++){
            if(j!=0)
                dp[i][0] = max(dp[i][0],dp[i-1][j]+land[i][0]); 
            if(j!=1)
                dp[i][1] = max(dp[i][1],dp[i-1][j]+land[i][1]);
            if(j!=2)
                dp[i][2] = max(dp[i][2],dp[i-1][j]+land[i][2]);
            if(j!=3)
                dp[i][3] = max(dp[i][3],dp[i-1][j]+land[i][3]);
        }
    }
    for(int i=0;i<4;i++){
        answer = max(dp[len-1][i],answer);
    }
    
    return answer;
}