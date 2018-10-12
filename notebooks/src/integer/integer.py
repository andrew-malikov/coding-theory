from math import fabs


def repesent_s_int(number: int) -> str:
    if fabs(number) > 2**15:
        raise AttributeError(
            "absolute value of number can't be more then {0}".format(2**15))

    sign = 0
    if number < 0:
        sign = 1
        number = -number

    return "{0}{1:015b}".format(sign, number)
