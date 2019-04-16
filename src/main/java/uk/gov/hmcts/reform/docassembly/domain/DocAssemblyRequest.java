package uk.gov.hmcts.reform.docassembly.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Base64;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
@EqualsAndHashCode
public class DocAssemblyRequest {
    private String templateId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OutputType outputType;

    private FormPayload formPayload;

    public static class DocAssemblyRequestBuilder {
        public DocAssemblyRequestBuilder templateId(String templateId) {
            this.templateId = Base64.getEncoder()
                .encodeToString(templateId.getBytes());
            return this;
        }
    }
}
