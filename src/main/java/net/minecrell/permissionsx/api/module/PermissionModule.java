package net.minecrell.permissionsx.api.module;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import net.minecrell.permissionsx.api.PermissionManager;

public interface PermissionModule {
	
	// TODO: Javadocs
	
	public abstract String getName();
	
	public abstract Logger getLogger();
	
	
	public abstract PermissionManager getManager();
	public abstract Plugin getPluginContainer();
	
	public abstract Server getServer();
	
	
	public abstract File getDataFolder();
	
	public abstract InputStream getResource(String fileName);
	
	public abstract void saveResource(String resourcePath);
	public abstract void saveResource(String resourcePath, boolean replace);
	
	
}
