package org.devlucaslima.nexus;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.devlucaslima.nexus.commands.bot.Say;
import org.devlucaslima.nexus.commands.fun.RockPaperScissors;
import org.devlucaslima.nexus.commands.moderation.Ban;
import org.devlucaslima.nexus.commands.server.ServerIcon;
import org.devlucaslima.nexus.commands.user.UserAvatar;
import org.devlucaslima.nexus.commands.bot.Ping;
import org.devlucaslima.nexus.commands.utilities.Clear;
import org.devlucaslima.nexus.commands.server.Serverinfo;
import org.devlucaslima.nexus.commands.user.Userinfo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JDA jda = JDABuilder.createDefault("")
                .enableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT)
                .setActivity(Activity.listening("hello!"))
                .addEventListeners(
                        //Command Manager
                        new CommandManager(),

                        //Bot
                        new Ping(),
                        new Say(),

                        //Utilities
                        new UserAvatar(),
                        new Userinfo(),
                        new Serverinfo(),
                        new ServerIcon(),
                        new Clear(),

                        //Moderation
                        new Ban(),

                        //Fun
                        new RockPaperScissors()
                        )
                .build();
        jda.awaitReady();
    }
}