package com.fc.main.vo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable {
	private List<T> recodes;
	private int rowCount;
//	private Integer pageCount;
//	private Integer pageSize;
//	private Integer pageCurent;
	public List<T> getRecodes() {
		return recodes;
	}
	public void setRecodes(List<T> recodes) {
		this.recodes = recodes;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	
	
}
