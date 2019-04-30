package uk.gov.hmcts.reform.docassembly;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import uk.gov.hmcts.reform.docassembly.domain.DocAssemblyRequest;
import uk.gov.hmcts.reform.docassembly.domain.DocAssemblyResponse;
import uk.gov.hmcts.reform.docassembly.healthcheck.InternalHealth;

@FeignClient(name = "doc-assembly-api", url = "${doc_assembly.url}")
public interface DocAssemblyApi {
    @GetMapping("/health")
    InternalHealth health();

    @PostMapping(
        value = "/api/template-renditions",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    DocAssemblyResponse generateOrder(
        @RequestHeader(HttpHeaders.AUTHORIZATION) String authorisation,
        @RequestHeader("ServiceAuthorization") String serviceAuthorisation,
        DocAssemblyRequest request
    );
}
