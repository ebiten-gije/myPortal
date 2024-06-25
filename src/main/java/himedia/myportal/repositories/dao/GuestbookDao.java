package himedia.myportal.repositories.dao;

import java.util.List;

import himedia.myportal.repositories.vo.GuestbookVo;

public interface GuestbookDao {

	public List <GuestbookVo> selectAll();
	
	public int insert(GuestbookVo vo);
	
	public int delete(GuestbookVo vo);
	
	public GuestbookVo search(Long no, String password);
	
	public boolean update(Long no, String content);
}
