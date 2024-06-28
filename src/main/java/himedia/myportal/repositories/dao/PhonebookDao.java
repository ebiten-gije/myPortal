package himedia.myportal.repositories.dao;

import java.util.List;

import himedia.myportal.repositories.vo.PhonebookVo;

public interface PhonebookDao {

	public List <PhonebookVo> selectAll ();
	
	public int insert (PhonebookVo vo);
	
	public int delete (Long id);
	
	public List <PhonebookVo> search(String keyword); 
	
	public boolean update(PhonebookVo vo);
}
