import heapq as hq
def solution(scoville, K):
    hq.heapify(scoville)
    print(scoville)
    answer = 0
    while (scoville[0] < K):
        if(len(scoville) <2):
            return -1
        first = hq.heappop(scoville)
        second = hq.heappop(scoville)
        k = first + (second * 2)
        hq.heappush(scoville, k)
        print(scoville)
        answer+=1
    
    return answer

scoville = [12, 2, 3, 9, 10, 1]
K = 30

print(solution(scoville, K))
