'''
1 ~ 100_000의 약수의 개수를 구해야 함
'''

def solution(number, limit, power):
    counts = [0]
    for num in range(1, number + 1):
        count = 0
        for deno in range(1, int(num ** (1 / 2)) + 1):
            if num % deno == 0:
                count += 2
                if num == deno ** 2:
                    count -= 1
        counts.append(count)

    answer = 0
    for count in counts:
        if count > limit:
            answer += power
        else:
            answer += count

    return answer