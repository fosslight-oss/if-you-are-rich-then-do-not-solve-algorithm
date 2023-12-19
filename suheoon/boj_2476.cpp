#include <bits/stdc++.h>
using namespace std;

vector<int> s;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int p;
    cin >> p;

    for (int i = 0; i < p; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		if (a == b && b == c) {
			s.push_back(10000 + (a * 1000));
		}
		else if (a == b) {
			s.push_back(1000 + (a * 100));
		}
		else if (a == c) {
			s.push_back(1000 + (a * 100));
		}
		else if (b == c) {
			s.push_back(1000 + (b * 100));
		}
		else {
			int arr[3];
			arr[0] = a;
			arr[1] = b;
			arr[2] = c;
			int max = arr[0];
			for (int i : arr) {
				if (i > max) {
					max = i;
				}
			}
			s.push_back(max * 100);
		}
	}
	sort(s.begin(), s.end());
	cout << s[s.size() - 1] << "\n";

	return 0;
}