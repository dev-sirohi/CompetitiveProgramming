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
	
	// dp stuff (if any)

	int T;
	cin>>T;

	while(T--) {
		solve();
	}

	return 0;
}

void solve() {
	int n, q;
	cin >> n >> q;
	int arr[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	int q_arr[q][3];
	for (int i = 0; i < q; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> q_arr[i][j];
		}
	}

	int prefix[n];
	prefix[0] = 0;
	for (int i = 1; i <= n; i++) {
		prefix[i] = arr[i - 1] + prefix[i - 1];
	}

	for (int i = 0; i < q; i++) {
		int l = q_arr[i][0];
		int r = q_arr[i][1];
		int k = q_arr[i][2];
		int k_sum = (r - l + 1) * k;
		int sidesubarr_sum = prefix[l - 1] + (prefix[n] - prefix[r]);

		// it doesn't matter whether the arr sum is even or odd, what matters ist the sidesubarr_sum

		if ((sidesubarr_sum + k_sum) & 1) {
			cout << "YES" << endl;
		} else {
			cout << "NO" << endl;
		}
	}
}