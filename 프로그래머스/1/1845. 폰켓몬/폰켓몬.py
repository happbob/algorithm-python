from collections import deque
def solution(nums):
    answer = 0
    arr = deque()
    for i in nums:
        if(i not in arr):    
            arr.appendleft(i)
            answer += 1
        if(answer == len(nums)//2):
            break
    return answer