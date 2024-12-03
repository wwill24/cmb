package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import bf.d;
import bf.i;
import bf.j;
import bf.k;
import bf.l;
import com.coffeemeetsbagel.models.constants.Extra;
import com.google.android.material.internal.p;
import java.util.Locale;
import jf.b;
import qf.c;

public final class BadgeState {

    /* renamed from: a  reason: collision with root package name */
    private final State f19126a;

    /* renamed from: b  reason: collision with root package name */
    private final State f19127b;

    /* renamed from: c  reason: collision with root package name */
    final float f19128c;

    /* renamed from: d  reason: collision with root package name */
    final float f19129d;

    /* renamed from: e  reason: collision with root package name */
    final float f19130e;

    BadgeState(Context context, int i10, int i11, int i12, State state) {
        int i13;
        CharSequence charSequence;
        int i14;
        int i15;
        boolean z10;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        State state2 = new State();
        this.f19127b = state2;
        state = state == null ? new State() : state;
        if (i10 != 0) {
            int unused = state.f19131a = i10;
        }
        TypedArray a10 = a(context, state.f19131a, i11, i12);
        Resources resources = context.getResources();
        this.f19128c = (float) a10.getDimensionPixelSize(l.Badge_badgeRadius, resources.getDimensionPixelSize(d.mtrl_badge_radius));
        this.f19130e = (float) a10.getDimensionPixelSize(l.Badge_badgeWidePadding, resources.getDimensionPixelSize(d.mtrl_badge_long_text_horizontal_padding));
        this.f19129d = (float) a10.getDimensionPixelSize(l.Badge_badgeWithTextRadius, resources.getDimensionPixelSize(d.mtrl_badge_with_text_radius));
        if (state.f19134d == -2) {
            i13 = 255;
        } else {
            i13 = state.f19134d;
        }
        int unused2 = state2.f19134d = i13;
        if (state.f19138h == null) {
            charSequence = context.getString(j.mtrl_badge_numberless_content_description);
        } else {
            charSequence = state.f19138h;
        }
        CharSequence unused3 = state2.f19138h = charSequence;
        if (state.f19139j == 0) {
            i14 = i.mtrl_badge_content_description;
        } else {
            i14 = state.f19139j;
        }
        int unused4 = state2.f19139j = i14;
        if (state.f19140k == 0) {
            i15 = j.mtrl_exceed_max_badge_number_content_description;
        } else {
            i15 = state.f19140k;
        }
        int unused5 = state2.f19140k = i15;
        int i24 = 0;
        if (state.f19142m == null || state.f19142m.booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Boolean unused6 = state2.f19142m = Boolean.valueOf(z10);
        if (state.f19136f == -2) {
            i16 = a10.getInt(l.Badge_maxCharacterCount, 4);
        } else {
            i16 = state.f19136f;
        }
        int unused7 = state2.f19136f = i16;
        if (state.f19135e != -2) {
            int unused8 = state2.f19135e = state.f19135e;
        } else {
            int i25 = l.Badge_number;
            if (a10.hasValue(i25)) {
                int unused9 = state2.f19135e = a10.getInt(i25, 0);
            } else {
                int unused10 = state2.f19135e = -1;
            }
        }
        if (state.f19132b == null) {
            i17 = t(context, a10, l.Badge_backgroundColor);
        } else {
            i17 = state.f19132b.intValue();
        }
        Integer unused11 = state2.f19132b = Integer.valueOf(i17);
        if (state.f19133c != null) {
            Integer unused12 = state2.f19133c = state.f19133c;
        } else {
            int i26 = l.Badge_badgeTextColor;
            if (a10.hasValue(i26)) {
                Integer unused13 = state2.f19133c = Integer.valueOf(t(context, a10, i26));
            } else {
                Integer unused14 = state2.f19133c = Integer.valueOf(new qf.d(context, k.TextAppearance_MaterialComponents_Badge).i().getDefaultColor());
            }
        }
        if (state.f19141l == null) {
            i18 = a10.getInt(l.Badge_badgeGravity, 8388661);
        } else {
            i18 = state.f19141l.intValue();
        }
        Integer unused15 = state2.f19141l = Integer.valueOf(i18);
        if (state.f19143n == null) {
            i19 = a10.getDimensionPixelOffset(l.Badge_horizontalOffset, 0);
        } else {
            i19 = state.f19143n.intValue();
        }
        Integer unused16 = state2.f19143n = Integer.valueOf(i19);
        if (state.f19144p == null) {
            i20 = a10.getDimensionPixelOffset(l.Badge_verticalOffset, 0);
        } else {
            i20 = state.f19144p.intValue();
        }
        Integer unused17 = state2.f19144p = Integer.valueOf(i20);
        if (state.f19145q == null) {
            i21 = a10.getDimensionPixelOffset(l.Badge_horizontalOffsetWithText, state2.f19143n.intValue());
        } else {
            i21 = state.f19145q.intValue();
        }
        Integer unused18 = state2.f19145q = Integer.valueOf(i21);
        if (state.f19146t == null) {
            i22 = a10.getDimensionPixelOffset(l.Badge_verticalOffsetWithText, state2.f19144p.intValue());
        } else {
            i22 = state.f19146t.intValue();
        }
        Integer unused19 = state2.f19146t = Integer.valueOf(i22);
        if (state.f19147w == null) {
            i23 = 0;
        } else {
            i23 = state.f19147w.intValue();
        }
        Integer unused20 = state2.f19147w = Integer.valueOf(i23);
        Integer unused21 = state2.f19148x = Integer.valueOf(state.f19148x != null ? state.f19148x.intValue() : i24);
        a10.recycle();
        if (state.f19137g == null) {
            Locale unused22 = state2.f19137g = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            Locale unused23 = state2.f19137g = state.f19137g;
        }
        this.f19126a = state;
    }

    private TypedArray a(Context context, int i10, int i11, int i12) {
        AttributeSet attributeSet;
        int i13;
        int i14;
        if (i10 != 0) {
            AttributeSet e10 = b.e(context, i10, Extra.BADGE);
            i13 = e10.getStyleAttribute();
            attributeSet = e10;
        } else {
            attributeSet = null;
            i13 = 0;
        }
        if (i13 == 0) {
            i14 = i12;
        } else {
            i14 = i13;
        }
        return p.i(context, attributeSet, l.Badge, i11, i14, new int[0]);
    }

    private static int t(Context context, @NonNull TypedArray typedArray, int i10) {
        return c.a(context, typedArray, i10).getDefaultColor();
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f19127b.f19147w.intValue();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f19127b.f19148x.intValue();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f19127b.f19134d;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f19127b.f19132b.intValue();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f19127b.f19141l.intValue();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f19127b.f19133c.intValue();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f19127b.f19140k;
    }

    /* access modifiers changed from: package-private */
    public CharSequence i() {
        return this.f19127b.f19138h;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f19127b.f19139j;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f19127b.f19145q.intValue();
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return this.f19127b.f19143n.intValue();
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.f19127b.f19136f;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f19127b.f19135e;
    }

    /* access modifiers changed from: package-private */
    public Locale o() {
        return this.f19127b.f19137g;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f19127b.f19146t.intValue();
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.f19127b.f19144p.intValue();
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.f19127b.f19135e != -1;
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return this.f19127b.f19142m.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public void u(int i10) {
        int unused = this.f19126a.f19134d = i10;
        int unused2 = this.f19127b.f19134d = i10;
    }

    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new a();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f19131a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Integer f19132b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Integer f19133c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f19134d = 255;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f19135e = -2;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f19136f = -2;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public Locale f19137g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f19138h;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public int f19139j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public int f19140k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public Integer f19141l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public Boolean f19142m = Boolean.TRUE;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public Integer f19143n;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public Integer f19144p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public Integer f19145q;
        /* access modifiers changed from: private */

        /* renamed from: t  reason: collision with root package name */
        public Integer f19146t;
        /* access modifiers changed from: private */

        /* renamed from: w  reason: collision with root package name */
        public Integer f19147w;
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public Integer f19148x;

        class a implements Parcelable.Creator<State> {
            a() {
            }

            @NonNull
            /* renamed from: a */
            public State createFromParcel(@NonNull Parcel parcel) {
                return new State(parcel);
            }

            @NonNull
            /* renamed from: b */
            public State[] newArray(int i10) {
                return new State[i10];
            }
        }

        public State() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            String str;
            parcel.writeInt(this.f19131a);
            parcel.writeSerializable(this.f19132b);
            parcel.writeSerializable(this.f19133c);
            parcel.writeInt(this.f19134d);
            parcel.writeInt(this.f19135e);
            parcel.writeInt(this.f19136f);
            CharSequence charSequence = this.f19138h;
            if (charSequence == null) {
                str = null;
            } else {
                str = charSequence.toString();
            }
            parcel.writeString(str);
            parcel.writeInt(this.f19139j);
            parcel.writeSerializable(this.f19141l);
            parcel.writeSerializable(this.f19143n);
            parcel.writeSerializable(this.f19144p);
            parcel.writeSerializable(this.f19145q);
            parcel.writeSerializable(this.f19146t);
            parcel.writeSerializable(this.f19147w);
            parcel.writeSerializable(this.f19148x);
            parcel.writeSerializable(this.f19142m);
            parcel.writeSerializable(this.f19137g);
        }

        State(@NonNull Parcel parcel) {
            this.f19131a = parcel.readInt();
            this.f19132b = (Integer) parcel.readSerializable();
            this.f19133c = (Integer) parcel.readSerializable();
            this.f19134d = parcel.readInt();
            this.f19135e = parcel.readInt();
            this.f19136f = parcel.readInt();
            this.f19138h = parcel.readString();
            this.f19139j = parcel.readInt();
            this.f19141l = (Integer) parcel.readSerializable();
            this.f19143n = (Integer) parcel.readSerializable();
            this.f19144p = (Integer) parcel.readSerializable();
            this.f19145q = (Integer) parcel.readSerializable();
            this.f19146t = (Integer) parcel.readSerializable();
            this.f19147w = (Integer) parcel.readSerializable();
            this.f19148x = (Integer) parcel.readSerializable();
            this.f19142m = (Boolean) parcel.readSerializable();
            this.f19137g = (Locale) parcel.readSerializable();
        }
    }
}
