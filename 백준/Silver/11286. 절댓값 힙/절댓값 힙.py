import sys
import heapq as hq
n = int(sys.stdin.readline())
arr_heap = []


for i in range(n):
    command = int(sys.stdin.readline())
    if command != 0:
        hq.heappush(arr_heap, (abs(command),command))
    if command == 0:
        try:
            print(hq.heappop(arr_heap)[1])
        except IndexError:
            print(0)