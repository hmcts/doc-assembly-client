package uk.gov.hmcts.reform.docassembly;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.hmcts.reform.docassembly.domain.DocAssemblyRequest;
import uk.gov.hmcts.reform.docassembly.exception.DocumentGenerationFailedException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocAssemblyClientTest {

    private static final String BEARER_TOKEN = "Bearer let me in";
    private static final String SERVICE_TOKEN = "Bearer service let me in";
    @Mock
    private DocAssemblyApi docAssemblyApi;

    private DocAssemblyClient docAssemblyClient;

    @Before
    public void setUp() {
        docAssemblyClient = new DocAssemblyClient(docAssemblyApi);
    }

    @Test(expected = DocumentGenerationFailedException.class)
    public void shouldThrowIfCallToDocAssemblyFails() {
        when(docAssemblyApi.generateOrder(
            eq(BEARER_TOKEN),
            eq(SERVICE_TOKEN),
            any(DocAssemblyRequest.class))).thenThrow(RuntimeException.class);

        docAssemblyClient.generateOrder(
            BEARER_TOKEN,
            SERVICE_TOKEN,
            DocAssemblyRequest.builder().build());
    }

}
