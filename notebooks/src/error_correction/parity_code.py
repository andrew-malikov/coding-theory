def normalize_bits(bits: [int], normalized_size: int = 7) -> [int]:
    if len(bits) == normalized_size:
        return bits

    if len(bits) > normalized_size:
        raise ValueError()

    normalized_bits = []

    for i in range(0, normalized_size - len(bits)):
        normalized_bits.append(0)

    for bit in bits:
        normalized_bits.append(bit)

    return normalized_bits


def add_parity_bit(bits: [int]) -> [int]:
    parity_bit = 0

    if len(list(filter(lambda x: True if x == 1 else False, bits))) % 2 == 1:
        parity_bit = 1

    protected_bits = bits.copy()
    protected_bits.append(parity_bit)

    return protected_bits


def encode(bits: [int], part_size: int = 7) -> [int]:
    size = len(bits)
    protected_bits = list()

    for i in range(0, size, part_size):
        end = i + part_size

        if end > size:
            end = size

        part = normalize_bits(bits[i:end], part_size)
        protected_bits.extend(add_parity_bit(part))

    return protected_bits
