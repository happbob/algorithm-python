import sys
from collections import OrderedDict

num = int(sys.stdin.readline())

arr={}
for i in range(num):
    book = sys.stdin.readline()[0:-1]
    if(book in arr):
        arr[book] = arr[book] + 1
    else:
        arr[book] = 1

tmp = [k for k,v in arr.items() if max(arr.values()) == v]
tmp.sort()

print(tmp[0])