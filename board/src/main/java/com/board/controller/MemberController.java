package com.board.controller;

import javax.inject.Inject;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
