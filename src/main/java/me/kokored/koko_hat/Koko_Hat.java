package me.kokored.koko_hat;

import org.bukkit.plugin.java.JavaPlugin;

public final class Koko_Hat extends JavaPlugin {

    @Override
    public void onEnable() {

        new Hat();

    }

    @Override
    public void onDisable() {
    }
}
