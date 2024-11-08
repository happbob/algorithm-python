import sys
n, k = sys.stdin.readline().split()
n, k = int(n), int(k)
arr = []

coin_num=0

for i in range(n):
    coin = int(sys.stdin.readline())
    arr.append(coin)


for i in range(n):
    if((k % arr[-1]) == 0):
        coin_num = coin_num + (k // arr[-1])
        print(coin_num)
        break
    else:
        coin_num = coin_num + (k // arr[-1])
        k = k % arr[-1]
        arr=arr[:-1]