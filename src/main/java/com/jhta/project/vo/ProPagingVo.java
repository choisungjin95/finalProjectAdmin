package com.jhta.project.vo;

public class ProPagingVo {
	
	// ����������, ����������, ��������, �Խñ� �� ����, �������� �� ����, ������������, SQL������ �� start, end
	private int endPage; // ���� ������ ������ ��ȣ
	private int startPage; //���� ���������� ó�� ������ ��ȣ
	private int lastPage; //���� ���������� ������ ������ ��ȣ
	private boolean preBtn; //���� ��ư ����
	private boolean nextBtn;//���� ��ư ����
	//private int cntPage = 5;
	
	public ProPagingVo() {
	}
	public ProPagingVo(int total, int nowPage, int perPageRow) {
		// total = ��ü �� ����, nowPage = ���� ������ ��ȣ, perPageRow = �� �������� �� ����
		setEndPage(total, perPageRow);
		setPageStartNum(nowPage, this.endPage);
		setLastPage(this.startPage, this.endPage);
		setPreBtn(this.startPage);
		setNextBtn(this.lastPage, this.endPage);
	}
	// ���� page���� ���������� ���ϴ� �Լ�
	public void setPageStartNum(int nowPage, int endPage) {
		this.startPage=(nowPage-1)/10*10+1;
	}
	
	//���� page���� ������������ ���ϴ� �Լ�
	public void setLastPage(int startPage, int endPage) {
		if(endPage<= (startPage+9)) {
			this.lastPage=endPage;
		}else {
			this.lastPage=startPage+9;
		}
	}
	//��������ȣ���� ����&���� ȭ��ǥ ǥ�� ���� ���ϴ� �Լ�
	public void setPreBtn(int startPage) {
		if(startPage==1) {
			this.preBtn=false;
		}else {
			this.preBtn=true; 
		}
	}
	public void setNextBtn(int lastPage, int endPage) {
		if(lastPage>= endPage) {
			this.nextBtn=false;
		}else {
			this.nextBtn=true; 
		}
	}

	// ���� ������ ������ ��� �ؼ� ���� ��Ű�� �Լ�
	public void setEndPage(int total, int perPageRow) {
		if(total / perPageRow == 0) {
			this.endPage = total / perPageRow;
		} else {
			this.endPage = total / perPageRow + 1;
		}
	}
///////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////
	// ���� ������ ������ ���� �� �� ȣ���ϴ¤� �Լ�
	public int getEndPage() {
		return this.endPage;
	}
	
	// ���� ������ ������ �� ȣ���ϴ� �Լ�
	public int getStartPage() {
		return this.startPage;
	}
	
	// ������ ������ ������ �� ȣ���ϴ� �Լ�
	public int getLastPage() {
		return this.lastPage;
	}
	// ���� ������ ���� ������ �� ȣ���ϴ� �Լ�
	public boolean getPreBtn() {
		return this.preBtn;
	}
	// ���� ������ ���� ������ �� ȣ���ϴ� �Լ�
	public boolean getNextBtn() {
		return this.nextBtn;
	}
	
	
//	// ����, �� ������ ���
//	public void calcStartEndPage(int nowPage, int cntPage) {
//		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
//		if (getLastPage() < getEndPage()) {
//			setEndPage(getLastPage());
//		}
//		setStartPage(getEndPage() - cntPage + 1);
//		if (getStartPage() < 1) {
//			setStartPage(1);
//		}
//	}
//	// DB �������� ����� start, end�� ���
//	public void calcStartEnd(int nowPage, int cntPerPage) {
//		setEnd(nowPage * cntPerPage);
//		setStart(getEnd() - cntPerPage + 1);
//	}
//	
//	public int getNowPage() {
//		return nowPage;
//	}
//	public void setNowPage(int nowPage) {
//		this.nowPage = nowPage;
//	}
//	public int getStartPage() {
//		return startPage;
//	}
//	public void setStartPage(int startPage) {
//		this.startPage = startPage;
//	}
//	public int getEndPage() {
//		return endPage;
//	}
//	public void setEndPage(int endPage) {
//		this.endPage = endPage;
//	}
//	public int getTotal() {
//		return total;
//	}
//	public void setTotal(int total) {
//		this.total = total;
//	}
//	public int getCntPerPage() {
//		return cntPerPage;
//	}
//	public void setCntPerPage(int cntPerPage) {
//		this.cntPerPage = cntPerPage;
//	}
//	public int getLastPage() {
//		return lastPage;
//	}
//	public void setLastPage(int lastPage) {
//		this.lastPage = lastPage;
//	}
//	public int getStart() {
//		return start;
//	}
//	public void setStart(int start) {
//		this.start = start;
//	}
//	public int getEnd() {
//		return end;
//	}
//	public void setEnd(int end) {
//		this.end = end;
//	}	
//	public int setCntPage() {
//		return cntPage;
//	}
//	public void getCntPage(int cntPage) {
//		this.cntPage = cntPage;
//	}
//	@Override
//	public String toString() {
//		return "PagingVO [nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage + ", total=" + total
//				+ ", cntPerPage=" + cntPerPage + ", lastPage=" + lastPage + ", start=" + start + ", end=" + end
//				+ ", cntPage=" + cntPage + "]";
//	}
}
