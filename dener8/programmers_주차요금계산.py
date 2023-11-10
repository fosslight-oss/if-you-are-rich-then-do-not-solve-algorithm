'''
차량별로 주차 요금 계산하기

입차된 후 출차 내역이 없다면 23:59에 출차된 것으로 간주
홀수 개라면, 출차시간 미리 넣어도 괜찮을 듯??

차량 번호가 작은 자동차부터 return

1 ≤ records의 길이 ≤ 1,000

defaultdict을 직접 수정하되, IN이면 val * -1 값을 더하고, OUT이면 val값을 더해서 맞춰주기
'''
from collections import defaultdict


def solution(fees, records):
    answer = []
    car_dd = defaultdict(int)
    for record in records:
        car = record.split()[1]
        car_dd[car] += 1  # 홀수인 것 따로 거를 예정
    car_set = set()  # 뒤에서 사용 예정
    for car in car_dd:
        if car_dd[car] % 2 == 1:  # 홀수이면
            records.append("23:59 " + car + " OUT")
        car_set.add(car)

    # 23:59 padding 완료하고, 이제 새로 세면 됨
    time_dd = defaultdict(int)
    for record in records:
        time, car, inout = record.split()
        hour, minute = time.split(":")
        hour, minute = int(hour), int(minute)
        time = hour * 60 + minute

        if inout == 'IN':
            time_dd[car] -= time
        elif inout == 'OUT':
            time_dd[car] += time

    car_set = sorted(car_set)
    for car in car_set:
        time = time_dd[car]
        if time <= fees[0]:
            answer.append(fees[1])
            continue
        remain = time - fees[0]  # 나머지 시간
        answer.append(((remain - 1) // fees[2] + 1) * fees[3] + fees[1])

    return answer