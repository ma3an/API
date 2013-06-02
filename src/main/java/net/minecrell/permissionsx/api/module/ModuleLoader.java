package net.minecrell.permissionsx.api.module;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.plugin.UnknownDependencyException;

public interface ModuleLoader {

	public PermissionModule loadModule(File file) throws InvalidModuleException, UnknownDependencyException;

	public void enableModule(PermissionModule module);

	public void disableModule(PermissionModule module);

	public InputStream getResource(PermissionModule module, String fileName) throws IOException;

	public boolean saveResource(PermissionModule module, String resourcePath, boolean replace) throws IOException;
}
