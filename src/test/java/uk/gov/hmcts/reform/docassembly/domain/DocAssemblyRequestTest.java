package uk.gov.hmcts.reform.docassembly.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Base64;

public class DocAssemblyRequestTest {

    @Test
    public void shouldCreateRequestWithEncodedTemplate() {
        String templateId = "this-is-a-template";
        DocAssemblyRequest docAssemblyRequest = DocAssemblyRequest
            .builder()
            .templateId(templateId)
            .build();
        String encodedTemplateId = Base64.getEncoder()
            .encodeToString(templateId.getBytes());
        Assertions.assertEquals(docAssemblyRequest.getTemplateId(), encodedTemplateId);
    }

    @Test
    public void shouldCreateRequestWithFileName() {
        String fileName = "fileName";
        DocAssemblyRequest docAssemblyRequest = DocAssemblyRequest
            .builder()
            .outputFilename(fileName)
            .build();
        Assertions.assertEquals(docAssemblyRequest.getOutputFilename(), fileName);
    }

    @Test
    public void shouldCreateRequestWithSecureDocStoreEnabled() {

        DocAssemblyRequest docAssemblyRequest = DocAssemblyRequest
            .builder()
            .secureDocStoreEnabled(true)
            .build();
        Assertions.assertTrue(docAssemblyRequest.isSecureDocStoreEnabled());
    }

    @Test
    public void shouldCreateRequestWithCaseTypeId() {
        String caseTypeId = "TEST";
        DocAssemblyRequest docAssemblyRequest = DocAssemblyRequest
            .builder()
            .caseTypeId(caseTypeId)
            .build();
        Assertions.assertEquals(docAssemblyRequest.getCaseTypeId(), caseTypeId);
        Assertions.assertFalse(docAssemblyRequest.isSecureDocStoreEnabled());
    }

    @Test
    public void shouldCreateRequestWithJurisdictionId() {
        String jurisdictionId = "TEST";
        DocAssemblyRequest docAssemblyRequest = DocAssemblyRequest
            .builder()
            .jurisdictionId(jurisdictionId)
            .build();
        Assertions.assertEquals(docAssemblyRequest.getJurisdictionId(), jurisdictionId);
        Assertions.assertFalse(docAssemblyRequest.isSecureDocStoreEnabled());
    }

}
