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
	int a, b, c;
	cin >> a >> b >> c;

	// now, what's happeniing is that everytime we add an a type node,
	// the number of branches increase by exactly 1.
	// and any number of b type nodes we have, it only increases the height, it increases 0 branches
	// and there have to be c type nodes at all the leaf positions
	// so, since b have no impact on anything other than height, and each a increases one branch, and c has no impace again,
	// it means that the count of c should be exactly a + 1
	// for ex: a = 2
	// the branches remaining would be 3 (since the second a will occupy one itself)
	// no matter how many b type nodes we have, we would require the same amount of c node, i.e. 3 => 2 + 1 (a + 1)

	if (c != a + 1) {
		cout << -1 << endl;
		return;
	}

	// initialize the height as 0
	int h = 0;

	// (1 << h) gives 2^h which is just the number of branches at height h
	// we're checking a >= 2^h because if it is greater, it will occupy the entire branch
	// and move onto the next one
	// so we keep doing this until we stop filling the branch
	while (a >= (1 << h)) {
		a -= (1 << h);
		h++;
	}

	// now if we have no more a's or b's then we can simply return the height because no matter how many c's we have left they don't matter
	if (!a && !b) {
		cout << h << endl;
		return;
	}

	// now if there are any a's left, they're less than the branches, but there's a chance combined with the b's they're greater than the branches.
	// well, since we are giving preference to the a's, we add them first, and whatever is left will be filled by b's
	// now if there aren't any extra b's, then we can just increase the height and return
	// otherwise we remove the number of branches minus a's from the b's
	// that will give us the extra b's
	if (a + b >= (1 << h)) {
		b -= (1 << h) - a;
		h++;
	} else {
		cout << h + 1 << endl;
		return;
	}

	// now the remaining spots will forever remain the same since the number of c's are a + 1
	// so no matter how many b's we have, we just need to see how many times over can they cover the entire branch
	// so that they increase the height
	// 6 + 6 - 1 / 6 => 1
	// 8 + 6 - 1 / 6 => 2
	// 15 + 6 - 1 / 6 => 3
	// basically, c is the number of remaining spots
	// and we wanna see how many times over can b override this.
	// because each time it does, it only increases the height.
	int k = (b + c - 1) / c;
	cout << h + k << endl;
}
