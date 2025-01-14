T = int(input())

def go(idx,n, sum, num , op, statement):
    if(idx == n):
        sum += (num * op)
        if(sum == 0):
            print(statement)
        return
    # print('index',index)
    # print('sum', sum)
    # print('num', num)
    # print('operation', operation)
    go(idx+1, n, sum, (idx+1)+(10*num), op, statement + ' ' + str(idx+1))
    go(idx+1, n, sum + (op * num), idx+1, 1, statement + '+' + str(idx+1))
    go(idx+1, n, sum + (op * num), idx+1, -1, statement + '-' + str(idx+1))
    

for i in range(T):
    n = int(input())
    go(1, n, 0, 1, 1, '1')


