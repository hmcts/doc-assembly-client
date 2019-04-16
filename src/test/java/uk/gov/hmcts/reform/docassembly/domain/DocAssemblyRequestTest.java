package uk.gov.hmcts.reform.docassembly.domain;

import org.junit.Test;

import java.util.Base64;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


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
        assertThat(docAssemblyRequest.getTemplateId(), is(encodedTemplateId));
    }

}
