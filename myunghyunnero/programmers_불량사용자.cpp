#include <string>
#include <vector>
#include <set>
using namespace std;
set<string> st;
vector<string> users;
vector<string> bans;
bool rightName[10];
bool checkStr(string user,string ban){
    if(user.size()!=ban.size()){
        return false;
    }else{
        for(int i=0;i<ban.size();i++){
            if(ban[i]=='*'){
                continue;
            }else{
                if(ban[i]!=user[i]){
                    return false;
                }
            }
        }
    }
    return true;
}
void dfs(int ban_idx,int ban_size){
    if(ban_idx == ban_size){
        string indexStr = "";
        // 일치하는 유저이름이면 1, 아니면 0 으로 문자열 만들고 set에 저장
        for(int i = 0 ;i<users.size();i++){
            if(rightName[i]){
                indexStr+='1';
            }else{
                indexStr+='0';
            }
        }
        st.insert(indexStr);
        return;
    }
    for(int i=0;i<users.size();i++){
        if(rightName[i]) continue;
        if(checkStr(users[i],bans[ban_idx])){
            rightName[i] = true;
            dfs(ban_idx+1,ban_size);
            rightName[i] = false;
        }
    }
}
int solution(vector<string> user_id, vector<string> banned_id) {
    int answer = 1;
    users=user_id;
    bans=banned_id;
    dfs(0,bans.size());
    return st.size();
}