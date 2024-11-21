def solution(clothes):
    clothes_dict = {}
    ans = 1
    for i in clothes:
        if(i[1] in clothes_dict):
            clothes_dict[i[1]] += 1
        else: 
            clothes_dict[i[1]] = 1
    answer = 1
    for _, value in clothes_dict.items():
        answer *= (value + 1)
        
    return answer -1