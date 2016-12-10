package com.xrk.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.xrk.utils.exception.GMException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import net.sf.json.JSONArray;

public class FileUtil {
	private static String[] imageType = { "jpg", "png", "gif", "bmp", "jpeg" };

	public static void createDir(String dirPath) {
		File f = new File(dirPath);
		// 判断文件夹是否存在
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	/** 获取文件后缀 */
	public static String getSuffix(String fileName) {
		if (fileName != null && (!"".equals(fileName)) && fileName.contains(".")) {
			String ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
			ext = ext.trim();
			if (!"".equals(ext)) {
				return ext;
			}
		}
		return null;
	}

	/**
	 * 判断是否为图片类型
	 * 
	 * @author Chaohua Lee
	 * @param fileName
	 * @return
	 */
	public static boolean isImageType(String fileName) {
		String type = getSuffix(fileName);
		boolean flag = false;
		if (null != type) {
			for (int i = 0; i < imageType.length; i++) {
				if (imageType[i].equalsIgnoreCase(type)) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * 刪除文件，文件夾
	 * 
	 * @param dirPath
	 */
	public static void delFile(String dirPath) {
		File f = new File(dirPath);
		if (!f.exists()) {
			return;
		}
		;
		if (f.isDirectory()) {
			File[] fileArr = f.listFiles();
			for (File item : fileArr) {
				delFile(item.getAbsolutePath());
			}
			f.delete();
		} else {
			f.delete();
		}
	}

	/**
	 * 删除真实文件夹图片原图
	 * 
	 * @param deleteImg
	 *            格式 "/upload/img1.jpg,/upload/img2.jpg"
	 */
	public static void delReallyFile(String save_fileurl, String n_fileurl, String deleteImg) {
		if (deleteImg != null && !deleteImg.equals("")) {
			if (deleteImg.indexOf(",") > -1) {
				String[] img_obj = deleteImg.split(",");
				for (int i = 0; i < img_obj.length; i++) {
					String img_url = img_obj[i].replaceAll(save_fileurl, n_fileurl);
					FileUtil.delFile(img_url);
				}
			} else {
				String img_url = deleteImg.replaceAll(save_fileurl, n_fileurl);
				FileUtil.delFile(img_url);
			}
		}
	}

	/**
	 * 删除临时文件夹图片原图
	 * 
	 * @param deleteImg
	 *            格式 "/upload/img1.jpg,/upload/img2.jpg"
	 */
	public static void delTemporaryFile(String deleteImg) {
		if (deleteImg != null && !deleteImg.equals("")) {
			FileUtil.delFile(deleteImg);
		}
	}

	public static void delFile_nameStartWith(String baseDirPath, String prefix) {
		delFile_nameStart(baseDirPath, prefix, true);
	}

	public static void delFile_nameNotStartWith(String baseDirPath, String prefix) {
		delFile_nameStart(baseDirPath, prefix, false);
	}

	private static void delFile_nameStart(String baseDirPath, String prefix, boolean del) {
		File f = new File(baseDirPath);

		if (!f.exists() || !f.isDirectory()) {
			return;
		}
		;

		File[] fileArr = f.listFiles();
		for (File item : fileArr) {

			// 刪除與指定前綴相同的
			if (del) {
				if (item.getName().startsWith(prefix)) {
					delFile(item.getAbsolutePath());
				}
			}

			// 刪除與指定的前綴不同的
			else {
				if (!item.getName().startsWith(prefix)) {
					delFile(item.getAbsolutePath());
				}
			}
		}
	}

	public static void delFile_nameEndWith(String baseDirPath, String suffix) {
		delFile_nameEnd(baseDirPath, suffix, true);
	}

	public static void delFile_nameNotEndWith(String baseDirPath, String suffix) {
		delFile_nameEnd(baseDirPath, suffix, false);
	}

	private static void delFile_nameEnd(String baseDirPath, String suffix, boolean del) {
		File f = new File(baseDirPath);

		if (!f.exists() || !f.isDirectory()) {
			return;
		}
		;

		File[] fileArr = f.listFiles();
		for (File item : fileArr) {

			// 刪除與指定後綴相同的
			if (del) {
				if (item.getName().endsWith(suffix)) {
					delFile(item.getAbsolutePath());
				}
			}

			// 刪除與指定的後綴不同的
			else {
				if (!item.getName().endsWith(suffix)) {
					delFile(item.getAbsolutePath());
				}
			}
		}
	}

	private static void delFile_nameMatch(String baseDirPath, String regex) {
		File f = new File(baseDirPath);

		if (!f.exists() || !f.isDirectory()) {
			return;
		}
		;

		File[] fileArr = f.listFiles();
		for (File item : fileArr) {
			if (item.getName().matches(regex)) {
				delFile(item.getAbsolutePath());
			}
		}

	}

	/**
	 * 生成文件夹目录
	 * 
	 * @author tong
	 * @param file
	 * @param t_root_path
	 *            文件保存目录
	 * @param t_root_path
	 *            临时文件目录
	 */
	public static String uploadFile(MultipartFile file, String t_root_path) {
		File t_localFile = null;// 临时文件目录
		try {
			String fileName = file.getOriginalFilename();// 获取图片的文件名
			if (isImageType(fileName)) {// 判断是否为图片类型
				// String extensionName =
				// fileName.substring(fileName.lastIndexOf(".") + 1);// 获取图片的扩展名
				String extensionName = getSuffix(fileName);// 获取文件后缀
				String randomName = String.valueOf(new Random().nextInt(100000000));// 生成八位随机数
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String ymd = sdf.format(new Date());
				Calendar now = Calendar.getInstance();

				 // 年 //月//日
				String save_root_path = now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DAY_OF_MONTH);

				 // 年 // 月//日
				t_root_path += now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DAY_OF_MONTH);

				// 随机生成一个字母
				String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
				char ran = chars.charAt((int) (Math.random() * 26));
				String encrytImageName = EncryptUtil.encrytImageName(ymd + randomName + ran);
				fileName = encrytImageName + "." + extensionName;
				save_root_path += File.separator + fileName;
				t_localFile = new File(t_root_path, fileName);
				// 临时文件目录
				File t_targetFile = new File(t_root_path, fileName);
				if (!t_targetFile.exists()) {
					t_targetFile.mkdirs();
				}
				t_localFile = new File(t_root_path, fileName);
				file.transferTo(t_localFile);// 上传临时图片
				return save_root_path;
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将临时文件复制到真实文件
	 * 
	 * @param originDirectory
	 *            源路径
	 * @param targetDirectory
	 *            目标路径
	 */
	public static void fileChannelCopy(String originDirectory, String targetDirectory) {
		File origindirectory = new File(originDirectory); // 源路径File实例
		File targetdirectory_1 = new File(targetDirectory); // 目标路径File实例
		File targetdirectory = new File(targetdirectory_1.getParent());
		if (!origindirectory.exists()) {
			origindirectory.mkdirs();
		}
		if (!targetdirectory.exists()) {
			targetdirectory.mkdirs();
		}
		try {
			FileInputStream fin = new FileInputStream(origindirectory);
			BufferedInputStream bin = new BufferedInputStream(fin);
			PrintStream pout = new PrintStream(
					targetdirectory.getAbsolutePath() + File.separator + origindirectory.getName());
			BufferedOutputStream bout = new BufferedOutputStream(pout);
			int total = bin.available(); // 文件的总大小
			int percent = total / 100; // 文件总量的百分之一
			int count;
			while ((count = bin.available()) != 0) {
				int c = bin.read(); // 从输入流中读一个字节
				bout.write((char) c); // 将字节（字符）写到输出流中
				if (((total - count) % percent) == 0) {
					double d = (double) (total - count) / total; // 必须强制转换成double
				}
			}
			bout.close();
			pout.close();
			bin.close();
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			delTemporaryFile(originDirectory);
		}
	}

	/*
	 * public static void fileChannelCopy(String originDirectory, String
	 * targetDirectory, HttpServletRequest request) { File origindirectory_1 =
	 * new File(originDirectory); // 源路径File实例 File targetdirectory_1 = new
	 * File(targetDirectory); // 目标路径File实例
	 * 
	 * File origindirectory = new File( origindirectory_1.getParent()); File
	 * targetdirectory = new File( targetdirectory_1.getParent());
	 * 
	 * if (!origindirectory.exists()) { origindirectory.mkdirs(); } if
	 * (!targetdirectory.exists()) { targetdirectory.mkdirs(); } File[] fileList
	 * = origindirectory.listFiles(); // 目录中的所有文件 for (File file : fileList) {
	 * if (!file.isFile()){// 判断是不是文件 continue; } try { FileInputStream fin =
	 * new FileInputStream(file); BufferedInputStream bin = new
	 * BufferedInputStream(fin); PrintStream pout = new
	 * PrintStream(targetdirectory.getAbsolutePath() + File.separator +
	 * file.getName()); BufferedOutputStream bout = new
	 * BufferedOutputStream(pout); int total = bin.available(); // 文件的总大小 int
	 * percent = total / 100; // 文件总量的百分之一 int count; while ((count =
	 * bin.available()) != 0) { int c = bin.read(); // 从输入流中读一个字节
	 * bout.write((char) c); // 将字节（字符）写到输出流中
	 * 
	 * if (((total - count) % percent) == 0) { double d = (double) (total -
	 * count) / total; // 必须强制转换成double }
	 * 
	 * } bout.close(); pout.close(); bin.close(); fin.close(); } catch
	 * (IOException e) { e.printStackTrace(); } finally {
	 * delTemporaryFile(originDirectory, request); } } }
	 */

	/**
	 * @author tong json字符串转为json数组
	 * @param str
	 * @return
	 */
	public static Object[] getJsonToArray(String str) {
		JSONArray jsonArray = JSONArray.fromObject(str);
		return jsonArray.toArray();
	}

	/**
	 * @author tong 接收图片上传
	 * @param request
	 * @return
	 * @throws com.xrk.utils.exception.GMException
	 */
	public static Map<String, String> uploadImg(HttpServletRequest request, String t_fileurl, String n_fileurl,
			String save_fileurl) throws GMException {
		try {
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(request)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				Map<String, String> imgUrlMap = new HashMap<String, String>();
				while (iter.hasNext()) {
					// 取得上传文件
					MultipartFile file = multiRequest.getFile(iter.next());
					file.getSize();// 图片大小
					if (file != null) {
						// 取得当前上传文件的文件名称
						String myFileName = file.getOriginalFilename();
						// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
						if (myFileName.trim() != "") {
							
							//String n_root_path = request.getSession().getServletContext().getRealPath("upload/N_IMG");
							//String t_root_path = request.getSession().getServletContext().getRealPath("upload/T_IMG");
							
							String t_root_path = t_fileurl;
							String userPicture = save_fileurl + FileUtil.uploadFile(file, t_root_path);
							userPicture = userPicture.replace("\\", "/");
							imgUrlMap.put("file_url", userPicture);
							imgUrlMap.put("file_name", myFileName);
							return imgUrlMap;
						}
					}
				}
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
