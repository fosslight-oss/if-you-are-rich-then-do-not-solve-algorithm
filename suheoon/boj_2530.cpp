#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    #include <iostream>

    int h, m, s, d;
    cin>>h>>m>>s>>d;
    cout<<(h+(m+(s+d)/60)/60)%24<<" "<<(m+(s+d)/60)%60<<" "<<(s+d)%60;
    return 0;
    
}