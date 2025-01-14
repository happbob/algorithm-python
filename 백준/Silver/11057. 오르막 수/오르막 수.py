def count_increasing_numbers(N):
    # dp 테이블 초기화
    dp = [[0] * 10 for _ in range(N + 1)]

    # 길이 1일 때 초기화
    for k in range(10):
        dp[1][k] = 1

    # dp 테이블 채우기
    for n in range(2, N + 1):
        for k in range(10):
            dp[n][k] = sum(dp[n - 1][j] for j in range(k + 1)) % 10007

    # 결과 계산
    result = sum(dp[N][k] for k in range(10)) % 10007
    return result

# 입력 받기
N = int(input())
print(count_increasing_numbers(N))