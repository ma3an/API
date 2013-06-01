package net.minecrell.permissionsx.api.event.module;

import net.minecrell.permissionsx.api.event.PermissionsEvent;
import net.minecrell.permissionsx.api.module.PermissionModule;

public abstract class ModuleEvent extends PermissionsEvent {
	private final PermissionModule module;
	
	public ModuleEvent(PermissionModule module) {
		this.module = module;
	}
	
	public PermissionModule getModule() {
		return module;
	}

}
