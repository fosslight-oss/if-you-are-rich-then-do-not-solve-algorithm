#include <string>
#include <vector>
#include <map>
using namespace std;
map<string,int> m;
int solution(vector<vector<string>> clothes) {
    int answer = 0;
    for(vector<string> cloth : clothes) {
        m[cloth[1]]++;
    }
    int sum =1;
    for(auto iter : m){
        sum*=(iter.second+1);
    }
    return sum-1;
}