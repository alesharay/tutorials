package com.aleshamray.amigoscoderestapi;

import com.aleshamray.amigoscoderestapi.domain.Address;
import com.aleshamray.amigoscoderestapi.domain.Student;
import com.aleshamray.amigoscoderestapi.enums.Gender;
import com.aleshamray.amigoscoderestapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class AmigoscoderestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmigoscoderestapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address(
				"England",
				"London",
				"NE9"
			);

			String email = "jahmed@gmail.com";

			Student student = new Student(
					"Jamila",
					"Ahmed",
					email,
					Gender.FEMALE,
					address,
					List.of("computer science, maths"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

//			usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
 			repository.findStudentByEmail(email)
					.ifPresentOrElse(s -> System.out.println("\n" + s + " already exists"), () -> {
						System.out.println("\nInserting student " + student);
						repository.insert(student);
					});
		};
	}

	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Student> students = mongoTemplate.find(query, Student.class);

		if(students.size() > 1) {
			throw new IllegalStateException("Found many students with email " + email);
		}

		if(students.isEmpty()) {
			System.out.println("\nInserting student " + student);
			repository.insert(student);
		} else {
			System.out.println("\n" + student + " already exists");
		}
	}
}