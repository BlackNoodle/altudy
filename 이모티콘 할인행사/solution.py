from itertools import product

discount_rate = [10, 20, 30, 40]


def decide(user, emoticons, discount):
    money = 0
    for i in range(len(discount)):
        if discount[i] >= user[0]:
            money += emoticons[i] * (100 - discount[i]) / 100

    return money >= user[1], money


def solution(users, emoticons):
    answer = [0, 0]
    for discount in product(discount_rate, repeat=len(emoticons)):
        ga = 0
        mon = 0
        for user in users:
            a, b = decide(user, emoticons, discount)
            if a:
                ga += 1
            else:
                mon += b

        if ga > answer[0]:
            answer = [ga, mon]
        elif ga == answer[0]:
            if mon > answer[1]:
                answer[1] = mon

    return answer
