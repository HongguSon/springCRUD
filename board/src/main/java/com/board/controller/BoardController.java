package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.Page;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

  @Inject
  BoardService service;

  // 게시물 목록
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public void getList(Model model) throws Exception { 
	  
	  List<BoardVO> list = null;
	  list = service.list();
	  
	  // 모델은 view에서 쓰기 위한 것.
	  model.addAttribute("list", list);
  }
  
  // 게시물 작성
  @RequestMapping(value = "/write", method = RequestMethod.GET)
  public void getWrite() throws Exception {
	  
  }
  
  
  // 게시물 작성(Post : 사용자 -> 서버)
  @RequestMapping(value = "/write", method = RequestMethod.POST)
  public String postWrite(BoardVO vo) throws Exception {
	  service.write(vo);
	  return "redirect:/board/list";
  }
  
  // 게시물 조회
  @RequestMapping(value = "/view", method = RequestMethod.GET)
  public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
	  BoardVO vo = service.view(bno);
	  
	  model.addAttribute("view", vo);
  }
  
  // 게시물 수정
  @RequestMapping(value = "/modify", method = RequestMethod.GET)
  public void getModify(@RequestParam("bno") int bno, Model model) throws Exception{
	  
	  BoardVO vo = service.view(bno);
	  model.addAttribute("view", vo);
  }
  
  // 게시물 수정(Post)
  @RequestMapping(value = "/modify", method = RequestMethod.POST)
  public String postModify(BoardVO vo) throws Exception {
	  service.modify(vo);
	  return "redirect:/board/view?bno=" + vo.getBno();
  }
  
  // 게시물 삭제
  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String getDelete(@RequestParam("bno") int bno) throws Exception {
	  service.delete(bno);
	  return "redirect:/board/list";
  }
  
  //게시물 목록 + Pagination
  @RequestMapping(value = "/listPage", method = RequestMethod.GET)
  public void getListPage(Model model, @RequestParam("num") int num) throws Exception { 
	  Page page = new Page();
	  page.setNum(num);
	  page.setCount(service.count());
	  
	  List<BoardVO> list = null;
	  list = service.listPage(page.getDisplayPost(), page.getPostNum());
	  
	  model.addAttribute("list", list);
	  
//	  model.addAttribute("pageNum", page.getPageNum());
//	  model.addAttribute("startPageNum", page.getStartPageNum());
//	  model.addAttribute("endPageNum", page.getEndPageNum());
//	  model.addAttribute("prev", page.getPrev());
//	  model.addAttribute("next", page.getNext());
	  model.addAttribute("page", page);
	  
	  model.addAttribute("select", num);
	
//	  int count = service.count();
//	  
//	  int postNum = 10;
//	  
//	  int pageNum = (int)Math.ceil((double)count/postNum);
//	  
//	  int displayPost = (num - 1) * postNum;
//	  
//	  // 한 번에 표시할 페이징 번호의 갯수 int pageNum_cnt = 10;
//	  
//	  // 표시되는 페이지 번호 중 마지막 번호 int endPageNum = (int)(Math.ceil((double)num /
//	  (double)pageNum_cnt) * pageNum_cnt);
//	  
//	  // 표시되는 페이지 번호 중 첫번째 번호 int startPageNum = endPageNum - (pageNum_cnt - 1);
//	  
//	  // 마지막 번호 재계산(12개의 게시물, 11~12를 표현하기 위한 if문 준비) int endPageNum_tmp =
//	  (int)(Math.ceil((double)count / (double)postNum));
//	  
//	  if(endPageNum > endPageNum_tmp) { endPageNum = endPageNum_tmp; }
//	  
//	  boolean prev = startPageNum == 1 ? false : true; boolean next = endPageNum *
//	  postNum >= count ? false : true; List<BoardVO> list = null; list =
//	  service.listPage(displayPost, postNum); model.addAttribute("list", list);
//	  model.addAttribute("pageNum", pageNum);
//	  
//	  model.addAttribute("startPageNum", startPageNum);
//	  model.addAttribute("endPageNum", endPageNum);
//	  model.addAttribute("prev",prev); model.addAttribute("next",next); // 현재 페이지
//	  model.addAttribute("select", num);
		 
 }
  @RequestMapping(value = "/listPageSearch", method = RequestMethod.GET)
  public void getListPageSearch(Model model, @RequestParam("num") int num,
		  @RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
		  @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) throws Exception { 
	  Page page = new Page();
	  page.setNum(num);
	  page.setCount(service.count());
	  
	  List<BoardVO> list = null;
	  list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
	  
	  model.addAttribute("list", list);
	  model.addAttribute("page", page);
	  model.addAttribute("select", num);
  }
}