from heapq import heappush, heappop

def solution(n, k, enemy):
    if k >= len(enemy): return len(enemy)
    
    answer = 0
    heap = []
    for idx, ene in enumerate(enemy):
        heappush(heap, -ene)
        
        while n < ene and k and heap:
            n -= heappop(heap)
            k -= 1
            
        if ene <= n:
            n -= ene
            answer = idx + 1
        else:
            break
    
    return answer

assert solution(7, 3, [4, 2, 4, 5, 3, 3, 1]) == 5
assert solution(2, 4, [3, 3, 3, 3]) == 4