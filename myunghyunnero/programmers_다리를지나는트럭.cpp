#include <string>
#include <vector>
#include <queue>
using namespace std;
queue<int> q;
int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int i=0;
    int time = 0;
    int weightSum = 0;
    while(true){
        int now_weight = truck_weights[i];
        if(i == truck_weights.size()){
            time += bridge_length;
            break;
        }
        
        if(q.size() == bridge_length){
            weightSum -= q.front();
            q.pop();
        }
        
        if(weightSum + now_weight <= weight){
            weightSum += now_weight;
            q.push(now_weight);
            i++;
        }
        else q.push(0);
        
        time++;
    }
    return time;
}