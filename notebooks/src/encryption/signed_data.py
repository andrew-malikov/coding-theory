from math import fabs

from src.encryption.rsa import RsaEncryption, RsaDecryption


class SignedData:
    def __init__(self, data: str, encrypted_hash):
        self.data = data
        self.encrypted_hash = encrypted_hash

    def is_valid(self, decryption: RsaDecryption) -> bool:
        decrypted_hash = decryption.decrypt(self.encrypted_hash)

        if decrypted_hash == hashed(self.data):
            return True
        return False


class SignedDataFromRaw(SignedData):
    def __init__(self, data: str, encryption: RsaEncryption):
        return super().__init__(data, encryption.encrypt(hashed(data)))


def hashed(data):
    return int(fabs(hash(data)))
