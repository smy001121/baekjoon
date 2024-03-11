#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		
		string s = to_string(num);
		reverse(s.begin(), s.end()); // 뒤집음
		int rev = stoi(s);

		int result = num + rev;
		string s2 = to_string(result);
		reverse(s2.begin(), s2.end());
		int revResult = stoi(s2);

		if (result == revResult) cout << "YES" << endl;
		else cout << "NO" << endl;

	}
}
