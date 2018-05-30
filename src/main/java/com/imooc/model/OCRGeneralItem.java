/**     
 * @文件名称: OCRGeneralItem.java  
 * @类路径: com.minstone.hardware.ocr.model  
 * @描述: TODO  
 * @作者：ousm  
 * @时间：2018年5月23日 上午8:03:48  
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
 * @创建时间：2018年5月23日 上午8:03:48
 * @版本：V1.0
 */
public class OCRGeneralItem {

	private String itemstring; // 字段字符串

	private OCRItemcoord itemcoord; // 字段在图像中的像素坐标，包括左上角坐标x,y，以及宽、高width, height

	private ArrayList<OCRGeneralWord> words; // 字段识别出来的每个字的信息，包括具体的字character，以及字对应的置信度confidence

	public String getItemstring() {
		return itemstring;
	}

	public void setItemstring(String itemstring) {
		this.itemstring = itemstring;
	}

	public OCRItemcoord getItemcoord() {
		return itemcoord;
	}

	public void setItemcoord(OCRItemcoord itemcoord) {
		this.itemcoord = itemcoord;
	}

	public ArrayList<OCRGeneralWord> getWords() {
		return words;
	}

	public void setWords(ArrayList<OCRGeneralWord> words) {
		this.words = words;
	}

	public OCRGeneralItem() {
	}

	public OCRGeneralItem(String itemstring, OCRItemcoord itemcoord, ArrayList<OCRGeneralWord> words) {
		this.itemstring = itemstring;
		this.itemcoord = itemcoord;
		this.words = words;
	}
}
