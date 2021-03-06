package net.minecrell.permissionsplusplus.api.event.module;

import net.minecrell.permissionsplusplus.api.module.PermissionModule;

import org.bukkit.event.HandlerList;

public class ModuleEnableEvent extends ModuleEvent {
	private static final HandlerList handlers = new HandlerList();

	public ModuleEnableEvent(final PermissionModule module) {
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
