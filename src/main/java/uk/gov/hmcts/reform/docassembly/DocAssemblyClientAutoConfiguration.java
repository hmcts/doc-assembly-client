package uk.gov.hmcts.reform.docassembly;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.gov.hmcts.reform.docassembly.healthcheck.DocAssemblyHealthIndicator;

@Configuration
@ConditionalOnProperty(prefix = "doc_assembly", name = "url")
@EnableFeignClients(basePackages = "uk.gov.hmcts.reform.docassembly")
public class DocAssemblyClientAutoConfiguration {
    @Bean
    public DocAssemblyHealthIndicator docAssemblyHealthIndicator(
        DocAssemblyApi docAssemblyApi) {
        return new DocAssemblyHealthIndicator(docAssemblyApi);
    }
}
