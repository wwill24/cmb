package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.n3;
import io.sentry.w2;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public interface f {
    void a(DiscardReason discardReason, DataCategory dataCategory);

    void b(DiscardReason discardReason, w2 w2Var);

    void c(DiscardReason discardReason, n3 n3Var);

    w2 d(w2 w2Var);
}
