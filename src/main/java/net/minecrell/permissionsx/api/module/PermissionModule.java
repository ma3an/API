package net.minecrell.permissionsx.api.module;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

import net.minecrell.permissionsx.api.PermissionManager;
import net.minecrell.permissionsx.api.PermissionPlugin;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

public interface PermissionModule extends Plugin {

	// TODO: Javadocs

	@Override
	public String getName();

	@Override
	public Logger getLogger();

	public ModuleManager getModuleManager();

	public PermissionManager getPermissionManager();

	public PermissionPlugin getPluginContainer();

	@Override
	public Server getServer();

	@Override
	public File getDataFolder();

	@Override
	public InputStream getResource(String fileName);

	public void saveResource(String resourcePath);

	@Override
	public void saveResource(String resourcePath, boolean replace);

	@Override
	public void onEnable();

	@Override
	public void onDisable();

	@Override
	public boolean isEnabled();

	public ModuleLoader getModuleLoader();
}
