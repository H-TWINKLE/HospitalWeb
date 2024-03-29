package com.gy.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseMenu<M extends BaseMenu<M>> extends Model<M> implements IBean {

	public M setMenuId(java.lang.Integer menuId) {
		set("menuId", menuId);
		return (M)this;
	}
	
	public java.lang.Integer getMenuId() {
		return getInt("menuId");
	}

	public M setMenuTitle(java.lang.String menuTitle) {
		set("menuTitle", menuTitle);
		return (M)this;
	}
	
	public java.lang.String getMenuTitle() {
		return getStr("menuTitle");
	}

	public M setMenuUrl(java.lang.String menuUrl) {
		set("menuUrl", menuUrl);
		return (M)this;
	}
	
	public java.lang.String getMenuUrl() {
		return getStr("menuUrl");
	}

	public M setMenuPlate(java.lang.Integer menuPlate) {
		set("menuPlate", menuPlate);
		return (M)this;
	}
	
	public java.lang.Integer getMenuPlate() {
		return getInt("menuPlate");
	}

}
