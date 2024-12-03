package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.g;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f264a;

    /* renamed from: b  reason: collision with root package name */
    final long f265b;

    /* renamed from: c  reason: collision with root package name */
    final long f266c;

    /* renamed from: d  reason: collision with root package name */
    final float f267d;

    /* renamed from: e  reason: collision with root package name */
    final long f268e;

    /* renamed from: f  reason: collision with root package name */
    final int f269f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f270g;

    /* renamed from: h  reason: collision with root package name */
    final long f271h;

    /* renamed from: j  reason: collision with root package name */
    List<CustomAction> f272j;

    /* renamed from: k  reason: collision with root package name */
    final long f273k;

    /* renamed from: l  reason: collision with root package name */
    final Bundle f274l;

    /* renamed from: m  reason: collision with root package name */
    private Object f275m;

    static class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i10) {
            return new PlaybackStateCompat[i10];
        }
    }

    PlaybackStateCompat(int i10, long j10, long j11, float f10, long j12, int i11, CharSequence charSequence, long j13, List<CustomAction> list, long j14, Bundle bundle) {
        this.f264a = i10;
        this.f265b = j10;
        this.f266c = j11;
        this.f267d = f10;
        this.f268e = j12;
        this.f269f = i11;
        this.f270g = charSequence;
        this.f271h = j13;
        this.f272j = new ArrayList(list);
        this.f273k = j14;
        this.f274l = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        Object obj2 = obj;
        ArrayList arrayList = null;
        if (obj2 == null) {
            return null;
        }
        List<Object> d10 = g.d(obj);
        if (d10 != null) {
            arrayList = new ArrayList(d10.size());
            for (Object a10 : d10) {
                arrayList.add(CustomAction.a(a10));
            }
        }
        Bundle a11 = h.a(obj);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(g.i(obj), g.h(obj), g.c(obj), g.g(obj), g.a(obj), 0, g.e(obj), g.f(obj), arrayList, g.b(obj), a11);
        playbackStateCompat.f275m = obj2;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f264a + ", position=" + this.f265b + ", buffered position=" + this.f266c + ", speed=" + this.f267d + ", updated=" + this.f271h + ", actions=" + this.f268e + ", error code=" + this.f269f + ", error message=" + this.f270g + ", custom actions=" + this.f272j + ", active item id=" + this.f273k + "}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f264a);
        parcel.writeLong(this.f265b);
        parcel.writeFloat(this.f267d);
        parcel.writeLong(this.f271h);
        parcel.writeLong(this.f266c);
        parcel.writeLong(this.f268e);
        TextUtils.writeToParcel(this.f270g, parcel, i10);
        parcel.writeTypedList(this.f272j);
        parcel.writeLong(this.f273k);
        parcel.writeBundle(this.f274l);
        parcel.writeInt(this.f269f);
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f276a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f277b;

        /* renamed from: c  reason: collision with root package name */
        private final int f278c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f279d;

        /* renamed from: e  reason: collision with root package name */
        private Object f280e;

        static class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i10) {
                return new CustomAction[i10];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f276a = str;
            this.f277b = charSequence;
            this.f278c = i10;
            this.f279d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null) {
                return null;
            }
            CustomAction customAction = new CustomAction(g.a.a(obj), g.a.d(obj), g.a.c(obj), g.a.b(obj));
            customAction.f280e = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f277b + ", mIcon=" + this.f278c + ", mExtras=" + this.f279d;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f276a);
            TextUtils.writeToParcel(this.f277b, parcel, i10);
            parcel.writeInt(this.f278c);
            parcel.writeBundle(this.f279d);
        }

        CustomAction(Parcel parcel) {
            this.f276a = parcel.readString();
            this.f277b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f278c = parcel.readInt();
            this.f279d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f264a = parcel.readInt();
        this.f265b = parcel.readLong();
        this.f267d = parcel.readFloat();
        this.f271h = parcel.readLong();
        this.f266c = parcel.readLong();
        this.f268e = parcel.readLong();
        this.f270g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f272j = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f273k = parcel.readLong();
        this.f274l = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f269f = parcel.readInt();
    }
}
