package io.github.dehuckakpyt.telegrambot.factory.button

import io.github.dehuckakpyt.telegrambot.converter.CallbackSerializer
import io.github.dehuckakpyt.telegrambot.model.type.InlineKeyboardButton


/**
 * Created on 06.10.2023.
 *<p>
 *
 * @author Denis Matytsin
 */
class ButtonFactoryImpl(
    private val callbackSerializer: CallbackSerializer,
) : ButtonFactory {

    override fun callbackButton(text: String, next: String): InlineKeyboardButton {
        return InlineKeyboardButton(text, callbackData = next)
    }

    override suspend fun callbackButton(chatId: Long, fromId: Long, text: String, next: String, content: Any): InlineKeyboardButton {
        return InlineKeyboardButton(text, callbackData = callbackSerializer.toCallback(chatId, fromId, next, content))
    }
}