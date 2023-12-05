package com.jmh.vo;

import lombok.Data;

@Data
public class Criteria {
	
	//private String searchField; // �˻�����
	//private String searchWord;	// �˻���
	
	private int pageNo = 1;		// ��û ������ ��ȣ
	private int amount = 10; 	// ���������� �Խù���
	private int startNo = 1;
	private int endNo = 10;
	
	
//	public Criteria(int pageNo, int amount) {
//		this.pageNo = pageNo;
//		this.amount = amount;
//	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		if(pageNo>0) {
			endNo = pageNo * amount;
			startNo = pageNo * amount - (amount-1);
		}
	}
	
//	@Override
//	public String toString() {
//		return "Criteria [pageNo=" + pageNo + ", amount=" + amount + "]";
//	}
	
}
