package com.gy.admin._notice;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseController;
import com.gy.common.entity.Notice;
import com.gy.common.entity.User;
import com.gy.common.utils.Constant;
import com.jfinal.kit.StrKit;

public class NoticeController extends BaseController {

	public void index() {

		setTitle("公告");

		setList(Net.INSTANCE.getListFromBmob(Notice.class, "author"));

		render("index.html");

	}

	public void edit(String id) {

		Notice n = null;

		if (StrKit.notBlank(id)) {
			n = Net.INSTANCE.getOneFromBmob(Notice.class, id);
		}

		if (n != null) {
			setAttr("n", n);
		}

		setTitle("修改消息");

		render("edit.html");

	}

	public void update() {

		Notice n = getBean(Notice.class, "n");
		n.setAuthor(new User(Constant._type_Pointer, getUser().getObjectId()));

		boolean flag = false;

		String val = getPara("val");

		if (StrKit.isBlank(val)) {
			flag = Net.INSTANCE.addBeanToBmob(n);
		} else {
			flag = Net.INSTANCE.updateBeanToBmob(n, val);
		}

		if (flag) {
			setTip("操作成功！");
		} else {
			setTip("操作失败！");
		}

		forwardAction("/notice");

	}

	public void delete(String id) {

		vailT(id);

		if (Net.INSTANCE.deleteToBmob(Notice.class, id)) {
			setTip("删除成功！");
		} else {
			setTip("删除失败！");
		}

		forwardAction("/notice");

	}

}
