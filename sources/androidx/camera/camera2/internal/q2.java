package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.utils.a;
import androidx.camera.core.impl.v0;
import androidx.camera.core.impl.y1;
import androidx.camera.core.impl.z1;
import androidx.camera.core.v1;
import androidx.core.util.h;
import com.leanplum.internal.ResourceQualifiers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.c0;
import o.q0;
import r.d;
import r.e;
import r.n;
import r.q;
import z.c;

final class q2 {

    /* renamed from: a  reason: collision with root package name */
    private final List<y1> f1923a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, Size> f1924b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final String f1925c;

    /* renamed from: d  reason: collision with root package name */
    private final c f1926d;

    /* renamed from: e  reason: collision with root package name */
    private final c0 f1927e;

    /* renamed from: f  reason: collision with root package name */
    private final d f1928f;

    /* renamed from: g  reason: collision with root package name */
    private final e f1929g;

    /* renamed from: h  reason: collision with root package name */
    private final int f1930h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f1931i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<Integer, List<Size>> f1932j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private boolean f1933k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1934l;

    /* renamed from: m  reason: collision with root package name */
    z1 f1935m;

    /* renamed from: n  reason: collision with root package name */
    private Map<Integer, Size[]> f1936n;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    private final v1 f1937o;

    /* renamed from: p  reason: collision with root package name */
    private final n f1938p;

