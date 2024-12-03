package n4;

import android.view.View;
import com.clevertap.android.sdk.inbox.e;
import com.google.android.exoplayer2.ExoPlayer;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f16422a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlayer f16423b;

    public /* synthetic */ a(e eVar, ExoPlayer exoPlayer) {
        this.f16422a = eVar;
        this.f16423b = exoPlayer;
    }

    public final void onClick(View view) {
        this.f16422a.e0(this.f16423b, view);
    }
}
