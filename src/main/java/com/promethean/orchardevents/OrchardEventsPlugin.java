package com.promethean.orchardevents;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class OrchardEventsPlugin extends JavaPlugin {
    private EventManager eventManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        eventManager = new EventManager(this);

        PluginCommand eventCommand = getCommand("event");
        if (eventCommand != null) {
            eventCommand.setExecutor(new EventCommand(eventManager));
        } else {
            getLogger().warning("Command /event not found in plugin.yml");
        }
    }

    @Override
    public void onDisable() {
        if (eventManager != null) {
            eventManager.stopEvent();
        }
    }
}
