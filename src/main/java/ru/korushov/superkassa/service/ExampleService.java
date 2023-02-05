package ru.korushov.superkassa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.korushov.superkassa.DTO.RequestDTO;
import ru.korushov.superkassa.DTO.ResponseDTO;
import ru.korushov.superkassa.model.Example;
import ru.korushov.superkassa.repository.ExampleRepository;
import ru.korushov.superkassa.util.MyJson;

import java.util.List;

/**
 * @author Vitaly Korushov
 */
@Service
@Transactional
public class ExampleService {

    @Autowired
    private final ExampleRepository exampleRepository;

    @Autowired
    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public Example findById(int id) {
        return exampleRepository.findById(id);
    }

    public ResponseDTO increaseNumber(RequestDTO requestDTO) {
        int id = requestDTO.getId();
        Example example = exampleRepository.findById(id);
        int currentNumber = example.getObj().getCurrent();
        currentNumber += requestDTO.getAdd();
        example.setObj(new MyJson(currentNumber));
        exampleRepository.update(example.getObj(), id);
        return new ResponseDTO(currentNumber);
    }

    public List<Example> getAll() {
        return exampleRepository.findAll();
    }
}
