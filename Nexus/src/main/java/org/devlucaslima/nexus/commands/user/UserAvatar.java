package org.devlucaslima.nexus.commands.user;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class UserAvatar extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getFullCommandName().equals("user avatar")){
            Member member = event.getMember();
            OptionMapping user = event.getOption("user");

            if (user == null){
                EmbedBuilder builder = new EmbedBuilder();
                builder.setTitle("Here's your avatar!");
                builder.appendDescription(member.getAsMention());
                builder.setImage(member.getEffectiveAvatarUrl());
                event.replyEmbeds(builder.build()).addActionRow(
                                Button.link(member.getEffectiveAvatarUrl(), "Show in explorer!"))
                        .queue();
            } else {
                EmbedBuilder builder = new EmbedBuilder();
                builder.setTitle("Here's the avatar of:");
                builder.appendDescription(user.getAsUser().getAsMention());
                builder.setImage(user.getAsUser().getEffectiveAvatarUrl());
                event.replyEmbeds(builder.build()).addActionRow(
                                Button.link(user.getAsUser().getEffectiveAvatarUrl(), "Show in explorer!"))
                        .queue();
            }
        }
    }
}
