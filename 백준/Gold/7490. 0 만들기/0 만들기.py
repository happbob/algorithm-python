T = int(input())

def go(idx, sum, num , op, statement):
    global n
    if(idx == n):
        sum += (num * op)
        if(sum == 0):
            print(statement)
        return
    go(idx+1, sum, (idx+1)+(10*num), op, statement + ' ' + str(idx+1))
    go(idx+1, sum + (op * num), idx+1, 1, statement + '+' + str(idx+1))
    go(idx+1, sum + (op * num), idx+1, -1, statement + '-' + str(idx+1))
    
array_num = []
for i in range(T):
    array_num.append(int(input()))

for i in array_num:
    n = i
    go(1, 0, 1, 1, '1')
    print()
