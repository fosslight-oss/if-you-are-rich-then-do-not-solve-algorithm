'''
today: 오늘 날짜 문자열
terms: 약관 유효기간 1차원 문자열 배열
privacies: 수집된 개인정보의 정보를 담은 1차원 문자열 배열

파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 하도록
'''

def solution(today, terms, privacies):
    answer = []

    year, month, day = today.split(".")
    year, month, day = int(year), int(month), int(day)

    # terms로 약관 dict 만들기
    d = dict()
    for i in range(len(terms)):
        x, y = terms[i].split(" ")
        d[x] = int(y)

    for i in range(len(privacies)):
        # split 두 번해서 나눈 후에 계산하여 answer에 결과 집어넣기
        period, rule = privacies[i].split(" ")
        _year, _month, _day = period.split(".")
        _year, _month, _day = int(_year), int(_month), int(_day)

        _month += d[rule]  # ex. d[A] = 3
        while _month > 12:
            _month -= 12
            _year += 1

        # today가 계산된 날짜보다 작으면 아직 기한이 남았다는 의미
        if not (year < _year or (year == _year and month < _month) or (
                year == _year and month == _month and day < _day)):
            answer.append(i + 1)

    return answer