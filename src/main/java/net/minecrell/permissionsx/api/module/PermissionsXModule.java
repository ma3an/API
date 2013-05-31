package net.minecrell.permissionsx.api.module;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import net.minecrell.permissionsx.api.PermissionManager;

public class PermissionsXModule implements PermissionModule {
	
	// TODO: Javadocs :(
	
	private ModuleManager moduleManager;	
	private ModuleLoader loader;
	
	private String moduleName;
	private ModuleLogger logger;
	
	private boolean initialized, isEnabled;
	
	private File file, dataFolder;
	
	@Override
	public String getName() {
		return moduleName;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}
	
	@Override
	public final ModuleManager getModuleManager() {
		return moduleManager;
	}
	
	@Override
	public final ModuleLoader getModuleLoader() {
		return loader;
	}
	
	protected final void initialize(ModuleLoader loader, ModuleManager moduleManager, String moduleName, File file, File dataFolder) {
		if (!initialized) {
			this.initialized = true;
			
			this.loader = loader;
			this.moduleManager = moduleManager;
			
			this.moduleName = moduleName;
			
			this.file = file;
			this.dataFolder = dataFolder;
			
			this.logger = new ModuleLogger(this);
		}
	}
	
    public final boolean isInitialized() {
        return initialized;
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
	public final PermissionManager getPermissionManager() {
		if (this.getModuleManager() == null) return null;
		return this.getModuleManager().getPermissionManager();
	}
	@Override
	public final Plugin getPluginContainer() {
		if (this.getPermissionManager() == null) return null;
		return this.getPermissionManager().getContainer();
	}
	@Override
	public final Server getServer() {
		if (this.getPermissionManager() == null) return null;
		return this.getPermissionManager().getServer();
	}
	
	protected final File getFile() {
		return file;
	}
	
	@Override
	public final File getDataFolder() {
		return dataFolder;
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
