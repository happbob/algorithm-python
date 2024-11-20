import sys

arr = [[0]*10 for _ in range(10)]
for i in range(10):
    arr[i] = list(map(int, sys.stdin.readline().split()))
ans = 25
paper = [0]*6

def is_possible(y,x,sz):
    if(paper[sz]==5):
        return False
    if(y+sz>10 or x+sz>10):
        return False

    for i in range(sz):
        for j in range(sz):
            if arr[y+i][x+j] == 0:
                return False
    return True

def mark(y,x,sz,v):
    for i in range(sz):
        for j in range(sz):
            arr[y+i][j+x] = v
    
    if v:
        paper[sz] -= 1
    else:
        paper[sz] += 1

def backtrack(y,x):
    global ans
    if y == 10:
        ans = min(ans, sum(paper))
        return
    if x == 10:
        backtrack(y+1, 0)
        return

    if arr[y][x] == 0:
        backtrack(y,x+1)
        return
    
    for sz in range(1,6):
        if is_possible(y,x,sz):
            mark(y,x,sz,0)
            backtrack(y, x+1)
            mark(y,x,sz,1)
    

    
backtrack(0,0)
print(-1 if ans == 25 else ans)