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
	int n;
	cin >> n;
	int arr[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	int max_diff = INT_MIN;

	// case 1
	max_diff = max(max_diff, arr[n - 1] - arr[0]);

	// case 2
	for (int i = 0; i < n - 1; i++) {
		max_diff = max(max_diff, arr[n - 1] - arr[i]);
	}

	// case 3
	for (int i = 1; i < n; i++) {
		max_diff = max(max_diff, arr[i] - arr[0]);
	}

	// case 4
	for (int i = 0; i < n; i++) {
		max_diff = max(max_diff, arr[(i - 1 + n) % n] - arr[i]);
	}

	cout << max_diff << endl;
}

/*

So there are only four options here.

1. the max_diff could be already there.
2. the max_diff is in the selected array on the right
3. the max_diff is in the selected array on the left
4. the max_diff is cyclic max

*/