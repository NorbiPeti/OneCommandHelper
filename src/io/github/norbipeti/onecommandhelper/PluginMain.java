package io.github.norbipeti.onecommandhelper;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin
{
	@Override
	public void onEnable() {
		//getServer().getPluginManager().registerEvents(new CommandListener(), this);
		getCommand("occ").setExecutor(new Commands());
	}
}
