def solution(elements):
    answer = 0
    num_set = set()
    elements += elements
    for length in range(1, len(elements) // 2 + 1):
        for start in range(len(elements) // 2):
            num_set.add(sum(elements[start: start + length]))

    answer = len(num_set)
    return answer