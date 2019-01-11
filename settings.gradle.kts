include(
        ":common",
        ":volume-analyzer:lib", ":volume-analyzer:cli",
        ":ascii:lib", ":ascii:encoder-cli", ":ascii:decoder-cli",
        ":huffman-code:lib", ":huffman-code:compressing-cli", ":huffman-code:decompressing-cli",
        ":arithmetic-coding:lib", ":arithmetic-coding:compressing-cli", "arithmetic-coding:decompressing-cli",
        ":lzw:lib", ":lzw:cli",
        ":layered-compression:compressing-cli", ":layered-compression:decompressing-cli",
        ":cipher-caesar:lib", ":cipher-caesar:cli",
        ":cipher-xor:lib", ":cipher-xor:cli",
        ":cipher-transposition:lib", ":cipher-transposition:cli"
)
