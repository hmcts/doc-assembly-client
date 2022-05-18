package uk.gov.hmcts.reform.docassembly.domain;

import org.junit.Test;

import java.util.Base64;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertEquals(docAssemblyRequest.getTemplateId(), is(encodedTemplateId));
    }

    @Test
    public void shouldCreateRequestWithFileName() {
        String fileName = "fileName";
        DocAssemblyRequest docAssemblyRequest = DocAssemblyRequest
            .builder()
            .outputFilename(fileName)
            .build();
        assertEquals(docAssemblyRequest.getOutputFilename(), is(fileName));
    }

    @Test
    public void shouldCreateRequestWithSecureDocStoreEnabled() {

        DocAssemblyRequest docAssemblyRequest = DocAssemblyRequest
            .builder()
            .secureDocStoreEnabled(true)
            .build();
        assertTrue(docAssemblyRequest.isSecureDocStoreEnabled());
    }

    @Test
    public void shouldCreateRequestWithCaseTypeId() {
        String caseTypeId = "TEST";
        DocAssemblyRequest docAssemblyRequest = DocAssemblyRequest
            .builder()
            .caseTypeId(caseTypeId)
            .build();
        assertEquals(docAssemblyRequest.getCaseTypeId(), caseTypeId);
        assertFalse(docAssemblyRequest.isSecureDocStoreEnabled());
    }

    @Test
    public void shouldCreateRequestWithJurisdictionId() {
        String jurisdictionId = "TEST";
        DocAssemblyRequest docAssemblyRequest = DocAssemblyRequest
            .builder()
            .caseTypeId(jurisdictionId)
            .build();
        assertEquals(docAssemblyRequest.getJurisdictionId(), jurisdictionId);
        assertFalse(docAssemblyRequest.isSecureDocStoreEnabled());
    }

}
