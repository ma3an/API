package net.minecrell.permissionsplusplus.api;

import org.bukkit.plugin.Plugin;

public interface PermissionPlugin extends Plugin {
	public PermissionManager getPermissionManager();
}
