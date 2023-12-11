package sk.umb.cavtasbe.TestingPart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.umb.cavtasbe.TestingPart.persistence.entity.TestingEntity;
import sk.umb.cavtasbe.TestingPart.persistence.repository.TestingRepository;

@Service
public class TestingService {
    
    @Autowired
    private final TestingRepository testingRepository;

    public TestingService(TestingRepository testingRepository) {

        this.testingRepository = testingRepository;

    }


    public TestingDetailDTO getTestingItemById(Long id) {
        return mapToTestingDetailDTO(testingRepository.findById(id).get());
    }

    public List<TestingDetailDTO> getAllTestingItems() {
        return mapToTestingDetailList(testingRepository.findAll());
    }


    @Transactional
    public String createTestingItem(TestingRequestDTO testingRequestDTO) {

        TestingEntity testingEntity = new TestingEntity();

        if(testingRequestDTO.getContent().isEmpty()) {
            return "error, content must be added";
        } else {
            testingEntity.setContent(testingRequestDTO.getContent());
        }

        testingEntity.setGeneratedContent("Freshly created");

        return testingRepository.save(testingEntity).getId().toString();

    }


    public TestingDetailDTO mapToTestingDetailDTO(TestingEntity testingEntity) {

        TestingDetailDTO testingDetailDTO = new TestingDetailDTO();
        testingDetailDTO.setId(testingEntity.getId());
        testingDetailDTO.setContent(testingEntity.getContent());
        testingDetailDTO.setGeneratedContent(testingEntity.getGeneratedContent());

        return testingDetailDTO;

    }

    public List<TestingDetailDTO> mapToTestingDetailList(List<TestingEntity> testingEntities) {

        List<TestingDetailDTO> testingDetailDTOs = new ArrayList<TestingDetailDTO>();

        testingEntities.forEach(entity -> {
            TestingDetailDTO testingDetailDTO = new TestingDetailDTO();
            testingDetailDTO.setId(entity.getId());
            testingDetailDTO.setContent(entity.getContent());
            testingDetailDTO.setGeneratedContent(entity.getGeneratedContent());
            testingDetailDTOs.add(testingDetailDTO);
        });

        return testingDetailDTOs;

    }


}
