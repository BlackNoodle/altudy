from collections import Counter


def solution(k, tangerine):
    answer = 0
    total = 0

    values = sorted(Counter(tangerine).values(), reverse=True)

    for v in values:
        total += v
        answer += 1
        if total >= k:
            break

    return answer


assert solution(6, [1, 3, 2, 5, 4, 5, 2, 3]) == 3
assert solution(4, [1, 3, 2, 5, 4, 5, 2, 3]) == 2
assert solution(2, [1, 1, 1, 1, 2, 2, 2, 3]) == 1
