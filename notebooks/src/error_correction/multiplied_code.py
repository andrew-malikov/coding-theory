def encode(data: [int], precision: int = 3) -> [int]:
    protected_data = []

    for byte in data:
        for i in range(0, precision):
            protected_data.append(byte)

    return protected_data


def decode(data: [int], precision: int = 3) -> [int]:
    decoded_data = []

    iterations = len(data) // precision

    for i in range(0, iterations):
        bytes = [0, 0]
        i = i * precision

        for byte in data[i:i + precision]:
            if byte == 0:
                bytes[0] += 1
            else:
                bytes[1] += 1

        if bytes[0] > bytes[1]:
            decoded_data.append(0)
        else:
            decoded_data.append(1)

    return decoded_data
