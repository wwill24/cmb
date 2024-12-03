package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        ResultReceiver f255a;

        static class a implements Parcelable.Creator<ResultReceiverWrapper> {
            a() {
            }

            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i10) {
                return new ResultReceiverWrapper[i10];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f255a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            this.f255a.writeToParcel(parcel, i10);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Object f256a;

        /* renamed from: b  reason: collision with root package name */
        private b f257b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f258c;

        static class a implements Parcelable.Creator<Token> {
            a() {
            }

            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable((ClassLoader) null));
            }

            /* renamed from: b */
            public Token[] newArray(int i10) {
                return new Token[i10];
            }
        }

        Token(Object obj) {
            this(obj, (b) null, (Bundle) null);
        }

        public b a() {
            return this.f257b;
        }

        public void c(b bVar) {
            this.f257b = bVar;
        }

        public void d(Bundle bundle) {
            this.f258c = bundle;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f256a;
            if (obj2 != null) {
                Object obj3 = token.f256a;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (token.f256a == null) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode() {
            Object obj = this.f256a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable((Parcelable) this.f256a, i10);
        }

        Token(Object obj, b bVar, Bundle bundle) {
            this.f256a = obj;
            this.f257b = bVar;
            this.f258c = bundle;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final MediaDescriptionCompat f252a;

        /* renamed from: b  reason: collision with root package name */
        private final long f253b;

        /* renamed from: c  reason: collision with root package name */
        private Object f254c;

        static class a implements Parcelable.Creator<QueueItem> {
            a() {
            }

            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: b */
            public QueueItem[] newArray(int i10) {
                return new QueueItem[i10];
            }
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j10 != -1) {
                this.f252a = mediaDescriptionCompat;
                this.f253b = j10;
                this.f254c = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem a(Object obj) {
            if (obj != null) {
                return new QueueItem(obj, MediaDescriptionCompat.a(f.a(obj)), f.b(obj));
            }
            return null;
        }

        public static List<QueueItem> c(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object a10 : list) {
                arrayList.add(a(a10));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f252a + ", Id=" + this.f253b + " }";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            this.f252a.writeToParcel(parcel, i10);
            parcel.writeLong(this.f253b);
        }

        QueueItem(Parcel parcel) {
            this.f252a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f253b = parcel.readLong();
        }
    }
}
