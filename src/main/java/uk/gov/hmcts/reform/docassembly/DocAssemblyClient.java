package uk.gov.hmcts.reform.docassembly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import uk.gov.hmcts.reform.docassembly.domain.DocAssemblyRequest;
import uk.gov.hmcts.reform.docassembly.domain.DocAssemblyResponse;
import uk.gov.hmcts.reform.docassembly.exception.DocumentGenerationFailedException;

@Component
@ConditionalOnProperty(prefix = "doc_assembly", name = "url")
public class DocAssemblyClient {
    private final DocAssemblyApi docAssemblyApi;

    @Autowired
    public DocAssemblyClient(DocAssemblyApi docAssemblyApi) {
        this.docAssemblyApi = docAssemblyApi;
    }

    public DocAssemblyResponse generateOrder(String authorisation,
                                             String serviceAuthorisation,
                                             DocAssemblyRequest docAssemblyRequest) {
        try {
            return docAssemblyApi.generateOrder(
                authorisation,
                serviceAuthorisation,
                docAssemblyRequest);
        } catch (Exception e) {
            throw new DocumentGenerationFailedException(e);
        }
    }
}
