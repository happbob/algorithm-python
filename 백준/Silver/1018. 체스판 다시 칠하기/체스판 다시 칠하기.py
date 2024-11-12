import sys

[n, m] = list(map(int, sys.stdin.readline().split()))
board = [[0]*m for i in range(n)]

for i in range(n):
    buff = sys.stdin.readline()
    for u in range(m):
        board[i][u] = buff[u]

cache_1 = [[0]*8 for i in range(8)]

for i in range(8):
    for u in range(8):
        if(i % 2 == 0):
            if(u%2==0):
                cache_1[i][u] = 'B'
            else:
                 cache_1[i][u] = 'W'
        else:
            if(u%2==1):
                cache_1[i][u] = 'B'
            else:
                 cache_1[i][u] = 'W'

ans = 32

for i in range(n-7):
    for u in range(m-7):
        buff=0
        for x in range(8):
            for y in range(8):
                if (board[i+x][u+y] != cache_1[x][y]):
                    buff += 1
        
        cal_min = min(buff, 64-buff)
        ans = min(ans, cal_min)

print(ans)