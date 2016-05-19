package com.ld_zxb.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ld_zxb.vo.UserLoginBodyVo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

 
public class SerialUtils {
	static long startTime = 0l;
	static long endTime = 0l;
	
	
	/**
	 * 序列化对象
	 * 
	 * @param person
	 * @return
	 * @throws IOException
	 */
	public static String serialize(UserLoginBodyVo person) throws IOException {
		startTime = System.currentTimeMillis();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				byteArrayOutputStream);
		objectOutputStream.writeObject(person);
		String serStr = byteArrayOutputStream.toString("ISO-8859-1");
		serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
		objectOutputStream.close();
		byteArrayOutputStream.close();
		Log.d("serial", "serialize str =" + serStr);
		endTime = System.currentTimeMillis();
		Log.d("serial", "序列化耗时为:" + (endTime - startTime));
		return serStr;
	}
	/**
	 * 反序列化对象
	 * 
	 * @param str
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static   UserLoginBodyVo deSerialization(String str) throws IOException,
			ClassNotFoundException {
		startTime = System.currentTimeMillis();
		String redStr = java.net.URLDecoder.decode(str, "UTF-8");
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
				redStr.getBytes("ISO-8859-1"));
		ObjectInputStream objectInputStream = new ObjectInputStream(
				byteArrayInputStream);
		UserLoginBodyVo person = (UserLoginBodyVo) objectInputStream.readObject();
		objectInputStream.close();
		byteArrayInputStream.close();
		endTime = System.currentTimeMillis(); 
		Log.d("serial", "反序列化耗时为:" + (endTime - startTime));
		return person;
	}

	public void saveObject(String strObject,Context context) {
		SharedPreferences sp = context.getSharedPreferences("person", 0);
		Editor edit = sp.edit();
		edit.putString("person", strObject);
		edit.commit();
	}
 	public String getObject(Context context) {
		SharedPreferences sp = context.getSharedPreferences("person", 0);
		return sp.getString("person", null);
	}
	
}
