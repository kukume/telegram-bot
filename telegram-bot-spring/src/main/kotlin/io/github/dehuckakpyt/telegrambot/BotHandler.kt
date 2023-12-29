package io.github.dehuckakpyt.telegrambot

import io.github.dehuckakpyt.telegrambot.context.SpringContext.autowired
import io.github.dehuckakpyt.telegrambot.handling.BotHandling


/**
 * Created on 21.12.2023.
 *<p>
 *
 * @author Denis Matytsin
 */
abstract class BotHandler(block: BotHandling.() -> Unit) {
    init {
        autowired<BotHandling>().block()
    }
}