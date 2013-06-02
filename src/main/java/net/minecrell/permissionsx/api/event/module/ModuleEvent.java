package net.minecrell.permissionsx.api.event.module;

import net.minecrell.permissionsx.api.event.PermissionEvent;
import net.minecrell.permissionsx.api.module.PermissionModule;

public abstract class ModuleEvent extends PermissionEvent {
	private final PermissionModule module;

	public ModuleEvent(final PermissionModule module) {
		this.module = module;
	}

	public PermissionModule getModule() {
		return module;
	}

}
