package io.github.norbipeti.onecommandhelper;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor
{
	private final String[] replacecmds = { "achievement", "ban", "ban-ip",
			"banlist", "blockdata", "clear", "clone", "debug",
			"defaultgamemode", "deop", "difficulty", "effect", "enchant",
			"entitydata", "execute", "fill", "gamemode", "gamerule", "give",
			"help", "kick", "kill", "list", "me", "op", "pardon", "particle",
			"playsound", "publish", "replaceitem", "save", "save-all",
			"save-off", "save-on", "say", "scoreboard", "seed", "setblock",
			"setidletimeout", "setworldspawn", "spawnpoint", "spreadplayers",
			"stats", "stop", "stopsound", "summon", "teleport", "tell",
			"tellraw", "testfor", "testforblock", "testforblocks", "time",
			"title", "toggledownfall", "tp", "trigger", "weather", "whitelist",
			"worldborder", "xp", "commands", "banip", "broadcast", "home",
			"setspawn", "unban" };

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias,
			String[] args)
	{
		StringBuilder acmdb = new StringBuilder("minecraft:execute "
				+ sender.getName() + " ~ ~ ~");
		if (sender != Bukkit.getConsoleSender()
				&& !(sender instanceof BlockCommandSender))
		{
			Block block = ((Player) sender).getLocation().subtract(0, 1, 0)
					.getBlock();
			if (block.getType() != Material.COMMAND)
			{
				sender.sendMessage("§cError! Block underneath must be command block! Found "
						+ block.getType());
				return true;
			}
			CommandBlock cmdblock = (CommandBlock) block.getState();
			acmdb.append(" ").append(cmdblock.getCommand());
		} else
		{
			if (args.length == 0)
			{
				sender.sendMessage("§cUsage: /" + alias + " <onecommand>");
				return true; //Why use the builtin usage shoing thing
			}
			for (String arg : args)
				acmdb.append(" ").append(arg);
		}
		String acmd = acmdb.toString();
		StringBuilder replace = new StringBuilder("(" + replacecmds[0]);
		for (int i = 1; i < replacecmds.length; i++)
			replace.append("|" + replacecmds[i]);
		replace.append(")");
		acmd = acmd.replaceAll("Command:\\/" + replace, "Command:/minecraft:$1")
				.replaceAll("Command\\:" + replace, "Command:minecraft:$1")
				.replaceAll(" " + replace + " ", " minecraft:$1 ");
		System.out.println(acmd); //TODO
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), acmd);
		return true;
	}
}
