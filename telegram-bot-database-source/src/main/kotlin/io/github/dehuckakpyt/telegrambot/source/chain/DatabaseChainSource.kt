package io.github.dehuckakpyt.telegrambot.source.chain

import com.dehucka.exposed.ext.execute
import com.dehucka.exposed.ext.read
import io.github.dehuckakpyt.telegrambot.model.Chain
import io.github.dehuckakpyt.telegrambot.model.Chains
import io.github.dehuckakpyt.telegrambot.model.DatabaseChain
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and

class DatabaseChainSource : ChainSource {

    override suspend fun save(chatId: Long, fromId: Long, step: String?, content: String?): Unit = execute {
        DatabaseChain.find((Chains.chatId eq chatId) and (Chains.fromId eq fromId)).firstOrNull()?.apply {
            this.step = step
            this.content = content
        } ?: DatabaseChain.new {
            this.chatId = chatId
            this.fromId = fromId
            this.step = step
            this.content = content
        }
    }

    override suspend fun get(chatId: Long, fromId: Long): Chain? = read {
        DatabaseChain.find((Chains.chatId eq chatId) and (Chains.fromId eq fromId)).firstOrNull()
    }
}