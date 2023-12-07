def solution(progresses, speeds):
    times = [0] * 100
    n = len(progresses)
    prev = -1
    
    for i in range(len(speeds)):
        last = 100 - progresses[i]
        work_time = last // speeds[i] + (1 if last % speeds[i] else 0)
        if prev > work_time: work_time = prev
        else: prev = work_time
        times[work_time] += 1
    
    answer = []
    for i in range(100):
        if times[i]:
            answer.append(times[i])
    
    return answer
