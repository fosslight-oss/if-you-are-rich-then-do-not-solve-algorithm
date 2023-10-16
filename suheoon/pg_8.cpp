#include <bits/stdc++.h>
using namespace std;

long long solution(int n, vector<int> times) {
    sort(times.begin(), times.end());
    
    long long lo = 1;
    long long hi = (long long)times[times.size() - 1] * n;
    
    while(lo + 1 < hi) {
        long long mid = (lo + hi) / 2;
        long long sum = 0;
        for (auto t : times) {
            sum += (mid / t);
        }
        if (sum >= n) {
            hi = mid;
        } else {
            lo = mid;
        }
    }
    
    return hi;
}