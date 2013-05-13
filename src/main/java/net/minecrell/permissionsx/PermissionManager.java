package net.minecrell.permissionsx;

import java.util.logging.Logger;

import net.minecrell.permissionsx.entity.OfflinePermissionUser;
import net.minecrell.permissionsx.entity.PermissionUser;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Main Interface to work with the PermissionX API
 * @since 0.0.1a
 * @author MP5K
 * @version 0.0.1a
 */
public interface PermissionManager {

	/**
	 * Returns the current Logger with is used to Log Messages
	 * @return the current Logger
	 */
	public abstract Logger getLogger();
	
	/**
	 * Returns the Name of the PermissionsX implementation 
	 * @return by default: <code>CraftPermissionsX</code>
	 */
	public abstract String getName();
	
	/**
	 * Returns the Version of the PermissionsX implementation
	 * @return the Version by default in the Format: <br>
	 * <code>{major version}.{minor version}.{patch version}</code>
	 */
	public abstract String getVersion();
	
	/**
	 * Returns the Plugin the Permission Manager is integrated to.
	 * @return the Plugin instance
	 */
	public abstract Plugin getContainer();
	
	/**
	 * Enables the Permission Manager
	 * @throws java.lang.IllegalStateException if the Plugin already enabled.
	 */
	public abstract void enable() throws IllegalStateException ;
	
	/**
	 * Disables the Permission Manager
	 * @throws IllegalStateException
	 */
	public abstract void disable() throws IllegalStateException;
	
	/**
	 * Reload the Manager (e.g. Configuration Files)
	 * @param everything if everything (e.g. Commands and Listeners should be reloaded to.
	 * @return true if the reload was successfull false otherwise
	 */
	public abstract boolean reload(boolean everything);
	
	/**
	 * Returns a Specific User identified by his username.
	 * @param name the Username you wan't to the the Player from
	 * @return the User, may be null if the user can't be found or is not online
	 * @see net.minecrell.permissionsx.entity.PermissionUser
	 */
	public abstract PermissionUser getUser(String name);
	
	/**
	 * Returns a Specific User identified by his username.
	 * @param name the Username you wan't to the the Player from
	 * @return the User, may be null if the user can't be found
	 * @see net.minecrell.permissionsx.entity.PermissionUser
	 */
	public abstract OfflinePermissionUser getOfflineUser(String name);
	
	/**
	 * Returns a Specific Player identified by his username.
	 * @param name the Username you wan't to the the Player from
	 * @return the User, may be null if the user can't be found
	 * @see org.bukkit.entity.Player
	 */
	public abstract Player getPlayer(String name);
	
	
	/**
	 * Returns the Configuration File used to load the Preferences from.
	 * @return the Config file instance never null
	 */
	public abstract FileConfiguration getConfiguration();
	
	/**
	 * Saves everything to the Disk. 
	 * @throws java.lang.RuntimeException if a IOException occurs.
	 */
	public abstract void saveAll();
	
}
