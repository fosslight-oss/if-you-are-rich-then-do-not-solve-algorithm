#include <bits/stdc++.h>
using namespace std;


int solution(int storey) {
    int answer = 0;
    
    while (storey) {
        int digit = storey % 10;
        
        if (digit > 5) {
            answer += (10 - digit);
            storey += 10;
        }
        else if (digit < 5) {
            answer += digit;
        }
        else {
            if ((storey / 10) % 10 > 4) {
                storey += 10;
            }
            answer += digit;
        }
        storey /= 10;
    }
    
    return answer;
}