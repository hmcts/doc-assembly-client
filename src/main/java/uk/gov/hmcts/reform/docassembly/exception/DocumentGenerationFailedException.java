package uk.gov.hmcts.reform.docassembly.exception;

public class DocumentGenerationFailedException extends RuntimeException {

    public DocumentGenerationFailedException(Throwable cause) {
        super(cause);
    }
}
