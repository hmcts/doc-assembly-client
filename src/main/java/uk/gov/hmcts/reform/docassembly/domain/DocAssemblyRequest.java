package uk.gov.hmcts.reform.docassembly.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.Base64;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Value
@ToString
public class DocAssemblyRequest {
    private String templateId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OutputType outputType;

    private FormPayload formPayload;

    private String outputFilename;

    private boolean secureDocStoreEnabled;

    private String caseTypeId;

    private String jurisdictionId;

    public static class DocAssemblyRequestBuilder {
        public DocAssemblyRequestBuilder templateId(String templateId) {
            this.templateId = Base64.getEncoder()
                .encodeToString(templateId.getBytes());
            return this;
        }
    }
}
