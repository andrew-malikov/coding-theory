package cipher.xor.lib

class Mask(private var seed: Int, private val maxValue: Int) {

    private fun updateSeed() {
        seed = (seed * seed + seed / 2) % maxValue
    }

    fun next(): Int {
        val mask = seed
        updateSeed()
        return mask
    }
}