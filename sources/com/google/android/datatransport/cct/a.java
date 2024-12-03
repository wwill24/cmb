package com.google.android.datatransport.cct;

import androidx.annotation.NonNull;
import cd.b;
import ed.g;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

public final class a implements g {

    /* renamed from: c  reason: collision with root package name */
    static final String f37960c;

    /* renamed from: d  reason: collision with root package name */
    static final String f37961d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f37962e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<b> f37963f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new b[]{b.b("proto"), b.b(JsonPacketExtension.ELEMENT)})));

    /* renamed from: g  reason: collision with root package name */
    public static final a f37964g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f37965h;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f37966a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37967b;

    static {
        String a10 = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f37960c = a10;
        String a11 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f37961d = a11;
        String a12 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f37962e = a12;
        f37964g = new a(a10, (String) null);
        f37965h = new a(a11, a12);
    }

    public a(@NonNull String str, String str2) {
        this.f37966a = str;
        this.f37967b = str2;
    }

    @NonNull
    public static a c(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    public Set<b> a() {
        return f37963f;
    }

    public byte[] b() {
        String str = this.f37967b;
        if (str == null && this.f37966a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f37966a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f37967b;
    }

    @NonNull
    public String e() {
        return this.f37966a;
    }

    public byte[] getExtras() {
        return b();
    }

    @NonNull
    public String getName() {
        return "cct";
    }
}
