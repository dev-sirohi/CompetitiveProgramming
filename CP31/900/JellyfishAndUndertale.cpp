#include <bits/stdc++.h>
#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstring>
#include <chrono>
#include <complex>
#define endl "\n"
#define ll long long int
#define vi vector<int>
#define vll vector<ll>
#define pii pair<int,int>
#define pll pair<long long, long long>
#define mod 1000000007
#define inf 1000000000000000001;
#define all(c) c.begin(),c.end()
#define mp(x,y) make_pair(x,y)
#define mem(a,val) memset(a,val,sizeof(a))
#define eb emplace_back
#define pb push_back
#define f first
#define s second

using namespace std;

// function declarations
void solve();

// constants
const int N = 2e5 + 20;

// dp vectors (if any)


int main() {
	std::ios::sync_with_stdio(false);
	// cout << "itr<1>::build_complete" << endl;
	
	// dp stuff (if any)

	int T;
	cin>>T;

	while(T--) {
		solve();
	}

	return 0;
}

inline void solve() {
	ll a, b, n;
	cin >> a >> b >> n;
	vll v;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.pb(num);
	}

	ll ans = 0;

	for (ll i = 0; i < n; i++) {
		if (v[i] < a) {
			ans += v[i];
		} else {
			ans += a - 1;
		}
	}

	ans += b;

	cout << ans << endl;
}