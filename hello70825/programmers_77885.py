from itertools import combinations
def converter(number_bin, index):
    target = number_bin[index]
    if(target == '0'):
        number_bin[index] = '1'
    else:
        number_bin[index] = '0'
    return number_bin

def solution(numbers):
    answer = []
    for number in numbers: # 100,000
        number_bin = bin(number)
        number_bin = number_bin[2:]
        while len(number_bin) <= 52: # 52
            number_bin = '0' + number_bin
        
        number_bin = list(number_bin)
        candidate = []
        # index 하나 변경  # 53C1 
        # int로 변경
        # number와 비교후 크다면 넣기
        index_list = [i for i in range(53)]
        for index in index_list:
            new_bin = converter(number_bin[:], index)
            new = int("".join(new_bin), 2)
            if(new > number):
                candidate.append(new)
        
        # index 두개 변경 53C2
        index_list = list(combinations(range(53), 2))
        #print('!', len(index_list), numbers)
        print(id(number_bin))
        print(id(number_bin[:]))
        for index1, index2 in index_list:
            #print(index1, index2)
            new_bin = converter(number_bin[:], index1)
            new_bin = converter(new_bin, index2)
            new = int("".join(new_bin), 2)
            if(new > number):
                candidate.append(new)
        
        candidate.sort()
        answer.append(candidate[0])
    return answer
