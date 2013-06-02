package net.minecrell.permissionsx.api.module;

import net.minecrell.permissionsx.api.PermissionManager;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.UnknownDependencyException;

public interface ModuleManager {

	// TODO: Commands

	public PermissionManager getPermissionManager();

	public PermissionModule getModule(String moduleName);

	public <Module> Module getModule(String moduleName, Class<? extends PermissionModule> moduleClass);

	public PermissionModule[] getModules();

	public PermissionModule loadModule(String fileName) throws InvalidModuleException, UnknownDependencyException;

	public PermissionModule[] loadModules();

	public void enableModule(PermissionModule module);

	public void disableModule(PermissionModule module);

	public boolean isModuleEnabled(String moduleName);

	public boolean isModuleEnabled(PermissionModule module);

	public void disableModules();

	public void clearModules();

	public void callEvent(Event event) throws IllegalStateException;

	public void registerEvents(Listener listener, PermissionModule module);

}
