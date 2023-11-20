'''
cache = deque()
'''

from collections import deque

def solution(cacheSize, cities):
    if cacheSize == 0:
        return len(cities) * 5

    # toLowerCase
    for i in range(len(cities)):
        word = cities[i]
        temp = ""
        for j in range(len(word)):
            if ord('A') <= ord(word[j]) <= ord('Z'):
                temp += chr(ord(word[j]) + 32)
            else:
                temp += word[j]
        cities[i] = temp

    answer = 0
    cache = deque()

    for i in range(len(cities)):
        if len(cache) < cacheSize:
            if cities[i] in cache:
                answer += 1
                cache.remove(cities[i])
                cache.append(cities[i])
            else:
                answer += 5
                cache.append(cities[i])
        else:
            if cities[i] in cache:
                answer += 1
                cache.remove(cities[i])
                cache.append(cities[i])
            else:
                answer += 5
                cache.popleft()
                cache.append(cities[i])

    return answer