package io.github.norbipeti.onecommandhelper;

import com.google.common.collect.Sets;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.IndexHelpTopic;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias,
                             String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage("§cYou need to be an OP to use this command.");
            return true;
        }
        StringBuilder acmdb = new StringBuilder("minecraft:execute ");
        acmdb.append(sender.getName()).append(" ");
        if (sender instanceof Player) {
            Block block = ((Player) sender).getTargetBlock(null, 10);
            if (block == null) {
                sender.sendMessage("§cYou need to look at the command block you want to activate. Make sure you're within 10 blocks of it.");
                return true;
            }
            if (block.getType() != Material.COMMAND) {
                sender.sendMessage("§cError! You need to look at a command block. Found "
                        + block.getType());
                return true;
            }
            CommandBlock cmdblock = (CommandBlock) block.getState();
            //acmdb.append(block.getX()).append(" ").append(block.getY()).append(" ").append(block.getZ()).append(" ");
            acmdb.append("~ ~ ~ ");
            acmdb.append(cmdblock.getCommand());
        } else {
            sender.sendMessage("§cYou need to be a player and look at the command block where you have the command you need to run.");
            return true;
        }
        String acmd = acmdb.toString();
        IndexHelpTopic iht = (IndexHelpTopic) Bukkit.getHelpMap().getHelpTopic("Minecraft");
        String[] replacecmds;
        try { //Get Minecraft (vanilla) commands
            Field f = iht.getClass().getDeclaredField("allTopics");
            f.setAccessible(true);
            replacecmds = ((Collection<HelpTopic>) f.get(iht)).stream().filter(ht -> ht.getName().startsWith("/minecraft:")).map(ht -> ht.getName().substring("/minecraft:".length())).toArray(String[]::new);
            System.out.println(Arrays.toString(replacecmds)); //TODO: Fallback method
        } catch (Exception e) {
            sender.sendMessage("§cAn error occured while getting commands!");
            e.printStackTrace();
            return true;
        }
        StringBuilder replace = new StringBuilder("(").append(replacecmds[0]);
        for (int i = 1; i < replacecmds.length; i++)
            replace.append("|").append(replacecmds[i]);
        replace.append(")");
        acmd = acmd.replaceAll("([^t]|^)( |:| /|:/)" + replace + " ",
                "$1$2minecraft:$3 ").replaceAll("\" (/*)minecraft:",
                "\"$1minecraft:"); //Tellraw
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), acmd);
        return true;
    }
}
