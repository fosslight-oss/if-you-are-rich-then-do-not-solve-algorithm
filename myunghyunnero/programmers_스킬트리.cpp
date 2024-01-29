#include <string>
#include <vector>

using namespace std;
bool alp[26];
int solution(string skill, vector<string> skill_trees) {
    int len  = skill.size();
    int answer = 0;
    for(int i=0;i<len;i++){
        alp[skill[i]-'A']=true;
    }
    for(string s : skill_trees){
        int index = 0;
        bool check=true;
        for(int i =0 ;i<s.size();i++){
            if(alp[s[i]-'A']){
                if(skill[index]==s[i]){
                    index++;
                }else{
                    check =false;
                }
            }
        }
        if(check) answer++;
    }
    return answer;
}