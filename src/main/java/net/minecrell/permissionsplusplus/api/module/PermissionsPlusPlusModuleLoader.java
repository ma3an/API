package net.minecrell.permissionsplusplus.api.module;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;

import net.minecrell.permissionsplusplus.api.event.module.ModuleEnableEvent;

import org.apache.commons.lang.Validate;
import org.bukkit.plugin.UnknownDependencyException;

public class PermissionsPlusPlusModuleLoader implements ModuleLoader {

	@Override
	public PermissionsPlusPlusModule loadModule(final File file) throws InvalidModuleException, UnknownDependencyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableModule(final PermissionModule module) {
		this.checkModule(module);

		if (!module.isEnabled()) {
			final String moduleName = module.getName();
			module.getLogger().info("Enabling " + moduleName + "...");

			final PermissionsPlusPlusModule xModule = (PermissionsPlusPlusModule) module;

			try {
				xModule.setEnabled(true);
			} catch (final Throwable t) {
				module.getLogger().log(Level.SEVERE, "Error occurred while enabling " + moduleName + " (Is it up to date?)", t);
			}

			module.getModuleManager().callEvent(new ModuleEnableEvent(module));
		}
	}

	@Override
	public void disableModule(final PermissionModule module) {
		this.checkModule(module);
		// TODO: Disable modules
	}

	private ClassLoader getClassLoader(final PermissionModule module) {
		this.checkModule(module);
		return ((PermissionsPlusPlusModule) module).getClassLoader();
	}

	@Override
	public InputStream getResource(final PermissionModule module, final String fileName) throws IOException {
		Validate.notEmpty(fileName);

		final URL url = this.getClassLoader(module).getResource(fileName);

		if (url == null)
			return null;

		final URLConnection connection = url.openConnection();
		connection.setUseCaches(false);
		return connection.getInputStream();
	}

	@Override
	public boolean saveResource(final PermissionModule module, String resourcePath, final boolean replace) throws IOException {
		Validate.notEmpty(resourcePath);
		resourcePath = resourcePath.replace('\\', '/');

		this.checkModule(module);
		final PermissionsPlusPlusModule xModule = (PermissionsPlusPlusModule) module;

		final InputStream i = this.getResource(module, resourcePath);
		if (i == null)
			throw new IllegalArgumentException("The embedded resource '" + resourcePath + "' cannot be found in " + xModule.getFile());

		final File outFile = new File(xModule.getDataFolder(), resourcePath);
		outFile.mkdirs();

		if (!outFile.exists() || replace) {
			final OutputStream o = new FileOutputStream(outFile);
			final byte[] buf = new byte[1024];
			int len;
			while ((len = i.read(buf)) > 0) {
				o.write(buf, 0, len);
			}
			o.close();
			i.close();

			return true;
		}

		return false;
	}

	private void checkModule(final PermissionModule module) {
		Validate.isTrue(module instanceof PermissionsPlusPlusModule, "Module is not associated with this ModuleLoader");
	}

}
