package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import androidx.core.app.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21 {

    /* renamed from: a  reason: collision with root package name */
    final Object f247a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f248b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<c, a> f249c;

    /* renamed from: d  reason: collision with root package name */
    final MediaSessionCompat.Token f250d;

    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> f251a;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i10, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f251a.get();
            if (mediaControllerCompat$MediaControllerImplApi21 != null && bundle != null) {
                synchronized (mediaControllerCompat$MediaControllerImplApi21.f247a) {
                    mediaControllerCompat$MediaControllerImplApi21.f250d.c(b.a.c(g.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerCompat$MediaControllerImplApi21.f250d.d(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerCompat$MediaControllerImplApi21.a();
                }
            }
        }
    }

    private static class a extends c.b {
        a(c cVar) {
            super(cVar);
        }

        public void F(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            throw new AssertionError();
        }

        public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }

        public void b() throws RemoteException {
            throw new AssertionError();
        }

        public void d(Bundle bundle) throws RemoteException {
            throw new AssertionError();
        }

        public void e(CharSequence charSequence) throws RemoteException {
            throw new AssertionError();
        }

        public void w(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f250d.a() != null) {
            for (c next : this.f248b) {
                a aVar = new a(next);
                this.f249c.put(next, aVar);
                next.f283b = aVar;
                try {
                    this.f250d.a().G(aVar);
                    next.i(13, (Object) null, (Bundle) null);
                } catch (RemoteException unused) {
                }
            }
            this.f248b.clear();
        }
    }
}
