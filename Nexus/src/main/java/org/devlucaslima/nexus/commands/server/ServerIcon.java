package org.devlucaslima.nexus.commands.server;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class ServerIcon extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getFullCommandName().equals("server icon")){
            Guild guild = event.getGuild();

            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("Here's the icon of the server!");
            builder.setImage(guild.getIconUrl());
            event.replyEmbeds(builder.build()).addActionRow(
                            Button.link(guild.getIconUrl(), "Show in explorer!"))
                    .queue();
        }
    }
}
