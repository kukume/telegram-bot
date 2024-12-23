# Synchronization

To choose how user actions will be handled, you can specify this in the config property `invocationStrategy` by selecting one of the options.

```kotlin
val config = TelegramBotConfig().apply {
    receiving {
        invocationStrategy = { HandlerInvocationStrategy.fullSync }
        invocationStrategy = { HandlerInvocationStrategy.fullAsync } // default
        invocationStrategy = { HandlerInvocationStrategy.userSync } // experimental
        invocationStrategy = { HandlerInvocationStrategy.chatSync } // experimental
        invocationStrategy = { HandlerInvocationStrategy.smartSync } // experimental
    }
}
```

- **fullSync** – All actions processing sequentially.
- **fullAsync** (default) – All actions processing independently.
- **userSync** (experimental) –  Actions to be executed for each user independently of other users, but actions of the same user in all chats will be executed strictly sequentially.
- **chatSync** (experimental) – Actions to be executed for each chat independently of other chats, but actions in the same chat will be executed strictly sequentially.
- **smartSync** (experimental) – Actions to be executed for each user independently of other users. Actions of the same user in the same chat will be executed strictly sequentially. Actions of the same user in different chats will be executed independently.

Or you can implement interface `HandlerInvocationStrategy` and provide your own variant.

```kotlin
class HandlerInvocationCustomStrategy : HandlerInvocationStrategy {
    override suspend fun invokeHandler(chatId: Long, fromId: Long, action: suspend () -> Unit): Unit {
        // your logic to invoke action (handler)
    }
}
val config = TelegramBotConfig().apply {
    receiving {
        // apply new variant
        invocationStrategy = { HandlerInvocationCustomStrategy() }
    }
}
```