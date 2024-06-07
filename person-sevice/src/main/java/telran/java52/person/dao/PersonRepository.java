package telran.java52.person.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import telran.java52.person.dto.CityPopulationDto;
import telran.java52.person.model.Child;
import telran.java52.person.model.Employee;
import telran.java52.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("select p from Person p where p.name=?1")
	Stream<Person> findByNameIgnoreCase(String name);
		
	@Query("select p from Person p where p.address.city=:cityName")
	Stream<Person> findByAddressCityIgnoreCase(String city);
	
	Stream<Person> findByBirthDateBetween(LocalDate from, LocalDate to);
	
	@Query ("select new telran.java52.person.dto.CityPopulationDto(p.address.city, count(p)) from Person p group by p.address.city order by count(p) desc")
	List<CityPopulationDto> getCitiesPopulation();
	
	@Query("select p from Child p")
	Stream<Child> findAllChildren();
	
	@Query ("select p from Employee p where p.salary between ?1 and ?2")
	Stream<Employee>findBySalary(double minSalary, double maxSalary);
}