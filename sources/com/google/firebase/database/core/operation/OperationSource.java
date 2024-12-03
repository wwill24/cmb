package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;

public class OperationSource {
    public static final OperationSource SERVER = new OperationSource(Source.Server, (QueryParams) null, false);
    public static final OperationSource USER = new OperationSource(Source.User, (QueryParams) null, false);
    private final QueryParams queryParams;
    private final Source source;
    private final boolean tagged;

    private enum Source {
        User,
        Server
    }

    public OperationSource(Source source2, QueryParams queryParams2, boolean z10) {
        boolean z11;
        this.source = source2;
        this.queryParams = queryParams2;
        this.tagged = z10;
        if (!z10 || isFromServer()) {
            z11 = true;
        } else {
            z11 = false;
        }
        Utilities.hardAssert(z11);
    }

    public static OperationSource forServerTaggedQuery(QueryParams queryParams2) {
        return new OperationSource(Source.Server, queryParams2, true);
    }

    public QueryParams getQueryParams() {
        return this.queryParams;
    }

    public boolean isFromServer() {
        return this.source == Source.Server;
    }

    public boolean isFromUser() {
        return this.source == Source.User;
    }

    public boolean isTagged() {
        return this.tagged;
    }

    public String toString() {
        return "OperationSource{source=" + this.source + ", queryParams=" + this.queryParams + ", tagged=" + this.tagged + '}';
    }
}
