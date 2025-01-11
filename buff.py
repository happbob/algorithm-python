n = int(input()) 

def dfs(idx, num, sum, op, express):
    global n
    if(idx == n):
        sum += num * op
        if (sum == 0):
            print(express)
    
    dfs(idx+1, num*10 + (idx + 1), sum, op, express + ' ' + (idx+1))
    dfs(idx+1, idx + 1, sum + (num*op), 1, express + '+' + (idx+1))
    dfs(idx+1, idx + 1, sum + (num*op), -1, express + '-' + (idx+1))

dfs(1,1,0,1,"1")
