package com.coffeemeetsbagel.country;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class CmbCountry$flag$2 extends Lambda implements Function0<String> {
    final /* synthetic */ CmbCountry this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CmbCountry$flag$2(CmbCountry cmbCountry) {
        super(0);
        this.this$0 = cmbCountry;
    }

    /* renamed from: a */
    public final String invoke() {
        StringBuilder sb2 = new StringBuilder();
        char[] chars = Character.toChars(Character.codePointAt(this.this$0.f11580d, 0) + 127397);
        j.f(chars, "toChars(firstLetter)");
        sb2.append(new String(chars));
        char[] chars2 = Character.toChars(Character.codePointAt(this.this$0.f11580d, 1) + 127397);
        j.f(chars2, "toChars(secondLetter)");
        sb2.append(new String(chars2));
        return sb2.toString();
    }
}
