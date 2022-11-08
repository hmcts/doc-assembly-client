package uk.gov.hmcts.reform.docassembly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.hmcts.reform.docassembly.domain.DocAssemblyRequest;
import uk.gov.hmcts.reform.docassembly.exception.DocumentGenerationFailedException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DocAssemblyClientTest {

    private static final String BEARER_TOKEN = "Bearer let me in";
    private static final String SERVICE_TOKEN = "Bearer service let me in";
    @Mock
    private DocAssemblyApi docAssemblyApi;

    private DocAssemblyClient docAssemblyClient;

    @BeforeEach
    public void setUp() {
        docAssemblyClient = new DocAssemblyClient(docAssemblyApi);
    }

    @Test()
    public void shouldThrowIfCallToDocAssemblyFails() {
        when(docAssemblyApi.generateOrder(
            eq(BEARER_TOKEN),
            eq(SERVICE_TOKEN),
            any(DocAssemblyRequest.class))).thenThrow(RuntimeException.class);

        assertThrows(DocumentGenerationFailedException.class, () -> {
            docAssemblyClient.generateOrder(
                BEARER_TOKEN,
                SERVICE_TOKEN,
                DocAssemblyRequest.builder().build());
        });
    }

}
