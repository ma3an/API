package net.minecrell.permissionsx.api;

import org.bukkit.plugin.Plugin;

public interface PermissionPlugin extends Plugin {
	public PermissionManager getPermissionManager();
}
