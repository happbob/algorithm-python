from itertools import combinations, permutations


n, m = map(int, input().split())
ans = 0
blocked_map = [[False]*n for _ in range(n)]
for i in range(m):
    buff1, buff2 = map(int, input().split())
    blocked_map[buff1-1][buff2-1] = True
    blocked_map[buff2-1][buff1-1] = True


for x in range(n-2):
    for y in range(x+1,n-1):
        if(blocked_map[x][y]):
            continue
        for z in range(y+1,n):
            if((not blocked_map[x][z]) and (not blocked_map[y][z])):
                ans += 1

print(ans)