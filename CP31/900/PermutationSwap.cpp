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
inline int hcf(int *arr, int n);
inline int find_hcf(int a, int b);

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
	int n;
	cin >> n;
	int arr[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	int hcf_arr[n];
	for (int i = 0; i < n; i++) {
		hcf_arr[i] = abs(arr[i] - (i + 1));
	}
	
	cout << hcf(hcf_arr, n) << endl;
}

inline int hcf(int *arr, int n) {
	int hcf = arr[0];
	for (int i = 1; i < n; i++) {
		hcf = find_hcf(hcf, arr[i]);
	}

	return hcf;
}

inline int find_hcf(int a, int b) {
	while (b != 0) {
		int temp = b;
		b = a % b;
		a = temp;
	}

	return a;
}