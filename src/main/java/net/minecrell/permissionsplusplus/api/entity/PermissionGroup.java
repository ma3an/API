package net.minecrell.permissionsplusplus.api.entity;

import java.util.List;

import net.minecrell.permissionsplusplus.api.PermissionManager;
import net.minecrell.permissionsplusplus.api.meta.MetaDataHolder;

import org.bukkit.permissions.Permission;

/**
 * Represents a Specific Permission Group
 * @since 0.0.1a
 * @author MP5K
 * @version 0.0.1a
 */
public interface PermissionGroup extends MetaDataHolder {

	/**
	 * Returns the Groups Name
	 * @return the Name
	 */
	public abstract String getName();

	/**
	 * Returns the unique Group id
	 * @return the id
	 */
	public abstract int getID();

	/**
	 * Checks if the Group meets the Specific Permission Requirements.
	 * @param name the Permission to check
	 * @return true if the Permission could be found false otherwise
	 */
	public abstract boolean hasPermission(String name);

	/**
	 * Sets or unset's a Specific Permission
	 * @param name the Permission to set/unset
	 * @param flag true if the permission should be added false otherwise
	 */
	public abstract void setPermission(String name, boolean flag);

	/**
	 * Wrapper Function for: <code>setPermission({name} , true) </code>
	 * @param name the Permission to add
	 */
	public abstract void addPermission(String name);

	/**
	 * Wrapper Function for: <code>setPermission({name} , false) </code>
	 * @param name the Permission to remove
	 */
	public abstract void removePermission(String name);

	/**
	 * Returns every Online user in this Group
	 * @return the Players as a <code>ArrayList< PermissionUser ></code>
	 */
	public abstract List<PermissionUser> getUsers();

	/**
	 * Returns every Permission this Group has.
	 * @return the Permissions as a <code>ArrayList< Permission ></code>
	 */
	public abstract List<Permission> getPermissions();

	/**
	 * Reloads the current Group
	 */
	public abstract void reload();

	/**
	 * Returns the Permission Manager the Group is handled by.
	 * @return the Permission Manager, never null.
	 */
	public abstract PermissionManager getManager();

	// TODO: Documentation
	public abstract boolean containsUser(OfflinePermissionUser user);

	public abstract void setUser(OfflinePermissionUser user, boolean flag);

	public abstract void addUser(OfflinePermissionUser user);

	public abstract void removeUser(OfflinePermissionUser user);

}
