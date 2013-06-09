package net.minecrell.permissionsplusplus.api.module;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public final class ModuleLogger extends Logger {
	private final String prefix;

	protected ModuleLogger(final PermissionModule module) {
		super(module.getClass().getCanonicalName(), null);
		this.setParent(module.getPermissionManager().getLogger());

		prefix = new StringBuilder().append("[").append(module.getName()).append("]").toString();
		this.setLevel(Level.ALL);
	}

	@Override
	public void log(final LogRecord record) {
		record.setMessage(prefix + record.getMessage());
		this.getParent().log(record);
	}
}
