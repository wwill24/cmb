package mg;

import com.google.gson.d;
import com.google.gson.internal.b;
import com.google.gson.q;
import com.google.gson.r;
import qg.a;

public final class e implements r {

    /* renamed from: a  reason: collision with root package name */
    private final b f23669a;

    public e(b bVar) {
        this.f23669a = bVar;
    }

    public <T> q<T> a(d dVar, a<T> aVar) {
        lg.b bVar = (lg.b) aVar.c().getAnnotation(lg.b.class);
        if (bVar == null) {
            return null;
        }
        return b(this.f23669a, dVar, aVar, bVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: mg.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: com.google.gson.q<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: com.google.gson.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: mg.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: mg.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: mg.m} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.q<?> b(com.google.gson.internal.b r8, com.google.gson.d r9, qg.a<?> r10, lg.b r11) {
        /*
            r7 = this;
            java.lang.Class r0 = r11.value()
            qg.a r0 = qg.a.a(r0)
            com.google.gson.internal.f r8 = r8.b(r0)
            java.lang.Object r8 = r8.a()
            boolean r6 = r11.nullSafe()
            boolean r11 = r8 instanceof com.google.gson.q
            if (r11 == 0) goto L_0x001b
            com.google.gson.q r8 = (com.google.gson.q) r8
            goto L_0x007b
        L_0x001b:
            boolean r11 = r8 instanceof com.google.gson.r
            if (r11 == 0) goto L_0x0026
            com.google.gson.r r8 = (com.google.gson.r) r8
            com.google.gson.q r8 = r8.a(r9, r10)
            goto L_0x007b
        L_0x0026:
            boolean r11 = r8 instanceof com.google.gson.o
            if (r11 != 0) goto L_0x005f
            boolean r0 = r8 instanceof com.google.gson.i
            if (r0 == 0) goto L_0x002f
            goto L_0x005f
        L_0x002f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Invalid attempt to bind an instance of "
            r11.append(r0)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getName()
            r11.append(r8)
            java.lang.String r8 = " as a @JsonAdapter for "
            r11.append(r8)
            java.lang.String r8 = r10.toString()
            r11.append(r8)
            java.lang.String r8 = ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r9.<init>(r8)
            throw r9
        L_0x005f:
            r0 = 0
            if (r11 == 0) goto L_0x0067
            r11 = r8
            com.google.gson.o r11 = (com.google.gson.o) r11
            r1 = r11
            goto L_0x0068
        L_0x0067:
            r1 = r0
        L_0x0068:
            boolean r11 = r8 instanceof com.google.gson.i
            if (r11 == 0) goto L_0x0070
            com.google.gson.i r8 = (com.google.gson.i) r8
            r2 = r8
            goto L_0x0071
        L_0x0070:
            r2 = r0
        L_0x0071:
            mg.m r8 = new mg.m
            r5 = 0
            r0 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r6 = 0
        L_0x007b:
            if (r8 == 0) goto L_0x0083
            if (r6 == 0) goto L_0x0083
            com.google.gson.q r8 = r8.a()
        L_0x0083:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: mg.e.b(com.google.gson.internal.b, com.google.gson.d, qg.a, lg.b):com.google.gson.q");
    }
}
