package arithmetic.coding.decompressing.cli

import arithmetic.coding.lib.CompressedDataFromBytes
import arithmetic.coding.lib.DecompressedData

fun main(args: Array<String>) {
    System.out.print(
            DecompressedData(CompressedDataFromBytes(System.`in`.readBytes()).deserialize()).content
    )
}