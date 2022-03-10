package com.jaego.web.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	// 페이지당 게시물 수
	public int perPageNum;
	// 화면당 페이지 수
	public static int BLOCK_SCALE = 10;

	private Integer page = 1; // 현재 페이지

	private int prevPage; // 이전 페이지
	private int nextPage; // 다음 페이지
	private int totPage; // 전체 페이지 개수
	private int totBlock; // 전체 페이지 블록 개수
	private int curBlock; // 현재 페이지 블록

	private int prevBlock; // 이전 페이지 블록
	private int nextBlock; // 다음 페이지 블록
	// where rn between #{start } and #{end}
	private int pageBegin; // #{start}
	private int pageEnd; // #{end}
	private int blockBegin;// 현재 페이지에 시작번호 [이전]
	private int blockEnd; // 현재 페이지에 끝 번호 [끝]
	private int lectureId;
	
	
	// 검색처리 추가
	private String searchType;
	private String keyword;

	// 생성자
	public PageMaker(){
        this.page=1;          //초기 페이지는 1 
        this.perPageNum=10;  //10 개씩 보여준다.
    }

	public void setTotPage(int count) {
		curBlock = 1; // 현재 페이지 블록 번호

		// 991/10 =99.1 올림처리
		// Math.ceil(실수) 올림 처리
		this.totPage = (int) Math.ceil(count * 1.0 / perPageNum);

		// between #{start} and #{end} 에 입력될 값 계산
		setPageRange();
		setTotBlock(); // 전체 페이지 블록 개수 계산
		// 페이지 블록의 시작, 끝 번호 계산
		setBlockRange();
	}

	private void setBlockRange() {
		// 현재 페이지에 몇번째 페이지 블록에 속하는지 계산
		curBlock = (int) Math.ceil((page - 1) / BLOCK_SCALE) + 1;
		// 현재 페이지 블록의 시작, 끝 번호 계산
		blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;
		blockEnd = blockBegin + BLOCK_SCALE - 1;
		// 마지막 블록이 범위를 초과하지 않도록 처리
		if (blockEnd > totPage)
			blockEnd = totPage;
		// [이전] 을 눌렸을 때 이동할 페이지 번호
		prevPage = (curBlock == 1) ? 1 : (curBlock - 1) * BLOCK_SCALE;
		// [다음] 을 눌렸을 때 이동할 페이지 번호
		nextPage = curBlock > totBlock ? (curBlock * BLOCK_SCALE) : (curBlock * BLOCK_SCALE) + 1;
		if (nextPage >= totPage)
			nextPage = totPage;
	}

	private void setPageRange() {
		// where rn between #{start } and #{end} 에 입력 될 값
		// 시작 번호 = (현재 페이지 -1 ) * 페이지당 게시물 수 +1;
		// ex (5-1) * 10 +1 = 41페이지
		pageBegin = (page - 1) * perPageNum + 1;
		// 끝번호 = 시작번호 + 페이지당 게시물 수 -1;
		pageEnd = pageBegin + perPageNum - 1;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		// 페이지 번호가 0이거나 0보다 작으면 1페이지로 한다.
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	// 페이지 블록의 갯수 계산 (총 100 페이지라면 10개 블록)
	public void setTotBlock() {
		this.totBlock = (int) Math.ceil(totPage / BLOCK_SCALE);
	}

	// 일반적인 페이징 처리 파라미터 출력 데이터 ex) /memberList?page=4&perPageNum=10
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", perPageNum).build();
		return uriComponents.toUriString();
	}

	//일반적인 페이징 부트스트랩 출력
	public String bootStrapPagingHTML(String url) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("<ul class='pagination'>");
		if (curBlock > 1) {
			sBuffer.append("<li><a href='" + url + makeQuery(1) + "'>처음</a></li>");
		}

		if (curBlock > 1) {
			sBuffer.append("<li><a href='" + url + makeQuery(prevPage) + "'>&laquo;</a></li>");
		}

		String active = "";
		for (int i = blockBegin; i <= blockEnd; i++) {
			if (page == i) {
				active = "class=active";
			} else {
				active = "";
			}
			sBuffer.append("<li " + active + " >");
			sBuffer.append("<a href='" + url + makeQuery(i) + "'>" + i + "</a></li>");
			sBuffer.append("</li>");
		}

		if (curBlock < totBlock) {
			sBuffer.append("<li><a href='" + url + makeQuery(nextPage) + "'>&raquo;</a></li>");
		}

		if (curBlock < totBlock) {
			sBuffer.append("<li><a href='" + url + makeQuery(totPage) + "'>마지막</a></li>");
		}

		sBuffer.append("</ul>");
		return sBuffer.toString();
	}

	// 검색 추가 페이지 파라미터
	public String makeSearch(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", perPageNum).queryParam("searchType", searchType)
				.queryParam("keyword", keyword).build();
		return uriComponents.toUriString();
	}

	// 검색 추가 페이지 부트스트랩 출력
	public String bootStrapPagingSearchHTML(String url) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("<ul class='pagination'>");
		if (curBlock > 1) {
			sBuffer.append("<li><a href='" + url + makeSearch(1) + "'>처음</a></li>");
		}

		if (curBlock > 1) {
			sBuffer.append("<li><a href='" + url + makeSearch(prevPage) + "'>&laquo;</a></li>");
		}

		String active = "";
		for (int i = blockBegin; i <= blockEnd; i++) {
			if (page == i) {
				active = "class=active";
			} else {
				active = "";
			}
			sBuffer.append("<li " + active + " >");
			sBuffer.append("<a href='" + url + makeSearch(i) + "'>" + i + "</a></li>");
			sBuffer.append("</li>");
		}

		if (curBlock < totBlock) {
			sBuffer.append("<li><a href='" + url + makeSearch(nextPage) + "'>&raquo;</a></li>");
		}

		if (curBlock < totBlock) {
			sBuffer.append("<li><a href='" + url + makeSearch(totPage) + "'>留덉�留�</a></li>");
		}

		sBuffer.append("</ul>");
		return sBuffer.toString();
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;

	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public int getTotBlock() {
		return totBlock;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}

	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		// 몇개 씩 보여줄것인가 이다. 최대 100개씩 보여 줄것으로 설정한다.
		// 만약 0보다 작거나 100 보다 크면 10으로 초기화 시킨다.
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getLectureId() {
		return lectureId;
	}

	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}

	public void setTotBlock(int totBlock) {
		this.totBlock = totBlock;
	}

	
	
}
