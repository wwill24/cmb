package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.integrity.model.a;
import java.util.Locale;

public class IntegrityServiceException extends ApiException {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f20473a;

    IntegrityServiceException(int i10, Throwable th2) {
        super(new Status(i10, String.format(Locale.ROOT, "Integrity API error (%d): %s.", new Object[]{Integer.valueOf(i10), a.a(i10)})));
        if (i10 != 0) {
            this.f20473a = th2;
            return;
        }
        throw new IllegalArgumentException("ErrorCode should not be 0.");
    }

    public final synchronized Throwable getCause() {
        return this.f20473a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
