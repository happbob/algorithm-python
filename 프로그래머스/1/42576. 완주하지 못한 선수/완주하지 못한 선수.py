def solution(participant, completion):
    dictionary={}
    for i in participant:
        if(i in dictionary):
            dictionary[i] += 1
        else :
            dictionary[i] = 1

    for i in completion:
        if(i in dictionary):
            dictionary[i] -= 1

    keys = [k for k, v in dictionary.items() if v == 1]

    return keys[0]