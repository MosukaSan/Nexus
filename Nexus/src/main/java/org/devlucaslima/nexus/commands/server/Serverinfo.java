package org.devlucaslima.nexus.commands.server;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Serverinfo extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        Guild guild = event.getGuild();

        if (event.getFullCommandName().equals("server info")){
            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle(guild.getName());
            builder.setThumbnail(guild.getIconUrl());
            builder.addField("Time Created \uD83D\uDCC5: ", "Year: " + guild.getTimeCreated().getYear() +
                    "\nMonth: " + guild.getTimeCreated().getMonth() + "\nDay: " + guild.getTimeCreated().getDayOfMonth() +
                    " (" + guild.getTimeCreated().getDayOfWeek() + ")" + "\nTime: " + guild.getTimeCreated().getHour() +
                    ":" + guild.getTimeCreated().getMinute() + ":" + guild.getTimeCreated().getSecond(), true);
            builder.addField("Members: \uD83E\uDDD1\u200D\uD83E\uDD1D\u200D\uD83E\uDDD1", String.valueOf(guild.getMemberCount()), true);
            builder.addField("ID: \uD83C\uDFB2", guild.getId(), false);
            builder.addField("Text Channels: \uD83D\uDCAC", String.valueOf(guild.getTextChannels().size()), true);
            builder.addField("Voice Channels: \uD83D\uDD0A", String.valueOf(guild.getVoiceChannels().size()), true);
            builder.addField("Roles: ❤\uFE0F", String.valueOf(guild.getRoles().size()), true);
            if (guild.getBanner() != null){
                builder.setImage(guild.getBannerUrl());
                event.replyEmbeds(builder.build()).addActionRow(
                                Button.link(guild.getIconUrl(), "Show Icon in Explorer!"),
                                Button.link(guild.getBannerUrl(), "Show Banner in Explorer!"))
                        .queue();
            } else {
                event.replyEmbeds(builder.build()).addActionRow(
                        Button.link(guild.getIconUrl(), "Show Icon in Explorer!"))
                        .queue();
            }
        }
    }
}
