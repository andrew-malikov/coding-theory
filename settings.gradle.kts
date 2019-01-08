include(
        ":common"
        , ":analyzer-lib", ":analyzer-cli"
        , ":ascii-lib", ":ascii-encoder-cli", ":ascii-decoder-cli"
        , ":huffman-code-lib", ":huffman-code-encoder-cli", ":huffman-code-decoder-cli"
        , ":arithmetic-coding-lib", ":arithmetic-coding-compressing-cli", "arithmetic-coding-decompressing-cli"
        , ":lzw-lib", ":lzw-cli"
        , ":cipher-caesar-lib", ":cipher-caesar-cli"
        , ":cipher-xor-lib", ":cipher-xor-cli"
        , ":cipher-transposition-lib", ":cipher-transposition-cli")
