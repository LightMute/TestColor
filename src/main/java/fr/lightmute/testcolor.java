package fr.lightmute;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class testcolor extends Plugin {
	public static testcolor instance;

	public static testcolor getinstance() {
		return instance;
	}

	String prefix = "§7[§dStelyBot§7] ";

	net.md_5.bungee.config.Configuration messages;

	public void onEnable() {
		instance = this;
		System.out.println(String.valueOf(this.prefix) + "actif !");
		ProxyServer.getInstance().getPluginManager().registerListener(this, new playerjoin());
		try {
			if (!getDataFolder().exists())
				getDataFolder().mkdir(); 
			File file = new File(getDataFolder().getPath(), "Config.yml");
			if (!file.exists()) {
				file.createNewFile();
				this.messages = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
				this.messages.set("Recordman.record", Integer.valueOf(0));
				ConfigurationProvider.getProvider(YamlConfiguration.class).save(this.messages, file);
			} else {
				this.messages = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
			} 
		} catch (Exception e) {
			ProxyServer.getInstance().getConsole().sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "[StelyCapucine] Impossible de crle fichier Config.yml"));
		} 
	}

	public void onLoad() {
		File file = new File(getDataFolder().getPath(), "Config.yml");
		if (file.exists())
			try {
				this.messages = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}  
	}

	public void onDisable() {
		System.out.println(String.valueOf(this.prefix) + "inactif !");
	}
}
