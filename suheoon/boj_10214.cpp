#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		int a, b;
		int sum1 = 0;
		int sum2 = 0;
		for (int k = 0; k < 9; k++) {
			cin >> a >> b;
			sum1 += a;
            sum2 += b;
		}
		if (sum1 > sum2) {
			cout << "Yonsei" << '\n';
		}
		else if (sum1 < sum2) {
			cout << "Korea" << '\n';
		}
		else {
			cout << "Draw" << '\n';
		}
	}

	return 0;
}