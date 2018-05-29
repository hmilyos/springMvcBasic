/**     
 * @文件名称: OCRGeneralResult.java  
 * @类路径: com.minstone.hardware.ocr.model  
 * @描述: TODO  
 * @作者：ousm  
 * @时间：2018年5月23日 上午8:04:45  
 * @版本：V1.0     
 */
package com.imooc.model;

import java.util.ArrayList;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：明动软件
 * @作者：ousm
 * @创建时间：2018年5月23日 上午8:04:45
 * @版本：V1.0
 */
public class OCRGeneralResult {

	private int errorcode; // 返回状态值
	private String errormsg; // 返回错误消息
	private ArrayList<OCRGeneralItem> items; // 识别出的所有字段信息每个字段包括
	
	public OCRGeneralResult(){
		
	}

	public int getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public ArrayList<OCRGeneralItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<OCRGeneralItem> items) {
		this.items = items;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	private String session_id; // 保留字段，目前不使用
}
