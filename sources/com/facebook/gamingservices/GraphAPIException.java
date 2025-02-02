package com.facebook.gamingservices;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/gamingservices/GraphAPIException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GraphAPIException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphAPIException(String str) {
        super(str);
        j.g(str, "message");
    }
}
