package com.gy.admin._user;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseController;
import com.gy.common.entity.Department;
import com.gy.common.entity.User;
import com.gy.common.utils.Constant;
import com.jfinal.kit.StrKit;
import com.jfinal.upload.UploadFile;

public class UserController extends BaseController {

	public void index() {

		setTitle("用户信息");

		setList(Net.INSTANCE.getUserListFromBmob(User.class));

		render("index.html");

	}

	public void add() {

		setTitle("新增医生");

		setAttr("dli", Net.INSTANCE.getListFromBmob(Department.class));

		render("add.html");

	}

	public void edit(String id) {

		User u = null;

		if (StrKit.notBlank(id)) {
			u = Net.INSTANCE.getOneUserFromBmob(User.class, id);
		}

		if (u != null) {
			setAttr("u", u);
		}

		setTitle("修改用户");
		
		setAttr("dli", Net.INSTANCE.getListFromBmob(Department.class));

		render("edit.html");

	}

	public void update() {

		getFile();

		User u = getBean(User.class, "u");

		UploadFile f = getFile("pic");

		if (f != null) {
			u.setHeaderPic(Net.INSTANCE.upLoadFileToBmob(f));
		}

		String departmentId = getPara("departmentId");

		if (StrKit.notBlank(departmentId)) {
			u.setDepartment(new Department(Constant._type_Pointer, departmentId));
		}

		boolean flag = false;

		String val = getPara("val");

		if (StrKit.isBlank(val)) {
			
			u.setUsername(System.currentTimeMillis() + "");
			u.setPassword(Constant.DEFAULT_PASS);
			u.setPass(Constant.DEFAULT_PASS);
			flag = Net.INSTANCE.addBeanToBmob(u);
		} else {
			flag = Net.INSTANCE.updateBeanToBmob(u, val);
		}

		if (flag) {
			setTip("操作成功！");
		} else {
			setTip("操作失败！");
		}

		forwardAction("/user");

	}

}
