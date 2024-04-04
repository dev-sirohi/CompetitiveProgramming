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
	int n;
	cin >> n;
	int arr[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[n];
	}

	if (n & 1) {
		cout << 4 << endl;
		cout << 1 << " " << n - 1 << endl;
		cout << 1 << " " << n - 1 << endl;
		cout << n - 1 << " " << n << endl;
		cout << n - 1 << " " << n << endl;
	} else {
		cout << 2 << endl;
		cout << 1 << " " << n << endl;
		cout << 1 << " " << n << endl;
	}
}

/*

ok
understand this
a ^ a = 0
a ^ 0 = a
a ^ b = b ^ a
basically, same-same=>0 in xor

this is the key to this question
now, since same-same=>0
that means 2*(same-same)=>0

now, in this question we have to xor a part of the array and then replace all of it's indexes with that result
see how stupidly easy this is?
you xor longest even part of array and then replace all with same value
now do it again
what do you get?
0
now, if the array was even, you're done
if it was odd, only one element remains.
just do the operation again on it and the 0 behind it
it will become element(last)-element(last)=>0

and the entire array is 0

*/