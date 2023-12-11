package sk.umb.cavtasbe.TestingPart.service;

public class TestingRequestDTO {
    
    
    private String content;
    private String generatedContent;


    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getGeneratedContent() {
        return generatedContent;
    }

    public void setGeneratedContent(String generatedContent) {
        this.generatedContent = generatedContent;
    }

}
