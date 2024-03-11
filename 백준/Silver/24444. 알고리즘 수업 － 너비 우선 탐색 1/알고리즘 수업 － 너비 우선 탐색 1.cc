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

void bfs(int node) {
    queue<int> q;
    q.push(node); // 큐에 노드를 집어넣음
    visited[node] = 1; // 처음 방문하면 방문 했다고 표시
    cnt++; // 방문 순서
    result[node] = cnt; // 처음으로 방문하면 cnt == 1
    while (!q.empty()) {
        int inq = q.front(); // 큐의 첫번째 원소

        q.pop();

        for (int i = 0; i < graph[inq].size(); i++) { // 노드와 인접한 노드의 개수만큼 반복
            int temp = graph[inq][i];
            if (!visited[temp]) { // 노드와 인접한 노드를 처음으로 방문하는 곳이면
                cnt++;
                result[temp] = cnt;
                q.push(temp); // 큐에 넣고
                visited[temp] = 1; // 방문 처리
            }
        }

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
    bfs(r);
    for (int i = 1; i <= n; i++) {
        printf("%d\n", result[i]);
    }
}