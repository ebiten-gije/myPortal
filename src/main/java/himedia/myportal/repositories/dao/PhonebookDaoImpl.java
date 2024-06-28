package himedia.myportal.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.PhonebookDaoException;
import himedia.myportal.repositories.vo.PhonebookVo;

@Repository("PhonebookDao")
public class PhonebookDaoImpl implements PhonebookDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<PhonebookVo> selectAll() {
		List<PhonebookVo> list = sqlSession.selectList("phonebook.selectAll");
		return list;
	}

	@Override
	public int insert(PhonebookVo vo) {
		try {
			int insertedCount = sqlSession.insert("phonebook.insert", vo);
			return insertedCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhonebookDaoException("게시물 입력 중 오류", vo);
		}
	}

	@Override
	public int delete(Long id) {
		try {
			int deletedCount = sqlSession.delete("phonebook.delete", id);
			return deletedCount;
		} catch(Exception e) {
			throw new PhonebookDaoException ("주소록 삭제 중 오류 비상");
		}
	}

	@Override
	public List <PhonebookVo> search(String keyword) {
		List<PhonebookVo> list = sqlSession.selectList("phonebook.search", keyword);
		return list;
	}

	@Override
	public boolean update(PhonebookVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
