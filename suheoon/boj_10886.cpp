#include <bits/stdc++.h>
using namespace std;

int arr[2];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    while(n--) {
        int vote;
        cin >> vote;
        arr[vote]++;
    }
    
    if (arr[0] > arr[1]) {
        cout << "Junhee is not cute!";
    } else {
        cout << "Junhee is cute!";
    }

    return 0;
}