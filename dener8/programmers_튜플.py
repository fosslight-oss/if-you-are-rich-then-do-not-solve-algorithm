def solution(s):
    answer = []
    s = s[2:-2].split("},{")
    for i in range(len(s)):
        s[i] = list(map(int, s[i].split(",")))
    s = sorted(s, key=lambda x: len(x))

    for i in range(len(s)):
        for j in range(i + 1):
            if s[i][j] not in answer:
                answer.append(s[i][j])
                break

    return answer