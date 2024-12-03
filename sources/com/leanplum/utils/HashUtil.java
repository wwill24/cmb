package com.leanplum.utils;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.text.d;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\n\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, d2 = {"Lcom/leanplum/utils/HashUtil;", "", "()V", "sha256", "", "text", "limit", "", "sha256_200", "sha256_40", "toHex", "", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class HashUtil {
    public static final HashUtil INSTANCE = new HashUtil();

    private HashUtil() {
    }

    public static /* synthetic */ String sha256$default(HashUtil hashUtil, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 32;
        }
        return hashUtil.sha256(str, i10);
    }

    private final String toHex(byte[] bArr, int i10) {
        return l.X(bArr, "", (CharSequence) null, (CharSequence) null, i10, "", HashUtil$toHex$1.INSTANCE, 6, (Object) null);
    }

    public final String sha256(String str, int i10) {
        j.g(str, "text");
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(d.f32216b);
        j.f(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        j.f(digest, "MessageDigest\n      .get…yteArray(Charsets.UTF_8))");
        return toHex(digest, i10);
    }

    public final String sha256_200(String str) {
        j.g(str, "text");
        return sha256(str, 25);
    }

    public final String sha256_40(String str) {
        j.g(str, "text");
        return sha256(str, 5);
    }
}
