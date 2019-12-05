package com.gy.admin._user;

import java.util.List;

import com.gy.admin.net.Net;
import com.gy.common.base.BaseService;
import com.gy.common.entity.Department;
import com.gy.common.utils.Constant;
import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.plugin.ehcache.IDataLoader;

public class UserService extends BaseService {

	public List<Department> getAllDepartmentByHospitalId(String objectId) {
		return CacheKit.get(Constant._CACHE_DEPARTMENT, "_hospital" + objectId, new IDataLoader() {

			@Override
			public Object load() {
				// TODO 自动生成的方法存根
				return Net.INSTANCE.getListFromBmob(Department.class);
			}
		});
	}
	
	

}
