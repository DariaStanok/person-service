package telran.java52.person.model;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity 
//! mozhno ne stavit' @ v sluchae SINGLE_TABLE
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) - vse v odnoi tablitse
//@Inheritance(strategy = InheritanceType.JOINED)- obshaya tablitsa + unikal'naya dlya kazhdogo child s ego dannimi
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS) // u kazhdogo svoya table so svoimi dannimi
public class Person implements Serializable {
	private static final long serialVersionUID = 2881753026638817581L;
	@Id
	Integer id;
	@Setter
	String name;
	LocalDate birthDate;
	@Setter
//	@Embedded
	Address address;
}