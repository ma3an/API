package net.minecrell.permissionsx.api.module;

import java.util.logging.Logger;

import org.bukkit.Server;

import net.minecrell.permissionsx.api.PermissionManager;

public interface PermissionModule {
	
	// TODO: Javadocs
	
	public abstract PermissionManager getManager();
	public abstract Logger getLogger();
	public abstract Server getServer();

}
