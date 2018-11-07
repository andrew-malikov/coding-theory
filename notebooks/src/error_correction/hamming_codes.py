from math import log2, floor, ceil


def get_powers(number: int):
    powers = dict()

    while number != 0:
        power = floor(log2(number))

        count = 1
        if power in powers:
            count += powers[power]

        powers[power] = count

        number -= 2**power

    return powers


def insert_control_bits(bits: [int]) -> [int]:
    expanded_bits = bits.copy()

    count = ceil(log2(len(bits) + ceil(log2(len(bits) + 1)) + 1))

    for i in range(0, count):
        expanded_bits.insert((2**i) - 1, 0)

    return expanded_bits


def analyze_control_bits(bits: [int]):
    stats = dict()

    if len(bits) == 0:
        return stats

    for i in range(0, len(bits)):
        if is_control_bit(i + 1):
            continue

        powers = get_powers(i + 1)

        for key in powers:
            count = bits[i]

            if key in stats:
                count += stats[key]

            stats[key] = count

    return stats


def is_control_bit(number: int) -> bool:
    return log2(number).is_integer()


def encode(bits: [int]) -> [int]:
    code = insert_control_bits(bits)

    stats = analyze_control_bits(code)
    for key in stats:
        code[2**key - 1] = stats[key] % 2

    return code


def get_diff_control_bits(code: [int], stats) -> [int]:
    diff = []

    for key in stats:
        if code[2**key - 1] != stats[key] % 2:
            diff.append(2**key)

    return diff


def repair_bit(code: [int], number: int):
    code[number] = 1 - code[number]


def remove_control_bits(code: [int], stats) -> [int]:
    control_bits = list(map(lambda x: 2**x - 1, stats))

    info_bits = []

    for i in range(0, len(code)):
        if i not in control_bits:
            info_bits.append(code[i])

    return info_bits


def decode(code: [int]) -> [int]:
    stats = analyze_control_bits(code)

    diff = get_diff_control_bits(code, stats)

    if len(diff) != 0:
        repair_bit(code, sum(diff) - 1)

    return remove_control_bits(code, stats)
