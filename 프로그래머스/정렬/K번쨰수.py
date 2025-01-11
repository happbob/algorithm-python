import heapq as hq

# def solution(array, commands):
#     return list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))

def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        buff = array[commands[i][0]-1 : commands[i][1]]
        hq.heapify(buff)
        print(buff)
        if(commands[i][2] == 1):
            answer.append(hq.heappop(buff))
        else:
            for j in range(commands[i][2]):
                if(j == commands[i][2]-1):
                    answer.append(hq.heappop(buff))
                    break
                hq.heappop(buff)
            
    return answer

array = [1, 5, 2, 6, 3, 7, 4]
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]

print(solution(array,commands))