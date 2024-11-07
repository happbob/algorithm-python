import sys
from itertools import combinations
import heapq as hq

arr_heap = []

for i in range(9):
    command = int(sys.stdin.readline())
    arr_heap.append(command)

arr_heap.sort()

for i in combinations(arr_heap,7):
    if(sum(i) == 100):
        for u in list(i):
            print(u)
        break   