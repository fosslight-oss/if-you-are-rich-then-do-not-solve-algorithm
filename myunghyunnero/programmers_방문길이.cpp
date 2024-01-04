#include <string>
using namespace std;
bool arr[22][22];
int solution(string dirs) {
    int answer = 0;
    int x=11;
    int y=11;
    for(char c : dirs){
        if(c == 'U'){
            if(x+2>=22) continue;
            arr[x+1][y]=true;
            x+=2;
        }else if(c == 'D'){
            if(x-2<0) continue;
            arr[x-1][y]=true;
            x-=2;
        }else if(c == 'L'){
            if(y-2<0) continue;
            arr[x][y-1]=true;
            y-=2;
        }else if(c == 'R'){
            if(y+2>=22) continue;
            arr[x][y+1]=true;
            y+=2;
        }
    }
    for(int i=0;i<22;i++){
        for(int j=0;j<22;j++){
            if(arr[i][j]) answer++;
        }
    }
    return answer;
}