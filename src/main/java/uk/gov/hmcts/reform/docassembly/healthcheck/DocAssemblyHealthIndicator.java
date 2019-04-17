package uk.gov.hmcts.reform.docassembly.healthcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import uk.gov.hmcts.reform.docassembly.DocAssemblyApi;

public class DocAssemblyHealthIndicator implements HealthIndicator {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocAssemblyHealthIndicator.class);

    private final DocAssemblyApi docAssemblyApi;

    public DocAssemblyHealthIndicator(final DocAssemblyApi docAssemblyApi) {
        this.docAssemblyApi = docAssemblyApi;
    }

    @Override
    public Health health() {
        try {
            InternalHealth internalHealth = this.docAssemblyApi.health();
            return new Health.Builder(internalHealth.getStatus()).build();
        } catch (Exception ex) {
            LOGGER.error("Error on doc assembly client healthcheck", ex);
            return Health.down(ex).build();
        }
    }
}
