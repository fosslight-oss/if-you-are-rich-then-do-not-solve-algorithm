'''
s가 표현하는 튜플을 구하시오
'''

def solution(s):
    arr = []
    
    s = s[1:len(s)-1:]
    start_flag = False
    num = ''
    val = []
    for i in range(len(s)):
        if s[i] == '{': start_flag = True
        elif s[i] == '}':
            start_flag = False
            val.append(int(num))
            arr.append(val)
            num = ''
            val = []
        elif s[i] == ',':
            if start_flag: 
                val.append(int(num))
                num = ''
        else: num += s[i]
    arr = sorted(arr, key=lambda x: len(x))
    
    answer = []
    for nums in arr:
        for num in nums:
            if num not in answer:
                answer.append(num)
                break
    
    return answer
