package com.gy.admin._department;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseController;
import com.gy.common.entity.Department;
import com.gy.common.entity.Hospital;
import com.gy.common.utils.Constant;
import com.jfinal.kit.StrKit;

public class DepartmentController extends BaseController {

	public void index() {

		setTitle("部门管理");

		setList(Net.INSTANCE.getListFromBmob(Department.class));

		render("index.html");

	}

	public void edit(String id) {

		Department d = null;

		if (StrKit.notBlank(id)) {
			d = Net.INSTANCE.getOneFromBmob(Department.class, id);
		}

		if (d != null) {
			setAttr("d", d);
		}

		setTitle("修改消息");

		render("edit.html");

	}

	public void update() {

		Department d = getBean(Department.class, "d");

		d.setHospital(new Hospital(Constant._type_Pointer, Constant.DEFAUTL_HOSPITAL_ID));

		boolean flag = false;

		String val = getPara("val");

		if (StrKit.isBlank(val)) {
			flag = Net.INSTANCE.addBeanToBmob(d);
		} else {
			flag = Net.INSTANCE.updateBeanToBmob(d, val);
		}

		if (flag) {
			setTip("操作成功！");
		} else {
			setTip("操作失败！");
		}

		forwardAction("/department");

	}

	public void delete(String id) {

		vailT(id);

		if (Net.INSTANCE.deleteToBmob(Department.class, id)) {
			setTip("删除成功！");
		} else {
			setTip("删除失败！");
		}

		forwardAction("/department");

	}

}
