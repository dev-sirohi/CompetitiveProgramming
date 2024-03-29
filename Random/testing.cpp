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
#define vvi vector < vi >
#define pii pair<int,int>
#define pll pair<long long, long long>
#define mod 1000000007
#define inf 1000000000000000001;
#define all(c) c.begin(),c.end()
#define mp(x,y) make_pair(x,y)
#define mem(a,val) memset(a,val,sizeof(a))
#define eb emplace_back
#define f first
#define s second
#define pb push_back

using namespace std;

const int N = 2e5 + 20;
int n;
string s;
vector<int> dv[N];

inline int diff(string a, string b) {
	int count = 0;
	for (int i = 0; i < a.size(); i++) {
		if (a[i] != b[i]) count++;
	}

	return count;
}

int main()
{
	std::ios::sync_with_stdio(false);

	for (int i = 1; i < N; i++) {
		for (int j = i; j < N; j += i) {
			dv[j].pb(i);
		}
	}

	int T;
	cin >> T;

	while(T--)
	{
		cin >> n;
		cin >> s;

		for (int x : dv[n]) {
			string p = s.substr(0, x), t = "";
			for (int i = 0; i < n / x; i++) {
				t += p;
			}

			if (diff(t, s) <= 1) {
				cout << x << "\n";
				break;
			}

			p = s.substr(x, x), t = "";
			for (int i = 0; i < n / x; i++) {
				t += p;
			}

			if (diff(t, s) <= 1) {
				cout << x << "\n";
				break;
			}
		}
	}
	return 0;
}
