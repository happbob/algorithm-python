n = int(input())

ans = 0
three_array = ['3','6','9']
for i in range(1,n+1):
    ans += str(i).count("3") + str(i).count("6") + str(i).count("9")

print(ans)