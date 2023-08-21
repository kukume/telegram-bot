package io.github.dehuckakpyt.telegrambot.container.factory

import com.elbekd.bot.types.Message
import io.github.dehuckakpyt.telegrambot.TelegramBot
import io.github.dehuckakpyt.telegrambot.container.MassageContainer
import io.github.dehuckakpyt.telegrambot.source.chain.ChainSource
import kotlin.reflect.KClass


/**
 * Created on 17.08.2023.
 *<p>
 *
 * @author Denis Matytsin
 */
interface MessageContainerFactory {
    fun condition(message: Message): Boolean

    fun create(
        chatId: Long,
        message: Message,
        content: String?,
        chainSource: ChainSource,
        bot: TelegramBot
    ): MassageContainer

    val type: KClass<out MassageContainer>

    val typeName: String
}