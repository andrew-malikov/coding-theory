class RsaKeys:
    def __init__(self, p: int, q: int):
        n = p * q
        phi_n = eulers_totient_function(p, q)

        e = self.find_e(phi_n)

        self.public = {"exp": e, "mod": n}
        self.private = {"exp": self.find_d(e, phi_n), "mod": n}

    def find_e(self, phi_n) -> int:
        """
            TODO: use some Fermat number
        """
        e = 3
        while gcd(e, phi_n) != 1:
            e += 2

        return e

    def find_d(self, e, phi_n) -> int:
        """
            TODO: use Extended Euclidean algorithm
        """
        k = 1
        while True:
            d, rem = divmod(k * phi_n + 1, e)
            if rem == 0:
                return d
            k += 1


def gcd(a: int, b: int) -> int:
    if b > a:
        a, b = b, a

    if a % b == 0:
        return b

    return gcd(a % b, b)


def eulers_totient_function(p: int, q: int) -> int:
    return (p - 1) * (q - 1)


class RsaEncryption:
    def __init__(self, key: dict):
        self._key = key

    def encrypt(self, data: int) -> int:
        return pow(data, self._key["exp"], self._key["mod"])


class RsaDecryption:
    def __init__(self, key: dict):
        self._key = key

    def decrypt(self, data: int) -> int:
        return pow(data, self._key["exp"], self._key["mod"])
