package himedia.myportal.services;

import java.util.List;

import himedia.myportal.repositories.vo.PhonebookVo;

public interface PhonebookService {
	
	public List<PhonebookVo> getList();
	public List <PhonebookVo> search(String str);
	public boolean write(PhonebookVo vo);
	public boolean delete(Long id);
	public boolean update(PhonebookVo vo);
}
