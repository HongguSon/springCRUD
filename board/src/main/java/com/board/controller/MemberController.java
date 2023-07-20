package com.board.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.MemberVO;
import com.board.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	// 회원가입(get, post)
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void getRegister() throws Exception {
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception {
		memberService.register(vo);
		return "redirect:/";
	}
	
	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String postLogin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		HttpSession session = req.getSession();
		MemberVO login = memberService.login(vo);
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", login);
		}
		return "redirect:/";
		
	}
	
	// 로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String getLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
	
	// 비밀번호 변경
	@RequestMapping(value="/memberModify", method=RequestMethod.GET)
	public void getMemberModify() throws Exception {
		
	}
	@RequestMapping(value="/memberModify", method=RequestMethod.POST)
	public String postMemberModify(HttpSession session, MemberVO vo) throws Exception {
		memberService.memberModify(vo);
		session.invalidate();
		return "redirect:/";
	}
}
