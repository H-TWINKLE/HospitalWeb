package com.gy.common.config;

import com.gy.admin._department.DepartmentController;
import com.gy.admin._eval.EvalController;
import com.gy.admin._feedback.FeedBackController;
import com.gy.admin._guahao.GuahaoController;
import com.gy.admin._index.IndexController;
import com.gy.admin._news.NewsController;
import com.gy.admin._notice.NoticeController;
import com.gy.admin._seek.SeekController;
import com.gy.admin._user.UserController;
import com.gy.common.interceptor.GobalInterceptor;
import com.gy.common.model._MappingKit;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class MainConfig extends JFinalConfig {
	/**
	 * 配置JFinal常量
	 */
	@Override
	public void configConstant(Constants me) {
		PropKit.use("config.properties");
		me.setDevMode(PropKit.getBoolean("devMode"));
		me.setBaseUploadPath("upload/temp/");
		me.setBaseDownloadPath("upload/temp/");
		me.setViewType(ViewType.JFINAL_TEMPLATE);
		me.setError404View("/comm/_404.html");
		me.setError500View("/comm/_500.html");
		me.setJsonFactory(MixedJsonFactory.me());
		me.setInjectDependency(true);

	}

	/**
	 * 配置JFinal路由映射
	 */
	@Override
	public void configRoute(Routes me) {

		me.setBaseViewPath("admin");

		me.add("/", IndexController.class, "/_index");
		me.add("/news", NewsController.class, "/_news");
		me.add("/user", UserController.class, "/_user");
		me.add("/eval", EvalController.class, "/_eval");
		me.add("/seek", SeekController.class, "/_seek");
		me.add("/notice", NoticeController.class, "/_notice");
		me.add("/feedback", FeedBackController.class, "/_feedback");
		me.add("/guahao", GuahaoController.class, "/_register");
		me.add("/department", DepartmentController.class, "/_department");

	}

	/**
	 * 配置JFinal插件 数据库连接池 ORM 缓存等插件 自定义插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		// 配置数据库连接池插件
		DruidPlugin dbPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
		// orm映射 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dbPlugin);
		arp.setShowSql(PropKit.getBoolean("devMode"));
		arp.setDialect(new MysqlDialect());
		dbPlugin.setDriverClass("com.mysql.jdbc.Driver");
		/******** 在此添加数据库 表-Model 映射 *********/
		// 如果使用了JFinal Model 生成器 生成了BaseModel 把下面注释解开即可
		_MappingKit.mapping(arp);

		// 添加到插件列表中
		me.add(dbPlugin);
		me.add(arp);
		//me.add(new EhCachePlugin());
	}

	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		me.addGlobalActionInterceptor(new SessionInViewInterceptor());
		me.add(new GobalInterceptor());
	}

	/**
	 * 配置全局处理器
	 */
	@Override
	public void configHandler(Handlers me) {

		me.add(new ContextPathHandler("base"));
	}

	/**
	 * 配置模板引擎
	 */
	@Override
	public void configEngine(Engine me) {

		me.setDevMode(PropKit.getBoolean("devMode"));
		me.addSharedFunction("/comm/_commLayout.html");
	}

	public static void main(String[] args) {
		JFinal.start("WebRoot", 520, "/", 5);
	}

}