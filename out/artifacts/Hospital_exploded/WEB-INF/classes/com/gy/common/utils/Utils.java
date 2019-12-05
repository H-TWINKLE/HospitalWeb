package com.gy.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.Base64Kit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

public enum Utils {

	INSTANCE;

	/** 加密 */
	public String encryptionBy64(String value) {

		return Base64Kit.encode(value);

	}

	/** 解密 */
	public String decryptBy64(String value) {

		return Base64Kit.decodeToStr(value);

	}

	public Ret transDataFromBmob(Ret r) {

		String text = r.getStr("value");

		if (StrKit.isBlank(text)) {
			return r;
		}

		JSONObject json = JSONObject.parseObject(text);

		return r.set(json);

	}

	/** 增加一对一关联查询 */
	public String analInclude(String... include) {

		if (include == null) {
			return "";
		}

		StringBuffer s = new StringBuffer();

		s.append("?include=");

		for (int x = 0; x < include.length; x++) {

			s.append(include[x]);

			if (x < include.length) {
				s.append(",");
			}

		}

		return s.toString();

	}

	/** 增加条件查询 */
	public String analWhere(JSONObject json) {
		try {
			return URLEncoder.encode("?where=" + json.toJSONString(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}

	}

	/** 增加一对多关联查询 */
	public String analRelatedTo() {

		return "";

	}


}
