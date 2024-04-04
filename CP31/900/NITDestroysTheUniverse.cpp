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

	int i = 0;
	int j = n - 1;
	while (i < j) {
		if (arr[i] == 0) {
			i++;
		}
		if (arr[j] == 0) {
			j--;
		}
		if (arr[i] != 0 && arr[j] != 0) {
			break;
		}	
	}

	if (j == j && arr[i] == 0) {
		cout << 0 << endl;
	} else if (i == j && arr[i] != 0) {
		cout << 1 << endl;
	} else {
		while (i <= j) {
			if (arr[i++] == 0 || arr[j--] == 0) {
				cout << 2 << endl;
				return;
			}
		}
		cout << 1 << endl;
	}
}