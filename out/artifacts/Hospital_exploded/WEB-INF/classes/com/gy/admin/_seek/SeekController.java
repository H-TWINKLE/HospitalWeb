package com.gy.admin._seek;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseController;
import com.gy.common.entity.Seek;
import com.gy.common.entity.User;
import com.gy.common.utils.Constant;
import com.jfinal.kit.StrKit;

public class SeekController extends BaseController {

	public void index() {

		setTitle("就诊情况");

		setList(Net.INSTANCE.getListFromBmob(Seek.class, "user", "doctor"));

		render("index.html");

	}

	public void delete(String id) {

		vailT(id);

		if (Net.INSTANCE.deleteToBmob(Seek.class, id)) {
			setTip("删除成功！");
		} else {
			setTip("删除失败！");
		}

		forwardAction("/seek");

	}

	public void add(String id) {

		vailT(id);

		Seek s = new Seek();

		if (StrKit.notBlank(getPara("what")))
			s.setContent(getPara("what"));

		if (StrKit.notBlank(getPara("progress")))
			s.setProgress(getPara("progress"));

		s.setDoctor(new User(Constant._type_Pointer, getUser().getObjectId()));

		setDefaultTipByFlag(Net.INSTANCE.updateBeanToBmob(s, id));

		forwardAction("/seek");

	}

}
