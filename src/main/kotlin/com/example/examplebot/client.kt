package com.example.examplebot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.cache.CacheFlag


class BotClient : ListenerAdapter(){
    lateinit var jda: JDA

    fun main(token: String) {
        jda = JDABuilder.createLight(token,
            GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES,GatewayIntent.GUILD_EMOJIS,
            GatewayIntent.GUILD_MESSAGE_REACTIONS)
            .enableCache(CacheFlag.EMOTE)
            .addEventListeners(this)
            .build()
    }

    override fun onReady(event: ReadyEvent) {
        val channel = event.jda.getTextChannelById("")
        if (channel != null) {
            channel.sendMessageFormat("起動しました").queue()
        }else{
            println("指定されたチャンネルがありません!")
        }
    }
}


fun main() {
    val bot = BotClient()
    bot.main("TOKEN")
}
