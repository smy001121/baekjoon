#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <deque>
#include <string.h>
#include <math.h>
#include <cmath>
#include <stack>
#include <algorithm>

using namespace std;


vector<int> graph[1001]; // 그래프
int visited[1001]; // 방문 여부

void dfs(int node) {
    if (visited[node] == 1) return; // 이미 방문 한 곳이면 종료

    visited[node] = 1; // 방문 안 한 곳이면 방문 했다고 표시
    cout << node << " ";

    for (int i = 0; i < graph[node].size(); i++) {
        dfs(graph[node][i]); // 그 다음 정점으로
    }
}

void bfs(int node) {
    queue<int> q;
    q.push(node);
    visited[node] = 1;
    cout << node << " ";

    while (!q.empty()) {
        int inq = q.front();
        q.pop();

        for (int i = 0; i < graph[inq].size(); i++) {
            int temp = graph[inq][i];
            if (!visited[temp]) {
                cout << temp << " ";
                q.push(temp);
                visited[temp] = 1;
            }
        }
    }

}

int main()
{
    int n, m, v; // n: 정점 개수 m: 간선 개수, v: 시작할 정점 번호
    scanf("%d %d %d", &n, &m, &v);

    for (int i = 1; i <= m; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    for (int i = 1; i <= n; i++) {
        sort(graph[i].begin(), graph[i].end());
    }

    dfs(v);
    printf("\n");
    memset(visited, 0, sizeof(visited));
    bfs(v);
}
