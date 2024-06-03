package io.github.dehuckakpyt.telegrambot.model.telegram.`internal`

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Created on 03.06.2024.
 *
 * @author KScript
 */
internal data class SetStickerPositionInSet(
    @get:JsonProperty("sticker")
    public val sticker: String,
    @get:JsonProperty("position")
    public val position: Int,
)
