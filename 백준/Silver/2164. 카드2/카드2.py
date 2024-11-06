import sys;

num = int(sys.stdin.readline())

temp = 2
while True:
    if (num == 1 or num == 2):
        print(num)
        break
    temp *= 2
    if (temp >= num):
        print((num - (temp // 2)) * 2)
        break