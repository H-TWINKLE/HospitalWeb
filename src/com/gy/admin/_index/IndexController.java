package com.gy.admin._index;

import java.util.List;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseController;
import com.gy.common.entity.Hospital;
import com.gy.common.entity.User;
import com.gy.common.interceptor.GobalInterceptor;
import com.gy.common.model.Menu;
import com.gy.common.utils.Constant;
import com.gy.common.utils.Utils;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.kit.StrKit;
import com.jfinal.upload.UploadFile;

public class IndexController extends BaseController {

	@Inject
	IndexService service;

	public void index() {

		setTitle("医疗管理系统");

		setSessionMenu();

		setList(Net.INSTANCE.getListFromBmob(Hospital.class, "department", "doctor"));

		render("index.html");

	}

	@Clear(GobalInterceptor.class)
	public void login() {

		setTitle("医疗管理系统 - 登录");

		if (toLoginByCookies()) {
			redirect("/");
			return;
		}

		render("login.html");

	}

	@Clear(GobalInterceptor.class)
	public void toLogin(String account, String password, Integer remember) {

		User u = service.toLogin(account, password);

		if (u == null) {
			setTip("用户名或者密码错误！");
			forwardAction("/login");
			return;
		}

		if (remember != null && remember == 1) {
			saveUserToCookies(account, password);
		}

		setUser(u);

		redirect("/");

	}

	@Clear(GobalInterceptor.class)
	public void logOut() {

		removeSessionAttr("user");

		removeSessionAttr("menu");

		removeCookie(Constant.COOKIES_NAME);

		redirect("/login");

	}

	public void edit(String id) {

		Hospital h = null;

		if (StrKit.notBlank(id)) {
			h = Net.INSTANCE.getOneFromBmob(Hospital.class, id);
		}

		if (h != null) {
			setAttr("h", h);
		}

		setTitle("修改医院");

		render("edit.html");

	}

	public void update() {

		getFile();

		Hospital h = getBean(Hospital.class, "h");

		UploadFile f = getFile("pic");

		if (f != null) {
			h.setPic(Net.INSTANCE.upLoadFileToBmob(f));
		}

		boolean flag = false;

		String val = getPara("val");

		if (StrKit.isBlank(val)) {
			flag = Net.INSTANCE.addBeanToBmob(h);
		} else {
			flag = Net.INSTANCE.updateBeanToBmob(h, val);
		}

		if (flag) {
			setTip("操作成功！");
		} else {
			setTip("操作失败！");
		}

		forwardAction("/");

	}

	protected void saveUserToCookies(String account, String pass) {

		String value = Utils.INSTANCE.encryptionBy64(account) + "," + Utils.INSTANCE.encryptionBy64(pass);

		setCookie(Constant.COOKIES_NAME, value, Constant.COOKIES_DEFAULT_TIME);
	}

	protected boolean toLoginByCookies() {

		String cookies = getCookie(Constant.COOKIES_NAME);

		if (cookies == null)
			return false;

		String[] value = cookies.split(",");

		if (value.length != 2) {
			return false;
		}

		String account = Utils.INSTANCE.decryptBy64(value[0]);

		String pass = Utils.INSTANCE.decryptBy64(value[1]);

		User u = service.toLogin(account, pass);

		if (u != null) {
			setUser(u);
			return true;
		}

		return false;

	}

	private void setSessionMenu() {

		List<Menu> list = getSessionAttr("menu");

		if (list == null) {
			setSessionAttr("menu", service.getUserMenu(getUser().getPlate()));
		}

	}

}
