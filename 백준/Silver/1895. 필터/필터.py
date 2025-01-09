import heapq as hq
R, C = map(int, input().split())
array = [[0]*C for _ in range(R)]
for i in range(R):
    array[i] = list(map(int, input().split()))
T = int(input())
filtered_array = [[0]*(C-2) for _ in range(R-2)]


for i in range(R-2):
    for u in range(C-2):
        heap_array=[]
        for x in range(i,i+3):
            for y in range(u,u+3):
                hq.heappush(heap_array,array[x][y])
        for z in range(4):
                hq.heappop(heap_array)
        filtered_array[i][u] = hq.heappop(heap_array)
ans = 0
for i in range(R-2):
    for u in range(C-2):
        if(filtered_array[i][u]>=T):
            ans+=1

print(ans)