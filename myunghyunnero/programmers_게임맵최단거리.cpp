#include<vector>
#include <queue>
using namespace std;
int dx[]={0,0,1,-1};
int dy[]={1,-1,0,0};
int arr[101][101];
int ex;
int ey;
queue<pair<int,int>> q;

void bfs(vector<vector<int>> v){
    arr[0][0]=1;
    q.push({0,0});
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        if(x == ex && y == ey){
            break;
        }
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=ex || nx < 0 || ny>=ey || ny <0 ){
                continue;
            }
            if(arr[nx][ny]==-1 && v[nx][ny]!=0){
                arr[nx][ny]=arr[x][y]+1;
                q.push({nx,ny});
            }
        }
    }
}
int solution(vector<vector<int>> maps)
{
    int answer = 0;
    ex = maps.size();
    ey = maps[0].size();
    for(int i=0;i<ex;i++){
        for(int j=0;j<ey;j++){
            arr[i][j]=-1;
        }
    }
    bfs(maps);
    return arr[ex-1][ey-1];
}