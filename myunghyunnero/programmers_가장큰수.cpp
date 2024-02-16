#include <string>
#include <vector>
#include <algorithm>
using namespace std;
bool cmp(string a, string b){
    return a+b > b+a;
}
string solution(vector<int> numbers) {
    string answer = "";
    vector<string> strs;
    for(int number : numbers){
        strs.push_back(to_string(number));
    }
    sort(strs.begin(),strs.end(),cmp);
    for(string str : strs){
        answer+=str;
    }
    if(strs[0]=="0"){
        return "0";
    }
    return answer;
}