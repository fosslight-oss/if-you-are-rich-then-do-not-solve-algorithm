#include <bits/stdc++.h>
using namespace std;

const int MX = 100001;
int arr[100];
pair<int,int> s[MX];

int main() {

    int T, N;
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> N;
		for (int j = 0; j < N; j++) {
			cin >> s[j].first >> s[j].second;
		}

		sort(s, s + N);

		int max_s = s[0].second;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (s[i].second <= max_s) {
				cnt++;
				max_s = s[i].second;
			}
		}

		arr[i] = cnt;
    }

	for (int i = 0; i < T; i++) {
		cout << arr[i] << '\n';
	}

	return 0;
} 