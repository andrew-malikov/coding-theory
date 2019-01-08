package cipher.transposition.cli

import cipher.transposition.lib.Transposition
import cipher.transposition.lib.Transpositions

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class TranspositionsFromJson(json: String) {
    val content: Transpositions = Transpositions(
            GsonBuilder()
                    .create()
                    .fromJson(json, object : TypeToken<List<Transposition>>() {}.type)
    )
}