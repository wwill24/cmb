package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class e {

    public interface a {
        void a(List<?> list);

        void b();

        void c(Object obj);

        void d(Bundle bundle);

        void e(CharSequence charSequence);

        void f(Object obj);

        void g(String str, Bundle bundle);

        void h(int i10, int i11, int i12, int i13, int i14);
    }

    static class b<T extends a> extends MediaController.Callback {

        /* renamed from: a  reason: collision with root package name */
        protected final T f291a;

        public b(T t10) {
            this.f291a = t10;
        }

        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f291a.h(playbackInfo.getPlaybackType(), c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f291a.d(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f291a.c(mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f291a.f(playbackState);
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f291a.a(list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f291a.e(charSequence);
        }

        public void onSessionDestroyed() {
            this.f291a.b();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f291a.g(str, bundle);
        }
    }

    public static class c {
        public static AudioAttributes a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return c(a(obj));
        }

        private static int c(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            int usage = audioAttributes.getUsage();
            if (usage == 13) {
                return 1;
            }
            switch (usage) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }
}
