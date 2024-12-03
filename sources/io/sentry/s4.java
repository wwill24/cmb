package io.sentry;

import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.l;
import org.jetbrains.annotations.ApiStatus;

public final class s4 extends j4 {

    /* renamed from: k  reason: collision with root package name */
    private final String f31628k;

    /* renamed from: l  reason: collision with root package name */
    private final TransactionNameSource f31629l;

    /* renamed from: m  reason: collision with root package name */
    private r4 f31630m;

    /* renamed from: n  reason: collision with root package name */
    private c f31631n;

    /* renamed from: p  reason: collision with root package name */
    private Instrumenter f31632p;

    @ApiStatus.Internal
    public s4(String str, TransactionNameSource transactionNameSource, String str2) {
        this(str, transactionNameSource, str2, (r4) null);
    }

    public c o() {
        return this.f31631n;
    }

    public Instrumenter p() {
        return this.f31632p;
    }

    public String q() {
        return this.f31628k;
    }

    public r4 r() {
        return this.f31630m;
    }

    public TransactionNameSource s() {
        return this.f31629l;
    }

    @ApiStatus.Internal
    public s4(String str, TransactionNameSource transactionNameSource, String str2, r4 r4Var) {
        super(str2);
        this.f31632p = Instrumenter.SENTRY;
        this.f31628k = (String) l.c(str, "name is required");
        this.f31629l = transactionNameSource;
        l(r4Var);
    }
}
