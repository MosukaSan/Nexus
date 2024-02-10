package org.devlucaslima.nexus.commands.user;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Userinfo extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getFullCommandName().equals("user info")){
            OptionMapping userOption = event.getOption("user");
            if (userOption == null){
                User user = event.getUser();
                Member member = event.getMember();

                EmbedBuilder builder = new EmbedBuilder();
                builder.setTitle(user.getGlobalName());
                builder.setDescription(user.getAsMention());
                builder.setThumbnail(user.getEffectiveAvatarUrl());
                builder.addField("Time Created \uD83D\uDCC5:", "Year: " + user.getTimeCreated().getYear() +
                        "\nMonth: " + user.getTimeCreated().getMonth() + "\nDay: " + user.getTimeCreated().getDayOfMonth() +
                        " (" + user.getTimeCreated().getDayOfWeek() + ")" + "\nTime: " + user.getTimeCreated().getHour() +
                        ":" + user.getTimeCreated().getMinute() + ":" + user.getTimeCreated().getSecond(), false);
                builder.addField("ID \uD83C\uDFB2:", user.getId(), false);
                if (member.getRoles().size() > 0) {
                    builder.addField("Roles in the server:", member.getRoles().size() + "\nBiggest: " +
                            member.getRoles().getFirst().getAsMention(), false);
                }
                event.replyEmbeds(builder.build()).addActionRow(
                                Button.link(user.getEffectiveAvatarUrl(), "Show Avatar in Explorer!"))
                        .queue();
            } else {
                User userRefered = event.getOption("user").getAsUser();
                Member memberRefered = event.getOption("user").getAsMember();

                EmbedBuilder builder = new EmbedBuilder();
                builder.setTitle(userRefered.getGlobalName());
                builder.setDescription(userRefered.getAsMention());
                builder.setThumbnail(userRefered.getEffectiveAvatarUrl());
                builder.addField("Time Created \uD83D\uDCC5: ", "Year: " + userRefered.getTimeCreated().getYear() +
                        "\nMonth: " + userRefered.getTimeCreated().getMonth() + "\nDay: " + userRefered.getTimeCreated().getDayOfMonth() +
                        " (" + userRefered.getTimeCreated().getDayOfWeek() + ")" + "\nTime: " + userRefered.getTimeCreated().getHour() +
                        ":" + userRefered.getTimeCreated().getMinute() + ":" + userRefered.getTimeCreated().getSecond(), false);
                builder.addField("ID \uD83C\uDFB2: ", userRefered.getId(), false);
                if (memberRefered.getRoles().size() > 0) {
                    builder.addField("Roles in the server ❤\uFE0F:", memberRefered.getRoles().size() + "\nBiggest: " +
                            memberRefered.getRoles().getFirst().getAsMention(), false);
                }
                event.replyEmbeds(builder.build()).addActionRow(
                                Button.link(userRefered.getEffectiveAvatarUrl(), "Show Avatar in Explorer!"))
                        .queue();
            }
        }
    }
}
