package ru.korushov.superkassa.controller;

import jakarta.validation.Valid;
import org.hibernate.exception.LockTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.korushov.superkassa.DTO.RequestDTO;
import ru.korushov.superkassa.DTO.ResponseDTO;
import ru.korushov.superkassa.model.Example;
import ru.korushov.superkassa.service.ExampleService;

import java.util.List;

/**
 * @author Vitaly Korushov
 */

@RestController
public class ExampleController {

    private final ExampleService exampleService;


    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }


    @GetMapping("/all")
    public List<Example> getAll() {
        return exampleService.getAll();
    }

    @PostMapping("/modify")
    public ResponseEntity<ResponseDTO> modify(@Valid @RequestBody RequestDTO requestDTO) throws Exception {
            try{
                ResponseDTO responseDTO = exampleService.increaseNumber(requestDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } catch (LockTimeoutException e) {
                return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
            }

    }

}
