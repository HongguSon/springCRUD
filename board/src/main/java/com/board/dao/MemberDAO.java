package com.board.dao;

import com.board.domain.MemberVO;

public interface MemberDAO {
	// 회원가입
	public void register(MemberVO vo) throws Exception;
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;
	// 비밀번호 변경
	public void memberModify(MemberVO vo) throws Exception;
	// 회원 탈퇴
	public void memberDelete(MemberVO vo) throws Exception;
}
