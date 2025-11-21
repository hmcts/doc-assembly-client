package uk.gov.hmcts.reform.docassembly.healthcheck;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.health.contributor.Status;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InternalHealth(Status status) {
    @JsonCreator
    public InternalHealth(String status) {
        this(new Status(status));
    }
}
