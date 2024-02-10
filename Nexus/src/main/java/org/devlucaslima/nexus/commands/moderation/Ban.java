package org.devlucaslima.nexus.commands.moderation;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Ban extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        if (command.equals("ban")){
            Member member = event.getMember();
            int length = event.getOption("length").getAsInt();

            if (length <= 7){
                Member banned = event.getOption("user").getAsMember();
                OptionMapping reason = event.getOption("reason");

                if(reason == null) {
                    event.getGuild().ban(banned, length, TimeUnit.DAYS).queue();

                    EmbedBuilder builder = new EmbedBuilder();
                    builder.setTitle("User Banned! ⛔");
                    builder.setThumbnail(banned.getEffectiveAvatarUrl());
                    builder.setDescription(banned.getAsMention());
                    builder.addField("Banned by \uD83D\uDD28:", member.getAsMention(), false);
                    builder.addField("Time \uD83D\uDD51:", length + " days", false);
                    builder.setColor(Color.red);
                    event.replyEmbeds(builder.build()).queue();

                } else {
                    event.getGuild().ban(banned, length, TimeUnit.DAYS).reason(String.valueOf(reason)).queue();

                    EmbedBuilder builder = new EmbedBuilder();
                    builder.setTitle("User Banned! ⛔");
                    builder.setThumbnail(banned.getEffectiveAvatarUrl());
                    builder.setDescription(banned.getAsMention());
                    builder.addField("Banned by \uD83D\uDD28:", member.getAsMention(), false);
                    builder.addField("Reason \uD83D\uDCCB:", reason.getAsString(), false);
                    builder.addField("Time \uD83D\uDD51:", length + " days", false);
                    builder.setColor(Color.red);
                    event.replyEmbeds(builder.build()).queue();
                }
            } else {
                event.reply("You can ban a user for max 7 days! ❌").setEphemeral(true).queue();
            }
        }
    }
}
