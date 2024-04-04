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
void swap(int arr[], int i, int j);

// constants
const int N = 2e5 + 20;

// dp vectors (if any)


int main() {
	std::ios::sync_with_stdio(false);
	cout << "itr<1>::build_complete" << endl;
	
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

	int sum = arr[0];
	int swapper = 0;

	for (int i = 1; i < n; i++) {
		if (sum == arr[i]) {
			// swap it with the beginning and move pointer up one
			while (swapper < n && arr[swapper] == arr[i]) {
				if (swapper == n - 1) {
					cout << "NO" << endl;
					return;
				}
				swapper++;
			}

			swap(arr, i, swapper);

			if (swapper > i) {
				sum += arr[i];
			} else {
				sum += arr[swapper];
			}

			swapper = 0;
		} else {
			sum += arr[i];
		}
	}

	cout << "YES" << endl;

	for (int i = 0; i < n; i++) {
		cout << arr[i] << " ";
	}

	cout << endl;
}

void swap(int arr[], int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}