package org.devlucaslima.nexus.commands.utilities;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Clear extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("clear")){
            Integer amount = event.getOption("amount").getAsInt();
            Member member = event.getMember();

            if (member.hasPermission(Permission.MESSAGE_MANAGE)){
                if (amount <= 100){
                    List<Message> messageList = event.getChannel().getHistory().retrievePast(amount).complete();
                    if (messageList.size() >= 2){
                        event.getChannel().asTextChannel().deleteMessages(messageList).queue();
                        event.reply("Messages cleared! \uD83E\uDDF9").queue();
                    } else {
                        event.reply("You need at least 2 messages on the channel! ❌").setEphemeral(true).queue();
                    }
                } else {
                    event.reply("you can't delete more than 100 messages at once! ❌").setEphemeral(true).queue();
                }
            } else {
                event.reply("you don't have permission to use this command ❌").setEphemeral(true).queue();
            }
        }
    }
}
