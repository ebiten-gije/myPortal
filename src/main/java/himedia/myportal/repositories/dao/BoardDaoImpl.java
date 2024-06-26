package himedia.myportal.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.BoardDaoException;
import himedia.myportal.repositories.vo.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
//	게시물 목록
	@Override
	public List<BoardVo> selectAll() {
		List<BoardVo> list = sqlSession.selectList("board.selectAll");
		return list;
	}

//	r게시물 작성
	@Override
	public int insert(BoardVo boardVo) {
		try {
			System.out.println(boardVo);
			int insertedCount = sqlSession.insert("board.insert",boardVo);
			return insertedCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BoardDaoException("게시물 입력 중 예어ㅣ발생~~", boardVo);
		}
	}

	@Override
	public BoardVo getContent(Long no) {
		
		BoardVo boardVo = sqlSession.selectOne("board.getContent", no);
		return boardVo;
	}

	@Override
	public int update(BoardVo boardVo) {
		try {
			int updatedCount = sqlSession.update("board.update", boardVo);
			return updatedCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BoardDaoException("수정 중 에러 발생~~!", boardVo);
		}
	}

	@Override
	public int increaseHitCount(Long no) {
		return sqlSession.update("increaseHitCount", no);
	}

	@Override
	public int delete(Long no, Long userNo) {
		try {
			Map <String, Long> map = new HashMap <>();
			map.put("no", no);
			map.put("userNo", userNo);
			return sqlSession.delete("board.deleteByUserNo", map);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BoardDaoException("게미숨 삭제 중 ㅈ오ㅓ료ㅠ");
		}
	}

}
