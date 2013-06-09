/*
 * PermissionsPlusPlus - PermissionsPlusPlus Plugin Developer API
 * Copyright (C) 2013 PermissionsPlusPlus-Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.minecrell.permissionsplusplus.api;

import java.util.logging.Logger;

import net.minecrell.permissionsplusplus.api.entity.OfflinePermissionUser;
import net.minecrell.permissionsplusplus.api.entity.PermissionGroup;
import net.minecrell.permissionsplusplus.api.entity.PermissionUser;
import net.minecrell.permissionsplusplus.api.module.ModuleManager;

import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Main Interface to work with the PermissionPlusPlus API
 * @since 0.0.1a
 * @author MP5K
 * @version 0.0.1a
 */
public interface PermissionManager {

	/**
	 * Returns the current Logger with is used to Log Messages
	 * @return the current Logger
	 */
	public Logger getLogger();

	/**
	 * Returns the Name of the PermissionsPlusPlus implementation
	 * @return by default: <code>PermissionsPlusPlus</code>
	 */
	public String getName();

	/**
	 * Returns the Version of the PermissionsPlusPlus implementation
	 * @return the Version by default in the Format: <br>
	 *         <code>{major version}.{minor version}.{patch version}</code>
	 */
	public String getVersion();

	/**
	 * Returns the Plugin the Permission Manager is integrated to.
	 * @return the Plugin instance
	 */
	public PermissionPlugin getContainer();

	// TODO: Javadocs
	public Server getServer();

	public ModuleManager getModuleManager();

	/**
	 * Enables the Permission Manager
	 * @throws java.lang.IllegalStateException if the Plugin already enabled.
	 */
	public void enable() throws IllegalStateException;

	/**
	 * Disables the Permission Manager
	 * @throws IllegalStateException
	 */
	public void disable() throws IllegalStateException;

	/**
	 * Reload the Manager (e.g. Configuration Files)
	 * @param everything if everything (e.g. Commands and Listeners should be
	 *            reloaded to.
	 * @return true if the reload was successfull false otherwise
	 */
	public abstract boolean reload(boolean everything);

	/**
	 * Returns a Specific User identified by his username.
	 * @param name the Username you wan't to the the Player from
	 * @return the User, may be null if the user can't be found or is not online
	 * @see net.minecrell.permissionsplusplus.api.entity.PermissionUser
	 */
	public PermissionUser getUser(String name);

	/**
	 * Returns a Specific User identified by his username.
	 * @param name the Username you wan't to the the Player from
	 * @return the User, may be null if the user can't be found
	 * @see net.minecrell.permissionsplusplus.api.entity.PermissionUser
	 */
	public OfflinePermissionUser getOfflineUser(String name);

	/**
	 * Returns a Specific Player identified by his username.
	 * @param name the Username you wan't to the the Player from
	 * @return the User, may be null if the user can't be found
	 * @see org.bukkit.entity.Player
	 */
	public Player getPlayer(String name);

	/**
	 * Returns a Specific Group identified by it's Group name
	 * @param name the Group name
	 * @return the Group instance. null if the group couldnt be found.
	 */
	public PermissionGroup getGroup(String name);

	/**
	 * Returns the Configuration File used to load the Preferences from.
	 * @return the Config file instance never null
	 */
	public FileConfiguration getConfiguration();

	/**
	 * Saves everything to the Disk.
	 * @throws java.lang.RuntimeException if a IOException occurs.
	 */
	public void saveAll();

}
