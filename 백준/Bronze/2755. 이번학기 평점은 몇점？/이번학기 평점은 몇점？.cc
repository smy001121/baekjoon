#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int n;
	cin >> n; // 과목 수

	float total = 0; // 총 평점
	int total_score = 0; // 총 학점
	float result; // 평균 평점

	for (int i = 0; i < n; i++) {
		string s; // 과목 이름
		int score; // 학점
		string score_alpha; // 성적
		cin >> s >> score >> score_alpha;

		total_score += score;
		
		if (score_alpha == "A+") {
			total += score * 4.3;
		} else if (score_alpha == "A0") {
			total += score * 4.0;
		} else if (score_alpha == "A-") {
			total += score * 3.7;
		} else if (score_alpha == "B+") {
			total += score * 3.3;
		} else if (score_alpha == "B0") {
			total += score * 3.0;
		} else if (score_alpha == "B-") {
			total += score * 2.7;
		} else if (score_alpha == "C+") {
			total += score * 2.3;
		} else if (score_alpha == "C0") {
			total += score * 2.0;
		} else if (score_alpha == "C-") {
			total += score * 1.7;
		} else if (score_alpha == "D+") {
			total += score * 1.3;
		} else if (score_alpha == "D0") {
			total += score * 1.0;
		} else if (score_alpha == "D-") {
			total += score * 0.7;
		} else total += score * 0.0;
	}
	//result = round((total / total_score) * 100) / 100;
	//cout << result << endl;
	printf("%.2f", total/total_score);
}
