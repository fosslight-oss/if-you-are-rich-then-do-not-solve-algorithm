#include <iostream>
#include <vector>
using namespace std;

int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    int size = stations.size();
    int start=0;
    int width = 2*w+1;
    for(int i=0;i<size;i++){
        if(start+1 <  stations[i]-w){
            int remain=stations[i]-w-start-1;
            if(remain>=1) {
                int cnt = remain%width==0 ?remain/width:remain/width+1;
                answer+=cnt;
            }
        }
        start=stations[i]+w;
    }
    if(start<=n){
        int remain=n-start;
        int cnt = remain%width==0 ? remain/width: remain/width+1;
        answer+=cnt;
    }
    return answer;
}