'''
1, 4, 7 = 무조건 왼손
3, 6, 9 = 무조건 오른손
2, 5, 8, 0 = 가까운 손 (거리 같으면 오른손잡이면 오른손, 왼손잡이면 왼손)
'''

def solution(numbers, hand):
    keypad = {1: [0, 0], 2: [0, 1], 3: [0, 2],
              4: [1, 0], 5: [1, 1], 6: [1, 2],
              7: [2, 0], 8: [2, 1], 9: [2, 2],
              0: [3, 1]}
    left = [3, 0]
    right = [3, 2]
    
    answer = ''
    
    for num in numbers:
        if num in [1, 4, 7]:
            left = keypad[num]
            answer += 'L'
        elif num in [3, 6, 9]:
            right = keypad[num]
            answer += 'R'
        else:
            x, y = keypad[num]
            l = abs(x - left[0]) + abs(y - left[1])
            r = abs(x - right[0]) + abs(y - right[1])
            if l > r or (l == r and hand == 'right'):
                answer += 'R'
                right = keypad[num]
            else:
                answer += 'L'
                left = keypad[num]
            
    return answer
