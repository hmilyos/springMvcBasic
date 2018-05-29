/**     
 * @文件名称: CheckResult.java  
 * @类路径: com.minstone.hardware.ocr.model  
 * @描述: TODO  
 * @作者：ousm  
 * @时间：2018年5月24日 下午2:06:12  
 * @版本：V1.0     
 */
package com.imooc.model;

/**
 * @类功能说明： 校验结果
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：明动软件
 * @作者：ousm
 * @创建时间：2018年5月24日 下午2:06:12
 * @版本：V1.0
 */
public class CheckResult {
	private int rowId;
	private String rowkey;
	private String rowValue;
	private boolean check;
	private String checkResult;

	public CheckResult() {

	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String getRowkey() {
		return rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public String getRowValue() {
		return rowValue;
	}

	public void setRowValue(String rowValue) {
		this.rowValue = rowValue;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}



}
