package com.promethean.orchardevents;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class EventManager {
    private final OrchardEventsPlugin plugin;
    private int taskId = -1;
    private int secondsRemaining = 0;
    private BossBar bossBar;

    public EventManager(OrchardEventsPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean isRunning() {
        return taskId != -1;
    }

    public void startEvent(int durationSeconds) {
        if (isRunning()) {
            return;
        }

        secondsRemaining = durationSeconds;
        bossBar = BossBar.bossBar(
            Component.text("Event ends in " + secondsRemaining + "s", NamedTextColor.GREEN),
            1.0f,
            BossBar.Color.GREEN,
            BossBar.Overlay.PROGRESS
        );
        Bukkit.getOnlinePlayers().forEach(player -> player.showBossBar(bossBar));
        Bukkit.broadcast(Component.text("Orchard Event started!", NamedTextColor.GOLD));

        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            secondsRemaining--;
            if (secondsRemaining <= 0) {
                stopEvent();
                Bukkit.broadcast(Component.text("Event complete!", NamedTextColor.AQUA));
                return;
            }

            float progress = Math.max(0f, Math.min(1f, secondsRemaining / (float) durationSeconds));
            bossBar.progress(progress);
            bossBar.name(Component.text("Event ends in " + secondsRemaining + "s", NamedTextColor.GREEN));
        }, 20L, 20L);
    }

    public void stopEvent() {
        if (!isRunning()) {
            return;
        }

        Bukkit.getScheduler().cancelTask(taskId);
        taskId = -1;

        if (bossBar != null) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.hideBossBar(bossBar);
            }
            bossBar = null;
        }
    }
}
