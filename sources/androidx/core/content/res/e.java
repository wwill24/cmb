package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e {

    static class a {
        static int a(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    public interface b {
    }

    public static final class c implements b {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final d[] f4547a;

        public c(@NonNull d[] dVarArr) {
            this.f4547a = dVarArr;
        }

        @NonNull
        public d[] a() {
            return this.f4547a;
        }
    }

    public static final class d {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final String f4548a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4549b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f4550c;

        /* renamed from: d  reason: collision with root package name */
        private final String f4551d;

        /* renamed from: e  reason: collision with root package name */
        private final int f4552e;

        /* renamed from: f  reason: collision with root package name */
        private final int f4553f;

        public d(@NonNull String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f4548a = str;
            this.f4549b = i10;
            this.f4550c = z10;
            this.f4551d = str2;
            this.f4552e = i11;
            this.f4553f = i12;
        }

        @NonNull
        public String a() {
            return this.f4548a;
        }

        public int b() {
            return this.f4553f;
        }

        public int c() {
            return this.f4552e;
        }

        public String d() {
            return this.f4551d;
        }

        public int e() {
            return this.f4549b;
        }

        public boolean f() {
            return this.f4550c;
        }
    }

    /* renamed from: androidx.core.content.res.e$e  reason: collision with other inner class name */
    public static final class C0036e implements b {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final androidx.core.provider.e f4554a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4555b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4556c;

        /* renamed from: d  reason: collision with root package name */
        private final String f4557d;

        public C0036e(@NonNull androidx.core.provider.e eVar, int i10, int i11, String str) {
            this.f4554a = eVar;
            this.f4556c = i10;
            this.f4555b = i11;
            this.f4557d = str;
        }

        public int a() {
            return this.f4556c;
        }

        @NonNull
        public androidx.core.provider.e b() {
            return this.f4554a;
        }

        public String c() {
            return this.f4557d;
        }

        public int d() {
            return this.f4555b;
        }
    }

    private static int a(TypedArray typedArray, int i10) {
        return a.a(typedArray, i10);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static androidx.core.content.res.e.b b(@androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r3, @androidx.annotation.NonNull android.content.res.Resources r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r2 = 1
            if (r0 == r2) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            if (r0 != r1) goto L_0x0012
            androidx.core.content.res.e$b r3 = d(r3, r4)
            return r3
        L_0x0012:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.e.b(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.res.e$b");
    }

    @NonNull
    public static List<List<byte[]>> c(@NonNull Resources resources, int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < obtainTypedArray.length(); i11++) {
                    int resourceId = obtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i10)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), t0.d.FontFamily);
        String string = obtainAttributes.getString(t0.d.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(t0.d.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(t0.d.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(t0.d.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(t0.d.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(t0.d.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = obtainAttributes.getString(t0.d.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(f(xmlPullParser, resources));
                    } else {
                        g(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new c((d[]) arrayList.toArray(new d[0]));
        }
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0036e(new androidx.core.provider.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        boolean z10;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), t0.d.FontFamilyFont);
        int i10 = t0.d.FontFamilyFont_fontWeight;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = t0.d.FontFamilyFont_android_fontWeight;
        }
        int i11 = obtainAttributes.getInt(i10, 400);
        int i12 = t0.d.FontFamilyFont_fontStyle;
        if (!obtainAttributes.hasValue(i12)) {
            i12 = t0.d.FontFamilyFont_android_fontStyle;
        }
        if (1 == obtainAttributes.getInt(i12, 0)) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i13 = t0.d.FontFamilyFont_ttcIndex;
        if (!obtainAttributes.hasValue(i13)) {
            i13 = t0.d.FontFamilyFont_android_ttcIndex;
        }
        int i14 = t0.d.FontFamilyFont_fontVariationSettings;
        if (!obtainAttributes.hasValue(i14)) {
            i14 = t0.d.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i14);
        int i15 = obtainAttributes.getInt(i13, 0);
        int i16 = t0.d.FontFamilyFont_font;
        if (!obtainAttributes.hasValue(i16)) {
            i16 = t0.d.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i16, 0);
        String string2 = obtainAttributes.getString(i16);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i11, z10, string, i15, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }
}
