package com.gy.common.base;

import java.util.List;

import com.gy.common.entity.User;
import com.jfinal.core.Controller;

public class BaseController extends Controller {

	protected void setTitle(String title) {
		setAttr("title", title);
	}

	protected void setTip(String tip) {
		setAttr("tip", tip);
	}

	protected Integer getDefaultName(Integer pages) {
		if (pages == null || pages == 0)
			return 1;
		return pages;

	}

	protected void setUser(User u) {
		setSessionAttr("user", u);
	}

	protected User getUser() {
		return getSessionAttr("user");
	}

	protected <T> void vailT(T t) {
		if (t == null) {
			renderError(404);
			return;
		}
	}

	protected void setList(List<?> list) {
		setAttr("list", list);
	}

	protected void setDefaultTipByFlag(boolean thing) {
		if (thing) {
			setTip("操作成功！");
		} else {
			setTip("操作失败！");
		}
	}

}
