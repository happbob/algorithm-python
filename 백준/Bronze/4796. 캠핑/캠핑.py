import sys
tc = 1
while True:
    l, p, v = map(int,sys.stdin.readline().split())
    answer = 0
    if(l == 0):
        break
    print("Case %d: %d" %(tc, (v//p*l) + min(l, v % p)))
    tc+=1