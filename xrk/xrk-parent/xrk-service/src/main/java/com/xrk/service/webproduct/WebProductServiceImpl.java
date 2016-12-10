package com.xrk.service.webproduct;

import java.util.List;

import com.xrk.dao.WebProductMapper;
import com.xrk.utils.BeanUtil;
import com.xrk.utils.JsonUtil;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xrk.entity.Album;
import com.xrk.entity.Cover;
import com.xrk.entity.WebProduct;
import com.xrk.utils.BeanUtil;
import com.xrk.utils.FileUtil;
import com.xrk.utils.Global;
import com.xrk.utils.JsonUtil;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;
import com.xrk.vo.WebProductVo;

/**
 * 套餐
 * 
 * @author tong
 *
 */
@Transactional
@Service("webProductService")
public class WebProductServiceImpl implements WebProductService {
	@Autowired
	private WebProductMapper webProductMapper;

	/**
	 * 后台 套餐数据列表
	 */
	public PageView query(PageView pageView, WebProduct webProduct) {
		try {
			List<WebProduct> list = webProductMapper.query(pageView, webProduct);
			pageView.setRecords(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageView;
	}

	/**
	 * 添加套餐
	 */
	public void add(WebProductVo webProductVo) throws GMException {
		WebProduct webProduct = new WebProduct();

		List<Album> albumList = webProductVo.getAlbumList();
		if (albumList.size() != 0) {
			String album = JsonUtil.stringify(albumList);
			webProductVo.setAlbum(album);
		} else {
			webProductVo.setAlbum(null);
		}

		List<Cover> coverList = webProductVo.getCoverList();
		if (coverList.size() != 0) {
			String cover = JsonUtil.stringify(coverList);
			webProductVo.setCover(cover);
		} else {
			webProductVo.setCover(null);
		}

		BeanUtil.copyBean(webProduct, webProductVo);

		webProduct.setLookCount(0);
		webProduct.setPraiseCount(0);
		webProduct.setEnabled(false);

		webProductMapper.add(webProduct);

		String t_fileurl = Global.getConfig("upload.t.fileurl");
		String n_fileurl = Global.getConfig("upload.n.fileurl");
		String save_fileurl = Global.getConfig("save.n.fileurl");
		// 删除图片原图
		String deleteImg = webProductVo.getDeleteImg();
		FileUtil.delReallyFile(save_fileurl, n_fileurl, deleteImg);
		// 删除图片原图

		// 将临时文件复制到真实文件
		List<Album> albumListDel = webProductVo.getAlbumList();
		for (Album album : albumListDel) {
			String targetDirectory = album.getUrl();
			if (targetDirectory != null) {
				String originDirectory = album.getUrl();
				originDirectory = originDirectory.replaceAll(save_fileurl, t_fileurl).replaceAll("n_img", "t_img");
				targetDirectory = targetDirectory.replaceAll(save_fileurl, n_fileurl);
				// targetDirectory =
				// request.getSession().getServletContext().getRealPath(targetDirectory);
				// originDirectory =
				// request.getSession().getServletContext().getRealPath(originDirectory);
				FileUtil.fileChannelCopy(originDirectory, targetDirectory);
			}
		}
		// 将临时文件复制到真实文件

		// 将临时文件复制到真实文件
		List<Cover> coverListDel = webProductVo.getCoverList();
		for (Cover cover : coverListDel) {
			String targetDirectory = cover.getUrl();
			if (targetDirectory != null) {
				String originDirectory = cover.getUrl();
				originDirectory = originDirectory.replaceAll(save_fileurl, t_fileurl).replaceAll("n_img", "t_img");
				targetDirectory = targetDirectory.replaceAll(save_fileurl, n_fileurl);
				// targetDirectory =
				// request.getSession().getServletContext().getRealPath(targetDirectory);
				// originDirectory =
				// request.getSession().getServletContext().getRealPath(originDirectory);
				FileUtil.fileChannelCopy(originDirectory, targetDirectory);
			}
		}
		// 将临时文件复制到真实文件

	}

	/**
	 * 修改套餐
	 */
	public void modify(WebProductVo webProductVo) throws GMException {
		WebProduct webProduct = new WebProduct();

		List<Album> albumList = webProductVo.getAlbumList();
		if (albumList.size() != 0) {
			String album = JsonUtil.stringify(albumList);
			webProductVo.setAlbum(album);
		} else {
			webProductVo.setAlbum(null);
		}

		List<Cover> coverList = webProductVo.getCoverList();
		if (coverList.size() != 0) {
			String cover = JsonUtil.stringify(coverList);
			webProductVo.setCover(cover);
		} else {
			webProductVo.setCover(null);
		}

		BeanUtil.copyBean(webProduct, webProductVo);

		webProductMapper.modify(webProduct);
		
		String t_fileurl = Global.getConfig("upload.t.fileurl");
		String n_fileurl = Global.getConfig("upload.n.fileurl");
		String save_fileurl = Global.getConfig("save.n.fileurl");
		
		// 删除图片原图
		String deleteImg = webProductVo.getDeleteImg();
		FileUtil.delReallyFile(save_fileurl, n_fileurl, deleteImg);
		// 删除图片原图

		// 将临时文件复制到真实文件
		List<Album> albumListDel = webProductVo.getAlbumList();
		for (Album album : albumListDel) {
			String targetDirectory = album.getUrl();
			if (targetDirectory != null) {
				String originDirectory = album.getUrl();
				originDirectory = originDirectory.replaceAll(save_fileurl, t_fileurl).replaceAll("n_img", "t_img");
				targetDirectory = targetDirectory.replaceAll(save_fileurl, n_fileurl);
				// targetDirectory =
				// request.getSession().getServletContext().getRealPath(targetDirectory);
				// originDirectory =
				// request.getSession().getServletContext().getRealPath(originDirectory);
				FileUtil.fileChannelCopy(originDirectory, targetDirectory);
			}
		}
		// 将临时文件复制到真实文件

		// 将临时文件复制到真实文件
		List<Cover> coverListDel = webProductVo.getCoverList();
		for (Cover cover : coverListDel) {
			String targetDirectory = cover.getUrl();
			if (targetDirectory != null) {
				String originDirectory = cover.getUrl();
				originDirectory = originDirectory.replaceAll(save_fileurl, t_fileurl).replaceAll("n_img", "t_img");
				targetDirectory = targetDirectory.replaceAll(save_fileurl, n_fileurl);
				// targetDirectory =
				// request.getSession().getServletContext().getRealPath(targetDirectory);
				// originDirectory =
				// request.getSession().getServletContext().getRealPath(originDirectory);
				FileUtil.fileChannelCopy(originDirectory, targetDirectory);
			}
		}
		// 将临时文件复制到真实文件
		
	}

	/**
	 * 删除套餐
	 */
	public void delete(String id) {
		webProductMapper.delete(id);

	}

	/**
	 * 取得某条套餐 
	 */
	public WebProduct getById(String id) {
		WebProduct webProduct = webProductMapper.getById(id);
		return webProduct;
	}

}
