import sys
from bisect import bisect_right, bisect_left
n = int(input())
n_arr = list(map(int, input().split()))
m = int(input())
m_arr = list(map(int, input().split()))

n_arr.sort()


for i in range(len(m_arr)):
    if(bisect_left(n_arr,m_arr[i]) != bisect_right(n_arr,m_arr[i])):

        print(1)
    else:
        print(0)