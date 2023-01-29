def solution(numbers):
    answer = []
    for number in numbers:
        str_num = bin(number)[2:]

        zero_idx = str_num.rfind("0")

        if zero_idx == -1:
            answer.append(int("0b10" + str_num[1:], 2))
        else:
            one_idx = str_num[zero_idx:].find("1")
            str_num = list(str_num)
            if one_idx != -1:
                str_num[zero_idx + one_idx] = "0"

            str_num[zero_idx] = "1"
            answer.append(int("0b" + "".join(str_num), 2))

    return answer


assert solution([2, 7]) == [3, 11]
