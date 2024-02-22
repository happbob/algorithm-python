T = int(input())
book_page_array = [[] for _ in range(T)]
for i in range(T):
    K = int(input())
    book_page_array[i] = list(map(int, input().split())) 

for book_pages in book_page_array:
    db = [[] * len(book_pages)]