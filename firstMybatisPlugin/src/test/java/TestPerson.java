import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zno.pojo.Person;
import cn.zno.pojo.PersonExample;
import cn.zno.pojo.PersonExample.Criteria;
import cn.zno.service.PersonService;

@ContextConfiguration(locations = {"classpath:beans-transaction.xml"})
@RunWith(SpringJUnit4ClassRunner.class) 
//@Transactional
public class TestPerson {
	
	@Autowired
	private PersonService personService;
	
	@Test
	public void insert(){
		for(int i=0;i<10;i++){
			Person person = new Person();
			person.setName("xiaoming");
			person.setAge(BigDecimal.valueOf(11));
			personService.insert(person);
		}
		
	}
	
	@Test
	public void update(){
		Person person = new Person();
		person.setName("xiaoming111");
		person.setAge(BigDecimal.valueOf(11));
		
		PersonExample example = new PersonExample();
		Criteria cri = example.createCriteria();
		cri.andAgeEqualTo(new BigDecimal(11));
		personService.update(person, example);
	}
	
	
	@Test
	public void select(){
		List<Person> listPerson = personService.select();
		for(Person person : listPerson ){
			System.out.println(person.toString());
		}
	}
}
