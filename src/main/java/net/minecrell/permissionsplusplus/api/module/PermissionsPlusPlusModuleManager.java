package net.minecrell.permissionsplusplus.api.module;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecrell.permissionsplusplus.api.PermissionManager;

import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.UnknownDependencyException;

public final class PermissionsPlusPlusModuleManager implements ModuleManager {
	private final PermissionManager permissionManager;

	private final Map<String, PermissionModule> modules = new HashMap<String, PermissionModule>();

	public PermissionsPlusPlusModuleManager(final PermissionManager permissionManager) {
		this.permissionManager = permissionManager;
	}

	@Override
	public PermissionManager getPermissionManager() {
		return permissionManager;
	}

	private Logger getLogger() {
		return this.getPermissionManager().getLogger();
	}

	private Server getServer() {
		return this.getPermissionManager().getServer();
	}

	private PluginManager getPluginManager() {
		return this.getServer().getPluginManager();
	}

	@Override
	public PermissionModule getModule(final String moduleName) {
		return modules.get(moduleName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <Module> Module getModule(final String moduleName, final Class<? extends PermissionModule> moduleClass) {
		return (Module) this.getModule(moduleName);
	}

	@Override
	public PermissionModule[] getModules() {
		return modules.values().toArray(new PermissionModule[modules.values().size()]);
	}

	@Override
	public PermissionModule loadModule(final String fileName) throws InvalidModuleException, UnknownDependencyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionModule[] loadModules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableModule(final PermissionModule module) {
		if (!module.isEnabled()) {
			// TODO: Commands

			try {
				module.getModuleLoader().enableModule(module);
			} catch (final Throwable t) {
				this.getLogger().log(Level.SEVERE, "Error occured (in the module loader) while enabling " + module.getName() + " (Is it up to date?)", t);
			}
		}
	}

	@Override
	public void disableModule(final PermissionModule module) {
		if (module.isEnabled()) {
			final String moduleName = module.getName();

			try {
				module.getModuleLoader().disableModule(module);
			} catch (final Throwable t) {
				this.getLogger().log(Level.SEVERE, "Error occurred while disabling " + moduleName + " (Is it up to date?)", t);
			}

			try {
				this.getServer().getScheduler().cancelTasks(module);
			} catch (final Throwable t) {
				this.getLogger().log(Level.SEVERE, "Error occurred while cancelling tasks for " + moduleName + " (Is it up to date?)", t);
			}

			try {
				this.getServer().getServicesManager().unregisterAll(module);
			} catch (final Throwable t) {
				this.getLogger().log(Level.SEVERE, "Error occurred while unregistering services for " + moduleName + " (Is it up to date?)", t);
			}

			try {
				HandlerList.unregisterAll(module);
			} catch (final Throwable t) {
				this.getLogger().log(Level.SEVERE, "Error occurred while unregistering events for " + moduleName + " (Is it up to date?)", t);
			}

			try {
				this.getServer().getMessenger().unregisterIncomingPluginChannel(module);
				this.getServer().getMessenger().unregisterOutgoingPluginChannel(module);
			} catch (final Throwable t) {
				this.getLogger().log(Level.SEVERE, "Error occurred while unregistering plugin channels for " + moduleName + " (Is it up to date?)", t);
			}
		}
	}

	@Override
	public boolean isModuleEnabled(final String moduleName) {
		return this.isModuleEnabled(this.getModule(moduleName));
	}

	@Override
	public boolean isModuleEnabled(final PermissionModule module) {
		if (module != null && modules.containsValue(module))
			return module.isEnabled();

		return false;
	}

	@Override
	public void disableModules() {
		for (final PermissionModule module : modules.values()) {
			this.disableModule(module);
		}
	}

	@Override
	public void clearModules() {
		this.disableModules();
		modules.clear();
	}

	@Override
	public void callEvent(final Event event) throws IllegalStateException {
		this.getPluginManager().callEvent(event);
	}

	@Override
	public void registerEvents(final Listener listener, final PermissionModule module) {
		this.getPluginManager().registerEvents(listener, module);
	}

}
