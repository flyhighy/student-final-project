package com.project.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.Dao.downloadDao;
import com.project.bean.Download;

public class download extends ActionSupport {
	
	private downloadDao downloadDao;
	private Download download;
	List<Integer> checkOption;
	
	
	public List<Integer> getCheckOption() {
		return checkOption;
	}
	public void setCheckOption(List<Integer> checkOption) {
		this.checkOption = checkOption;
	}
	public downloadDao getDownloadDao() {
		return downloadDao;
	}
	public void setDownloadDao(downloadDao downloadDao) {
		this.downloadDao = downloadDao;
	}
	public Download getDownload() {
		return download;
	}
	public void setDownload(Download download) {
		this.download = download;
	}
	
	public String adminDownload() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.put("nowNav", "8");
		
		List<Download> list = this.downloadDao.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		return SUCCESS;
	}
	
	//增加文件
	public String addDownload() throws Exception{
		return SUCCESS;
	}
	
	//保存文件
	public String saveDownload() throws Exception{
		download.setTime(new Date());
		this.downloadDao.saveDownload(download);
		return SUCCESS;
	}
	
	//删除文件
	public String delDownload() throws Exception{
		this.downloadDao.delDownload(download.getId());
		return SUCCESS;
	}
	
	//批量删除文件
	public String delManyDownload() throws Exception{
		for(int i = 0;i < checkOption.size();i++ ){
			this.downloadDao.delDownload(checkOption.get(i));
		}
		return SUCCESS;
	}
	//编辑文件
	@SuppressWarnings("unchecked")
	public String editDownload() throws Exception{
		Download download1 = this.downloadDao.findById(download.getId());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("download", download1);
		return SUCCESS;
	}
	//更新文件
	public String updateDownload() throws Exception{
		download.setTime(new Date());
		this.downloadDao.updateDownload(download);
		return SUCCESS;
	}

}
