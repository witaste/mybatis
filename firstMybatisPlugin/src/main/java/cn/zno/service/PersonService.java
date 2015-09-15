package cn.zno.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zno.dao.PersonMapper;
import cn.zno.pojo.Person;
import cn.zno.pojo.PersonExample;

@Service
public class PersonService {

	@Autowired
	private PersonMapper personMapper;

	public void insert(Person person){
		personMapper.insertSelective(person);
	}
	
	public void update(Person person ,PersonExample example){
		personMapper.updateByExampleSelective(person, example);
	}
	
	public List<Person> select(){
		int pageNo =1;
		int pageSize=5;
		return personMapper.selectByExample(new PersonExample(),new RowBounds((pageNo - 1) * pageSize,pageSize));
	}
}
