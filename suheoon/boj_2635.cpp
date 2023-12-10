#include <bits/stdc++.h>
using namespace std;

int n, mx;
vector<int> nums;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for(int i = 1; i <= n; i++){
        int s = i;
        int next = n - s;
        int l = 3;
        vector<int> v = {n, s, next};

        while(1){
            int tmp = next;
            next = s - next;
            if(next < 0) break;
            s = tmp; 
            l++;
            v.push_back(next);
        }

        if(mx < l) nums = v, mx = l;
    }

    cout << mx << '\n';
    for(auto e : nums) cout << e << ' ';

    return 0;
}