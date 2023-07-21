package com.board.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sql;
	 
	private static String namespace = "com.board.mappers.member";
	
	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		MemberVO temp = sql.selectOne(namespace + ".login", vo);
//		System.out.println(temp);
		return temp;
	}

	@Override
	public void memberModify(MemberVO vo) throws Exception {
		sql.update(namespace + ".memberModify", vo);
		
	}

	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		sql.delete(namespace + ".memberDelete", vo);
		
	}

	@Override
	public MemberVO idCheck(String userId) throws Exception {
		return sql.selectOne(namespace + ".idCheck", userId);
	}

}
