package com.example.sc.common;

import lombok.*;

import javax.annotation.Nonnull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OpenResponse implements StatusAware, Serializable {
    private static final long serialVersionUID = 4752294758601904847L;
    @Builder.Default
    private int status = STATUS_OK;
    private String notes;
    private String remarks;

    public void setStatusOK() {
        setStatus(STATUS_OK);
    }

    public void setStatusFailed() {
        setStatus(STATUS_FAILED);
    }

    @Nonnull
    public static OpenResponse ok(String remarks) {
        return new OpenResponse(STATUS_OK, null, remarks);
    }

    @Nonnull
    public static OpenResponse ok() {
        return ok(null);
    }

    @Nonnull
    public static OpenResponse failed(String notes) {
        return failed(notes, null);
    }

    @Nonnull
    public static OpenResponse failed(String notes, String remarks) {
        return new OpenResponse(STATUS_FAILED, notes, remarks);
    }
}
