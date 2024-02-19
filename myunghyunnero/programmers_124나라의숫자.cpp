#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    int remain;
    
    while (n!=0) {
        remain = n % 3;
        n /= 3;

        if (remain == 0) { //나누어 떨어질 경우 몫을 1빼준다.
            answer = "4" + answer;
            n--;
        }
        else if (remain == 1) {
            answer = "1" + answer;
        }
        else if (remain == 2) {
            answer = "2" + answer;
        }
    }
    return answer;
}