package me.kokored.koko_hat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.Material;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Hat implements CommandExecutor {

    Plugin plugin = Koko_Hat.getPlugin(Koko_Hat.class);

    public Hat() {
        Bukkit.getPluginCommand("hat").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("kokohat.hat")) {
                Player player = (Player) sender;
                PlayerInventory inv = player.getInventory();
                ItemStack hand = inv.getItemInMainHand();
                ItemStack hat = inv.getHelmet();

                if (hand.getType() == Material.AIR) {
                    player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("nothing on hand"));

                    return true;

                }
                if (hand.getAmount() != 1) {
                    player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("more than one item"));

                    return true;

                }
                if (hand.getAmount() == 1) {
                    inv.setHelmet(hand);
                    inv.setItemInMainHand(hat);
                    player.updateInventory();
                    player.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("hat on"));


                }

            }else {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.RED + plugin.getConfig().getString("no permission"));

            }
        }else {
            sender.sendMessage(plugin.getConfig().getString("only player"));

        }
        return true;
    }
}