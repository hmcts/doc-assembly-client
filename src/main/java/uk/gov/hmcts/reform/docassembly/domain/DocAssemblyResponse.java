package uk.gov.hmcts.reform.docassembly.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@EqualsAndHashCode
public class DocAssemblyResponse {
    private String renditionOutputLocation;
}
