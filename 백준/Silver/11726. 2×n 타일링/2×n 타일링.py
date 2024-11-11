import sys

input = sys.stdin.readline()

n = int(input)

a = [1,2,3]

if(n==1):
    print(1)

if(n==2):
    print(2)

if(n==3):
    print(3)

if( n > 3):
    for i in range(2,n-1):
        a.append((a[-1]+a[-2]))
    print(a[-1]%10007)



# 1 => 1 + 0

# 2 =>  1 + 1C0 = 2

# 3 => 1 + 2C1 = 3

# 4 => 1 + 3C1 + 1 = 5

# 5 => 1 + 4C1 + 3C1 = 8

# 6 => 1 + 5C1 + 6 + 1 = 13

# 000000
# 000000
