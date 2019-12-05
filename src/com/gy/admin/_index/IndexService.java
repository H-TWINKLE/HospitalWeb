package com.gy.admin._index;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.gy.admin.net.Net;
import com.gy.common.base.BaseService;
import com.gy.common.entity.User;
import com.gy.common.model.Menu;
import com.gy.common.utils.Constant;
import com.jfinal.kit.Ret;

public class IndexService extends BaseService {

	public User toLogin(String account, String pass) {

		Ret r = Net.INSTANCE.toLogin(account, pass);

		if (r.isFail()) {
			return null;
		}

		return JSONObject.parseObject(r.getStr("value"), User.class);

	}

	public List<Menu> getUserMenu(Integer plate) {

		if (plate == null)
			plate = 0;

		switch (plate) {
		case Constant.STYLE_AS_DOCTOR:

			return Menu.dao.find("select * from menu where menuPlate=?", plate);
		case Constant.STYLE_AS_ADMIN:

			return Menu.dao.find("select * from menu");

		default:
			return null;
		}

	}

}
