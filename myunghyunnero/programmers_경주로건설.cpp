#include <string>
#include <vector>
#include <iostream>
using namespace std;
int arr[26][26][4];
int dx[]={0,0,1,-1};
int dy[]={1,-1,0,0};
vector<vector<int>> boards;
int desX;
int desY;
void dfs(int x,int y,int dir){
    if(x == desX-1 && y==desY-1){
        return;
    }
    for(int i=0;i<4;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];
        if(nx<0 || ny<0 || nx>=desX || ny>=desY) continue;
        if(boards[nx][ny]==1 || (nx==0 && ny==0)) continue;
        if(dir!=i ){
            if(arr[nx][ny][i]==0 || arr[nx][ny][i]>=arr[x][y][dir]+600){
                arr[nx][ny][i]=arr[x][y][dir]+600;
                dfs(nx,ny,i);
            }
        }else{
            if(arr[nx][ny][i]==0 || arr[nx][ny][i]>=arr[x][y][dir]+100){
                arr[nx][ny][i]=arr[x][y][dir]+100;
                dfs(nx,ny,i);
            }
        }
    }
}
int solution(vector<vector<int>> board) {
    int answer = 987654321;
    boards = board;
    desX = board.size();
    desY = board[0].size();
    dfs(0,0,0);
    dfs(0,0,2);
    for(int i=0;i<4;i++){
        if(arr[desX-1][desY-1][i]!=0)
            answer=min(answer,arr[desX-1][desY-1][i]);
    }
    return answer;
}