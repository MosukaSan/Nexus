package org.devlucaslima.nexus;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.util.ArrayList;
import java.util.List;

import static net.dv8tion.jda.api.interactions.commands.OptionType.STRING;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onGuildReady(GuildReadyEvent event) {
        Guild guild = event.getGuild();

        //Subcommands
        //User
        List<SubcommandData> user = new ArrayList<>();
        user.add(new SubcommandData("info", "Get your info or of other user")
                .addOption(OptionType.USER, "user", "The user to get info", false));

        user.add(new SubcommandData("avatar", "Shows your avatar or of other user")
                .addOption(OptionType.USER, "user", "The user to get the avatar", false));

        //Server
        List<SubcommandData> server = new ArrayList<>();
        server.add(new SubcommandData("info", "Show some info about the server"));

        server.add(new SubcommandData("icon", "Shows the server icon"));

        //Register and update commands
        guild.updateCommands().addCommands(
                //Bot
                Commands.slash("ping", "Pings the bot"),

                Commands.slash("say", "Writhe something for the bot to say")
                                .addOption(STRING, "text", "The text you want the bot to say", true),

                //Utilities
                Commands.slash("user", "User Commands").addSubcommands(user),

                Commands.slash("server", "Server Commands").addSubcommands(server),

                Commands.slash("clear", "Clear an amount of messages")
                                .addOption(OptionType.INTEGER, "amount", "the amount of messages to be clear", true)
                                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.MESSAGE_MANAGE)),

                //Moderation
                Commands.slash("ban", "Ban a member from the server")
                        .addOption(OptionType.USER, "user", "The user to ban", true)
                        .addOption(OptionType.INTEGER, "length", "The time the user will be banned", true)
                        .addOption(STRING, "reason", "The reason for ban", false)
                        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.BAN_MEMBERS)),

                //Fun
                Commands.slash("rockpaperscissors", "Let's play rock paper scissors")
                        .addOptions(new OptionData(OptionType.STRING, "choice", "Make you choice", true)
                                .addChoice("rock", "rock")
                                .addChoice("paper", "paper")
                                .addChoice("scissors", "scissors"))
                ).queue();
    }
}
