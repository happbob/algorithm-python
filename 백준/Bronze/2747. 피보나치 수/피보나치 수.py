import sys

input = sys.stdin.readline

n = int(input())

array = []

zero = 0
one = 1

array.append(0)
array.append(1)
for i in range(n):
    array.append(array[-1] + array[-2])

print(array[n])