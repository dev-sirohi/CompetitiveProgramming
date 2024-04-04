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
	int n;
	cin >> n;
	int arr[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	if (n & 1) {
		int _xor = 0;
		for (auto i : arr) {
			_xor ^= i;
		}
		cout << _xor << endl;
	} else {
		int _xor = 0;
		for (auto i : arr) {
			_xor ^= i;
		}
		if (!_xor) {
			cout << 1 << endl;
		} else {
			cout << -1 << endl;
		}
	}
}

/*

understand this
(a ^ b) ^ c = (a ^ c) ^ b

basically, we can switch paranthesis in xor operations without changing the result

now, if i multiply each element x of an array with any number y and then multiply all resulting b's
then see what happens
(a ^ y) ^ (b ^ y) => (a ^ b) ^ (y ^ y) => (a ^ b) ^ 0 => a ^ b

so, now if we take any x in this question, if the array is of even length, then no matter what we take, the result is always going to be the xor of array
so, to get 0, we can't do anything if array length is even unless the xor of the array is 0
so if even, print random number if xor(array) = 0 else -1

now, for odd
(a ^ y) ^ (b ^ y) ^ (c ^ y) => (a ^ b ^ c) ^ y
and to make this zero, we can replace y with (a ^ b ^ c)
i.e. the xor(array)

*/