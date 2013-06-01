package net.minecrell.permissionsx.api.event.module;

import org.bukkit.event.HandlerList;

import net.minecrell.permissionsx.api.module.PermissionModule;

public class ModuleEnableEvent extends ModuleEvent {
    private static final HandlerList handlers = new HandlerList();

	public ModuleEnableEvent(PermissionModule module) {
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
