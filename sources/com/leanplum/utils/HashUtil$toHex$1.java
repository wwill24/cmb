package com.leanplum.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "eachByte", "", "invoke"}, k = 3, mv = {1, 4, 2})
final class HashUtil$toHex$1 extends Lambda implements Function1<Byte, CharSequence> {
    public static final HashUtil$toHex$1 INSTANCE = new HashUtil$toHex$1();

    HashUtil$toHex$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).byteValue());
    }

    public final CharSequence invoke(byte b10) {
        String format2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
        j.f(format2, "java.lang.String.format(this, *args)");
        return format2;
    }
}
