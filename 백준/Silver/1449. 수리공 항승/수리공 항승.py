import sys

[n, l] = sys.stdin.readline().split()
n, l = int(n), int(l)
tape = 0
x = list(map(int, input().split()))

pointer=1

arr = [False] * 1001
for i in x:
    arr[i] = True

while pointer < 1001:
    if(arr[pointer]):
        tape += 1
        pointer += l
    else:
        pointer += 1

print(tape)


