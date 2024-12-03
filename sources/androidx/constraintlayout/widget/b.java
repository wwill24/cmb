package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f4204a;

    /* renamed from: b  reason: collision with root package name */
    c f4205b;

    /* renamed from: c  reason: collision with root package name */
    int f4206c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f4207d = -1;

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<a> f4208e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<c> f4209f = new SparseArray<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f4210a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<C0028b> f4211b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f4212c = -1;

        /* renamed from: d  reason: collision with root package name */
        c f4213d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.State_android_id) {
                    this.f4210a = obtainStyledAttributes.getResourceId(index, this.f4210a);
                } else if (index == h.State_constraints) {
                    this.f4212c = obtainStyledAttributes.getResourceId(index, this.f4212c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4212c);
                    context.getResources().getResourceName(this.f4212c);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f4213d = cVar;
                        cVar.e(context, this.f4212c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(C0028b bVar) {
            this.f4211b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f4211b.size(); i10++) {
                if (this.f4211b.get(i10).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b  reason: collision with other inner class name */
    static class C0028b {

        /* renamed from: a  reason: collision with root package name */
        float f4214a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f4215b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f4216c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f4217d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        int f4218e = -1;

        /* renamed from: f  reason: collision with root package name */
        c f4219f;

        public C0028b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.Variant_constraints) {
                    this.f4218e = obtainStyledAttributes.getResourceId(index, this.f4218e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4218e);
                    context.getResources().getResourceName(this.f4218e);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f4219f = cVar;
                        cVar.e(context, this.f4218e);
                    }
                } else if (index == h.Variant_region_heightLessThan) {
                    this.f4217d = obtainStyledAttributes.getDimension(index, this.f4217d);
                } else if (index == h.Variant_region_heightMoreThan) {
                    this.f4215b = obtainStyledAttributes.getDimension(index, this.f4215b);
                } else if (index == h.Variant_region_widthLessThan) {
                    this.f4216c = obtainStyledAttributes.getDimension(index, this.f4216c);
                } else if (index == h.Variant_region_widthMoreThan) {
                    this.f4214a = obtainStyledAttributes.getDimension(index, this.f4214a);
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f4214a) && f10 < this.f4214a) {
                return false;
            }
            if (!Float.isNaN(this.f4215b) && f11 < this.f4215b) {
                return false;
            }
            if (!Float.isNaN(this.f4216c) && f10 > this.f4216c) {
                return false;
            }
            if (Float.isNaN(this.f4217d) || f11 <= this.f4217d) {
                return true;
            }
            return false;
        }
    }

    b(Context context, ConstraintLayout constraintLayout, int i10) {
        this.f4204a = constraintLayout;
        a(context, i10);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r10 = r0.getXml(r10)
            r0 = 0
            int r1 = r10.getEventType()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
        L_0x000d:
            r2 = 1
            if (r1 == r2) goto L_0x008c
            if (r1 == 0) goto L_0x007b
            r3 = 2
            if (r1 == r3) goto L_0x0017
            goto L_0x007e
        L_0x0017:
            java.lang.String r1 = r10.getName()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r4 = -1
            int r5 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r6 = 4
            r7 = 3
            switch(r5) {
                case -1349929691: goto L_0x004d;
                case 80204913: goto L_0x0043;
                case 1382829617: goto L_0x003a;
                case 1657696882: goto L_0x0030;
                case 1901439077: goto L_0x0026;
                default: goto L_0x0025;
            }     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
        L_0x0025:
            goto L_0x0057
        L_0x0026:
            java.lang.String r2 = "Variant"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = r7
            goto L_0x0058
        L_0x0030:
            java.lang.String r2 = "layoutDescription"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = 0
            goto L_0x0058
        L_0x003a:
            java.lang.String r5 = "StateSet"
            boolean r1 = r1.equals(r5)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0043:
            java.lang.String r2 = "State"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = r3
            goto L_0x0058
        L_0x004d:
            java.lang.String r2 = "ConstraintSet"
            boolean r1 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r1 == 0) goto L_0x0057
            r2 = r6
            goto L_0x0058
        L_0x0057:
            r2 = r4
        L_0x0058:
            if (r2 == r3) goto L_0x006e
            if (r2 == r7) goto L_0x0063
            if (r2 == r6) goto L_0x005f
            goto L_0x007e
        L_0x005f:
            r8.b(r9, r10)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x007e
        L_0x0063:
            androidx.constraintlayout.widget.b$b r1 = new androidx.constraintlayout.widget.b$b     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r1.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            if (r0 == 0) goto L_0x007e
            r0.a(r1)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x007e
        L_0x006e:
            androidx.constraintlayout.widget.b$a r0 = new androidx.constraintlayout.widget.b$a     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r0.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            android.util.SparseArray<androidx.constraintlayout.widget.b$a> r1 = r8.f4208e     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            int r2 = r0.f4210a     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            r1.put(r2, r0)     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x007e
        L_0x007b:
            r10.getName()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
        L_0x007e:
            int r1 = r10.next()     // Catch:{ XmlPullParserException -> 0x0088, IOException -> 0x0083 }
            goto L_0x000d
        L_0x0083:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x008c
        L_0x0088:
            r9 = move-exception
            r9.printStackTrace()
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.a(android.content.Context, int):void");
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        int i10;
        c cVar = new c();
        int attributeCount = xmlPullParser.getAttributeCount();
        int i11 = 0;
        while (i11 < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            if (attributeName == null || attributeValue == null || !"id".equals(attributeName)) {
                i11++;
            } else {
                if (attributeValue.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                    i10 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i10 = -1;
                }
                if (i10 == -1 && attributeValue.length() > 1) {
                    i10 = Integer.parseInt(attributeValue.substring(1));
                }
                cVar.x(context, xmlPullParser);
                this.f4209f.put(i10, cVar);
                return;
            }
        }
    }

    public void c(e eVar) {
    }

    public void d(int i10, float f10, float f11) {
        c cVar;
        a aVar;
        int b10;
        c cVar2;
        int i11 = this.f4206c;
        if (i11 == i10) {
            if (i10 == -1) {
                aVar = this.f4208e.valueAt(0);
            } else {
                aVar = this.f4208e.get(i11);
            }
            int i12 = this.f4207d;
            if ((i12 == -1 || !aVar.f4211b.get(i12).a(f10, f11)) && this.f4207d != (b10 = aVar.b(f10, f11))) {
                if (b10 == -1) {
                    cVar2 = this.f4205b;
                } else {
                    cVar2 = aVar.f4211b.get(b10).f4219f;
                }
                if (b10 != -1) {
                    int i13 = aVar.f4211b.get(b10).f4218e;
                }
                if (cVar2 != null) {
                    this.f4207d = b10;
                    cVar2.c(this.f4204a);
                    return;
                }
                return;
            }
            return;
        }
        this.f4206c = i10;
        a aVar2 = this.f4208e.get(i10);
        int b11 = aVar2.b(f10, f11);
        if (b11 == -1) {
            cVar = aVar2.f4213d;
        } else {
            cVar = aVar2.f4211b.get(b11).f4219f;
        }
        if (b11 != -1) {
            int i14 = aVar2.f4211b.get(b11).f4218e;
        }
        if (cVar == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NO Constraint set found ! id=");
            sb2.append(i10);
            sb2.append(", dim =");
            sb2.append(f10);
            sb2.append(", ");
            sb2.append(f11);
            return;
        }
        this.f4207d = b11;
        cVar.c(this.f4204a);
    }
}
