package net.minecrell.permissionsx.api.meta;

import net.minecrell.permissionsx.api.PermissionManager;

public final class MetaData {

	private String name;
	private Object[] data = new Object[3];
	private PermissionManager mgr;
	
	public MetaData(PermissionManager mgr ,String name){
		this.name = name;
		this.mgr = mgr;
	}
	
	public PermissionManager getManager(){
		return mgr;
	}
	
	public String getName(){
		return name;
	}
	
	private void set(String name , Object l){
		this.data[0] = name;
		this.data[1] = l;
	}
	
	public void setLong(Long l){
		set("long" ,l);
	}
	
	public void setBoolean(Boolean b){
		set("boolean" , b);
	}
	
	public void setInteger(Integer i){
		set("integer" ,i);
	}
	
	public void setShort(Short s){
		set("short" , s);
	}
	
	public void setCharacter(Character c){
		set("character" ,c);
	}
	
	public void setString(String str){
		set("string" , str);
	}
	
	public String getType(){
		return data[0].toString();
	}
	
	public Long getLong(){
		if("long".equals(getType())){
			return (Long) data[1];
		}
		return null;
	}
	
	public Boolean getBoolean(){
		if("boolean".equals(getType())){
			return (Boolean) data[1];
		}
		return null;
	}
	
	public Integer getInteger(){
		if("integer".equals(getType())){
			return (Integer) data[1];
		}
		return null;
	}
	
	public Short getShort(){
		if("short".equals(getType())){
			return (Short) data[1];
		}
		return null;
	}
	
	public Character getCharacter(){
		if("character".equals(getType())){
			return (Character) data[1];
		}
		return null;
	}
	
	public Byte getByte(){
		if("byte".equals(getType())){
			return (Byte) data[1];
		}
		return null;
	}
	
	public String getString(){
		if("string".equals(getType())){
			if(data[1] == null) return null;
			return data[1].toString();
		}
		return null;
	}
	
	public Object getObject(){
		return data[1];
	}
	
}
