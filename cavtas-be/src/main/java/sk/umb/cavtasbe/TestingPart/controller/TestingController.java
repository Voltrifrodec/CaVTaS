package sk.umb.cavtasbe.TestingPart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sk.umb.cavtasbe.TestingPart.service.TestingDetailDTO;
import sk.umb.cavtasbe.TestingPart.service.TestingRequestDTO;
import sk.umb.cavtasbe.TestingPart.service.TestingService;

@RestController
public class TestingController {
    
    @Autowired
    private final TestingService testingService;

    public TestingController(TestingService testingService) {
        this.testingService = testingService;
    }


    @GetMapping("/api/test")
    public List<TestingDetailDTO> getAllTestingitems() {
        System.out.println("'Get all testing items' request has been called");
        return testingService.getAllTestingItems();
    }

    @GetMapping("/api/test/{id}")
    public TestingDetailDTO getTestingItemById(@PathVariable Long id) {
        System.out.println("'Get testing item by ID' request has been called, ID: " + id);
        return testingService.getTestingItemById(id);
    }

    
    @PostMapping("/api/test")
    public String createTestingItem(@RequestBody TestingRequestDTO testingRequestDTO) {
        System.out.println("'Create new testing item' request has been called.");
        return testingService.createTestingItem(testingRequestDTO);
    }
    
}
