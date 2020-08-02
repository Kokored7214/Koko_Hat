package me.kokored.koko_hat;

import org.bukkit.plugin.java.JavaPlugin;

public final class Koko_Hat extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Koko_JoinMotd has enabled");

        new Hat();

    }

    @Override
    public void onDisable() {
        System.out.println("Koko_JoinMotd has disabled");
    }
}
