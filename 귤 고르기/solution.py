from collections import Counter


def solution(k, tangerine):
    answer = 0
    total = 0

    # Counter를 이용해서 각 무게별로 몇 개의 귤이 있는지 카운트 합니다.
    # 카운트한 결과에서 갯수가 많은 순으로 sort한 값을 리스트를 만든다.
    values = sorted(Counter(tangerine).values(), reverse=True)

    # 갯수가 많은 종류별로 더해가면서 원하는 갯수 이상인지를 판별하면 이상이 되었을 때 반복문을 break한다.
    for v in values:
        total += v
        answer += 1
        if total >= k:
            break

    return answer


assert solution(6, [1, 3, 2, 5, 4, 5, 2, 3]) == 3
assert solution(4, [1, 3, 2, 5, 4, 5, 2, 3]) == 2
assert solution(2, [1, 1, 1, 1, 2, 2, 2, 3]) == 1
