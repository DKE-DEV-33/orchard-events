package com.promethean.orchardevents;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public final class EventCommand implements CommandExecutor {
    private final EventManager eventManager;

    public EventCommand(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Component.text("Usage: /event <start|stop> [seconds]", NamedTextColor.YELLOW));
            return true;
        }

        if (args[0].equalsIgnoreCase("start")) {
            if (eventManager.isRunning()) {
                sender.sendMessage(Component.text("An event is already running.", NamedTextColor.RED));
                return true;
            }

            int duration = 120;
            if (args.length >= 2) {
                try {
                    duration = Integer.parseInt(args[1]);
                } catch (NumberFormatException ignored) {
                    sender.sendMessage(Component.text("Invalid duration. Using 120 seconds.", NamedTextColor.YELLOW));
                }
            }

            eventManager.startEvent(duration);
            sender.sendMessage(Component.text("Event started for " + duration + " seconds.", NamedTextColor.GREEN));
            return true;
        }

        if (args[0].equalsIgnoreCase("stop")) {
            if (!eventManager.isRunning()) {
                sender.sendMessage(Component.text("No active event to stop.", NamedTextColor.RED));
                return true;
            }
            eventManager.stopEvent();
            sender.sendMessage(Component.text("Event stopped.", NamedTextColor.GREEN));
            return true;
        }

        sender.sendMessage(Component.text("Usage: /event <start|stop> [seconds]", NamedTextColor.YELLOW));
        return true;
    }
}
