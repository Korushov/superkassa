package ru.korushov.superkassa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import ru.korushov.superkassa.DTO.RequestDTO;
import ru.korushov.superkassa.controller.ExampleController;
import ru.korushov.superkassa.exception.ExampleException;
import ru.korushov.superkassa.model.Example;
import ru.korushov.superkassa.repository.ExampleRepository;
import ru.korushov.superkassa.util.MyJson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SuperkassaApplicationTests {

	@Autowired
	private ExampleRepository repository;

	@Autowired
	private ExampleController controller;

	private RequestDTO requestDTO;

	SuperkassaApplicationTests() {
	}

	@BeforeEach
	void init() {
		requestDTO = RequestDTO.builder().id(1).build();
	}

	@Test
	void invalidRequest() {
		assertThrows(Throwable.class, ()->controller.modify(requestDTO));
	}

	@Test
	void modify() throws ExampleException {
		int current = repository.findById(requestDTO.getId()).get().getObj().getCurrent();
		requestDTO.setAdd(10);
		repository.save(Example.builder().obj((new MyJson(current))).build());
		controller.modify(requestDTO);
		assertEquals(current + 10, repository.findById(requestDTO.getId()).get().getObj().getCurrent());
	}

}
