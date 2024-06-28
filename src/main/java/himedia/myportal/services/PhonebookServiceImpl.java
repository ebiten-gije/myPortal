package himedia.myportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.PhonebookDao;
import himedia.myportal.repositories.vo.PhonebookVo;

@Service("PhoneService")
public class PhonebookServiceImpl implements PhonebookService {
	@Autowired
	PhonebookDao phonebookDao;
	
	@Override
	public List<PhonebookVo> getList() {
		List <PhonebookVo> list = phonebookDao.selectAll();
		return list;
	}

	@Override
	public List <PhonebookVo> search(String str) {
		List <PhonebookVo> list = phonebookDao.search(str);
		return list;
	}

	@Override
	public boolean write(PhonebookVo vo) {
		int insertedCount = phonebookDao.insert(vo);
		return insertedCount== 1;
	}

	@Override
	public boolean delete(Long id) {
		int deletedCount = phonebookDao.delete(id);
		return deletedCount == 1;
	}

	@Override
	public boolean update(PhonebookVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
