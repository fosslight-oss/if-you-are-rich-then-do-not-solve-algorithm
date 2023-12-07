#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string a, b;
	char op;

	cin >> a >> op >> b;

	int sizeA = a.size();
	int sizeB = b.size();
	int totSize = 0;

	if (op == '*') {
		totSize = sizeA + sizeB - 2;
		cout << '1';
		for (int i = 0; i < totSize; i++) {
			cout << "0";
		}
	}
	
	else {
		if (sizeA != sizeB) {
			int big = max(sizeA, sizeB);
			int small = min(sizeA, sizeB);
			for (int i = big; i > 0; i--) {
				if (i == big || i == small) cout << "1";
				else cout << "0";
			}
		}
		else {
			for (int i = sizeA; i > 0; i--) {
				if (i == sizeA) cout << "2";
				else cout << "0";
			}
		}
	}

}
