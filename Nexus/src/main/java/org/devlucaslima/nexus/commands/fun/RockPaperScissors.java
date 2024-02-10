package org.devlucaslima.nexus.commands.fun;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.Random;

public class RockPaperScissors extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("rockpaperscissors")){
            OptionMapping choice = event.getOption("choice");
            String type = choice.getAsString();
            String replyMessage = "";
            String botReply = "";
            Random random = new Random();
            Integer botChoice = random.nextInt(3) + 1;

            if (botChoice == 1) {
                botReply = "I choose rock! \uD83E\uDEA8";
                switch (type.toLowerCase()){
                    case "rock" -> {
                        replyMessage = "It's a tie!";
                        break;
                    }
                    case "paper" -> {
                        replyMessage = "I've lost \uD83D\uDE25";
                        break;
                    }
                    case "scissors" -> {
                        replyMessage = "I win!";
                        break;
                    }
                }
            }
            if (botChoice == 2) {
                botReply = "I choose paper! \uD83E\uDDFB";
                switch (type.toLowerCase()) {
                    case "rock" -> {
                        replyMessage = "I win!";
                        break;
                    }
                    case "paper" -> {
                        replyMessage = "It's a tie!";
                        break;
                    }
                    case "scissors" -> {
                        replyMessage = "I've lost \uD83D\uDE25";
                        break;
                    }
                }
            }
            if (botChoice == 3){
                botReply = "I choose scissors! ✂\uFE0F";
                switch (type.toLowerCase()) {
                    case "rock" -> {
                        replyMessage = "I've lost \uD83D\uDE25";
                        break;
                    }
                    case "paper" -> {
                        replyMessage = "I win!";
                        break;
                    }
                    case "scissors" -> {
                        replyMessage = "It's a tie!";
                        break;
                    }
                }
            }
            switch (type.toLowerCase()){
                case "rock" -> {
                    event.reply("You chose: \uD83E\uDEA8\n\n" + botReply + "\n" + replyMessage).queue();
                    break;
                }
                case "paper" -> {
                    event.reply("You chose: \uD83E\uDDFB\n\n" + botReply + "\n" + replyMessage).queue();
                    break;
                }
                case "scissors" -> {
                    event.reply("You chose: ✂\uFE0F\n\n" + botReply + "\n" + replyMessage).queue();
                    break;
                }
            }

        }
    }
}
