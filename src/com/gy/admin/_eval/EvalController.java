package com.gy.admin._eval;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseController;
import com.gy.common.entity.Eval;

public class EvalController extends BaseController {

	public void index() {

		setTitle("用户评价");

		setList(Net.INSTANCE.getListFromBmob(Eval.class, "doctor", "author"));

		render("index.html");

	}

	public void delete(String id) {

		vailT(id);

		if (Net.INSTANCE.deleteToBmob(Eval.class, id)) {
			setTip("删除成功！");
		} else {
			setTip("删除失败！");
		}

		forwardAction("/eval");

	}

}
