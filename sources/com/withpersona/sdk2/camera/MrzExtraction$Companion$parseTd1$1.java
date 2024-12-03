package com.withpersona.sdk2.camera;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.MatchResult;

final class MrzExtraction$Companion$parseTd1$1 extends Lambda implements Function1<MatchResult, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final MrzExtraction$Companion$parseTd1$1 f14167a = new MrzExtraction$Companion$parseTd1$1();

    MrzExtraction$Companion$parseTd1$1() {
        super(1);
    }

    /* renamed from: a */
    public final CharSequence invoke(MatchResult matchResult) {
        j.g(matchResult, "it");
        return matchResult.getValue();
    }
}
