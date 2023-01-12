from collections import deque


def solution(storey):
    answer = 1e9

    q = deque()
    q.append((storey, 0))  # storey, cost

    while q:
        storey, cost = q.popleft()

        up_storey, up_cost = up(storey)
        down_storey, down_cost = down(storey)

        if up_storey == 1:
            answer = min(answer, cost + up_cost + up_storey)
        else:
            q.append((up_storey, cost + up_cost))

        if down_storey == 0:
            answer = min(answer, cost + down_cost + down_storey)
        else:
            q.append((down_storey, cost + down_cost))

    return answer


def up(storey):
    return (storey // 10) + 1, 10 - (storey % 10)


def down(storey):
    return storey // 10, storey % 10


assert solution(16) == 6
assert solution(2554) == 16
