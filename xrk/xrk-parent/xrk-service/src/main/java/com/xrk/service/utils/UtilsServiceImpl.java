package com.xrk.service.utils;

import com.xrk.utils.FileUtil;
import com.xrk.utils.Global;
import com.xrk.utils.exception.GMException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 工具
 * 
 * @author tong
 *
 */
@Transactional
@Service("utilsService")
public class UtilsServiceImpl implements UtilsService {

	/**
	 * 上传 图片
	 */
	@Override
	public Map<String, String> uploadImg(HttpServletRequest request) throws GMException {
		String t_fileurl = Global.getConfig("upload.t.fileurl");
		String n_fileurl = Global.getConfig("upload.n.fileurl");
		String save_fileurl = Global.getConfig("save.n.fileurl");
		Map<String, String> urlMap = FileUtil.uploadImg(request, t_fileurl, n_fileurl, save_fileurl);
		return urlMap;
	}

}
