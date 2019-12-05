package com.gy.admin.net;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.gy.common.entity.User;
import com.gy.common.utils.Utils;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.upload.UploadFile;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public enum Net {

	INSTANCE;

	protected Logger log = Logger.getLogger(Net.class);

	public static final String X_Bmob_Application_Id = "a6b5c8f2bc82c0129c1efceb81c91899";

	public static final String X_Bmob_REST_API_Key = "ffa211710f9cbd01a84dc717f75374f4";

	public static final String X_Bmob_Master_Key = "441c7625f35dc15289fb430cce84f67e";

	/** GET */
	public static final String LOGIN_URL = "https://api2.bmob.cn/1/login";

	/** GET PUT DELETE */
	public static final String QUERY_UPDATE_DELETE = "https://api2.bmob.cn/1/classes/";

	/** POST */
	public static final String UPLOAD_FILE = "https://api2.bmob.cn/2/files/";

	/** GET */
	public static final String _USER = "https://api2.bmob.cn/1/users";

	private static OkHttpClient CLIENT = new OkHttpClient();

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public static final MediaType JPEG = MediaType.parse("image/jpeg");

	public static final Builder BUILDER = new Request.Builder()
			.addHeader("X-Bmob-Application-Id", X_Bmob_Application_Id)
			.addHeader("X-Bmob-REST-API-Key", X_Bmob_REST_API_Key).addHeader("Content-Type", "application/json");

	public <T> String makeBeanToString(T t) {
		return JSONObject.toJSONString(t);
	}

	public Ret toLogin(String username, String password) {

		Request request = BUILDER.url(LOGIN_URL + "?username=" + username + "&password=" + password).get().build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			if (response == null) {
				return Ret.fail();
			}

			String text = null;

			try {
				text = response.body().string();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (text == null) {
				return Ret.fail();
			}

			log.warn(text);

			Ret msg = response.code() == 200 ? Ret.ok() : Ret.fail();

			msg.set("value", text);

			return msg;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.close();
		}

		return Ret.fail();

	}

	public <T> List<T> getListFromBmob(Class<T> clazz, String... include) {

		String url = QUERY_UPDATE_DELETE + clazz.getSimpleName().toLowerCase() + Utils.INSTANCE.analInclude(include);

		Request request = BUILDER.url(url).get().build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			JSONObject json = JSONObject.parseObject(text);

			return JSONObject.parseArray(json.get("results").toString(), clazz);

		} catch (Exception e) {
			return null;
		} finally {
			response.close();
		}
	}

	public <T> List<T> getListFromBmobWithWhere(Class<T> clazz, JSONObject object) {

		String url = QUERY_UPDATE_DELETE + clazz.getSimpleName().toLowerCase() + Utils.INSTANCE.analWhere(object);

		Request request = BUILDER.url(url).get().build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			JSONObject json = JSONObject.parseObject(text);

			return JSONObject.parseArray(json.get("results").toString(), clazz);

		} catch (Exception e) {
			return null;
		} finally {
			response.close();
		}
	}

	public <T> List<T> getUserListFromBmob(Class<T> clazz) {

		Request request = BUILDER.url(_USER).get().build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			JSONObject json = JSONObject.parseObject(text);

			return JSONObject.parseArray(json.get("results").toString(), clazz);

		} catch (Exception e) {
			return null;
		} finally {
			response.close();
		}
	}

	public <T> T getOneUserFromBmob(Class<T> clazz, String objectId) {

		String url = _USER + "/" + objectId;

		Request request = BUILDER.url(url).get().build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			return JSONObject.parseObject(text, clazz);

		} catch (Exception e) {
			return null;
		} finally {
			response.close();
		}
	}

	public <T> T getOneFromBmob(Class<T> clazz, String objectId, String... include) {

		String url = QUERY_UPDATE_DELETE + clazz.getSimpleName().toLowerCase() + "/" + objectId
				+ Utils.INSTANCE.analInclude(include);

		Request request = BUILDER.url(url).get().build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			return JSONObject.parseObject(text, clazz);

		} catch (Exception e) {
			return null;
		} finally {
			response.close();
		}

	}

	public String upLoadFileToBmob(UploadFile uploadFile) {

		String url = UPLOAD_FILE + uploadFile.getFileName();

		RequestBody r = RequestBody.create(JPEG, uploadFile.getFile());

		Request request = BUILDER.url(url).post(r).build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			return JSONObject.parseObject(text).get("url").toString();

		} catch (Exception e) {
			return null;
		} finally {
			response.close();
		}

	}

	public <T> boolean updateBeanToBmob(T t, String objectId) {

		String url = QUERY_UPDATE_DELETE + t.getClass().getSimpleName().toLowerCase() + "/" + objectId;

		if (t instanceof User) {

			url = QUERY_UPDATE_DELETE + "_User/" + objectId;

			BUILDER.addHeader("X-Bmob-Master-Key", X_Bmob_Master_Key);
		}

		RequestBody r = RequestBody.create(JSON, makeBeanToString(t));

		Request request = BUILDER.url(url).put(r).build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			return StrKit.notBlank(JSONObject.parseObject(text).get("updatedAt").toString());

		} catch (Exception e) {

			return false;

		} finally {
			response.close();
		}

	}

	public <T> boolean addBeanToBmob(T t) {

		String url = QUERY_UPDATE_DELETE + t.getClass().getSimpleName().toLowerCase();

		if (t instanceof User) {

			url = QUERY_UPDATE_DELETE + "_User/";

			BUILDER.addHeader("X-Bmob-Master-Key", X_Bmob_Master_Key);
		}

		RequestBody r = RequestBody.create(JSON, makeBeanToString(t));

		Request request = BUILDER.url(url).post(r).build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			return StrKit.notBlank(JSONObject.parseObject(text).get("createdAt").toString());

		} catch (Exception e) {

			return false;

		} finally {
			response.close();
		}

	}

	public <K> boolean addRelationToBmob(Class<K> clazz, String objectId, String value) {

		String url = QUERY_UPDATE_DELETE + clazz.getSimpleName().toLowerCase() + "/" + objectId;

		RequestBody r = RequestBody.create(JSON, value);

		Request request = BUILDER.url(url).put(r).build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			return StrKit.notBlank(JSONObject.parseObject(text).get("msg").toString());

		} catch (Exception e) {

			return false;

		} finally {
			response.close();
		}

	}

	public <T> boolean deleteToBmob(Class<T> clazz, String objectId) {

		String url = QUERY_UPDATE_DELETE + clazz.getSimpleName().toLowerCase() + "/" + objectId;

		Request request = BUILDER.url(url).delete().build();

		Response response = null;

		try {
			response = CLIENT.newCall(request).execute();

			String text = response.body().string();

			log.warn(text);

			return StrKit.notBlank(JSONObject.parseObject(text).get("msg").toString());

		} catch (Exception e) {

			return false;

		} finally {
			response.close();
		}

	}

}
