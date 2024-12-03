package com.withpersona.sdk2.camera;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.MatchResult;

final class MrzExtraction$Companion$parseTd3$1 extends Lambda implements Function1<MatchResult, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final MrzExtraction$Companion$parseTd3$1 f14168a = new MrzExtraction$Companion$parseTd3$1();

    MrzExtraction$Companion$parseTd3$1() {
        super(1);
    }

    /* renamed from: a */
    public final CharSequence invoke(MatchResult matchResult) {
        j.g(matchResult, "it");
        return matchResult.getValue();
    }
}
