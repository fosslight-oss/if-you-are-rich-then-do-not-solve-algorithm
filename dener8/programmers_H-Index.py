def solution(citations):
    answer = 0
    n = len(citations)
    citations = [0] + sorted(citations, reverse=True)
    for i in range(1, n + 1):
        if i <= citations[i]:
            answer += 1
            continue
        break

    return answer