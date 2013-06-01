package net.minecrell.permissionsx.api.module;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import net.minecrell.permissionsx.api.PermissionManager;

public interface PermissionModule {
	
	// TODO: Javadocs
	
	public String getName();
	
	public Logger getLogger();
	
	public ModuleManager getModuleManager();
	
	public PermissionManager getPermissionManager();
	public Plugin getPluginContainer();
	
	public Server getServer();
	
	
	public File getDataFolder();
	
	public InputStream getResource(String fileName) throws IOException;
	
	public boolean saveResource(String resourcePath) throws IOException;
	public boolean saveResource(String resourcePath, boolean replace) throws IOException;
	
	public void onEnable();
	public void onDisable();
	
	public boolean isEnabled();
	
	public ModuleLoader getModuleLoader();
}
