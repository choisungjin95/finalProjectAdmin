package com.jhta.project.vo;

public class ProPagingVo {
	
	// 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수, 마지막페이지, SQL쿼리에 쓸 start, end
	private int endPage; // 제일 마지막 페이지 번호
	private int startPage; //현재 페이지에서 처음 페이지 번호
	private int lastPage; //현재 페이지에서 마지막 페이지 번호
	private boolean preBtn; //이전 버튼 유무
	private boolean nextBtn;//다음 버튼 유무
	//private int cntPage = 5;
	
	public ProPagingVo() {
	}
	public ProPagingVo(int total, int nowPage, int perPageRow) {
		// total = 전체 글 갯수, nowPage = 현재 페이지 번호, perPageRow = 한 페이지당 글 갯수
		setEndPage(total, perPageRow);
		setPageStartNum(nowPage, this.endPage);
		setLastPage(this.startPage, this.endPage);
		setPreBtn(this.startPage);
		setNextBtn(this.lastPage, this.endPage);
	}
	// 현재 page에서 시작페이지 구하는 함수
	public void setPageStartNum(int nowPage, int endPage) {
		this.startPage=(nowPage-1)/10*10+1;
	}
	
	//현재 page에서 마지막페이지 구하는 함수
	public void setLastPage(int startPage, int endPage) {
		if(endPage<= (startPage+9)) {
			this.lastPage=endPage;
		}else {
			this.lastPage=startPage+9;
		}
	}
	//페이지번호에서 이전&다음 화살표 표시 유무 구하는 함수
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

	// 제일 마지막 페이지 계산 해서 저장 시키는 함수
	public void setEndPage(int total, int perPageRow) {
		if(total / perPageRow == 0) {
			this.endPage = total / perPageRow;
		} else {
			this.endPage = total / perPageRow + 1;
		}
	}
///////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////
	// 제일 마지막 페이지 꺼내 쓸 때 호출하는ㄴ 함수
	public int getEndPage() {
		return this.endPage;
	}
	
	// 시작 페이지 꺼내쓸 때 호출하는 함수
	public int getStartPage() {
		return this.startPage;
	}
	
	// 마지막 페이지 꺼내쓸 때 호출하는 함수
	public int getLastPage() {
		return this.lastPage;
	}
	// 이전 페이지 유무 꺼내쓸 때 호출하는 함수
	public boolean getPreBtn() {
		return this.preBtn;
	}
	// 다음 페이지 유무 꺼내쓸 때 호출하는 함수
	public boolean getNextBtn() {
		return this.nextBtn;
	}
	
	
//	// 시작, 끝 페이지 계산
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
//	// DB 쿼리에서 사용할 start, end값 계산
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
