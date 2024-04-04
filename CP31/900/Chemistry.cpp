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
	// we might need to use hashmap for this one
	// count occurence of each character
	// if k == sum of characters with odd count
	// check if the remaining characters with odd count are <= 1
	// then yes else no

	int n, k;
	string s;
	cin >> n >> k >> s;

	int chars[26] = {0};
	for (char c : s) {
		chars[c - 'a']++;
	}

	vi v;
	for (int i = 0; i < 26; i++) {
		if (chars[i] > 0) {
			v.pb(chars[i]);
		}
	}

	int oddCount = 0;
	for (int i = 0; i < v.size(); i++) {
		if (v[i] & 1) {
			oddCount++;
		}
	}

	if (oddCount > k + 1) cout << "NO" << endl;
	else cout << "YES" << endl;
}