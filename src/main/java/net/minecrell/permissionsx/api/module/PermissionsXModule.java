package net.minecrell.permissionsx.api.module;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import net.minecrell.permissionsx.api.PermissionManager;

public class PermissionsXModule implements PermissionModule {
	private PermissionManager permissionManager;
	
	private String moduleName;
	private ModuleLogger logger;
	
	private boolean initialized, isEnabled;
	
	@Override
	public String getName() {
		return moduleName;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}
	
	

	@Override
	public void onEnable() {}

	@Override
	public void onDisable() {}

	@Override
	public final boolean isEnabled() {
		return isEnabled;
	}
	
	protected final void setEnabled(final boolean enabled) {
		if (isEnabled != enabled) {
			isEnabled = enabled;
			
			if (isEnabled) {
				onEnable();
			} else {
				onDisable();
			}
		}
	}
	
	
	@Override
	public PermissionManager getManager() {
		return permissionManager;
	}
	
	@Override
	public final Plugin getPluginContainer() {
		if (!initialized) return null;
		return permissionManager.getContainer();
	}
	
	@Override
	public final Server getServer() {
		return permissionManager.gets
	}
	
	@Override
	public final File getDataFolder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public InputStream getResource(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void saveResource(String resourcePath) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void saveResource(String resourcePath, boolean replace) {
		// TODO Auto-generated method stub
		
	}

}
