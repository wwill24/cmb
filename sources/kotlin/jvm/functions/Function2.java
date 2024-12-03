package kotlin.jvm.functions;

import gk.c;

public interface Function2<P1, P2, R> extends c<R> {
    R invoke(P1 p12, P2 p22);
}
