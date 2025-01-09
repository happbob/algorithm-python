n = int(input())

ans = 0
three_array = ['3','6','9']
for i in range(1,n+1):
    for u in range(len(str(i))):
        if(str(i)[u] in three_array):
            ans+=1

print(ans)