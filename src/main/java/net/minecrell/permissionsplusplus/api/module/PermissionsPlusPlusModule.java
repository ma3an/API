package net.minecrell.permissionsplusplus.api.module;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import net.minecrell.permissionsplusplus.api.PermissionManager;
import net.minecrell.permissionsplusplus.api.PermissionPlugin;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import com.avaje.ebean.EbeanServer;

public class PermissionsPlusPlusModule implements PermissionModule {

	// TODO: Javadocs :(

	private ModuleManager moduleManager;
	private PermissionsPlusPlusModuleLoader moduleLoader;
	private ClassLoader classLoader;

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
		return moduleLoader;
	}

	final ClassLoader getClassLoader() {
		return classLoader;
	}

	protected final void initialize(final PermissionsPlusPlusModuleLoader loader, final ClassLoader classLoader, final ModuleManager moduleManager, final String moduleName, final File file, final File dataFolder) {
		if (!initialized) {
			initialized = true;

			moduleLoader = loader;
			this.classLoader = classLoader;

			this.moduleManager = moduleManager;

			this.moduleName = moduleName;

			this.file = file;
			this.dataFolder = dataFolder;

			logger = new ModuleLogger(this);
		}
	}

	public final boolean isInitialized() {
		return initialized;
	}

	@Override
	public void onEnable() {
	}

	@Override
	public void onDisable() {
	}

	@Override
	public final boolean isEnabled() {
		return isEnabled;
	}

	protected final void setEnabled(final boolean enabled) {
		if (isEnabled != enabled) {
			isEnabled = enabled;

			if (isEnabled) {
				this.onEnable();
			} else {
				this.onDisable();
			}
		}
	}

	@Override
	public final PermissionManager getPermissionManager() {
		if (this.getModuleManager() == null)
			return null;
		return this.getModuleManager().getPermissionManager();
	}

	@Override
	public final PermissionPlugin getPluginContainer() {
		if (this.getPermissionManager() == null)
			return null;
		return this.getPermissionManager().getContainer();
	}

	@Override
	public final Server getServer() {
		if (this.getPermissionManager() == null)
			return null;
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
	public final InputStream getResource(final String fileName) {
		try {
			return this.getModuleLoader().getResource(this, fileName);
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public final void saveResource(final String resourcePath) {
		this.saveResource(resourcePath, true);
	}

	@Override
	public final void saveResource(final String resourcePath, final boolean replace) {
		try {
			this.getModuleLoader().saveResource(this, resourcePath, replace);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FileConfiguration getConfig() {
		return this.getPluginContainer().getConfig();
	}

	@Override
	public EbeanServer getDatabase() {
		return this.getPluginContainer().getDatabase();
	}

	@Override
	public final ChunkGenerator getDefaultWorldGenerator(final String worldName, final String id) {
		return this.getPluginContainer().getDefaultWorldGenerator(worldName, id);
	}

	@Override
	public final PluginDescriptionFile getDescription() {
		return this.getPluginContainer().getDescription();
	}

	@Override
	public final PluginLoader getPluginLoader() {
		return this.getPluginContainer().getPluginLoader();
	}

	@Override
	public final boolean isNaggable() {
		return this.getPluginContainer().isNaggable();
	}

	@Override
	public final void onLoad() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void reloadConfig() {
		this.getPluginContainer().reloadConfig();
	}

	@Override
	public void saveConfig() {
		this.getPluginContainer().saveConfig();
	}

	@Override
	public void saveDefaultConfig() {
		this.getPluginContainer().saveDefaultConfig();
	}

	@Override
	public final void setNaggable(final boolean canNag) {
		this.getPluginContainer().setNaggable(canNag);
	}

	@Override
	public List<String> onTabComplete(final CommandSender sender, final Command cmd, final String alias, final String[] args) {
		return this.getPluginContainer().onTabComplete(sender, cmd, alias, args);
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		return this.getPluginContainer().onCommand(sender, cmd, label, args);
	}

}
