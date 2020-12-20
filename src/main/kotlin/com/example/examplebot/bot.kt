package com.example.examplebot

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandClientBuilder
import com.jagrosh.jdautilities.command.CommandEvent
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder


class Ping:Command(){
    init {
        this.name = "ping"
    }
    override fun execute(event: CommandEvent?){
        event?.reply(event.author.asMention + "pong!")
    }
}


class CommandBot{
    lateinit var jda: JDA
    private val commandPrefix = "!"

    fun main(token: String) {
        val commandClient = CommandClientBuilder()
            .setOwnerId("owner")
            .setPrefix(commandPrefix)
            .addCommands(Ping()) // ここでコマンドを登録
            .build()

        jda = JDABuilder.createDefault(token)
            .addEventListeners(commandClient)
            .build()
    }
}


fun main(){
    val bot = CommandBot()
    bot.main("TOKEN")
}


