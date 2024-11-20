import sys

buff = sys.stdin.readline()

ans = {}

for i in buff:
    if i in ans:
        ans[i] += 1
    else:
        ans[i] = 1

del ans['\n']

if(sum(i%2 for i in ans.values())>1):
    print("I'm Sorry Hansoo")
else:
    half = ''
    for i,v in sorted(ans.items()):
        half += (i * (v // 2))
    result = half
    for i, v in ans.items():
        if(v%2==1):
            result += i

    result += half[::-1]
    print(result)