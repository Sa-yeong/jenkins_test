package student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {
	
	StudentManager studentManager;
	
	@BeforeAll
	void setup() {
		studentManager = new StudentManager();
		studentManager.addStudent("철수");
	}
	
	@Order(1)
	@Test
	void AddNewStudent() {
		studentManager.addStudent("홍길동");
		assertTrue(studentManager.hasStudent("홍길동"));
	}
	
	@Order(2)
	@Test
	void DeleteStudent() {
		studentManager.removeStudent("홍길동");
		assertFalse(studentManager.hasStudent("홍길동"));
	}
	
	@Order(3)
	@Test
	void AddDuplicateStudent() {
		assertThrows(IllegalArgumentException.class, () -> {
			studentManager.addStudent("철수");
		});
	}
	
	@Order(4)
	@Test
	void DeleteNonExistStudent() {
		assertThrows(IllegalArgumentException.class, () -> {
			studentManager.removeStudent("홍길동");
		});
	}

}
