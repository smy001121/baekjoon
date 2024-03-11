#include <iostream>
#include <queue>
#include <deque>
#include <string.h>
#include <math.h>
#include <cmath>
#include <stack>
#include <algorithm>

using namespace std;

vector<int> graph[100001];
int visited[100001];
int result[100001];
int cnt = 0;

void dfs(int node) {
    if (visited[node] == 1) return; // 이미 방문 한 곳이면 종료

    visited[node] = 1; // 방문 안 한 곳이면 방문 했다고 표시
    cnt++;
    result[node] = cnt; // 정점 node의 방문 순서

    for (int i = 0; i < graph[node].size(); i++) {
        dfs(graph[node][i]); // 그 다음 정점으로
    }
}


int main()
{
    int n, m, r;
    scanf("%d %d %d", &n, &m, &r);
    for (int i = 1; i <= m; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    for (int i = 1; i <= n; i++) {
        sort(graph[i].begin(), graph[i].end());
    }
    dfs(r);
    for (int i = 1; i <= n; i++) {
        printf("%d\n", result[i]);
    }
}