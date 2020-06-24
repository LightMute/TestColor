package fr.lightmute;

import org.bukkit.Color;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class playerjoin implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerjoinevents(LoginEvent e) {
		ProxiedPlayer player = (ProxiedPlayer) e.getConnection();
		/*test */ player.sendMessage(player.getName()+ Color.fromRGB(34, 24, 17) + " coucou");
	}

}
