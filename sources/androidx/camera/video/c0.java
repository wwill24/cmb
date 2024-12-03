package androidx.camera.video;

import android.media.MediaScannerConnection;
import android.net.Uri;
import androidx.camera.video.Recorder;

public final /* synthetic */ class c0 implements MediaScannerConnection.OnScanCompletedListener {
    public final void onScanCompleted(String str, Uri uri) {
        Recorder.h.G(str, uri);
    }
}
