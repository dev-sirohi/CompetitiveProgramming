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
	cin >> T;

	while (T--) {
		solve();
	}

	return 0;
}

void solve() {
	ll n;
	cin >> n;

	if (n & 1) {
		cout << 1 << endl;
		return;
	}

	for (ll i = 1; i <= n; i++) {
		if (n % i != 0) {
			cout << i - 1 << endl;
			return;
		}
	}

	cout << 2 << endl;
}

/*

first, odd
you cannot get odd numbers by multiplying any numbers except odd * 1 or odd with odd
and there can never be 2 odds together
so the ans has to be 1

for even,

24
1 2 3 4 6 8 12

[1, 2, 3, 4]

1 <= x <= (4 - 1 + 1)

40

[4,5]

1 <= x <= (2 - 1 + 1)
1 2

24

*/