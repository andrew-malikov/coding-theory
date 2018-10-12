from random import random


def generate_bit_sequence(count: int) -> [int]:
    sequence = []

    for i in range(0, count):
        sequence.append(round(random()))

    return sequence
