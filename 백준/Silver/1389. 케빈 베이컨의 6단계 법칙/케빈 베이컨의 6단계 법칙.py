import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
adj = [[] for _ in range(n)]
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)


def bfs(start, goal):
    chk = [False] * n
    chk[start] = True
    dq = deque()
    dq.append((start,0))
    
    while dq:
        now, d = dq.popleft()
        if now == goal:
            return d
        
        nd = d + 1
        for nxt in adj[now]:
            if not chk[nxt]:
                chk[nxt] = True
                dq.append((nxt, nd))

def get_kevin(start):
    tot = 0
    for i in range(n):
        if i != start:
            tot += bfs(start, i)
    
    return tot


answer = []
ans = (-1, 10001)


for i in range(n):
    answer.append(get_kevin(i))

for i, v in enumerate(answer):
    if ans[1] > v:
        ans = (i, v)

print(ans[0]+1)