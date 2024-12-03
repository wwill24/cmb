package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mparticle.kits.AppsFlyerKit;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.jivesoftware.smack.packet.Message;
import org.xmlpull.v1.XmlPullParserException;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f4220f = {0, 4, 8};

    /* renamed from: g  reason: collision with root package name */
    private static SparseIntArray f4221g = new SparseIntArray();

    /* renamed from: h  reason: collision with root package name */
    private static SparseIntArray f4222h = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    public String f4223a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f4224b = 0;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, ConstraintAttribute> f4225c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f4226d = true;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<Integer, a> f4227e = new HashMap<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f4228a;

        /* renamed from: b  reason: collision with root package name */
        String f4229b;

        /* renamed from: c  reason: collision with root package name */
        public final d f4230c = new d();

        /* renamed from: d  reason: collision with root package name */
        public final C0030c f4231d = new C0030c();

        /* renamed from: e  reason: collision with root package name */
        public final b f4232e = new b();

        /* renamed from: f  reason: collision with root package name */
        public final e f4233f = new e();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f4234g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        C0029a f4235h;

        /* renamed from: androidx.constraintlayout.widget.c$a$a  reason: collision with other inner class name */
        static class C0029a {

            /* renamed from: a  reason: collision with root package name */
            int[] f4236a = new int[10];

            /* renamed from: b  reason: collision with root package name */
            int[] f4237b = new int[10];

            /* renamed from: c  reason: collision with root package name */
            int f4238c = 0;

            /* renamed from: d  reason: collision with root package name */
            int[] f4239d = new int[10];

            /* renamed from: e  reason: collision with root package name */
            float[] f4240e = new float[10];

            /* renamed from: f  reason: collision with root package name */
            int f4241f = 0;

            /* renamed from: g  reason: collision with root package name */
            int[] f4242g = new int[5];

            /* renamed from: h  reason: collision with root package name */
            String[] f4243h = new String[5];

            /* renamed from: i  reason: collision with root package name */
            int f4244i = 0;

            /* renamed from: j  reason: collision with root package name */
            int[] f4245j = new int[4];

            /* renamed from: k  reason: collision with root package name */
            boolean[] f4246k = new boolean[4];

            /* renamed from: l  reason: collision with root package name */
            int f4247l = 0;

            C0029a() {
            }

            /* access modifiers changed from: package-private */
            public void a(int i10, float f10) {
                int i11 = this.f4241f;
                int[] iArr = this.f4239d;
                if (i11 >= iArr.length) {
                    this.f4239d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f4240e;
                    this.f4240e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f4239d;
                int i12 = this.f4241f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f4240e;
                this.f4241f = i12 + 1;
                fArr2[i12] = f10;
            }

            /* access modifiers changed from: package-private */
            public void b(int i10, int i11) {
                int i12 = this.f4238c;
                int[] iArr = this.f4236a;
                if (i12 >= iArr.length) {
                    this.f4236a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f4237b;
                    this.f4237b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f4236a;
                int i13 = this.f4238c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f4237b;
                this.f4238c = i13 + 1;
                iArr4[i13] = i11;
            }

            /* access modifiers changed from: package-private */
            public void c(int i10, String str) {
                int i11 = this.f4244i;
                int[] iArr = this.f4242g;
                if (i11 >= iArr.length) {
                    this.f4242g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f4243h;
                    this.f4243h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f4242g;
                int i12 = this.f4244i;
                iArr2[i12] = i10;
                String[] strArr2 = this.f4243h;
                this.f4244i = i12 + 1;
                strArr2[i12] = str;
            }

            /* access modifiers changed from: package-private */
            public void d(int i10, boolean z10) {
                int i11 = this.f4247l;
                int[] iArr = this.f4245j;
                if (i11 >= iArr.length) {
                    this.f4245j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f4246k;
                    this.f4246k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f4245j;
                int i12 = this.f4247l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f4246k;
                this.f4247l = i12 + 1;
                zArr2[i12] = z10;
            }
        }

        /* access modifiers changed from: private */
        public void f(int i10, ConstraintLayout.b bVar) {
            this.f4228a = i10;
            b bVar2 = this.f4232e;
            bVar2.f4267j = bVar.f4144e;
            bVar2.f4269k = bVar.f4146f;
            bVar2.f4271l = bVar.f4148g;
            bVar2.f4273m = bVar.f4150h;
            bVar2.f4275n = bVar.f4152i;
            bVar2.f4277o = bVar.f4154j;
            bVar2.f4279p = bVar.f4156k;
            bVar2.f4281q = bVar.f4158l;
            bVar2.f4283r = bVar.f4160m;
            bVar2.f4284s = bVar.f4162n;
            bVar2.f4285t = bVar.f4164o;
            bVar2.f4286u = bVar.f4172s;
            bVar2.f4287v = bVar.f4174t;
            bVar2.f4288w = bVar.f4176u;
            bVar2.f4289x = bVar.f4178v;
            bVar2.f4290y = bVar.G;
            bVar2.f4291z = bVar.H;
            bVar2.A = bVar.I;
            bVar2.B = bVar.f4166p;
            bVar2.C = bVar.f4168q;
            bVar2.D = bVar.f4170r;
            bVar2.E = bVar.X;
            bVar2.F = bVar.Y;
            bVar2.G = bVar.Z;
            bVar2.f4263h = bVar.f4140c;
            bVar2.f4259f = bVar.f4136a;
            bVar2.f4261g = bVar.f4138b;
            bVar2.f4255d = bVar.width;
            bVar2.f4257e = bVar.height;
            bVar2.H = bVar.leftMargin;
            bVar2.I = bVar.rightMargin;
            bVar2.J = bVar.topMargin;
            bVar2.K = bVar.bottomMargin;
            bVar2.N = bVar.D;
            bVar2.V = bVar.M;
            bVar2.W = bVar.L;
            bVar2.Y = bVar.O;
            bVar2.X = bVar.N;
            bVar2.f4276n0 = bVar.f4137a0;
            bVar2.f4278o0 = bVar.f4139b0;
            bVar2.Z = bVar.P;
            bVar2.f4250a0 = bVar.Q;
            bVar2.f4252b0 = bVar.T;
            bVar2.f4254c0 = bVar.U;
            bVar2.f4256d0 = bVar.R;
            bVar2.f4258e0 = bVar.S;
            bVar2.f4260f0 = bVar.V;
            bVar2.f4262g0 = bVar.W;
            bVar2.f4274m0 = bVar.f4141c0;
            bVar2.P = bVar.f4182x;
            bVar2.R = bVar.f4184z;
            bVar2.O = bVar.f4180w;
            bVar2.Q = bVar.f4183y;
            bVar2.T = bVar.A;
            bVar2.S = bVar.B;
            bVar2.U = bVar.C;
            bVar2.f4282q0 = bVar.f4143d0;
            bVar2.L = bVar.getMarginEnd();
            this.f4232e.M = bVar.getMarginStart();
        }

        /* access modifiers changed from: private */
        public void g(int i10, d.a aVar) {
            f(i10, aVar);
            this.f4230c.f4310d = aVar.f4328x0;
            e eVar = this.f4233f;
            eVar.f4314b = aVar.A0;
            eVar.f4315c = aVar.B0;
            eVar.f4316d = aVar.C0;
            eVar.f4317e = aVar.D0;
            eVar.f4318f = aVar.E0;
            eVar.f4319g = aVar.F0;
            eVar.f4320h = aVar.G0;
            eVar.f4322j = aVar.H0;
            eVar.f4323k = aVar.I0;
            eVar.f4324l = aVar.J0;
            eVar.f4326n = aVar.f4330z0;
            eVar.f4325m = aVar.f4329y0;
        }

        /* access modifiers changed from: private */
        public void h(a aVar, int i10, d.a aVar2) {
            g(i10, aVar2);
            if (aVar instanceof Barrier) {
                b bVar = this.f4232e;
                bVar.f4268j0 = 1;
                Barrier barrier = (Barrier) aVar;
                bVar.f4264h0 = barrier.getType();
                this.f4232e.f4270k0 = barrier.getReferencedIds();
                this.f4232e.f4266i0 = barrier.getMargin();
            }
        }

        public void d(ConstraintLayout.b bVar) {
            b bVar2 = this.f4232e;
            bVar.f4144e = bVar2.f4267j;
            bVar.f4146f = bVar2.f4269k;
            bVar.f4148g = bVar2.f4271l;
            bVar.f4150h = bVar2.f4273m;
            bVar.f4152i = bVar2.f4275n;
            bVar.f4154j = bVar2.f4277o;
            bVar.f4156k = bVar2.f4279p;
            bVar.f4158l = bVar2.f4281q;
            bVar.f4160m = bVar2.f4283r;
            bVar.f4162n = bVar2.f4284s;
            bVar.f4164o = bVar2.f4285t;
            bVar.f4172s = bVar2.f4286u;
            bVar.f4174t = bVar2.f4287v;
            bVar.f4176u = bVar2.f4288w;
            bVar.f4178v = bVar2.f4289x;
            bVar.leftMargin = bVar2.H;
            bVar.rightMargin = bVar2.I;
            bVar.topMargin = bVar2.J;
            bVar.bottomMargin = bVar2.K;
            bVar.A = bVar2.T;
            bVar.B = bVar2.S;
            bVar.f4182x = bVar2.P;
            bVar.f4184z = bVar2.R;
            bVar.G = bVar2.f4290y;
            bVar.H = bVar2.f4291z;
            bVar.f4166p = bVar2.B;
            bVar.f4168q = bVar2.C;
            bVar.f4170r = bVar2.D;
            bVar.I = bVar2.A;
            bVar.X = bVar2.E;
            bVar.Y = bVar2.F;
            bVar.M = bVar2.V;
            bVar.L = bVar2.W;
            bVar.O = bVar2.Y;
            bVar.N = bVar2.X;
            bVar.f4137a0 = bVar2.f4276n0;
            bVar.f4139b0 = bVar2.f4278o0;
            bVar.P = bVar2.Z;
            bVar.Q = bVar2.f4250a0;
            bVar.T = bVar2.f4252b0;
            bVar.U = bVar2.f4254c0;
            bVar.R = bVar2.f4256d0;
            bVar.S = bVar2.f4258e0;
            bVar.V = bVar2.f4260f0;
            bVar.W = bVar2.f4262g0;
            bVar.Z = bVar2.G;
            bVar.f4140c = bVar2.f4263h;
            bVar.f4136a = bVar2.f4259f;
            bVar.f4138b = bVar2.f4261g;
            bVar.width = bVar2.f4255d;
            bVar.height = bVar2.f4257e;
            String str = bVar2.f4274m0;
            if (str != null) {
                bVar.f4141c0 = str;
            }
            bVar.f4143d0 = bVar2.f4282q0;
            bVar.setMarginStart(bVar2.M);
            bVar.setMarginEnd(this.f4232e.L);
            bVar.a();
        }

        /* renamed from: e */
        public a clone() {
            a aVar = new a();
            aVar.f4232e.a(this.f4232e);
            aVar.f4231d.a(this.f4231d);
            aVar.f4230c.a(this.f4230c);
            aVar.f4233f.a(this.f4233f);
            aVar.f4228a = this.f4228a;
            aVar.f4235h = this.f4235h;
            return aVar;
        }
    }

    public static class b {

        /* renamed from: r0  reason: collision with root package name */
        private static SparseIntArray f4248r0;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a  reason: collision with root package name */
        public boolean f4249a = false;

        /* renamed from: a0  reason: collision with root package name */
        public int f4250a0 = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4251b = false;

        /* renamed from: b0  reason: collision with root package name */
        public int f4252b0 = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4253c = false;

        /* renamed from: c0  reason: collision with root package name */
        public int f4254c0 = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f4255d;

        /* renamed from: d0  reason: collision with root package name */
        public int f4256d0 = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f4257e;

        /* renamed from: e0  reason: collision with root package name */
        public int f4258e0 = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f4259f = -1;

        /* renamed from: f0  reason: collision with root package name */
        public float f4260f0 = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public int f4261g = -1;

        /* renamed from: g0  reason: collision with root package name */
        public float f4262g0 = 1.0f;

        /* renamed from: h  reason: collision with root package name */
        public float f4263h = -1.0f;

        /* renamed from: h0  reason: collision with root package name */
        public int f4264h0 = -1;

        /* renamed from: i  reason: collision with root package name */
        public boolean f4265i = true;

        /* renamed from: i0  reason: collision with root package name */
        public int f4266i0 = 0;

        /* renamed from: j  reason: collision with root package name */
        public int f4267j = -1;

        /* renamed from: j0  reason: collision with root package name */
        public int f4268j0 = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f4269k = -1;

        /* renamed from: k0  reason: collision with root package name */
        public int[] f4270k0;

        /* renamed from: l  reason: collision with root package name */
        public int f4271l = -1;

        /* renamed from: l0  reason: collision with root package name */
        public String f4272l0;

        /* renamed from: m  reason: collision with root package name */
        public int f4273m = -1;

        /* renamed from: m0  reason: collision with root package name */
        public String f4274m0;

        /* renamed from: n  reason: collision with root package name */
        public int f4275n = -1;

        /* renamed from: n0  reason: collision with root package name */
        public boolean f4276n0 = false;

        /* renamed from: o  reason: collision with root package name */
        public int f4277o = -1;

        /* renamed from: o0  reason: collision with root package name */
        public boolean f4278o0 = false;

        /* renamed from: p  reason: collision with root package name */
        public int f4279p = -1;

        /* renamed from: p0  reason: collision with root package name */
        public boolean f4280p0 = true;

        /* renamed from: q  reason: collision with root package name */
        public int f4281q = -1;

        /* renamed from: q0  reason: collision with root package name */
        public int f4282q0 = 0;

        /* renamed from: r  reason: collision with root package name */
        public int f4283r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f4284s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f4285t = -1;

        /* renamed from: u  reason: collision with root package name */
        public int f4286u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f4287v = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f4288w = -1;

        /* renamed from: x  reason: collision with root package name */
        public int f4289x = -1;

        /* renamed from: y  reason: collision with root package name */
        public float f4290y = 0.5f;

        /* renamed from: z  reason: collision with root package name */
        public float f4291z = 0.5f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4248r0 = sparseIntArray;
            sparseIntArray.append(h.Layout_layout_constraintLeft_toLeftOf, 24);
            f4248r0.append(h.Layout_layout_constraintLeft_toRightOf, 25);
            f4248r0.append(h.Layout_layout_constraintRight_toLeftOf, 28);
            f4248r0.append(h.Layout_layout_constraintRight_toRightOf, 29);
            f4248r0.append(h.Layout_layout_constraintTop_toTopOf, 35);
            f4248r0.append(h.Layout_layout_constraintTop_toBottomOf, 34);
            f4248r0.append(h.Layout_layout_constraintBottom_toTopOf, 4);
            f4248r0.append(h.Layout_layout_constraintBottom_toBottomOf, 3);
            f4248r0.append(h.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f4248r0.append(h.Layout_layout_editor_absoluteX, 6);
            f4248r0.append(h.Layout_layout_editor_absoluteY, 7);
            f4248r0.append(h.Layout_layout_constraintGuide_begin, 17);
            f4248r0.append(h.Layout_layout_constraintGuide_end, 18);
            f4248r0.append(h.Layout_layout_constraintGuide_percent, 19);
            f4248r0.append(h.Layout_guidelineUseRtl, 90);
            f4248r0.append(h.Layout_android_orientation, 26);
            f4248r0.append(h.Layout_layout_constraintStart_toEndOf, 31);
            f4248r0.append(h.Layout_layout_constraintStart_toStartOf, 32);
            f4248r0.append(h.Layout_layout_constraintEnd_toStartOf, 10);
            f4248r0.append(h.Layout_layout_constraintEnd_toEndOf, 9);
            f4248r0.append(h.Layout_layout_goneMarginLeft, 13);
            f4248r0.append(h.Layout_layout_goneMarginTop, 16);
            f4248r0.append(h.Layout_layout_goneMarginRight, 14);
            f4248r0.append(h.Layout_layout_goneMarginBottom, 11);
            f4248r0.append(h.Layout_layout_goneMarginStart, 15);
            f4248r0.append(h.Layout_layout_goneMarginEnd, 12);
            f4248r0.append(h.Layout_layout_constraintVertical_weight, 38);
            f4248r0.append(h.Layout_layout_constraintHorizontal_weight, 37);
            f4248r0.append(h.Layout_layout_constraintHorizontal_chainStyle, 39);
            f4248r0.append(h.Layout_layout_constraintVertical_chainStyle, 40);
            f4248r0.append(h.Layout_layout_constraintHorizontal_bias, 20);
            f4248r0.append(h.Layout_layout_constraintVertical_bias, 36);
            f4248r0.append(h.Layout_layout_constraintDimensionRatio, 5);
            f4248r0.append(h.Layout_layout_constraintLeft_creator, 91);
            f4248r0.append(h.Layout_layout_constraintTop_creator, 91);
            f4248r0.append(h.Layout_layout_constraintRight_creator, 91);
            f4248r0.append(h.Layout_layout_constraintBottom_creator, 91);
            f4248r0.append(h.Layout_layout_constraintBaseline_creator, 91);
            f4248r0.append(h.Layout_android_layout_marginLeft, 23);
            f4248r0.append(h.Layout_android_layout_marginRight, 27);
            f4248r0.append(h.Layout_android_layout_marginStart, 30);
            f4248r0.append(h.Layout_android_layout_marginEnd, 8);
            f4248r0.append(h.Layout_android_layout_marginTop, 33);
            f4248r0.append(h.Layout_android_layout_marginBottom, 2);
            f4248r0.append(h.Layout_android_layout_width, 22);
            f4248r0.append(h.Layout_android_layout_height, 21);
            f4248r0.append(h.Layout_layout_constraintWidth, 41);
            f4248r0.append(h.Layout_layout_constraintHeight, 42);
            f4248r0.append(h.Layout_layout_constrainedWidth, 41);
            f4248r0.append(h.Layout_layout_constrainedHeight, 42);
            f4248r0.append(h.Layout_layout_wrapBehaviorInParent, 76);
            f4248r0.append(h.Layout_layout_constraintCircle, 61);
            f4248r0.append(h.Layout_layout_constraintCircleRadius, 62);
            f4248r0.append(h.Layout_layout_constraintCircleAngle, 63);
            f4248r0.append(h.Layout_layout_constraintWidth_percent, 69);
            f4248r0.append(h.Layout_layout_constraintHeight_percent, 70);
            f4248r0.append(h.Layout_chainUseRtl, 71);
            f4248r0.append(h.Layout_barrierDirection, 72);
            f4248r0.append(h.Layout_barrierMargin, 73);
            f4248r0.append(h.Layout_constraint_referenced_ids, 74);
            f4248r0.append(h.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(b bVar) {
            this.f4249a = bVar.f4249a;
            this.f4255d = bVar.f4255d;
            this.f4251b = bVar.f4251b;
            this.f4257e = bVar.f4257e;
            this.f4259f = bVar.f4259f;
            this.f4261g = bVar.f4261g;
            this.f4263h = bVar.f4263h;
            this.f4265i = bVar.f4265i;
            this.f4267j = bVar.f4267j;
            this.f4269k = bVar.f4269k;
            this.f4271l = bVar.f4271l;
            this.f4273m = bVar.f4273m;
            this.f4275n = bVar.f4275n;
            this.f4277o = bVar.f4277o;
            this.f4279p = bVar.f4279p;
            this.f4281q = bVar.f4281q;
            this.f4283r = bVar.f4283r;
            this.f4284s = bVar.f4284s;
            this.f4285t = bVar.f4285t;
            this.f4286u = bVar.f4286u;
            this.f4287v = bVar.f4287v;
            this.f4288w = bVar.f4288w;
            this.f4289x = bVar.f4289x;
            this.f4290y = bVar.f4290y;
            this.f4291z = bVar.f4291z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f4250a0 = bVar.f4250a0;
            this.f4252b0 = bVar.f4252b0;
            this.f4254c0 = bVar.f4254c0;
            this.f4256d0 = bVar.f4256d0;
            this.f4258e0 = bVar.f4258e0;
            this.f4260f0 = bVar.f4260f0;
            this.f4262g0 = bVar.f4262g0;
            this.f4264h0 = bVar.f4264h0;
            this.f4266i0 = bVar.f4266i0;
            this.f4268j0 = bVar.f4268j0;
            this.f4274m0 = bVar.f4274m0;
            int[] iArr = bVar.f4270k0;
            if (iArr == null || bVar.f4272l0 != null) {
                this.f4270k0 = null;
            } else {
                this.f4270k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f4272l0 = bVar.f4272l0;
            this.f4276n0 = bVar.f4276n0;
            this.f4278o0 = bVar.f4278o0;
            this.f4280p0 = bVar.f4280p0;
            this.f4282q0 = bVar.f4282q0;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.Layout);
            this.f4251b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = f4248r0.get(index);
                switch (i11) {
                    case 1:
                        this.f4283r = c.y(obtainStyledAttributes, index, this.f4283r);
                        break;
                    case 2:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f4281q = c.y(obtainStyledAttributes, index, this.f4281q);
                        break;
                    case 4:
                        this.f4279p = c.y(obtainStyledAttributes, index, this.f4279p);
                        break;
                    case 5:
                        this.A = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = obtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.f4289x = c.y(obtainStyledAttributes, index, this.f4289x);
                        break;
                    case 10:
                        this.f4288w = c.y(obtainStyledAttributes, index, this.f4288w);
                        break;
                    case 11:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f4259f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4259f);
                        break;
                    case 18:
                        this.f4261g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4261g);
                        break;
                    case 19:
                        this.f4263h = obtainStyledAttributes.getFloat(index, this.f4263h);
                        break;
                    case 20:
                        this.f4290y = obtainStyledAttributes.getFloat(index, this.f4290y);
                        break;
                    case 21:
                        this.f4257e = obtainStyledAttributes.getLayoutDimension(index, this.f4257e);
                        break;
                    case 22:
                        this.f4255d = obtainStyledAttributes.getLayoutDimension(index, this.f4255d);
                        break;
                    case 23:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f4267j = c.y(obtainStyledAttributes, index, this.f4267j);
                        break;
                    case 25:
                        this.f4269k = c.y(obtainStyledAttributes, index, this.f4269k);
                        break;
                    case 26:
                        this.G = obtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.f4271l = c.y(obtainStyledAttributes, index, this.f4271l);
                        break;
                    case 29:
                        this.f4273m = c.y(obtainStyledAttributes, index, this.f4273m);
                        break;
                    case 30:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 31:
                        this.f4286u = c.y(obtainStyledAttributes, index, this.f4286u);
                        break;
                    case 32:
                        this.f4287v = c.y(obtainStyledAttributes, index, this.f4287v);
                        break;
                    case 33:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.f4277o = c.y(obtainStyledAttributes, index, this.f4277o);
                        break;
                    case 35:
                        this.f4275n = c.y(obtainStyledAttributes, index, this.f4275n);
                        break;
                    case 36:
                        this.f4291z = obtainStyledAttributes.getFloat(index, this.f4291z);
                        break;
                    case 37:
                        this.W = obtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = obtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = obtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        c.z(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        c.z(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.B = c.y(obtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f4260f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f4262g0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        break;
                                    case 72:
                                        this.f4264h0 = obtainStyledAttributes.getInt(index, this.f4264h0);
                                        break;
                                    case 73:
                                        this.f4266i0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4266i0);
                                        break;
                                    case 74:
                                        this.f4272l0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f4280p0 = obtainStyledAttributes.getBoolean(index, this.f4280p0);
                                        break;
                                    case 76:
                                        this.f4282q0 = obtainStyledAttributes.getInt(index, this.f4282q0);
                                        break;
                                    case 77:
                                        this.f4284s = c.y(obtainStyledAttributes, index, this.f4284s);
                                        break;
                                    case 78:
                                        this.f4285t = c.y(obtainStyledAttributes, index, this.f4285t);
                                        break;
                                    case 79:
                                        this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case 80:
                                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case 81:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 82:
                                        this.f4250a0 = obtainStyledAttributes.getInt(index, this.f4250a0);
                                        break;
                                    case 83:
                                        this.f4254c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4254c0);
                                        break;
                                    case 84:
                                        this.f4252b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4252b0);
                                        break;
                                    case 85:
                                        this.f4258e0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4258e0);
                                        break;
                                    case 86:
                                        this.f4256d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f4256d0);
                                        break;
                                    case 87:
                                        this.f4276n0 = obtainStyledAttributes.getBoolean(index, this.f4276n0);
                                        break;
                                    case 88:
                                        this.f4278o0 = obtainStyledAttributes.getBoolean(index, this.f4278o0);
                                        break;
                                    case 89:
                                        this.f4274m0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f4265i = obtainStyledAttributes.getBoolean(index, this.f4265i);
                                        break;
                                    case 91:
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("unused attribute 0x");
                                        sb2.append(Integer.toHexString(index));
                                        sb2.append("   ");
                                        sb2.append(f4248r0.get(index));
                                        break;
                                    default:
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Unknown attribute 0x");
                                        sb3.append(Integer.toHexString(index));
                                        sb3.append("   ");
                                        sb3.append(f4248r0.get(index));
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$c  reason: collision with other inner class name */
    public static class C0030c {

        /* renamed from: o  reason: collision with root package name */
        private static SparseIntArray f4292o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f4293a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f4294b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f4295c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f4296d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f4297e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f4298f = 0;

        /* renamed from: g  reason: collision with root package name */
        public float f4299g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public int f4300h = -1;

        /* renamed from: i  reason: collision with root package name */
        public float f4301i = Float.NaN;

        /* renamed from: j  reason: collision with root package name */
        public float f4302j = Float.NaN;

        /* renamed from: k  reason: collision with root package name */
        public int f4303k = -1;

        /* renamed from: l  reason: collision with root package name */
        public String f4304l = null;

        /* renamed from: m  reason: collision with root package name */
        public int f4305m = -3;

        /* renamed from: n  reason: collision with root package name */
        public int f4306n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4292o = sparseIntArray;
            sparseIntArray.append(h.Motion_motionPathRotate, 1);
            f4292o.append(h.Motion_pathMotionArc, 2);
            f4292o.append(h.Motion_transitionEasing, 3);
            f4292o.append(h.Motion_drawPath, 4);
            f4292o.append(h.Motion_animateRelativeTo, 5);
            f4292o.append(h.Motion_animateCircleAngleTo, 6);
            f4292o.append(h.Motion_motionStagger, 7);
            f4292o.append(h.Motion_quantizeMotionSteps, 8);
            f4292o.append(h.Motion_quantizeMotionPhase, 9);
            f4292o.append(h.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(C0030c cVar) {
            this.f4293a = cVar.f4293a;
            this.f4294b = cVar.f4294b;
            this.f4296d = cVar.f4296d;
            this.f4297e = cVar.f4297e;
            this.f4298f = cVar.f4298f;
            this.f4301i = cVar.f4301i;
            this.f4299g = cVar.f4299g;
            this.f4300h = cVar.f4300h;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.Motion);
            this.f4293a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f4292o.get(index)) {
                    case 1:
                        this.f4301i = obtainStyledAttributes.getFloat(index, this.f4301i);
                        break;
                    case 2:
                        this.f4297e = obtainStyledAttributes.getInt(index, this.f4297e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.f4296d = n0.b.f16349c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.f4296d = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.f4298f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f4294b = c.y(obtainStyledAttributes, index, this.f4294b);
                        break;
                    case 6:
                        this.f4295c = obtainStyledAttributes.getInteger(index, this.f4295c);
                        break;
                    case 7:
                        this.f4299g = obtainStyledAttributes.getFloat(index, this.f4299g);
                        break;
                    case 8:
                        this.f4303k = obtainStyledAttributes.getInteger(index, this.f4303k);
                        break;
                    case 9:
                        this.f4302j = obtainStyledAttributes.getFloat(index, this.f4302j);
                        break;
                    case 10:
                        int i11 = obtainStyledAttributes.peekValue(index).type;
                        if (i11 != 1) {
                            if (i11 != 3) {
                                this.f4305m = obtainStyledAttributes.getInteger(index, this.f4306n);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.f4304l = string;
                                if (string.indexOf(RemoteSettings.FORWARD_SLASH_STRING) <= 0) {
                                    this.f4305m = -1;
                                    break;
                                } else {
                                    this.f4306n = obtainStyledAttributes.getResourceId(index, -1);
                                    this.f4305m = -2;
                                    break;
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f4306n = resourceId;
                            if (resourceId == -1) {
                                break;
                            } else {
                                this.f4305m = -2;
                                break;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4307a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f4308b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f4309c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f4310d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f4311e = Float.NaN;

        public void a(d dVar) {
            this.f4307a = dVar.f4307a;
            this.f4308b = dVar.f4308b;
            this.f4310d = dVar.f4310d;
            this.f4311e = dVar.f4311e;
            this.f4309c = dVar.f4309c;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.PropertySet);
            this.f4307a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.PropertySet_android_alpha) {
                    this.f4310d = obtainStyledAttributes.getFloat(index, this.f4310d);
                } else if (index == h.PropertySet_android_visibility) {
                    this.f4308b = obtainStyledAttributes.getInt(index, this.f4308b);
                    this.f4308b = c.f4220f[this.f4308b];
                } else if (index == h.PropertySet_visibilityMode) {
                    this.f4309c = obtainStyledAttributes.getInt(index, this.f4309c);
                } else if (index == h.PropertySet_motionProgress) {
                    this.f4311e = obtainStyledAttributes.getFloat(index, this.f4311e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* renamed from: o  reason: collision with root package name */
        private static SparseIntArray f4312o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f4313a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f4314b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f4315c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f4316d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f4317e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f4318f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f4319g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f4320h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public int f4321i = -1;

        /* renamed from: j  reason: collision with root package name */
        public float f4322j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f4323k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f4324l = 0.0f;

        /* renamed from: m  reason: collision with root package name */
        public boolean f4325m = false;

        /* renamed from: n  reason: collision with root package name */
        public float f4326n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4312o = sparseIntArray;
            sparseIntArray.append(h.Transform_android_rotation, 1);
            f4312o.append(h.Transform_android_rotationX, 2);
            f4312o.append(h.Transform_android_rotationY, 3);
            f4312o.append(h.Transform_android_scaleX, 4);
            f4312o.append(h.Transform_android_scaleY, 5);
            f4312o.append(h.Transform_android_transformPivotX, 6);
            f4312o.append(h.Transform_android_transformPivotY, 7);
            f4312o.append(h.Transform_android_translationX, 8);
            f4312o.append(h.Transform_android_translationY, 9);
            f4312o.append(h.Transform_android_translationZ, 10);
            f4312o.append(h.Transform_android_elevation, 11);
            f4312o.append(h.Transform_transformPivotTarget, 12);
        }

        public void a(e eVar) {
            this.f4313a = eVar.f4313a;
            this.f4314b = eVar.f4314b;
            this.f4315c = eVar.f4315c;
            this.f4316d = eVar.f4316d;
            this.f4317e = eVar.f4317e;
            this.f4318f = eVar.f4318f;
            this.f4319g = eVar.f4319g;
            this.f4320h = eVar.f4320h;
            this.f4321i = eVar.f4321i;
            this.f4322j = eVar.f4322j;
            this.f4323k = eVar.f4323k;
            this.f4324l = eVar.f4324l;
            this.f4325m = eVar.f4325m;
            this.f4326n = eVar.f4326n;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.Transform);
            this.f4313a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f4312o.get(index)) {
                    case 1:
                        this.f4314b = obtainStyledAttributes.getFloat(index, this.f4314b);
                        break;
                    case 2:
                        this.f4315c = obtainStyledAttributes.getFloat(index, this.f4315c);
                        break;
                    case 3:
                        this.f4316d = obtainStyledAttributes.getFloat(index, this.f4316d);
                        break;
                    case 4:
                        this.f4317e = obtainStyledAttributes.getFloat(index, this.f4317e);
                        break;
                    case 5:
                        this.f4318f = obtainStyledAttributes.getFloat(index, this.f4318f);
                        break;
                    case 6:
                        this.f4319g = obtainStyledAttributes.getDimension(index, this.f4319g);
                        break;
                    case 7:
                        this.f4320h = obtainStyledAttributes.getDimension(index, this.f4320h);
                        break;
                    case 8:
                        this.f4322j = obtainStyledAttributes.getDimension(index, this.f4322j);
                        break;
                    case 9:
                        this.f4323k = obtainStyledAttributes.getDimension(index, this.f4323k);
                        break;
                    case 10:
                        this.f4324l = obtainStyledAttributes.getDimension(index, this.f4324l);
                        break;
                    case 11:
                        this.f4325m = true;
                        this.f4326n = obtainStyledAttributes.getDimension(index, this.f4326n);
                        break;
                    case 12:
                        this.f4321i = c.y(obtainStyledAttributes, index, this.f4321i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f4221g.append(h.Constraint_layout_constraintLeft_toLeftOf, 25);
        f4221g.append(h.Constraint_layout_constraintLeft_toRightOf, 26);
        f4221g.append(h.Constraint_layout_constraintRight_toLeftOf, 29);
        f4221g.append(h.Constraint_layout_constraintRight_toRightOf, 30);
        f4221g.append(h.Constraint_layout_constraintTop_toTopOf, 36);
        f4221g.append(h.Constraint_layout_constraintTop_toBottomOf, 35);
        f4221g.append(h.Constraint_layout_constraintBottom_toTopOf, 4);
        f4221g.append(h.Constraint_layout_constraintBottom_toBottomOf, 3);
        f4221g.append(h.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f4221g.append(h.Constraint_layout_constraintBaseline_toTopOf, 91);
        f4221g.append(h.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f4221g.append(h.Constraint_layout_editor_absoluteX, 6);
        f4221g.append(h.Constraint_layout_editor_absoluteY, 7);
        f4221g.append(h.Constraint_layout_constraintGuide_begin, 17);
        f4221g.append(h.Constraint_layout_constraintGuide_end, 18);
        f4221g.append(h.Constraint_layout_constraintGuide_percent, 19);
        f4221g.append(h.Constraint_guidelineUseRtl, 99);
        f4221g.append(h.Constraint_android_orientation, 27);
        f4221g.append(h.Constraint_layout_constraintStart_toEndOf, 32);
        f4221g.append(h.Constraint_layout_constraintStart_toStartOf, 33);
        f4221g.append(h.Constraint_layout_constraintEnd_toStartOf, 10);
        f4221g.append(h.Constraint_layout_constraintEnd_toEndOf, 9);
        f4221g.append(h.Constraint_layout_goneMarginLeft, 13);
        f4221g.append(h.Constraint_layout_goneMarginTop, 16);
        f4221g.append(h.Constraint_layout_goneMarginRight, 14);
        f4221g.append(h.Constraint_layout_goneMarginBottom, 11);
        f4221g.append(h.Constraint_layout_goneMarginStart, 15);
        f4221g.append(h.Constraint_layout_goneMarginEnd, 12);
        f4221g.append(h.Constraint_layout_constraintVertical_weight, 40);
        f4221g.append(h.Constraint_layout_constraintHorizontal_weight, 39);
        f4221g.append(h.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f4221g.append(h.Constraint_layout_constraintVertical_chainStyle, 42);
        f4221g.append(h.Constraint_layout_constraintHorizontal_bias, 20);
        f4221g.append(h.Constraint_layout_constraintVertical_bias, 37);
        f4221g.append(h.Constraint_layout_constraintDimensionRatio, 5);
        f4221g.append(h.Constraint_layout_constraintLeft_creator, 87);
        f4221g.append(h.Constraint_layout_constraintTop_creator, 87);
        f4221g.append(h.Constraint_layout_constraintRight_creator, 87);
        f4221g.append(h.Constraint_layout_constraintBottom_creator, 87);
        f4221g.append(h.Constraint_layout_constraintBaseline_creator, 87);
        f4221g.append(h.Constraint_android_layout_marginLeft, 24);
        f4221g.append(h.Constraint_android_layout_marginRight, 28);
        f4221g.append(h.Constraint_android_layout_marginStart, 31);
        f4221g.append(h.Constraint_android_layout_marginEnd, 8);
        f4221g.append(h.Constraint_android_layout_marginTop, 34);
        f4221g.append(h.Constraint_android_layout_marginBottom, 2);
        f4221g.append(h.Constraint_android_layout_width, 23);
        f4221g.append(h.Constraint_android_layout_height, 21);
        f4221g.append(h.Constraint_layout_constraintWidth, 95);
        f4221g.append(h.Constraint_layout_constraintHeight, 96);
        f4221g.append(h.Constraint_android_visibility, 22);
        f4221g.append(h.Constraint_android_alpha, 43);
        f4221g.append(h.Constraint_android_elevation, 44);
        f4221g.append(h.Constraint_android_rotationX, 45);
        f4221g.append(h.Constraint_android_rotationY, 46);
        f4221g.append(h.Constraint_android_rotation, 60);
        f4221g.append(h.Constraint_android_scaleX, 47);
        f4221g.append(h.Constraint_android_scaleY, 48);
        f4221g.append(h.Constraint_android_transformPivotX, 49);
        f4221g.append(h.Constraint_android_transformPivotY, 50);
        f4221g.append(h.Constraint_android_translationX, 51);
        f4221g.append(h.Constraint_android_translationY, 52);
        f4221g.append(h.Constraint_android_translationZ, 53);
        f4221g.append(h.Constraint_layout_constraintWidth_default, 54);
        f4221g.append(h.Constraint_layout_constraintHeight_default, 55);
        f4221g.append(h.Constraint_layout_constraintWidth_max, 56);
        f4221g.append(h.Constraint_layout_constraintHeight_max, 57);
        f4221g.append(h.Constraint_layout_constraintWidth_min, 58);
        f4221g.append(h.Constraint_layout_constraintHeight_min, 59);
        f4221g.append(h.Constraint_layout_constraintCircle, 61);
        f4221g.append(h.Constraint_layout_constraintCircleRadius, 62);
        f4221g.append(h.Constraint_layout_constraintCircleAngle, 63);
        f4221g.append(h.Constraint_animateRelativeTo, 64);
        f4221g.append(h.Constraint_transitionEasing, 65);
        f4221g.append(h.Constraint_drawPath, 66);
        f4221g.append(h.Constraint_transitionPathRotate, 67);
        f4221g.append(h.Constraint_motionStagger, 79);
        f4221g.append(h.Constraint_android_id, 38);
        f4221g.append(h.Constraint_motionProgress, 68);
        f4221g.append(h.Constraint_layout_constraintWidth_percent, 69);
        f4221g.append(h.Constraint_layout_constraintHeight_percent, 70);
        f4221g.append(h.Constraint_layout_wrapBehaviorInParent, 97);
        f4221g.append(h.Constraint_chainUseRtl, 71);
        f4221g.append(h.Constraint_barrierDirection, 72);
        f4221g.append(h.Constraint_barrierMargin, 73);
        f4221g.append(h.Constraint_constraint_referenced_ids, 74);
        f4221g.append(h.Constraint_barrierAllowsGoneWidgets, 75);
        f4221g.append(h.Constraint_pathMotionArc, 76);
        f4221g.append(h.Constraint_layout_constraintTag, 77);
        f4221g.append(h.Constraint_visibilityMode, 78);
        f4221g.append(h.Constraint_layout_constrainedWidth, 80);
        f4221g.append(h.Constraint_layout_constrainedHeight, 81);
        f4221g.append(h.Constraint_polarRelativeTo, 82);
        f4221g.append(h.Constraint_transformPivotTarget, 83);
        f4221g.append(h.Constraint_quantizeMotionSteps, 84);
        f4221g.append(h.Constraint_quantizeMotionPhase, 85);
        f4221g.append(h.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = f4222h;
        int i10 = h.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i10, 6);
        f4222h.append(i10, 7);
        f4222h.append(h.ConstraintOverride_android_orientation, 27);
        f4222h.append(h.ConstraintOverride_layout_goneMarginLeft, 13);
        f4222h.append(h.ConstraintOverride_layout_goneMarginTop, 16);
        f4222h.append(h.ConstraintOverride_layout_goneMarginRight, 14);
        f4222h.append(h.ConstraintOverride_layout_goneMarginBottom, 11);
        f4222h.append(h.ConstraintOverride_layout_goneMarginStart, 15);
        f4222h.append(h.ConstraintOverride_layout_goneMarginEnd, 12);
        f4222h.append(h.ConstraintOverride_layout_constraintVertical_weight, 40);
        f4222h.append(h.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f4222h.append(h.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f4222h.append(h.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f4222h.append(h.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f4222h.append(h.ConstraintOverride_layout_constraintVertical_bias, 37);
        f4222h.append(h.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f4222h.append(h.ConstraintOverride_layout_constraintLeft_creator, 87);
        f4222h.append(h.ConstraintOverride_layout_constraintTop_creator, 87);
        f4222h.append(h.ConstraintOverride_layout_constraintRight_creator, 87);
        f4222h.append(h.ConstraintOverride_layout_constraintBottom_creator, 87);
        f4222h.append(h.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f4222h.append(h.ConstraintOverride_android_layout_marginLeft, 24);
        f4222h.append(h.ConstraintOverride_android_layout_marginRight, 28);
        f4222h.append(h.ConstraintOverride_android_layout_marginStart, 31);
        f4222h.append(h.ConstraintOverride_android_layout_marginEnd, 8);
        f4222h.append(h.ConstraintOverride_android_layout_marginTop, 34);
        f4222h.append(h.ConstraintOverride_android_layout_marginBottom, 2);
        f4222h.append(h.ConstraintOverride_android_layout_width, 23);
        f4222h.append(h.ConstraintOverride_android_layout_height, 21);
        f4222h.append(h.ConstraintOverride_layout_constraintWidth, 95);
        f4222h.append(h.ConstraintOverride_layout_constraintHeight, 96);
        f4222h.append(h.ConstraintOverride_android_visibility, 22);
        f4222h.append(h.ConstraintOverride_android_alpha, 43);
        f4222h.append(h.ConstraintOverride_android_elevation, 44);
        f4222h.append(h.ConstraintOverride_android_rotationX, 45);
        f4222h.append(h.ConstraintOverride_android_rotationY, 46);
        f4222h.append(h.ConstraintOverride_android_rotation, 60);
        f4222h.append(h.ConstraintOverride_android_scaleX, 47);
        f4222h.append(h.ConstraintOverride_android_scaleY, 48);
        f4222h.append(h.ConstraintOverride_android_transformPivotX, 49);
        f4222h.append(h.ConstraintOverride_android_transformPivotY, 50);
        f4222h.append(h.ConstraintOverride_android_translationX, 51);
        f4222h.append(h.ConstraintOverride_android_translationY, 52);
        f4222h.append(h.ConstraintOverride_android_translationZ, 53);
        f4222h.append(h.ConstraintOverride_layout_constraintWidth_default, 54);
        f4222h.append(h.ConstraintOverride_layout_constraintHeight_default, 55);
        f4222h.append(h.ConstraintOverride_layout_constraintWidth_max, 56);
        f4222h.append(h.ConstraintOverride_layout_constraintHeight_max, 57);
        f4222h.append(h.ConstraintOverride_layout_constraintWidth_min, 58);
        f4222h.append(h.ConstraintOverride_layout_constraintHeight_min, 59);
        f4222h.append(h.ConstraintOverride_layout_constraintCircleRadius, 62);
        f4222h.append(h.ConstraintOverride_layout_constraintCircleAngle, 63);
        f4222h.append(h.ConstraintOverride_animateRelativeTo, 64);
        f4222h.append(h.ConstraintOverride_transitionEasing, 65);
        f4222h.append(h.ConstraintOverride_drawPath, 66);
        f4222h.append(h.ConstraintOverride_transitionPathRotate, 67);
        f4222h.append(h.ConstraintOverride_motionStagger, 79);
        f4222h.append(h.ConstraintOverride_android_id, 38);
        f4222h.append(h.ConstraintOverride_motionTarget, 98);
        f4222h.append(h.ConstraintOverride_motionProgress, 68);
        f4222h.append(h.ConstraintOverride_layout_constraintWidth_percent, 69);
        f4222h.append(h.ConstraintOverride_layout_constraintHeight_percent, 70);
        f4222h.append(h.ConstraintOverride_chainUseRtl, 71);
        f4222h.append(h.ConstraintOverride_barrierDirection, 72);
        f4222h.append(h.ConstraintOverride_barrierMargin, 73);
        f4222h.append(h.ConstraintOverride_constraint_referenced_ids, 74);
        f4222h.append(h.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f4222h.append(h.ConstraintOverride_pathMotionArc, 76);
        f4222h.append(h.ConstraintOverride_layout_constraintTag, 77);
        f4222h.append(h.ConstraintOverride_visibilityMode, 78);
        f4222h.append(h.ConstraintOverride_layout_constrainedWidth, 80);
        f4222h.append(h.ConstraintOverride_layout_constrainedHeight, 81);
        f4222h.append(h.ConstraintOverride_polarRelativeTo, 82);
        f4222h.append(h.ConstraintOverride_transformPivotTarget, 83);
        f4222h.append(h.ConstraintOverride_quantizeMotionSteps, 84);
        f4222h.append(h.ConstraintOverride_quantizeMotionPhase, 85);
        f4222h.append(h.ConstraintOverride_quantizeMotionInterpolator, 86);
        f4222h.append(h.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    static void A(Object obj, String str, int i10) {
        if (str != null) {
            int indexOf = str.indexOf(61);
            int length = str.length();
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    String trim = substring.trim();
                    String trim2 = substring2.trim();
                    if ("ratio".equalsIgnoreCase(trim)) {
                        if (obj instanceof ConstraintLayout.b) {
                            ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                            if (i10 == 0) {
                                bVar.width = 0;
                            } else {
                                bVar.height = 0;
                            }
                            B(bVar, trim2);
                        } else if (obj instanceof b) {
                            ((b) obj).A = trim2;
                        } else if (obj instanceof a.C0029a) {
                            ((a.C0029a) obj).c(5, trim2);
                        }
                    } else if ("weight".equalsIgnoreCase(trim)) {
                        try {
                            float parseFloat = Float.parseFloat(trim2);
                            if (obj instanceof ConstraintLayout.b) {
                                ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                                if (i10 == 0) {
                                    bVar2.width = 0;
                                    bVar2.L = parseFloat;
                                    return;
                                }
                                bVar2.height = 0;
                                bVar2.M = parseFloat;
                            } else if (obj instanceof b) {
                                b bVar3 = (b) obj;
                                if (i10 == 0) {
                                    bVar3.f4255d = 0;
                                    bVar3.W = parseFloat;
                                    return;
                                }
                                bVar3.f4257e = 0;
                                bVar3.V = parseFloat;
                            } else if (obj instanceof a.C0029a) {
                                a.C0029a aVar = (a.C0029a) obj;
                                if (i10 == 0) {
                                    aVar.b(23, 0);
                                    aVar.a(39, parseFloat);
                                    return;
                                }
                                aVar.b(21, 0);
                                aVar.a(40, parseFloat);
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else if (Message.Thread.PARENT_ATTRIBUTE_NAME.equalsIgnoreCase(trim)) {
                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                        if (obj instanceof ConstraintLayout.b) {
                            ConstraintLayout.b bVar4 = (ConstraintLayout.b) obj;
                            if (i10 == 0) {
                                bVar4.width = 0;
                                bVar4.V = max;
                                bVar4.P = 2;
                                return;
                            }
                            bVar4.height = 0;
                            bVar4.W = max;
                            bVar4.Q = 2;
                        } else if (obj instanceof b) {
                            b bVar5 = (b) obj;
                            if (i10 == 0) {
                                bVar5.f4255d = 0;
                                bVar5.f4260f0 = max;
                                bVar5.Z = 2;
                                return;
                            }
                            bVar5.f4257e = 0;
                            bVar5.f4262g0 = max;
                            bVar5.f4250a0 = 2;
                        } else if (obj instanceof a.C0029a) {
                            a.C0029a aVar2 = (a.C0029a) obj;
                            if (i10 == 0) {
                                aVar2.b(23, 0);
                                aVar2.b(54, 2);
                                return;
                            }
                            aVar2.b(21, 0);
                            aVar2.b(55, 2);
                        }
                    }
                }
            }
        }
    }

    static void B(ConstraintLayout.b bVar, String str) {
        float f10 = Float.NaN;
        int i10 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i11 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i10 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i10 = 1;
                }
                i11 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i11);
                if (substring2.length() > 0) {
                    f10 = Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i11, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f10 = i10 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        bVar.I = str;
        bVar.J = f10;
        bVar.K = i10;
    }

    private void C(Context context, a aVar, TypedArray typedArray, boolean z10) {
        if (z10) {
            D(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (!(index == h.Constraint_android_id || h.Constraint_android_layout_marginStart == index || h.Constraint_android_layout_marginEnd == index)) {
                aVar.f4231d.f4293a = true;
                aVar.f4232e.f4251b = true;
                aVar.f4230c.f4307a = true;
                aVar.f4233f.f4313a = true;
            }
            switch (f4221g.get(index)) {
                case 1:
                    b bVar = aVar.f4232e;
                    bVar.f4283r = y(typedArray, index, bVar.f4283r);
                    break;
                case 2:
                    b bVar2 = aVar.f4232e;
                    bVar2.K = typedArray.getDimensionPixelSize(index, bVar2.K);
                    break;
                case 3:
                    b bVar3 = aVar.f4232e;
                    bVar3.f4281q = y(typedArray, index, bVar3.f4281q);
                    break;
                case 4:
                    b bVar4 = aVar.f4232e;
                    bVar4.f4279p = y(typedArray, index, bVar4.f4279p);
                    break;
                case 5:
                    aVar.f4232e.A = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f4232e;
                    bVar5.E = typedArray.getDimensionPixelOffset(index, bVar5.E);
                    break;
                case 7:
                    b bVar6 = aVar.f4232e;
                    bVar6.F = typedArray.getDimensionPixelOffset(index, bVar6.F);
                    break;
                case 8:
                    b bVar7 = aVar.f4232e;
                    bVar7.L = typedArray.getDimensionPixelSize(index, bVar7.L);
                    break;
                case 9:
                    b bVar8 = aVar.f4232e;
                    bVar8.f4289x = y(typedArray, index, bVar8.f4289x);
                    break;
                case 10:
                    b bVar9 = aVar.f4232e;
                    bVar9.f4288w = y(typedArray, index, bVar9.f4288w);
                    break;
                case 11:
                    b bVar10 = aVar.f4232e;
                    bVar10.R = typedArray.getDimensionPixelSize(index, bVar10.R);
                    break;
                case 12:
                    b bVar11 = aVar.f4232e;
                    bVar11.S = typedArray.getDimensionPixelSize(index, bVar11.S);
                    break;
                case 13:
                    b bVar12 = aVar.f4232e;
                    bVar12.O = typedArray.getDimensionPixelSize(index, bVar12.O);
                    break;
                case 14:
                    b bVar13 = aVar.f4232e;
                    bVar13.Q = typedArray.getDimensionPixelSize(index, bVar13.Q);
                    break;
                case 15:
                    b bVar14 = aVar.f4232e;
                    bVar14.T = typedArray.getDimensionPixelSize(index, bVar14.T);
                    break;
                case 16:
                    b bVar15 = aVar.f4232e;
                    bVar15.P = typedArray.getDimensionPixelSize(index, bVar15.P);
                    break;
                case 17:
                    b bVar16 = aVar.f4232e;
                    bVar16.f4259f = typedArray.getDimensionPixelOffset(index, bVar16.f4259f);
                    break;
                case 18:
                    b bVar17 = aVar.f4232e;
                    bVar17.f4261g = typedArray.getDimensionPixelOffset(index, bVar17.f4261g);
                    break;
                case 19:
                    b bVar18 = aVar.f4232e;
                    bVar18.f4263h = typedArray.getFloat(index, bVar18.f4263h);
                    break;
                case 20:
                    b bVar19 = aVar.f4232e;
                    bVar19.f4290y = typedArray.getFloat(index, bVar19.f4290y);
                    break;
                case 21:
                    b bVar20 = aVar.f4232e;
                    bVar20.f4257e = typedArray.getLayoutDimension(index, bVar20.f4257e);
                    break;
                case 22:
                    d dVar = aVar.f4230c;
                    dVar.f4308b = typedArray.getInt(index, dVar.f4308b);
                    d dVar2 = aVar.f4230c;
                    dVar2.f4308b = f4220f[dVar2.f4308b];
                    break;
                case 23:
                    b bVar21 = aVar.f4232e;
                    bVar21.f4255d = typedArray.getLayoutDimension(index, bVar21.f4255d);
                    break;
                case 24:
                    b bVar22 = aVar.f4232e;
                    bVar22.H = typedArray.getDimensionPixelSize(index, bVar22.H);
                    break;
                case 25:
                    b bVar23 = aVar.f4232e;
                    bVar23.f4267j = y(typedArray, index, bVar23.f4267j);
                    break;
                case 26:
                    b bVar24 = aVar.f4232e;
                    bVar24.f4269k = y(typedArray, index, bVar24.f4269k);
                    break;
                case 27:
                    b bVar25 = aVar.f4232e;
                    bVar25.G = typedArray.getInt(index, bVar25.G);
                    break;
                case 28:
                    b bVar26 = aVar.f4232e;
                    bVar26.I = typedArray.getDimensionPixelSize(index, bVar26.I);
                    break;
                case 29:
                    b bVar27 = aVar.f4232e;
                    bVar27.f4271l = y(typedArray, index, bVar27.f4271l);
                    break;
                case 30:
                    b bVar28 = aVar.f4232e;
                    bVar28.f4273m = y(typedArray, index, bVar28.f4273m);
                    break;
                case 31:
                    b bVar29 = aVar.f4232e;
                    bVar29.M = typedArray.getDimensionPixelSize(index, bVar29.M);
                    break;
                case 32:
                    b bVar30 = aVar.f4232e;
                    bVar30.f4286u = y(typedArray, index, bVar30.f4286u);
                    break;
                case 33:
                    b bVar31 = aVar.f4232e;
                    bVar31.f4287v = y(typedArray, index, bVar31.f4287v);
                    break;
                case 34:
                    b bVar32 = aVar.f4232e;
                    bVar32.J = typedArray.getDimensionPixelSize(index, bVar32.J);
                    break;
                case 35:
                    b bVar33 = aVar.f4232e;
                    bVar33.f4277o = y(typedArray, index, bVar33.f4277o);
                    break;
                case 36:
                    b bVar34 = aVar.f4232e;
                    bVar34.f4275n = y(typedArray, index, bVar34.f4275n);
                    break;
                case 37:
                    b bVar35 = aVar.f4232e;
                    bVar35.f4291z = typedArray.getFloat(index, bVar35.f4291z);
                    break;
                case 38:
                    aVar.f4228a = typedArray.getResourceId(index, aVar.f4228a);
                    break;
                case 39:
                    b bVar36 = aVar.f4232e;
                    bVar36.W = typedArray.getFloat(index, bVar36.W);
                    break;
                case 40:
                    b bVar37 = aVar.f4232e;
                    bVar37.V = typedArray.getFloat(index, bVar37.V);
                    break;
                case 41:
                    b bVar38 = aVar.f4232e;
                    bVar38.X = typedArray.getInt(index, bVar38.X);
                    break;
                case 42:
                    b bVar39 = aVar.f4232e;
                    bVar39.Y = typedArray.getInt(index, bVar39.Y);
                    break;
                case 43:
                    d dVar3 = aVar.f4230c;
                    dVar3.f4310d = typedArray.getFloat(index, dVar3.f4310d);
                    break;
                case 44:
                    e eVar = aVar.f4233f;
                    eVar.f4325m = true;
                    eVar.f4326n = typedArray.getDimension(index, eVar.f4326n);
                    break;
                case 45:
                    e eVar2 = aVar.f4233f;
                    eVar2.f4315c = typedArray.getFloat(index, eVar2.f4315c);
                    break;
                case 46:
                    e eVar3 = aVar.f4233f;
                    eVar3.f4316d = typedArray.getFloat(index, eVar3.f4316d);
                    break;
                case 47:
                    e eVar4 = aVar.f4233f;
                    eVar4.f4317e = typedArray.getFloat(index, eVar4.f4317e);
                    break;
                case 48:
                    e eVar5 = aVar.f4233f;
                    eVar5.f4318f = typedArray.getFloat(index, eVar5.f4318f);
                    break;
                case 49:
                    e eVar6 = aVar.f4233f;
                    eVar6.f4319g = typedArray.getDimension(index, eVar6.f4319g);
                    break;
                case 50:
                    e eVar7 = aVar.f4233f;
                    eVar7.f4320h = typedArray.getDimension(index, eVar7.f4320h);
                    break;
                case 51:
                    e eVar8 = aVar.f4233f;
                    eVar8.f4322j = typedArray.getDimension(index, eVar8.f4322j);
                    break;
                case 52:
                    e eVar9 = aVar.f4233f;
                    eVar9.f4323k = typedArray.getDimension(index, eVar9.f4323k);
                    break;
                case 53:
                    e eVar10 = aVar.f4233f;
                    eVar10.f4324l = typedArray.getDimension(index, eVar10.f4324l);
                    break;
                case 54:
                    b bVar40 = aVar.f4232e;
                    bVar40.Z = typedArray.getInt(index, bVar40.Z);
                    break;
                case 55:
                    b bVar41 = aVar.f4232e;
                    bVar41.f4250a0 = typedArray.getInt(index, bVar41.f4250a0);
                    break;
                case 56:
                    b bVar42 = aVar.f4232e;
                    bVar42.f4252b0 = typedArray.getDimensionPixelSize(index, bVar42.f4252b0);
                    break;
                case 57:
                    b bVar43 = aVar.f4232e;
                    bVar43.f4254c0 = typedArray.getDimensionPixelSize(index, bVar43.f4254c0);
                    break;
                case 58:
                    b bVar44 = aVar.f4232e;
                    bVar44.f4256d0 = typedArray.getDimensionPixelSize(index, bVar44.f4256d0);
                    break;
                case 59:
                    b bVar45 = aVar.f4232e;
                    bVar45.f4258e0 = typedArray.getDimensionPixelSize(index, bVar45.f4258e0);
                    break;
                case 60:
                    e eVar11 = aVar.f4233f;
                    eVar11.f4314b = typedArray.getFloat(index, eVar11.f4314b);
                    break;
                case 61:
                    b bVar46 = aVar.f4232e;
                    bVar46.B = y(typedArray, index, bVar46.B);
                    break;
                case 62:
                    b bVar47 = aVar.f4232e;
                    bVar47.C = typedArray.getDimensionPixelSize(index, bVar47.C);
                    break;
                case 63:
                    b bVar48 = aVar.f4232e;
                    bVar48.D = typedArray.getFloat(index, bVar48.D);
                    break;
                case 64:
                    C0030c cVar = aVar.f4231d;
                    cVar.f4294b = y(typedArray, index, cVar.f4294b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        aVar.f4231d.f4296d = n0.b.f16349c[typedArray.getInteger(index, 0)];
                        break;
                    } else {
                        aVar.f4231d.f4296d = typedArray.getString(index);
                        break;
                    }
                case 66:
                    aVar.f4231d.f4298f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    C0030c cVar2 = aVar.f4231d;
                    cVar2.f4301i = typedArray.getFloat(index, cVar2.f4301i);
                    break;
                case 68:
                    d dVar4 = aVar.f4230c;
                    dVar4.f4311e = typedArray.getFloat(index, dVar4.f4311e);
                    break;
                case 69:
                    aVar.f4232e.f4260f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f4232e.f4262g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case 72:
                    b bVar49 = aVar.f4232e;
                    bVar49.f4264h0 = typedArray.getInt(index, bVar49.f4264h0);
                    break;
                case 73:
                    b bVar50 = aVar.f4232e;
                    bVar50.f4266i0 = typedArray.getDimensionPixelSize(index, bVar50.f4266i0);
                    break;
                case 74:
                    aVar.f4232e.f4272l0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f4232e;
                    bVar51.f4280p0 = typedArray.getBoolean(index, bVar51.f4280p0);
                    break;
                case 76:
                    C0030c cVar3 = aVar.f4231d;
                    cVar3.f4297e = typedArray.getInt(index, cVar3.f4297e);
                    break;
                case 77:
                    aVar.f4232e.f4274m0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f4230c;
                    dVar5.f4309c = typedArray.getInt(index, dVar5.f4309c);
                    break;
                case 79:
                    C0030c cVar4 = aVar.f4231d;
                    cVar4.f4299g = typedArray.getFloat(index, cVar4.f4299g);
                    break;
                case 80:
                    b bVar52 = aVar.f4232e;
                    bVar52.f4276n0 = typedArray.getBoolean(index, bVar52.f4276n0);
                    break;
                case 81:
                    b bVar53 = aVar.f4232e;
                    bVar53.f4278o0 = typedArray.getBoolean(index, bVar53.f4278o0);
                    break;
                case 82:
                    C0030c cVar5 = aVar.f4231d;
                    cVar5.f4295c = typedArray.getInteger(index, cVar5.f4295c);
                    break;
                case 83:
                    e eVar12 = aVar.f4233f;
                    eVar12.f4321i = y(typedArray, index, eVar12.f4321i);
                    break;
                case 84:
                    C0030c cVar6 = aVar.f4231d;
                    cVar6.f4303k = typedArray.getInteger(index, cVar6.f4303k);
                    break;
                case 85:
                    C0030c cVar7 = aVar.f4231d;
                    cVar7.f4302j = typedArray.getFloat(index, cVar7.f4302j);
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 != 1) {
                        if (i11 != 3) {
                            C0030c cVar8 = aVar.f4231d;
                            cVar8.f4305m = typedArray.getInteger(index, cVar8.f4306n);
                            break;
                        } else {
                            aVar.f4231d.f4304l = typedArray.getString(index);
                            if (aVar.f4231d.f4304l.indexOf(RemoteSettings.FORWARD_SLASH_STRING) <= 0) {
                                aVar.f4231d.f4305m = -1;
                                break;
                            } else {
                                aVar.f4231d.f4306n = typedArray.getResourceId(index, -1);
                                aVar.f4231d.f4305m = -2;
                                break;
                            }
                        }
                    } else {
                        aVar.f4231d.f4306n = typedArray.getResourceId(index, -1);
                        C0030c cVar9 = aVar.f4231d;
                        if (cVar9.f4306n == -1) {
                            break;
                        } else {
                            cVar9.f4305m = -2;
                            break;
                        }
                    }
                case 87:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("unused attribute 0x");
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(f4221g.get(index));
                    break;
                case 91:
                    b bVar54 = aVar.f4232e;
                    bVar54.f4284s = y(typedArray, index, bVar54.f4284s);
                    break;
                case 92:
                    b bVar55 = aVar.f4232e;
                    bVar55.f4285t = y(typedArray, index, bVar55.f4285t);
                    break;
                case 93:
                    b bVar56 = aVar.f4232e;
                    bVar56.N = typedArray.getDimensionPixelSize(index, bVar56.N);
                    break;
                case 94:
                    b bVar57 = aVar.f4232e;
                    bVar57.U = typedArray.getDimensionPixelSize(index, bVar57.U);
                    break;
                case 95:
                    z(aVar.f4232e, typedArray, index, 0);
                    break;
                case 96:
                    z(aVar.f4232e, typedArray, index, 1);
                    break;
                case 97:
                    b bVar58 = aVar.f4232e;
                    bVar58.f4282q0 = typedArray.getInt(index, bVar58.f4282q0);
                    break;
                default:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unknown attribute 0x");
                    sb3.append(Integer.toHexString(index));
                    sb3.append("   ");
                    sb3.append(f4221g.get(index));
                    break;
            }
        }
        b bVar59 = aVar.f4232e;
        if (bVar59.f4272l0 != null) {
            bVar59.f4270k0 = null;
        }
    }

    private static void D(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0029a aVar2 = new a.C0029a();
        aVar.f4235h = aVar2;
        aVar.f4231d.f4293a = false;
        aVar.f4232e.f4251b = false;
        aVar.f4230c.f4307a = false;
        aVar.f4233f.f4313a = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            switch (f4222h.get(index)) {
                case 2:
                    aVar2.b(2, typedArray.getDimensionPixelSize(index, aVar.f4232e.K));
                    break;
                case 5:
                    aVar2.c(5, typedArray.getString(index));
                    break;
                case 6:
                    aVar2.b(6, typedArray.getDimensionPixelOffset(index, aVar.f4232e.E));
                    break;
                case 7:
                    aVar2.b(7, typedArray.getDimensionPixelOffset(index, aVar.f4232e.F));
                    break;
                case 8:
                    aVar2.b(8, typedArray.getDimensionPixelSize(index, aVar.f4232e.L));
                    break;
                case 11:
                    aVar2.b(11, typedArray.getDimensionPixelSize(index, aVar.f4232e.R));
                    break;
                case 12:
                    aVar2.b(12, typedArray.getDimensionPixelSize(index, aVar.f4232e.S));
                    break;
                case 13:
                    aVar2.b(13, typedArray.getDimensionPixelSize(index, aVar.f4232e.O));
                    break;
                case 14:
                    aVar2.b(14, typedArray.getDimensionPixelSize(index, aVar.f4232e.Q));
                    break;
                case 15:
                    aVar2.b(15, typedArray.getDimensionPixelSize(index, aVar.f4232e.T));
                    break;
                case 16:
                    aVar2.b(16, typedArray.getDimensionPixelSize(index, aVar.f4232e.P));
                    break;
                case 17:
                    aVar2.b(17, typedArray.getDimensionPixelOffset(index, aVar.f4232e.f4259f));
                    break;
                case 18:
                    aVar2.b(18, typedArray.getDimensionPixelOffset(index, aVar.f4232e.f4261g));
                    break;
                case 19:
                    aVar2.a(19, typedArray.getFloat(index, aVar.f4232e.f4263h));
                    break;
                case 20:
                    aVar2.a(20, typedArray.getFloat(index, aVar.f4232e.f4290y));
                    break;
                case 21:
                    aVar2.b(21, typedArray.getLayoutDimension(index, aVar.f4232e.f4257e));
                    break;
                case 22:
                    aVar2.b(22, f4220f[typedArray.getInt(index, aVar.f4230c.f4308b)]);
                    break;
                case 23:
                    aVar2.b(23, typedArray.getLayoutDimension(index, aVar.f4232e.f4255d));
                    break;
                case 24:
                    aVar2.b(24, typedArray.getDimensionPixelSize(index, aVar.f4232e.H));
                    break;
                case 27:
                    aVar2.b(27, typedArray.getInt(index, aVar.f4232e.G));
                    break;
                case 28:
                    aVar2.b(28, typedArray.getDimensionPixelSize(index, aVar.f4232e.I));
                    break;
                case 31:
                    aVar2.b(31, typedArray.getDimensionPixelSize(index, aVar.f4232e.M));
                    break;
                case 34:
                    aVar2.b(34, typedArray.getDimensionPixelSize(index, aVar.f4232e.J));
                    break;
                case 37:
                    aVar2.a(37, typedArray.getFloat(index, aVar.f4232e.f4291z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f4228a);
                    aVar.f4228a = resourceId;
                    aVar2.b(38, resourceId);
                    break;
                case 39:
                    aVar2.a(39, typedArray.getFloat(index, aVar.f4232e.W));
                    break;
                case 40:
                    aVar2.a(40, typedArray.getFloat(index, aVar.f4232e.V));
                    break;
                case 41:
                    aVar2.b(41, typedArray.getInt(index, aVar.f4232e.X));
                    break;
                case 42:
                    aVar2.b(42, typedArray.getInt(index, aVar.f4232e.Y));
                    break;
                case 43:
                    aVar2.a(43, typedArray.getFloat(index, aVar.f4230c.f4310d));
                    break;
                case 44:
                    aVar2.d(44, true);
                    aVar2.a(44, typedArray.getDimension(index, aVar.f4233f.f4326n));
                    break;
                case 45:
                    aVar2.a(45, typedArray.getFloat(index, aVar.f4233f.f4315c));
                    break;
                case 46:
                    aVar2.a(46, typedArray.getFloat(index, aVar.f4233f.f4316d));
                    break;
                case 47:
                    aVar2.a(47, typedArray.getFloat(index, aVar.f4233f.f4317e));
                    break;
                case 48:
                    aVar2.a(48, typedArray.getFloat(index, aVar.f4233f.f4318f));
                    break;
                case 49:
                    aVar2.a(49, typedArray.getDimension(index, aVar.f4233f.f4319g));
                    break;
                case 50:
                    aVar2.a(50, typedArray.getDimension(index, aVar.f4233f.f4320h));
                    break;
                case 51:
                    aVar2.a(51, typedArray.getDimension(index, aVar.f4233f.f4322j));
                    break;
                case 52:
                    aVar2.a(52, typedArray.getDimension(index, aVar.f4233f.f4323k));
                    break;
                case 53:
                    aVar2.a(53, typedArray.getDimension(index, aVar.f4233f.f4324l));
                    break;
                case 54:
                    aVar2.b(54, typedArray.getInt(index, aVar.f4232e.Z));
                    break;
                case 55:
                    aVar2.b(55, typedArray.getInt(index, aVar.f4232e.f4250a0));
                    break;
                case 56:
                    aVar2.b(56, typedArray.getDimensionPixelSize(index, aVar.f4232e.f4252b0));
                    break;
                case 57:
                    aVar2.b(57, typedArray.getDimensionPixelSize(index, aVar.f4232e.f4254c0));
                    break;
                case 58:
                    aVar2.b(58, typedArray.getDimensionPixelSize(index, aVar.f4232e.f4256d0));
                    break;
                case 59:
                    aVar2.b(59, typedArray.getDimensionPixelSize(index, aVar.f4232e.f4258e0));
                    break;
                case 60:
                    aVar2.a(60, typedArray.getFloat(index, aVar.f4233f.f4314b));
                    break;
                case 62:
                    aVar2.b(62, typedArray.getDimensionPixelSize(index, aVar.f4232e.C));
                    break;
                case 63:
                    aVar2.a(63, typedArray.getFloat(index, aVar.f4232e.D));
                    break;
                case 64:
                    aVar2.b(64, y(typedArray, index, aVar.f4231d.f4294b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        aVar2.c(65, n0.b.f16349c[typedArray.getInteger(index, 0)]);
                        break;
                    } else {
                        aVar2.c(65, typedArray.getString(index));
                        break;
                    }
                case 66:
                    aVar2.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    aVar2.a(67, typedArray.getFloat(index, aVar.f4231d.f4301i));
                    break;
                case 68:
                    aVar2.a(68, typedArray.getFloat(index, aVar.f4230c.f4311e));
                    break;
                case 69:
                    aVar2.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    aVar2.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    break;
                case 72:
                    aVar2.b(72, typedArray.getInt(index, aVar.f4232e.f4264h0));
                    break;
                case 73:
                    aVar2.b(73, typedArray.getDimensionPixelSize(index, aVar.f4232e.f4266i0));
                    break;
                case 74:
                    aVar2.c(74, typedArray.getString(index));
                    break;
                case 75:
                    aVar2.d(75, typedArray.getBoolean(index, aVar.f4232e.f4280p0));
                    break;
                case 76:
                    aVar2.b(76, typedArray.getInt(index, aVar.f4231d.f4297e));
                    break;
                case 77:
                    aVar2.c(77, typedArray.getString(index));
                    break;
                case 78:
                    aVar2.b(78, typedArray.getInt(index, aVar.f4230c.f4309c));
                    break;
                case 79:
                    aVar2.a(79, typedArray.getFloat(index, aVar.f4231d.f4299g));
                    break;
                case 80:
                    aVar2.d(80, typedArray.getBoolean(index, aVar.f4232e.f4276n0));
                    break;
                case 81:
                    aVar2.d(81, typedArray.getBoolean(index, aVar.f4232e.f4278o0));
                    break;
                case 82:
                    aVar2.b(82, typedArray.getInteger(index, aVar.f4231d.f4295c));
                    break;
                case 83:
                    aVar2.b(83, y(typedArray, index, aVar.f4233f.f4321i));
                    break;
                case 84:
                    aVar2.b(84, typedArray.getInteger(index, aVar.f4231d.f4303k));
                    break;
                case 85:
                    aVar2.a(85, typedArray.getFloat(index, aVar.f4231d.f4302j));
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 != 1) {
                        if (i11 != 3) {
                            C0030c cVar = aVar.f4231d;
                            cVar.f4305m = typedArray.getInteger(index, cVar.f4306n);
                            aVar2.b(88, aVar.f4231d.f4305m);
                            break;
                        } else {
                            aVar.f4231d.f4304l = typedArray.getString(index);
                            aVar2.c(90, aVar.f4231d.f4304l);
                            if (aVar.f4231d.f4304l.indexOf(RemoteSettings.FORWARD_SLASH_STRING) <= 0) {
                                aVar.f4231d.f4305m = -1;
                                aVar2.b(88, -1);
                                break;
                            } else {
                                aVar.f4231d.f4306n = typedArray.getResourceId(index, -1);
                                aVar2.b(89, aVar.f4231d.f4306n);
                                aVar.f4231d.f4305m = -2;
                                aVar2.b(88, -2);
                                break;
                            }
                        }
                    } else {
                        aVar.f4231d.f4306n = typedArray.getResourceId(index, -1);
                        aVar2.b(89, aVar.f4231d.f4306n);
                        C0030c cVar2 = aVar.f4231d;
                        if (cVar2.f4306n == -1) {
                            break;
                        } else {
                            cVar2.f4305m = -2;
                            aVar2.b(88, -2);
                            break;
                        }
                    }
                case 87:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("unused attribute 0x");
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(f4221g.get(index));
                    break;
                case 93:
                    aVar2.b(93, typedArray.getDimensionPixelSize(index, aVar.f4232e.N));
                    break;
                case 94:
                    aVar2.b(94, typedArray.getDimensionPixelSize(index, aVar.f4232e.U));
                    break;
                case 95:
                    z(aVar2, typedArray, index, 0);
                    break;
                case 96:
                    z(aVar2, typedArray, index, 1);
                    break;
                case 97:
                    aVar2.b(97, typedArray.getInt(index, aVar.f4232e.f4282q0));
                    break;
                case 98:
                    if (!MotionLayout.B0) {
                        if (typedArray.peekValue(index).type != 3) {
                            aVar.f4228a = typedArray.getResourceId(index, aVar.f4228a);
                            break;
                        } else {
                            aVar.f4229b = typedArray.getString(index);
                            break;
                        }
                    } else {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f4228a);
                        aVar.f4228a = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            aVar.f4229b = typedArray.getString(index);
                            break;
                        }
                    }
                case 99:
                    aVar2.d(99, typedArray.getBoolean(index, aVar.f4232e.f4265i));
                    break;
                default:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unknown attribute 0x");
                    sb3.append(Integer.toHexString(index));
                    sb3.append("   ");
                    sb3.append(f4221g.get(index));
                    break;
            }
        }
    }

    private String I(int i10) {
        switch (i10) {
            case 1:
                return ViewHierarchyConstants.DIMENSION_LEFT_KEY;
            case 2:
                return "right";
            case 3:
                return ViewHierarchyConstants.DIMENSION_TOP_KEY;
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    private int[] q(View view, String str) {
        int i10;
        Object g10;
        String[] split = str.split(AppsFlyerKit.COMMA);
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < split.length) {
            String trim = split[i11].trim();
            try {
                i10 = g.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (g10 = ((ConstraintLayout) view.getParent()).g(0, trim)) != null && (g10 instanceof Integer)) {
                i10 = ((Integer) g10).intValue();
            }
            iArr[i12] = i10;
            i11++;
            i12++;
        }
        if (i12 != split.length) {
            return Arrays.copyOf(iArr, i12);
        }
        return iArr;
    }

    private void s(int i10, int i11, int i12, int i13, int[] iArr, float[] fArr, int i14, int i15, int i16) {
        int[] iArr2 = iArr;
        float[] fArr2 = fArr;
        if (iArr2.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr2 == null || fArr2.length == iArr2.length) {
            if (fArr2 != null) {
                v(iArr2[0]).f4232e.W = fArr2[0];
            }
            v(iArr2[0]).f4232e.X = i14;
            i(iArr2[0], i15, i10, i11, -1);
            for (int i17 = 1; i17 < iArr2.length; i17++) {
                int i18 = i17 - 1;
                i(iArr2[i17], i15, iArr2[i18], i16, -1);
                i(iArr2[i18], i16, iArr2[i17], i15, -1);
                if (fArr2 != null) {
                    v(iArr2[i17]).f4232e.W = fArr2[i17];
                }
            }
            i(iArr2[iArr2.length - 1], i16, i12, i13, -1);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    private a u(Context context, AttributeSet attributeSet, boolean z10) {
        int[] iArr;
        a aVar = new a();
        if (z10) {
            iArr = h.ConstraintOverride;
        } else {
            iArr = h.Constraint;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        C(context, aVar, obtainStyledAttributes, z10);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private a v(int i10) {
        if (!this.f4227e.containsKey(Integer.valueOf(i10))) {
            this.f4227e.put(Integer.valueOf(i10), new a());
        }
        return this.f4227e.get(Integer.valueOf(i10));
    }

    /* access modifiers changed from: private */
    public static int y(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        if (resourceId == -1) {
            return typedArray.getInt(i10, -1);
        }
        return resourceId;
    }

    static void z(Object obj, TypedArray typedArray, int i10, int i11) {
        if (obj != null) {
            int i12 = typedArray.peekValue(i10).type;
            if (i12 != 3) {
                int i13 = -2;
                boolean z10 = false;
                if (i12 != 5) {
                    int i14 = typedArray.getInt(i10, 0);
                    if (i14 == -4) {
                        z10 = true;
                    } else if (i14 == -3 || !(i14 == -2 || i14 == -1)) {
                        i13 = 0;
                    } else {
                        i13 = i14;
                    }
                } else {
                    i13 = typedArray.getDimensionPixelSize(i10, 0);
                }
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i11 == 0) {
                        bVar.width = i13;
                        bVar.f4137a0 = z10;
                        return;
                    }
                    bVar.height = i13;
                    bVar.f4139b0 = z10;
                } else if (obj instanceof b) {
                    b bVar2 = (b) obj;
                    if (i11 == 0) {
                        bVar2.f4255d = i13;
                        bVar2.f4276n0 = z10;
                        return;
                    }
                    bVar2.f4257e = i13;
                    bVar2.f4278o0 = z10;
                } else if (obj instanceof a.C0029a) {
                    a.C0029a aVar = (a.C0029a) obj;
                    if (i11 == 0) {
                        aVar.b(23, i13);
                        aVar.d(80, z10);
                        return;
                    }
                    aVar.b(21, i13);
                    aVar.d(81, z10);
                }
            } else {
                A(obj, typedArray.getString(i10), i11);
            }
        }
    }

    public void E(int i10, float f10) {
        v(i10).f4232e.f4290y = f10;
    }

    public void F(int i10, float f10) {
        v(i10).f4232e.W = f10;
    }

    public void G(int i10, int i11, int i12) {
        a v10 = v(i10);
        switch (i11) {
            case 1:
                v10.f4232e.H = i12;
                return;
            case 2:
                v10.f4232e.I = i12;
                return;
            case 3:
                v10.f4232e.J = i12;
                return;
            case 4:
                v10.f4232e.K = i12;
                return;
            case 5:
                v10.f4232e.N = i12;
                return;
            case 6:
                v10.f4232e.M = i12;
                return;
            case 7:
                v10.f4232e.L = i12;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void H(int i10, float f10) {
        v(i10).f4232e.f4291z = f10;
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet((c) null);
        constraintLayout.requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void d(ConstraintLayout constraintLayout, boolean z10) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f4227e.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!this.f4227e.containsKey(Integer.valueOf(id2))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id unknown ");
                sb2.append(androidx.constraintlayout.motion.widget.a.b(childAt));
            } else if (this.f4226d && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id2 != -1) {
                if (this.f4227e.containsKey(Integer.valueOf(id2))) {
                    hashSet.remove(Integer.valueOf(id2));
                    a aVar = this.f4227e.get(Integer.valueOf(id2));
                    if (aVar != null) {
                        if (childAt instanceof Barrier) {
                            aVar.f4232e.f4268j0 = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id2);
                            barrier.setType(aVar.f4232e.f4264h0);
                            barrier.setMargin(aVar.f4232e.f4266i0);
                            barrier.setAllowsGoneWidget(aVar.f4232e.f4280p0);
                            b bVar = aVar.f4232e;
                            int[] iArr = bVar.f4270k0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.f4272l0;
                                if (str != null) {
                                    bVar.f4270k0 = q(barrier, str);
                                    barrier.setReferencedIds(aVar.f4232e.f4270k0);
                                }
                            }
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                        bVar2.a();
                        aVar.d(bVar2);
                        if (z10) {
                            ConstraintAttribute.e(childAt, aVar.f4234g);
                        }
                        childAt.setLayoutParams(bVar2);
                        d dVar = aVar.f4230c;
                        if (dVar.f4309c == 0) {
                            childAt.setVisibility(dVar.f4308b);
                        }
                        childAt.setAlpha(aVar.f4230c.f4310d);
                        childAt.setRotation(aVar.f4233f.f4314b);
                        childAt.setRotationX(aVar.f4233f.f4315c);
                        childAt.setRotationY(aVar.f4233f.f4316d);
                        childAt.setScaleX(aVar.f4233f.f4317e);
                        childAt.setScaleY(aVar.f4233f.f4318f);
                        e eVar = aVar.f4233f;
                        if (eVar.f4321i != -1) {
                            View findViewById = ((View) childAt.getParent()).findViewById(aVar.f4233f.f4321i);
                            if (findViewById != null) {
                                float top = ((float) (findViewById.getTop() + findViewById.getBottom())) / 2.0f;
                                float left = ((float) (findViewById.getLeft() + findViewById.getRight())) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    childAt.setPivotX(left - ((float) childAt.getLeft()));
                                    childAt.setPivotY(top - ((float) childAt.getTop()));
                                }
                            }
                        } else {
                            if (!Float.isNaN(eVar.f4319g)) {
                                childAt.setPivotX(aVar.f4233f.f4319g);
                            }
                            if (!Float.isNaN(aVar.f4233f.f4320h)) {
                                childAt.setPivotY(aVar.f4233f.f4320h);
                            }
                        }
                        childAt.setTranslationX(aVar.f4233f.f4322j);
                        childAt.setTranslationY(aVar.f4233f.f4323k);
                        childAt.setTranslationZ(aVar.f4233f.f4324l);
                        e eVar2 = aVar.f4233f;
                        if (eVar2.f4325m) {
                            childAt.setElevation(eVar2.f4326n);
                        }
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("WARNING NO CONSTRAINTS for view ");
                    sb3.append(id2);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = this.f4227e.get(num);
            if (aVar2 != null) {
                if (aVar2.f4232e.f4268j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar3 = aVar2.f4232e;
                    int[] iArr2 = bVar3.f4270k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f4272l0;
                        if (str2 != null) {
                            bVar3.f4270k0 = q(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f4232e.f4270k0);
                        }
                    }
                    barrier2.setType(aVar2.f4232e.f4264h0);
                    barrier2.setMargin(aVar2.f4232e.f4266i0);
                    ConstraintLayout.b e10 = constraintLayout.generateDefaultLayoutParams();
                    barrier2.s();
                    aVar2.d(e10);
                    constraintLayout.addView(barrier2, e10);
                }
                if (aVar2.f4232e.f4249a) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b e11 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.d(e11);
                    constraintLayout.addView(guideline, e11);
                }
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = constraintLayout.getChildAt(i11);
            if (childAt2 instanceof a) {
                ((a) childAt2).i(constraintLayout);
            }
        }
    }

    public void e(Context context, int i10) {
        f((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    public void f(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f4227e.clear();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f4226d || id2 != -1) {
                if (!this.f4227e.containsKey(Integer.valueOf(id2))) {
                    this.f4227e.put(Integer.valueOf(id2), new a());
                }
                a aVar = this.f4227e.get(Integer.valueOf(id2));
                if (aVar != null) {
                    aVar.f4234g = ConstraintAttribute.a(this.f4225c, childAt);
                    aVar.f(id2, bVar);
                    aVar.f4230c.f4308b = childAt.getVisibility();
                    aVar.f4230c.f4310d = childAt.getAlpha();
                    aVar.f4233f.f4314b = childAt.getRotation();
                    aVar.f4233f.f4315c = childAt.getRotationX();
                    aVar.f4233f.f4316d = childAt.getRotationY();
                    aVar.f4233f.f4317e = childAt.getScaleX();
                    aVar.f4233f.f4318f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        e eVar = aVar.f4233f;
                        eVar.f4319g = pivotX;
                        eVar.f4320h = pivotY;
                    }
                    aVar.f4233f.f4322j = childAt.getTranslationX();
                    aVar.f4233f.f4323k = childAt.getTranslationY();
                    aVar.f4233f.f4324l = childAt.getTranslationZ();
                    e eVar2 = aVar.f4233f;
                    if (eVar2.f4325m) {
                        eVar2.f4326n = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        aVar.f4232e.f4280p0 = barrier.getAllowsGoneWidget();
                        aVar.f4232e.f4270k0 = barrier.getReferencedIds();
                        aVar.f4232e.f4264h0 = barrier.getType();
                        aVar.f4232e.f4266i0 = barrier.getMargin();
                    }
                }
                i10++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void g(d dVar) {
        int childCount = dVar.getChildCount();
        this.f4227e.clear();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = dVar.getChildAt(i10);
            d.a aVar = (d.a) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f4226d || id2 != -1) {
                if (!this.f4227e.containsKey(Integer.valueOf(id2))) {
                    this.f4227e.put(Integer.valueOf(id2), new a());
                }
                a aVar2 = this.f4227e.get(Integer.valueOf(id2));
                if (aVar2 != null) {
                    if (childAt instanceof a) {
                        aVar2.h((a) childAt, id2, aVar);
                    }
                    aVar2.g(id2, aVar);
                }
                i10++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void h(int i10, int i11, int i12, int i13) {
        if (!this.f4227e.containsKey(Integer.valueOf(i10))) {
            this.f4227e.put(Integer.valueOf(i10), new a());
        }
        a aVar = this.f4227e.get(Integer.valueOf(i10));
        if (aVar != null) {
            switch (i11) {
                case 1:
                    if (i13 == 1) {
                        b bVar = aVar.f4232e;
                        bVar.f4267j = i12;
                        bVar.f4269k = -1;
                        return;
                    } else if (i13 == 2) {
                        b bVar2 = aVar.f4232e;
                        bVar2.f4269k = i12;
                        bVar2.f4267j = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("left to " + I(i13) + " undefined");
                    }
                case 2:
                    if (i13 == 1) {
                        b bVar3 = aVar.f4232e;
                        bVar3.f4271l = i12;
                        bVar3.f4273m = -1;
                        return;
                    } else if (i13 == 2) {
                        b bVar4 = aVar.f4232e;
                        bVar4.f4273m = i12;
                        bVar4.f4271l = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                case 3:
                    if (i13 == 3) {
                        b bVar5 = aVar.f4232e;
                        bVar5.f4275n = i12;
                        bVar5.f4277o = -1;
                        bVar5.f4283r = -1;
                        bVar5.f4284s = -1;
                        bVar5.f4285t = -1;
                        return;
                    } else if (i13 == 4) {
                        b bVar6 = aVar.f4232e;
                        bVar6.f4277o = i12;
                        bVar6.f4275n = -1;
                        bVar6.f4283r = -1;
                        bVar6.f4284s = -1;
                        bVar6.f4285t = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                case 4:
                    if (i13 == 4) {
                        b bVar7 = aVar.f4232e;
                        bVar7.f4281q = i12;
                        bVar7.f4279p = -1;
                        bVar7.f4283r = -1;
                        bVar7.f4284s = -1;
                        bVar7.f4285t = -1;
                        return;
                    } else if (i13 == 3) {
                        b bVar8 = aVar.f4232e;
                        bVar8.f4279p = i12;
                        bVar8.f4281q = -1;
                        bVar8.f4283r = -1;
                        bVar8.f4284s = -1;
                        bVar8.f4285t = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                case 5:
                    if (i13 == 5) {
                        b bVar9 = aVar.f4232e;
                        bVar9.f4283r = i12;
                        bVar9.f4281q = -1;
                        bVar9.f4279p = -1;
                        bVar9.f4275n = -1;
                        bVar9.f4277o = -1;
                        return;
                    } else if (i13 == 3) {
                        b bVar10 = aVar.f4232e;
                        bVar10.f4284s = i12;
                        bVar10.f4281q = -1;
                        bVar10.f4279p = -1;
                        bVar10.f4275n = -1;
                        bVar10.f4277o = -1;
                        return;
                    } else if (i13 == 4) {
                        b bVar11 = aVar.f4232e;
                        bVar11.f4285t = i12;
                        bVar11.f4281q = -1;
                        bVar11.f4279p = -1;
                        bVar11.f4275n = -1;
                        bVar11.f4277o = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                case 6:
                    if (i13 == 6) {
                        b bVar12 = aVar.f4232e;
                        bVar12.f4287v = i12;
                        bVar12.f4286u = -1;
                        return;
                    } else if (i13 == 7) {
                        b bVar13 = aVar.f4232e;
                        bVar13.f4286u = i12;
                        bVar13.f4287v = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                case 7:
                    if (i13 == 7) {
                        b bVar14 = aVar.f4232e;
                        bVar14.f4289x = i12;
                        bVar14.f4288w = -1;
                        return;
                    } else if (i13 == 6) {
                        b bVar15 = aVar.f4232e;
                        bVar15.f4288w = i12;
                        bVar15.f4289x = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                default:
                    throw new IllegalArgumentException(I(i11) + " to " + I(i13) + " unknown");
            }
        }
    }

    public void i(int i10, int i11, int i12, int i13, int i14) {
        if (!this.f4227e.containsKey(Integer.valueOf(i10))) {
            this.f4227e.put(Integer.valueOf(i10), new a());
        }
        a aVar = this.f4227e.get(Integer.valueOf(i10));
        if (aVar != null) {
            switch (i11) {
                case 1:
                    if (i13 == 1) {
                        b bVar = aVar.f4232e;
                        bVar.f4267j = i12;
                        bVar.f4269k = -1;
                    } else if (i13 == 2) {
                        b bVar2 = aVar.f4232e;
                        bVar2.f4269k = i12;
                        bVar2.f4267j = -1;
                    } else {
                        throw new IllegalArgumentException("Left to " + I(i13) + " undefined");
                    }
                    aVar.f4232e.H = i14;
                    return;
                case 2:
                    if (i13 == 1) {
                        b bVar3 = aVar.f4232e;
                        bVar3.f4271l = i12;
                        bVar3.f4273m = -1;
                    } else if (i13 == 2) {
                        b bVar4 = aVar.f4232e;
                        bVar4.f4273m = i12;
                        bVar4.f4271l = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                    aVar.f4232e.I = i14;
                    return;
                case 3:
                    if (i13 == 3) {
                        b bVar5 = aVar.f4232e;
                        bVar5.f4275n = i12;
                        bVar5.f4277o = -1;
                        bVar5.f4283r = -1;
                        bVar5.f4284s = -1;
                        bVar5.f4285t = -1;
                    } else if (i13 == 4) {
                        b bVar6 = aVar.f4232e;
                        bVar6.f4277o = i12;
                        bVar6.f4275n = -1;
                        bVar6.f4283r = -1;
                        bVar6.f4284s = -1;
                        bVar6.f4285t = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                    aVar.f4232e.J = i14;
                    return;
                case 4:
                    if (i13 == 4) {
                        b bVar7 = aVar.f4232e;
                        bVar7.f4281q = i12;
                        bVar7.f4279p = -1;
                        bVar7.f4283r = -1;
                        bVar7.f4284s = -1;
                        bVar7.f4285t = -1;
                    } else if (i13 == 3) {
                        b bVar8 = aVar.f4232e;
                        bVar8.f4279p = i12;
                        bVar8.f4281q = -1;
                        bVar8.f4283r = -1;
                        bVar8.f4284s = -1;
                        bVar8.f4285t = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                    aVar.f4232e.K = i14;
                    return;
                case 5:
                    if (i13 == 5) {
                        b bVar9 = aVar.f4232e;
                        bVar9.f4283r = i12;
                        bVar9.f4281q = -1;
                        bVar9.f4279p = -1;
                        bVar9.f4275n = -1;
                        bVar9.f4277o = -1;
                        return;
                    } else if (i13 == 3) {
                        b bVar10 = aVar.f4232e;
                        bVar10.f4284s = i12;
                        bVar10.f4281q = -1;
                        bVar10.f4279p = -1;
                        bVar10.f4275n = -1;
                        bVar10.f4277o = -1;
                        return;
                    } else if (i13 == 4) {
                        b bVar11 = aVar.f4232e;
                        bVar11.f4285t = i12;
                        bVar11.f4281q = -1;
                        bVar11.f4279p = -1;
                        bVar11.f4275n = -1;
                        bVar11.f4277o = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                case 6:
                    if (i13 == 6) {
                        b bVar12 = aVar.f4232e;
                        bVar12.f4287v = i12;
                        bVar12.f4286u = -1;
                    } else if (i13 == 7) {
                        b bVar13 = aVar.f4232e;
                        bVar13.f4286u = i12;
                        bVar13.f4287v = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                    aVar.f4232e.M = i14;
                    return;
                case 7:
                    if (i13 == 7) {
                        b bVar14 = aVar.f4232e;
                        bVar14.f4289x = i12;
                        bVar14.f4288w = -1;
                    } else if (i13 == 6) {
                        b bVar15 = aVar.f4232e;
                        bVar15.f4288w = i12;
                        bVar15.f4289x = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + I(i13) + " undefined");
                    }
                    aVar.f4232e.L = i14;
                    return;
                default:
                    throw new IllegalArgumentException(I(i11) + " to " + I(i13) + " unknown");
            }
        }
    }

    public void j(int i10, int i11, int i12, float f10) {
        b bVar = v(i10).f4232e;
        bVar.B = i11;
        bVar.C = i12;
        bVar.D = f10;
    }

    public void k(int i10, int i11) {
        v(i10).f4232e.f4250a0 = i11;
    }

    public void l(int i10, int i11) {
        v(i10).f4232e.Z = i11;
    }

    public void m(int i10, int i11) {
        v(i10).f4232e.f4257e = i11;
    }

    public void n(int i10, int i11) {
        v(i10).f4232e.f4255d = i11;
    }

    public void o(int i10, boolean z10) {
        v(i10).f4232e.f4278o0 = z10;
    }

    public void p(int i10, boolean z10) {
        v(i10).f4232e.f4276n0 = z10;
    }

    public void r(int i10, int i11, int i12, int i13, int[] iArr, float[] fArr, int i14) {
        s(i10, i11, i12, i13, iArr, fArr, i14, 1, 2);
    }

    public void t(int i10, int i11, int i12, int i13, int[] iArr, float[] fArr, int i14) {
        int[] iArr2 = iArr;
        float[] fArr2 = fArr;
        if (iArr2.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr2 == null || fArr2.length == iArr2.length) {
            if (fArr2 != null) {
                v(iArr2[0]).f4232e.V = fArr2[0];
            }
            v(iArr2[0]).f4232e.Y = i14;
            i(iArr2[0], 3, i10, i11, 0);
            for (int i15 = 1; i15 < iArr2.length; i15++) {
                int i16 = i15 - 1;
                i(iArr2[i15], 3, iArr2[i16], 4, 0);
                i(iArr2[i16], 4, iArr2[i15], 3, 0);
                if (fArr2 != null) {
                    v(iArr2[i15]).f4232e.V = fArr2[i15];
                }
            }
            i(iArr2[iArr2.length - 1], 4, i12, i13, 0);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void w(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a u10 = u(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        u10.f4232e.f4249a = true;
                    }
                    this.f4227e.put(Integer.valueOf(u10.f4228a), u10);
                }
            }
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01cb, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x01da
            if (r0 == 0) goto L_0x01c8
            r4 = -1
            r5 = 3
            r6 = 2
            r7 = 0
            if (r0 == r6) goto L_0x0067
            if (r0 == r5) goto L_0x0015
            goto L_0x01cb
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r0 = r0.toLowerCase(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2075718416: goto L_0x0045;
                case -190376483: goto L_0x003b;
                case 426575017: goto L_0x0031;
                case 2146106725: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0026:
            goto L_0x004e
        L_0x0027:
            java.lang.String r8 = "constraintset"
            boolean r0 = r0.equals(r8)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r7
            goto L_0x004e
        L_0x0031:
            java.lang.String r7 = "constraintoverride"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r6
            goto L_0x004e
        L_0x003b:
            java.lang.String r7 = "constraint"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r3
            goto L_0x004e
        L_0x0045:
            java.lang.String r7 = "guideline"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x004e
            r4 = r5
        L_0x004e:
            if (r4 == 0) goto L_0x0066
            if (r4 == r3) goto L_0x0058
            if (r4 == r6) goto L_0x0058
            if (r4 == r5) goto L_0x0058
            goto L_0x01cb
        L_0x0058:
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.c$a> r0 = r9.f4227e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r3 = r2.f4228a     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2 = r1
            goto L_0x01cb
        L_0x0066:
            return
        L_0x0067:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            switch(r8) {
                case -2025855158: goto L_0x00d0;
                case -1984451626: goto L_0x00c6;
                case -1962203927: goto L_0x00bc;
                case -1269513683: goto L_0x00b2;
                case -1238332596: goto L_0x00a8;
                case -71750448: goto L_0x009e;
                case 366511058: goto L_0x0093;
                case 1331510167: goto L_0x0089;
                case 1791837707: goto L_0x007e;
                case 1803088381: goto L_0x0074;
                default: goto L_0x0072;
            }     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0072:
            goto L_0x00d9
        L_0x0074:
            java.lang.String r5 = "Constraint"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r7
            goto L_0x00d9
        L_0x007e:
            java.lang.String r5 = "CustomAttribute"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 8
            goto L_0x00d9
        L_0x0089:
            java.lang.String r6 = "Barrier"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r5
            goto L_0x00d9
        L_0x0093:
            java.lang.String r5 = "CustomMethod"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 9
            goto L_0x00d9
        L_0x009e:
            java.lang.String r5 = "Guideline"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r6
            goto L_0x00d9
        L_0x00a8:
            java.lang.String r5 = "Transform"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 5
            goto L_0x00d9
        L_0x00b2:
            java.lang.String r5 = "PropertySet"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 4
            goto L_0x00d9
        L_0x00bc:
            java.lang.String r5 = "ConstraintOverride"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = r3
            goto L_0x00d9
        L_0x00c6:
            java.lang.String r5 = "Motion"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 7
            goto L_0x00d9
        L_0x00d0:
            java.lang.String r5 = "Layout"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            if (r0 == 0) goto L_0x00d9
            r4 = 6
        L_0x00d9:
            java.lang.String r0 = "XML parser error must be within a Constraint "
            switch(r4) {
                case 0: goto L_0x01be;
                case 1: goto L_0x01b5;
                case 2: goto L_0x01a6;
                case 3: goto L_0x0199;
                case 4: goto L_0x0174;
                case 5: goto L_0x014e;
                case 6: goto L_0x0128;
                case 7: goto L_0x0102;
                case 8: goto L_0x00e0;
                case 9: goto L_0x00e0;
                default: goto L_0x00de;
            }
        L_0x00de:
            goto L_0x01cb
        L_0x00e0:
            if (r2 == 0) goto L_0x00e9
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r0 = r2.f4234g     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.ConstraintAttribute.d(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x00e9:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0102:
            if (r2 == 0) goto L_0x010f
            androidx.constraintlayout.widget.c$c r0 = r2.f4231d     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x010f:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0128:
            if (r2 == 0) goto L_0x0135
            androidx.constraintlayout.widget.c$b r0 = r2.f4232e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0135:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x014e:
            if (r2 == 0) goto L_0x015b
            androidx.constraintlayout.widget.c$e r0 = r2.f4233f     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x015b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0174:
            if (r2 == 0) goto L_0x0180
            androidx.constraintlayout.widget.c$d r0 = r2.f4230c     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01cb
        L_0x0180:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            throw r10     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x0199:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$a r0 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$b r2 = r0.f4232e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f4268j0 = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01a6:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$a r0 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$b r2 = r0.f4232e     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f4249a = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            r2.f4251b = r3     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01b5:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$a r0 = r9.u(r10, r0, r3)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x01c6
        L_0x01be:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            androidx.constraintlayout.widget.c$a r0 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01c6:
            r2 = r0
            goto L_0x01cb
        L_0x01c8:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
        L_0x01cb:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x01d6, IOException -> 0x01d1 }
            goto L_0x0006
        L_0x01d1:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x01da
        L_0x01d6:
            r10 = move-exception
            r10.printStackTrace()
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.x(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
