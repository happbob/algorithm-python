def solution(answers):
    answer = [0,0,0]
    player_1 = [1,2,3,4,5]
    player_2 = [2,1,2,3,2,4,2,5]
    player_3 = [3,3,1,1,2,2,4,4,5,5]
    
    for i in range(len(answers)):
        if(answers[i] == player_1[(i % len(player_1)) ]): 
            answer[0] += 1
        if(answers[i] == player_2[(i % len(player_2))]):
            answer[1] += 1
        if(answers[i] == player_3[(i % len(player_3))]):
            answer[2] += 1
    max = answer[0]
    sol = [1]
    for i in range(1, len(answer)):
        if(max == answer[i]):
            sol.append(i+1)
            max = answer[i]
        elif(max < answer[i]):
            sol.clear()
            sol.append(i+1)
            max = answer[i]

    return sol

answers = [1, 3, 2, 4, 2]	
print(solution(answers))