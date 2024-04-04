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
bool check_parity(vi &v, int i, int j);

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
	int n;
	cin >> n;
	vi v;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		v.pb(num);
	}

	cout << endl;

	int count = 0;
	int i = 0;
	while (i < v.size()) {
		if (i != 0 && check_parity(v, i, i - 1)) {
			v[i - 1] *= v[i];
			v.erase(v.begin() + i);
			i--;
			count++;
		}

		i++;
	}

	cout << count << endl;
}

bool check_parity(vi &v, int i, int j) {
	if ((v[i] % 2 == 0 && v[j] % 2 == 0) || (v[i] % 2 != 0 && v[j] % 2 != 0)) {
		return true;
	}

	return false;
}