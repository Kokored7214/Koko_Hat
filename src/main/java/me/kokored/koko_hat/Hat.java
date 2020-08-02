package me.kokored.koko_hat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.Bukkit;

public class Hat implements CommandExecutor {
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
                    player.sendMessage("You have nothing on hand...");

                    return true;

                }
                if (hand.getAmount() != 1) {
                    player.sendMessage(ChatColor.GRAY + "You have more than one item in your hand");

                    return true;

                }
                if (hand.getAmount() == 1) {
                    inv.setHelmet(hand);
                    inv.setItemInMainHand(hat);
                    player.updateInventory();
                    player.sendMessage(ChatColor.GREEN + "hat is now on!");

                }

            }else {
                Player player = (Player) sender;
                player.sendMessage(org.bukkit.ChatColor.RED + "You do not have permission to do that command");

            }
        }else {
            sender.sendMessage("This command can only be executed by the player");

        }
        return true;
    }
}