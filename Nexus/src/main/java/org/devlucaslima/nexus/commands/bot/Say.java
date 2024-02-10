package org.devlucaslima.nexus.commands.bot;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Say extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("say")){
            String text = event.getOption("text").getAsString();
            event.reply(text).queue();
        }
    }
}
