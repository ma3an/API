package net.minecrell.permissionsx.api.module;

import net.minecrell.permissionsx.api.PermissionManager;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.UnknownDependencyException;

public final class PermissionsXModuleManager implements ModuleManager {
	
	// TODO: Implement ModuleManager
	
	private final PermissionManager permissionManager;
	
	public PermissionsXModuleManager(PermissionManager permissionManager) {
		this.permissionManager = permissionManager;
	}

	@Override
	public PermissionManager getPermissionManager() {
		return permissionManager;
	}
	
	private Plugin getPluginContainer() {
		return permissionManager.getContainer();
	}

	@Override
	public PermissionModule getModule(String moduleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Module> Module getModule(String moduleName, Class<? extends PermissionModule> moduleClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionModule[] getModules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionModule loadModule(String fileName) throws InvalidModuleException, UnknownDependencyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionModule[] loadModules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableModule(PermissionModule module) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableModule(PermissionModule module) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isModuleEnabled(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModuleEnabled(PermissionModule module) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void disableModules() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearModules() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void callEvent(Event event) throws IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerEvents(Listener listener, PermissionModule module) {
		// TODO Auto-generated method stub
		
	}

}
