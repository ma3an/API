package net.minecrell.permissionsx.api.meta;

import net.minecrell.permissionsx.api.PermissionManager;

public final class MetaData {

	private final String name;
	private final Object[] data = new Object[3];
	private final PermissionManager mgr;

	public MetaData(final PermissionManager mgr, final String name) {
		this.name = name;
		this.mgr = mgr;
	}

	public PermissionManager getManager() {
		return mgr;
	}

	public String getName() {
		return name;
	}

	private void set(final String name, final Object l) {
		data[0] = name;
		data[1] = l;
	}

	public void setLong(final Long l) {
		this.set("long", l);
	}

	public void setBoolean(final Boolean b) {
		this.set("boolean", b);
	}

	public void setInteger(final Integer i) {
		this.set("integer", i);
	}

	public void setShort(final Short s) {
		this.set("short", s);
	}

	public void setCharacter(final Character c) {
		this.set("character", c);
	}

	public void setString(final String str) {
		this.set("string", str);
	}

	public String getType() {
		return data[0].toString();
	}

	public Long getLong() {
		if ("long".equals(this.getType()))
			return (Long) data[1];
		return null;
	}

	public Boolean getBoolean() {
		if ("boolean".equals(this.getType()))
			return (Boolean) data[1];
		return null;
	}

	public Integer getInteger() {
		if ("integer".equals(this.getType()))
			return (Integer) data[1];
		return null;
	}

	public Short getShort() {
		if ("short".equals(this.getType()))
			return (Short) data[1];
		return null;
	}

	public Character getCharacter() {
		if ("character".equals(this.getType()))
			return (Character) data[1];
		return null;
	}

	public Byte getByte() {
		if ("byte".equals(this.getType()))
			return (Byte) data[1];
		return null;
	}

	public String getString() {
		if ("string".equals(this.getType())) {
			if (data[1] == null)
				return null;
			return data[1].toString();
		}
		return null;
	}

	public Object getObject() {
		return data[1];
	}

}
