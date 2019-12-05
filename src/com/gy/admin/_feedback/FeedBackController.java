package com.gy.admin._feedback;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseController;
import com.gy.common.entity.Opinion;
import com.gy.common.entity.User;
import com.gy.common.utils.Constant;

public class FeedBackController extends BaseController {

	public void index() {

		setTitle("意见反馈");

		setList(Net.INSTANCE.getListFromBmob(Opinion.class, "user", "admin"));

		render("index.html");

	}

	public void delete(String id) {

		vailT(id);

		if (Net.INSTANCE.deleteToBmob(Opinion.class, id)) {
			setTip("删除成功！");
		} else {
			setTip("删除失败！");
		}

		forwardAction("/feedback");

	}

	public void add(String id, String what) {

		vailT(id);

		vailT(what);

		Opinion o = new Opinion();
		o.setReplay(what);
		o.setAdmin(new User(Constant._type_Pointer, getUser().getObjectId()));

		setDefaultTipByFlag(Net.INSTANCE.updateBeanToBmob(o, id));

		forwardAction("/feedback");

	}

}
