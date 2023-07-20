package com.board.dao;

import com.board.domain.MemberVO;

public interface MemberDAO {
	// 회원가입
	public void register(MemberVO vo) throws Exception;
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;
	// 비밀번호 변경
	public void memberModify(MemberVO vo) throws Exception;
}
