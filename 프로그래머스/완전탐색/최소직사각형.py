# return max(max(x) for x in sizes) * max(min(x) for x in sizes)

def solution(sizes):
    answer = 0
    max_num = max(sizes[0])
    min_num = min(sizes[0])
    for i in range(1,len(sizes)):
        if max_num < max(sizes[i]):
            max_num = max(sizes[i])
        if min_num < min(sizes[i]):
            min_num = min(sizes[i])
    answer = max_num * min_num
    return answer



sizes = [[60, 50], [30, 70], [60, 30], [80, 40]]

print(solution(sizes))