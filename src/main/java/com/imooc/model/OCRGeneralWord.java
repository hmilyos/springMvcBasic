/**     
 * @文件名称: OCRGeneralWord.java  
 * @类路径: com.minstone.hardware.ocr.model  
 * @描述: TODO  
 * @作者：ousm  
 * @时间：2018年5月23日 上午7:59:47  
 * @版本：V1.0     
 */
package com.imooc.model;

/**
 * 
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：明动软件
 * @作者：ousm
 * @创建时间：2018年5月23日 上午8:01:09
 * @版本：V1.0
 */
public class OCRGeneralWord {

	private String character; // 识别出的单字字符
	private Float confidence; // 识别出的单字字符对应的置信度
	
	public OCRGeneralWord(){
		
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Float getConfidence() {
		return confidence;
	}

	public void setConfidence(Float confidence) {
		this.confidence = confidence;
	}

}
