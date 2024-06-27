package himedia.myportal.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.BoardDaoException;
import himedia.myportal.repositories.vo.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
//	게시물 목록
	@Override
	public List<BoardVo> selectAll() {
		List<BoardVo> list = sqlSession.selectList("board.selectAll");
		logger.debug(list.toString());
		return list;
	}

//	r게시물 작성
	@Override
	public int insert(BoardVo boardVo) {
		logger.debug("게시물 작성 액션");
		logger.debug("" + boardVo);
		try {
			int insertedCount = sqlSession.insert("board.insert",boardVo);
			logger.debug("삽입된 레코드 수: " + insertedCount);
			return insertedCount;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("게시물 입력 중 에러 발생~~");
			throw new BoardDaoException("게시물 입력 중 예어ㅣ발생~~", boardVo);
		}
	}

	@Override
	public BoardVo getContent(Long no) {
		logger.debug("게시물 no: " + no);
		BoardVo boardVo = sqlSession.selectOne("board.getContent", no);
		logger.debug("게시물 vo : " + boardVo);
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
