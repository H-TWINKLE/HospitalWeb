package com.gy.admin._news;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseController;
import com.gy.common.entity.Post;
import com.gy.common.entity.User;
import com.gy.common.utils.Constant;
import com.jfinal.kit.StrKit;

public class NewsController extends BaseController {


	public void index() {

		setTitle("动态推送");

		setList(Net.INSTANCE.getListFromBmob(Post.class, "author"));

		render("index.html");

	}

	public void edit(String id) {

		Post p = null;

		if (StrKit.notBlank(id)) {
			p = Net.INSTANCE.getOneFromBmob(Post.class, id);
		}

		if (p != null) {
			setAttr("p", p);
		}

		setTitle("修改消息");

		render("edit.html");

	}

	public void update() {

		Post p = getBean(Post.class, "p");
		
		User u = new User();
		u.set__type(Constant._type_Pointer);
		u.setObjectId(getUser().getObjectId());
		
		System.out.println(getUser().getObjectId());
		
		p.setAuthor(u);
		
		System.out.println(p);

		boolean flag = false;

		String val = getPara("val");
		

		if (StrKit.isBlank(val)) {
			flag = Net.INSTANCE.addBeanToBmob(p);
		} else {
			flag = Net.INSTANCE.updateBeanToBmob(p, val);
		}

		if (flag) {
			setTip("操作成功！");
		} else {
			setTip("操作失败！");
		}

		forwardAction("/news");

	}

	public void delete(String id) {

		vailT(id);

		if (Net.INSTANCE.deleteToBmob(Post.class, id)) {
			setTip("删除成功！");
		} else {
			setTip("删除失败！");
		}

		forwardAction("/news");

	}

}
