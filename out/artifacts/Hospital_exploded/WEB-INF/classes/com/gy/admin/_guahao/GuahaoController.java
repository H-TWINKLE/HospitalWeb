package com.gy.admin._guahao;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseController;
import com.gy.common.entity.Register;

public class GuahaoController extends BaseController {
	
	public void index() {

		setTitle("挂号信息");

		setList(Net.INSTANCE.getListFromBmob(Register.class, "user", "department"));

		render("index.html");

	}
	
	public void add(String id,String what) {

		
		vailT(id);

		vailT(what);

		Register r = new Register();
		
		r.setProgress(what);

		setDefaultTipByFlag(Net.INSTANCE.updateBeanToBmob(r, id));

		forwardAction("/guahao");

	}
	
	
	
	public void delete(String id) {

		vailT(id);

		if (Net.INSTANCE.deleteToBmob(Register.class, id)) {
			setTip("删除成功！");
		} else {
			setTip("删除失败！");
		}

		forwardAction("/guahao");

	}
	

}
