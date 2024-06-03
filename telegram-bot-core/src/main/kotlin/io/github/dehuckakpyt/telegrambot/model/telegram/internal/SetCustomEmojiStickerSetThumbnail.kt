package io.github.dehuckakpyt.telegrambot.model.telegram.`internal`

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Created on 03.06.2024.
 *
 * @author KScript
 */
internal data class SetCustomEmojiStickerSetThumbnail(
    @get:JsonProperty("name")
    public val name: String,
    @get:JsonProperty("custom_emoji_id")
    public val customEmojiId: String? = null,
)
