package net.minecrell.permissionsx.api.event.module;

import net.minecrell.permissionsx.api.module.PermissionModule;

import org.bukkit.event.HandlerList;

public class ModuleDisableEvent extends ModuleEvent {
	private static final HandlerList handlers = new HandlerList();

	public ModuleDisableEvent(final PermissionModule module) {
		super(module);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
