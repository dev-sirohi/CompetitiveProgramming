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

void solve() {
	// the knight doesn't have a starting position so he can start anywhere
	// now, he can obviously fork one, either the king or the queen,
	// we just have to check if he can fork the other one

	pii Nm;
	pii K;
	pii Q;
	cin >> Nm.f >> Nm.s >> K.f >> K.s >> Q.f >> Q.s;

	// pair<bool, bool> fork;
	// fork.f = false;
	// fork.s = false;

	int dx[4] = {1, -1, 1, -1};
	int dy[4] = {-1, -1, 1, 1};

	set<pii> st1, st2;

	for (int i = 0; i < 4; i++) {
		st1.insert({K.f + dx[i] * Nm.f, K.s + dy[i] * Nm.s});
		st2.insert({Q.f + dx[i] * Nm.f, Q.s + dy[i] * Nm.s});
		st1.insert({K.f + dx[i] * Nm.s, K.s + dy[i] * Nm.f});
		st2.insert({Q.f + dx[i] * Nm.s, Q.s + dy[i] * Nm.f});
	}

	int count = 0;
	for (auto it = st1.begin(); it != st1.end(); it++) {
		if (st2.find(*it) != st2.end()) {
			count++;
		}
	}

	cout << count << endl;
}