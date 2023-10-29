#include <bits/stdc++.h>
using namespace std;

map<char, int> mp;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    
    int n = survey.size();
    
    for (int i = 0; i < n; i++) {
        char c1 = survey[i][0]; // 비동의
        char c2 = survey[i][1]; // 동의
        
        int select = choices[i];
        
        if (select == 4) continue;
        else if (1 <= select && select <= 3) {
            switch (select) {
                case 1:
                    mp[c1] += 3;
                    break;
                case 2:
                    mp[c1] += 2;
                    break;
                case 3:
                    mp[c1] += 1;
                    break;
            }
        } else {
            switch (select) {
                case 7:
                    mp[c2] += 3;
                    break;
                case 6:
                    mp[c2] += 2;
                    break;
                case 5:
                    mp[c2] += 1;
                    break;
            }
        }
    }
    
    if (mp['R'] >= mp['T']) answer += 'R';
    else answer += 'T';

    if (mp['C'] >= mp['F']) answer += 'C';
    else answer += 'F';

    if (mp['J'] >= mp['M']) answer += 'J';
    else answer += 'M';

    if (mp['A'] >= mp['N']) answer += 'A';
    else answer += 'N';
    
    return answer;
}