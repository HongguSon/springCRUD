package com.board.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.MemberVO;
import com.board.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	// 회원가입(get, post)
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void getRegister() throws Exception {
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception {
		String inputPass = vo.getUserPass();
		String pass = passEncoder.encode(inputPass);
		vo.setUserPass(pass);
		
		memberService.register(vo);
		return "redirect:/";
	}
	
	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String postLogin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		HttpSession session = req.getSession();
		MemberVO login = memberService.login(vo);
		
		boolean passMatch = passEncoder.matches(vo.getUserPass(), login.getUserPass());
		
		if(login != null && passMatch) {
			session.setAttribute("member", login);
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
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
		String inputPass = vo.getUserPass();
		String pass = passEncoder.encode(inputPass);
		vo.setUserPass(pass);
		
		memberService.memberModify(vo);
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원 탈퇴
	@RequestMapping(value="/memberDelete", method = RequestMethod.GET)
	public void getMemberDelete() throws Exception {
		
	}
	
	@RequestMapping(value="/memberDelete", method = RequestMethod.POST)
	public String postMemberDelete(HttpSession session, MemberVO vo, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO)session.getAttribute("member");
		String oldPass = member.getUserPass();
		String newPass = vo.getUserPass();
		boolean passMatch = passEncoder.matches(vo.getUserPass(), member.getUserPass());
		
		if(!(passMatch)) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/memberDelete";
		} else {
			session.invalidate();
		}
		memberService.memberDelete(vo);
		return "redirect:/";
	}
	
	// 아이디 중복 확인
	@ResponseBody
	@RequestMapping(value ="/idCheck", method = RequestMethod.POST)
	public int postIdCheck(HttpServletRequest req) throws Exception {
		String userId = req.getParameter("userId");

		MemberVO idCheck = memberService.idCheck(userId);

		int result = 0;
		
		if(idCheck != null) {
			result = 1;
		}
		return result;
	}
}
