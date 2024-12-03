package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.e;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class c implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    final Object f282a = e.a(new a(this));

    /* renamed from: b  reason: collision with root package name */
    a f283b;

    private static class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<c> f284a;

        a(c cVar) {
            this.f284a = new WeakReference<>(cVar);
        }

        public void a(List<?> list) {
            c cVar = this.f284a.get();
            if (cVar != null) {
                cVar.e(MediaSessionCompat.QueueItem.c(list));
            }
        }

        public void b() {
            c cVar = this.f284a.get();
            if (cVar != null) {
                cVar.g();
            }
        }

        public void c(Object obj) {
            c cVar = this.f284a.get();
            if (cVar != null) {
                cVar.c(MediaMetadataCompat.a(obj));
            }
        }

        public void d(Bundle bundle) {
            c cVar = this.f284a.get();
            if (cVar != null) {
                cVar.b(bundle);
            }
        }

        public void e(CharSequence charSequence) {
            c cVar = this.f284a.get();
            if (cVar != null) {
                cVar.f(charSequence);
            }
        }

        public void f(Object obj) {
            c cVar = this.f284a.get();
            if (cVar != null && cVar.f283b == null) {
                cVar.d(PlaybackStateCompat.a(obj));
            }
        }

        public void g(String str, Bundle bundle) {
            c cVar = this.f284a.get();
            if (cVar != null) {
                a aVar = cVar.f283b;
                cVar.h(str, bundle);
            }
        }

        public void h(int i10, int i11, int i12, int i13, int i14) {
            c cVar = this.f284a.get();
            if (cVar != null) {
                cVar.a(new d(i10, i11, i12, i13, i14));
            }
        }
    }

    private static class b extends a.C0006a {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<c> f285a;

        b(c cVar) {
            this.f285a = new WeakReference<>(cVar);
        }

        public void A(int i10) throws RemoteException {
            c cVar = this.f285a.get();
            if (cVar != null) {
                cVar.i(12, Integer.valueOf(i10), (Bundle) null);
            }
        }

        public void T(boolean z10) throws RemoteException {
            c cVar = this.f285a.get();
            if (cVar != null) {
                cVar.i(11, Boolean.valueOf(z10), (Bundle) null);
            }
        }

        public void a0(boolean z10) throws RemoteException {
        }

        public void f0(int i10) throws RemoteException {
            c cVar = this.f285a.get();
            if (cVar != null) {
                cVar.i(9, Integer.valueOf(i10), (Bundle) null);
            }
        }

        public void o() throws RemoteException {
            c cVar = this.f285a.get();
            if (cVar != null) {
                cVar.i(13, (Object) null, (Bundle) null);
            }
        }

        public void onEvent(String str, Bundle bundle) throws RemoteException {
            c cVar = this.f285a.get();
            if (cVar != null) {
                cVar.i(1, str, bundle);
            }
        }

        public void u0(PlaybackStateCompat playbackStateCompat) throws RemoteException {
            c cVar = this.f285a.get();
            if (cVar != null) {
                cVar.i(2, playbackStateCompat, (Bundle) null);
            }
        }
    }

    public void a(d dVar) {
    }

    public void b(Bundle bundle) {
    }

    public void binderDied() {
        i(8, (Object) null, (Bundle) null);
    }

    public void c(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void d(PlaybackStateCompat playbackStateCompat) {
    }

    public void e(List<MediaSessionCompat.QueueItem> list) {
    }

    public void f(CharSequence charSequence) {
    }

    public void g() {
    }

    public void h(String str, Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public void i(int i10, Object obj, Bundle bundle) {
    }
}
