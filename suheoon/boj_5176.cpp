#include <bits/stdc++.h>
using namespace std;

int k;
int p,m;
bool arr[1000];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> k;
    while (k--) {
		cin >> p >> m;
 
        int cnt = 0;
		for (int i = 0; i < p; i++) {
			int now = 0;
			cin >> now;
			
			if (arr[now]) cnt++;
			else arr[now] = 1;
		}
 
		cout << cnt << '\n';
	}

    return 0;
}