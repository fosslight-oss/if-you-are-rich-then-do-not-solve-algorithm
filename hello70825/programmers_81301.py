def solution(s):
    dd = {'zero':'0', 'one':'1', 'two':'2',
          'three':'3', 'four': '4', 'five': '5',
         'six':'6', 'seven':'7', 'eight':'8', 'nine':'9'}
    answer = ''
    
    word = ''
    for i in range(len(s)):
        if '0' <= s[i] <= '9':
            if word != '':
                answer += dd[word]
                word = ''
            answer += s[i]
        else:
            if word in dd:
                answer += dd[word]
                word = ''
            word += s[i]
    else:
        if word in dd: answer += dd[word]
    return int(answer)
