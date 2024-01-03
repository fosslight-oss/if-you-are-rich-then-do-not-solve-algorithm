#include <string>
#include <vector>
using namespace std;
vector<string> boards;
int x,y;
int answer=0;
bool findTwo(){
    bool visited[31][31];
    for(int i = 0 ;i<31;i++){
        for(int j=0;j<31;j++){
            visited[i][j]=false;
        }
    }
    bool check = false;
    for(int i=0;i<x-1;i++){
        for(int j=0;j<y-1;j++){
            char c = boards[i][j];
            if(c ==' ') continue;
            if(c == boards[i+1][j] 
              && c == boards[i][j+1]
              && c == boards[i+1][j+1]){
                visited[i][j]=true;
                visited[i+1][j]=true;
                visited[i][j+1]=true;
                visited[i+1][j+1]=true;
                check=true; //발견한게 있음
            }
        }
    }
    for(int i=0;i<x;i++){
        for(int j=0;j<y;j++){
            if(visited[i][j]){
                answer++;
                boards[i][j]=' ';
            }
        }
    }
    //한 열마다 내려가게 함 
    for(int i=0;i<y;i++){
        int minY=-1;
        for(int j=x-1;j>=0;j--){
            if(boards[j][i]==' '){
                minY = j;
                break;
            }
        }
        if(minY == -1) continue; //빈칸 없으면 넘어감
        for(int j=minY-1;j>=0;j--){
            if(boards[j][i]!=' '){
                boards[minY][i]=boards[j][i];
                boards[j][i]=' ';
                minY--;
            }
        }
    }
    return check;
    
}
int solution(int m, int n, vector<string> board) {
    x=m;
    y=n;
    boards = board;
    while(findTwo());
    return answer;
}