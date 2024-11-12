import sys
n,p = map(int,sys.stdin.readline().split())
finger_stack = [[] for i in range(7)]
finger_move = 0
for i in range(n):
    line, plat = map(int,sys.stdin.readline().split())
    while finger_stack[line] and finger_stack[line][-1] > plat:
        finger_stack[line].pop()
        finger_move += 1
    if finger_stack[line] and finger_stack[line][-1] == plat:
        continue
    finger_stack[line].append(plat)
    finger_move += 1
print(finger_move)