    q2(@NonNull Context context, @NonNull String str, @NonNull q0 q0Var, @NonNull c cVar) throws CameraUnavailableException {
        int i10;
        this.f1933k = false;
        this.f1934l = false;
        this.f1936n = new HashMap();
        this.f1938p = new n();
        String str2 = (String) h.g(str);
        this.f1925c = str2;
        this.f1926d = (c) h.g(cVar);
        this.f1928f = new d(str);
        this.f1929g = new e();
        this.f1937o = v1.b(context);
        try {
            c0 c10 = q0Var.c(str2);
            this.f1927e = c10;
            Integer num = (Integer) c10.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            if (num != null) {
                i10 = num.intValue();
            } else {
                i10 = 2;
            }
            this.f1930h = i10;
            this.f1931i = x();
            int[] iArr = (int[]) c10.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i11 : iArr) {
                    if (i11 == 3) {
                        this.f1933k = true;
                    } else if (i11 == 6) {
                        this.f1934l = true;
                    }
                }
            }
            h();
            i();
            a();
        } catch (CameraAccessExceptionCompat e10) {
            throw k1.a(e10);
        }
    }

    private void a() {
    }

    @NonNull
    private Size[] c(int i10) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f1927e.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(i10);
            if (outputSizes != null) {
                Size[] d10 = d(outputSizes, i10);
                Arrays.sort(d10, new androidx.camera.core.impl.utils.e(true));
                return d10;
            }
            throw new IllegalArgumentException("Can not get supported output size for the format: " + i10);
        }
        throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
    }

    @NonNull
    private Size[] d(@NonNull Size[] sizeArr, int i10) {
        List<Size> e10 = e(i10);
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        arrayList.removeAll(e10);
        return (Size[]) arrayList.toArray(new Size[0]);
    }

    @NonNull
    private List<Size> e(int i10) {
        List<Size> list = this.f1932j.get(Integer.valueOf(i10));
        if (list != null) {
            return list;
        }
        List<Size> a10 = this.f1928f.a(i10);
        this.f1932j.put(Integer.valueOf(i10), a10);
        return a10;
    }

    private Size f(int i10) {
        Size size = this.f1924b.get(Integer.valueOf(i10));
        if (size != null) {
            return size;
        }
        Size m10 = m(i10);
        this.f1924b.put(Integer.valueOf(i10), m10);
        return m10;
    }

    private Size g(Size size, int i10) {
        if (size == null || !w(i10)) {
            return size;
        }
        return new Size(size.getHeight(), size.getWidth());
    }

    private void h() {
        this.f1923a.addAll(h2.a(this.f1930h, this.f1933k, this.f1934l));
        this.f1923a.addAll(this.f1929g.a(this.f1925c, this.f1930h));
    }

    private void i() {
        this.f1935m = z1.a(new Size(640, ResourceQualifiers.Qualifier.AnonymousClass14.DENSITY_XXHIGH), this.f1937o.d(), n());
    }

    @NonNull
    private Size[] j(int i10) {
        Size[] sizeArr = this.f1936n.get(Integer.valueOf(i10));
        if (sizeArr != null) {
            return sizeArr;
        }
        Size[] c10 = c(i10);
        this.f1936n.put(Integer.valueOf(i10), c10);
        return c10;
    }

    private List<List<Size>> k(List<List<Size>> list) {
        int i10 = 1;
        for (List<Size> size : list) {
            i10 *= size.size();
        }
        if (i10 != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(new ArrayList());
            }
            int size2 = i10 / list.get(0).size();
            int i12 = i10;
            for (int i13 = 0; i13 < list.size(); i13++) {
                List list2 = list.get(i13);
                for (int i14 = 0; i14 < i10; i14++) {
                    ((List) arrayList.get(i14)).add((Size) list2.get((i14 % i12) / size2));
                }
                if (i13 < list.size() - 1) {
                    i12 = size2;
                    size2 /= list.get(i13 + 1).size();
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("Failed to find supported resolutions.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.util.Size[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.Size[] l(int r4, @androidx.annotation.NonNull androidx.camera.core.impl.v0 r5) {
        /*
            r3 = this;
            r0 = 0
            java.util.List r5 = r5.k(r0)
            if (r5 == 0) goto L_0x0026
            java.util.Iterator r5 = r5.iterator()
        L_0x000b:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0026
            java.lang.Object r1 = r5.next()
            android.util.Pair r1 = (android.util.Pair) r1
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 != r4) goto L_0x000b
            java.lang.Object r5 = r1.second
            r0 = r5
            android.util.Size[] r0 = (android.util.Size[]) r0
        L_0x0026:
            if (r0 == 0) goto L_0x0035
            android.util.Size[] r0 = r3.d(r0, r4)
            androidx.camera.core.impl.utils.e r4 = new androidx.camera.core.impl.utils.e
            r5 = 1
            r4.<init>(r5)
            java.util.Arrays.sort(r0, r4)
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.q2.l(int, androidx.camera.core.impl.v0):android.util.Size[]");
    }

    @NonNull
    private Size n() {
        try {
            int parseInt = Integer.parseInt(this.f1925c);
            CamcorderProfile camcorderProfile = null;
            if (this.f1926d.b(parseInt, 1)) {
                camcorderProfile = this.f1926d.a(parseInt, 1);
            }
            if (camcorderProfile != null) {
                return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            }
            return o(parseInt);
        } catch (NumberFormatException unused) {
            return p();
        }
    }

    @NonNull
    private Size o(int i10) {
        CamcorderProfile camcorderProfile;
        Size size = c.f18785c;
        if (this.f1926d.b(i10, 10)) {
            camcorderProfile = this.f1926d.a(i10, 10);
        } else if (this.f1926d.b(i10, 8)) {
            camcorderProfile = this.f1926d.a(i10, 8);
        } else if (this.f1926d.b(i10, 12)) {
            camcorderProfile = this.f1926d.a(i10, 12);
        } else if (this.f1926d.b(i10, 6)) {
            camcorderProfile = this.f1926d.a(i10, 6);
        } else if (this.f1926d.b(i10, 5)) {
            camcorderProfile = this.f1926d.a(i10, 5);
        } else if (this.f1926d.b(i10, 4)) {
            camcorderProfile = this.f1926d.a(i10, 4);
        } else {
            camcorderProfile = null;
        }
        if (camcorderProfile != null) {
            return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        }
        return size;
    }

    @NonNull
    private Size p() {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f1927e.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(MediaRecorder.class);
            if (outputSizes == null) {
                return c.f18785c;
            }
            Arrays.sort(outputSizes, new androidx.camera.core.impl.utils.e(true));
            for (Size size : outputSizes) {
                int width = size.getWidth();
                Size size2 = c.f18786d;
                if (width <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
                    return size;
                }
            }
            return c.f18785c;
        }
        throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
    }

    private Rational s(@NonNull v0 v0Var) {
        Rational rational;
        int a10 = new q().a(this.f1925c, this.f1927e);
        if (a10 != 0) {
            if (a10 != 1) {
                if (a10 == 2) {
                    Size f10 = f(256);
                    return new Rational(f10.getWidth(), f10.getHeight());
                } else if (a10 != 3) {
                    return null;
                } else {
                    Size t10 = t(v0Var);
                    if (v0Var.u()) {
                        int x10 = v0Var.x();
                        if (x10 != 0) {
                            if (x10 != 1) {
                                v1.c("SupportedSurfaceCombination", "Undefined target aspect ratio: " + x10);
                                return null;
                            } else if (this.f1931i) {
                                rational = a.f2614c;
                            } else {
                                rational = a.f2615d;
                            }
                        } else if (this.f1931i) {
                            rational = a.f2612a;
                        } else {
                            rational = a.f2613b;
                        }
                    } else if (t10 != null) {
                        return new Rational(t10.getWidth(), t10.getHeight());
                    } else {
                        return null;
                    }
                }
            } else if (this.f1931i) {
                rational = a.f2614c;
            } else {
                rational = a.f2615d;
            }
        } else if (this.f1931i) {
            rational = a.f2612a;
        } else {
            rational = a.f2613b;
        }
        return rational;
    }

    private Size t(@NonNull v0 v0Var) {
        return g(v0Var.B((Size) null), v0Var.y(0));
    }

    private List<Integer> u(List<f2<?>> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (f2<?> w10 : list) {
            int w11 = w10.w(0);
            if (!arrayList2.contains(Integer.valueOf(w11))) {
                arrayList2.add(Integer.valueOf(w11));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        for (Integer intValue : arrayList2) {
            int intValue2 = intValue.intValue();
            for (f2 next : list) {
                if (intValue2 == next.w(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(next)));
                }
            }
        }
        return arrayList;
    }

    private Map<Rational, List<Size>> v(List<Size> list) {
        HashMap hashMap = new HashMap();
        hashMap.put(a.f2612a, new ArrayList());
        hashMap.put(a.f2614c, new ArrayList());
        for (Size next : list) {
            Rational rational = null;
            for (Rational rational2 : hashMap.keySet()) {
                if (a.a(next, rational2)) {
                    List list2 = (List) hashMap.get(rational2);
                    if (!list2.contains(next)) {
                        list2.add(next);
                    }
                    rational = rational2;
                }
            }
            if (rational == null) {
                hashMap.put(new Rational(next.getWidth(), next.getHeight()), new ArrayList(Collections.singleton(next)));
            }
        }
        return hashMap;
    }

    private boolean w(int i10) {
        boolean z10;
        Integer num = (Integer) this.f1927e.a(CameraCharacteristics.SENSOR_ORIENTATION);
        h.h(num, "Camera HAL in bad state, unable to retrieve the SENSOR_ORIENTATION");
        int b10 = androidx.camera.core.impl.utils.c.b(i10);
        Integer num2 = (Integer) this.f1927e.a(CameraCharacteristics.LENS_FACING);
        h.h(num2, "Camera HAL in bad state, unable to retrieve the LENS_FACING");
        if (1 == num2.intValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        int a10 = androidx.camera.core.impl.utils.c.a(b10, num.intValue(), z10);
        if (a10 == 90 || a10 == 270) {
            return true;
        }
        return false;
    }

    private boolean x() {
        Size size = (Size) this.f1927e.a(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        if (size == null || size.getWidth() >= size.getHeight()) {
            return true;
        }
        return false;
    }

    private void y() {
        this.f1937o.e();
        if (this.f1935m == null) {
            i();
            return;
        }
        this.f1935m = z1.a(this.f1935m.b(), this.f1937o.d(), this.f1935m.d());
    }

    private void z(List<Size> list, Size size) {
        if (list != null && !list.isEmpty()) {
            int i10 = -1;
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (true) {
                int i12 = i11;
                int i13 = i10;
                i10 = i12;
                if (i10 >= list.size()) {
                    break;
                }
                Size size2 = list.get(i10);
                if (size2.getWidth() < size.getWidth() || size2.getHeight() < size.getHeight()) {
                    break;
                }
                if (i13 >= 0) {
                    arrayList.add(list.get(i13));
                }
                i11 = i10 + 1;
            }
            list.removeAll(arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public SurfaceConfig A(int i10, Size size) {
        return SurfaceConfig.f(i10, size, this.f1935m);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0007 A[LOOP:0: B:1:0x0007->B:4:0x0017, LOOP_START, PHI: r1 
      PHI: (r1v1 boolean) = (r1v0 boolean), (r1v5 boolean) binds: [B:0:0x0000, B:4:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(java.util.List<androidx.camera.core.impl.SurfaceConfig> r4) {
        /*
            r3 = this;
            java.util.List<androidx.camera.core.impl.y1> r0 = r3.f1923a
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0007:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            java.lang.Object r1 = r0.next()
            androidx.camera.core.impl.y1 r1 = (androidx.camera.core.impl.y1) r1
            boolean r1 = r1.d(r4)
            if (r1 == 0) goto L_0x0007
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.q2.b(java.util.List):boolean");
    }

    /* access modifiers changed from: package-private */
    public Size m(int i10) {
        return (Size) Collections.max(Arrays.asList(j(i10)), new androidx.camera.core.impl.utils.e());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Map<f2<?>, Size> q(@NonNull List<androidx.camera.core.impl.a> list, @NonNull List<f2<?>> list2) {
        y();
        ArrayList arrayList = new ArrayList();
        for (androidx.camera.core.impl.a d10 : list) {
            arrayList.add(d10.d());
        }
        for (f2<?> l10 : list2) {
            arrayList.add(SurfaceConfig.f(l10.l(), new Size(640, ResourceQualifiers.Qualifier.AnonymousClass14.DENSITY_XXHIGH), this.f1935m));
        }
        if (b(arrayList)) {
            List<Integer> u10 = u(list2);
            ArrayList arrayList2 = new ArrayList();
            for (Integer intValue : u10) {
                arrayList2.add(r(list2.get(intValue.intValue())));
            }
            HashMap hashMap = null;
            Iterator<List<Size>> it = k(arrayList2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                List next = it.next();
                ArrayList arrayList3 = new ArrayList();
                for (androidx.camera.core.impl.a d11 : list) {
                    arrayList3.add(d11.d());
                }
                for (int i10 = 0; i10 < next.size(); i10++) {
                    arrayList3.add(SurfaceConfig.f(list2.get(u10.get(i10).intValue()).l(), (Size) next.get(i10), this.f1935m));
                }
                if (b(arrayList3)) {
                    hashMap = new HashMap();
                    for (f2 next2 : list2) {
                        hashMap.put(next2, (Size) next.get(u10.indexOf(Integer.valueOf(list2.indexOf(next2)))));
                    }
                }
            }
            if (hashMap != null) {
                return hashMap;
            }
            throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.f1925c + " and Hardware level: " + this.f1930h + ". May be the specified resolution is too large and not supported. Existing surfaces: " + list + " New configs: " + list2);
        }
        throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.f1925c + ".  May be attempting to bind too many use cases. Existing surfaces: " + list + " New configs: " + list2);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Size> r(@NonNull f2<?> f2Var) {
        int l10 = f2Var.l();
        v0 v0Var = (v0) f2Var;
        Size[] l11 = l(l10, v0Var);
        if (l11 == null) {
            l11 = j(l10);
        }
        ArrayList arrayList = new ArrayList();
        Size i10 = v0Var.i((Size) null);
        Size m10 = m(l10);
        if (i10 == null || c.a(m10) < c.a(i10)) {
            i10 = m10;
        }
        Arrays.sort(l11, new androidx.camera.core.impl.utils.e(true));
        Size t10 = t(v0Var);
        Size size = c.f18784b;
        int a10 = c.a(size);
        if (c.a(i10) < a10) {
            size = c.f18783a;
        } else if (t10 != null && c.a(t10) < a10) {
            size = t10;
        }
        for (Size size2 : l11) {
            if (c.a(size2) <= c.a(i10) && c.a(size2) >= c.a(size) && !arrayList.contains(size2)) {
                arrayList.add(size2);
            }
        }
        if (!arrayList.isEmpty()) {
            Rational s10 = s(v0Var);
            if (t10 == null) {
                t10 = v0Var.z((Size) null);
            }
            ArrayList arrayList2 = new ArrayList();
            new HashMap();
            if (s10 == null) {
                arrayList2.addAll(arrayList);
                if (t10 != null) {
                    z(arrayList2, t10);
                }
            } else {
                Map<Rational, List<Size>> v10 = v(arrayList);
                if (t10 != null) {
                    for (Rational rational : v10.keySet()) {
                        z(v10.get(rational), t10);
                    }
                }
                ArrayList<Rational> arrayList3 = new ArrayList<>(v10.keySet());
                Collections.sort(arrayList3, new a.C0018a(s10));
                for (Rational rational2 : arrayList3) {
                    for (Size size3 : v10.get(rational2)) {
                        if (!arrayList2.contains(size3)) {
                            arrayList2.add(size3);
                        }
                    }
                }
            }
            return this.f1938p.a(SurfaceConfig.d(f2Var.l()), arrayList2);
        }
        throw new IllegalArgumentException("Can not get supported output size under supported maximum for the format: " + l10);
    }
}
