#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int sumZero = 0;
string changeTwo(string s){
    int num = 0;
    for(char c : s){
        if(c=='1'){
            num++;
        }else{
            sumZero++;
        }
    }

    string ret = "";
    while(num>0){
        ret+=num%2 + '0';
        num/=2;
    }
    reverse(ret.begin(),ret.end());
    return ret;
}
vector<int> solution(string s) {
    vector<int> answer;
    int cnt=0;
    string str=s;
    while(str!="1"){
        str=changeTwo(str);
        cnt++;
    }
    answer.push_back(cnt);
    answer.push_back(sumZero);
    return answer;
}