from functools import reduce
from math import fabs


class MachineInteger:
    def __init__(self, number):
        self._validate(number)

        body = self._str_to_list(f"{int(fabs(number)):015b}")

        if number < 0:
            body = self._get_inverted_bits(body)
            body = self._get_increased_bits(body)
            body.insert(0, 1)
        else:
            body.insert(0, 0)

        self.representation = body

    def _get_increased_bits(self, bits: [int]) -> [int]:
        increased = []

        is_increased = False
        for bit in reversed(bits):
            if is_increased:
                increased.insert(0, bit)
                continue

            if bit == 0:
                bit = 1
                is_increased = True
            else:
                bit = 0

            increased.insert(0, bit)

        return increased

    def _get_inverted_bits(self, bits: [int]) -> [int]:
        inverted = []

        for bit in bits:
            inverted.append(1 - bit)

        return inverted

    def _str_to_list(self, number: str) -> [int]:
        return list(map(lambda symbol: int(symbol), number))

    def __str__(self):
        return reduce(lambda x, y: x + str(y), self.representation, "")

    def _validate(self, number):
        if fabs(number) < 2**15:
            return

        raise NotImplementedError(
            f"absolute value of number can't be more then {2**15}")
