from itertools import combinations, permutations


n, m = map(int, input().split())
array = [[] for _ in range(n)]
for i in range(m):
    buff1, buff2 = map(int, input().split())
    array[min(buff1, buff2)].append(max(buff1, buff2))

nums = [i for i in range(1, n+1)]
combi = list(combinations(nums, 3))
ans = len(combi)
for i in range(1, n):
    if ( len(array[i-1]) > 0):
        ans -= (n-2-i+1) * len(array[i-1])

print(ans)