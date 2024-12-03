package j4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.h;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.inbox.CTInboxActivity;
import com.clevertap.android.sdk.inbox.e;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import i4.t;

public class a extends RecyclerView {
    ExoPlayer V0;
    private Context W0;
    /* access modifiers changed from: private */
    public e X0;
    private StyledPlayerView Y0;

    /* renamed from: j4.a$a  reason: collision with other inner class name */
    class C0164a extends RecyclerView.t {
        C0164a() {
        }

        public void a(@NonNull RecyclerView recyclerView, int i10) {
            super.a(recyclerView, i10);
            if (i10 == 0) {
                a.this.P1();
            }
        }

        public void b(@NonNull RecyclerView recyclerView, int i10, int i11) {
            super.b(recyclerView, i10, i11);
        }
    }

    class b implements RecyclerView.q {
        b() {
        }

        public void b(@NonNull View view) {
            if (a.this.X0 != null && a.this.X0.f6302a.equals(view)) {
                a.this.S1();
            }
        }

        public void d(@NonNull View view) {
        }
    }

    class c implements Player.Listener {
        c() {
        }
    }

    public a(Context context) {
        super(context);
        M1(context);
    }

    private e L1() {
        e eVar;
        int i10;
        int a22 = ((LinearLayoutManager) getLayoutManager()).a2();
        int c22 = ((LinearLayoutManager) getLayoutManager()).c2();
        e eVar2 = null;
        int i11 = 0;
        for (int i12 = a22; i12 <= c22; i12++) {
            View childAt = getChildAt(i12 - a22);
            if (!(childAt == null || (eVar = (e) childAt.getTag()) == null || !eVar.g0())) {
                Rect rect = new Rect();
                if (eVar.f6302a.getGlobalVisibleRect(rect)) {
                    i10 = rect.height();
                } else {
                    i10 = 0;
                }
                if (i10 > i11) {
                    eVar2 = eVar;
                    i11 = i10;
                }
            }
        }
        return eVar2;
    }

    private void M1(Context context) {
        this.W0 = context.getApplicationContext();
        StyledPlayerView styledPlayerView = new StyledPlayerView(this.W0);
        this.Y0 = styledPlayerView;
        styledPlayerView.setBackgroundColor(0);
        if (CTInboxActivity.f10465h == 2) {
            this.Y0.setResizeMode(3);
        } else {
            this.Y0.setResizeMode(0);
        }
        this.Y0.setUseArtwork(true);
        this.Y0.setDefaultArtwork(h.e(context.getResources(), t.ct_audio, (Resources.Theme) null));
        ExoPlayer build = new ExoPlayer.Builder(context).setTrackSelector(new DefaultTrackSelector(this.W0, new AdaptiveTrackSelection.Factory())).build();
        this.V0 = build;
        build.setVolume(0.0f);
        this.Y0.setUseController(true);
        this.Y0.setControllerAutoShow(false);
        this.Y0.setPlayer(this.V0);
        l(new C0164a());
        j(new b());
        this.V0.addListener(new c());
    }

    private void R1() {
        ViewGroup viewGroup;
        int indexOfChild;
        StyledPlayerView styledPlayerView = this.Y0;
        if (styledPlayerView != null && (viewGroup = (ViewGroup) styledPlayerView.getParent()) != null && (indexOfChild = viewGroup.indexOfChild(this.Y0)) >= 0) {
            viewGroup.removeViewAt(indexOfChild);
            ExoPlayer exoPlayer = this.V0;
            if (exoPlayer != null) {
                exoPlayer.stop();
            }
            e eVar = this.X0;
            if (eVar != null) {
                eVar.h0();
                this.X0 = null;
            }
        }
    }

    public void N1() {
        ExoPlayer exoPlayer = this.V0;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
        }
    }

    public void O1() {
        if (this.Y0 == null) {
            M1(this.W0);
            P1();
        }
    }

    public void P1() {
        int i10;
        boolean z10;
        if (this.Y0 != null) {
            e L1 = L1();
            if (L1 == null) {
                S1();
                R1();
                return;
            }
            e eVar = this.X0;
            if (eVar == null || !eVar.f6302a.equals(L1.f6302a)) {
                R1();
                if (L1.W(this.Y0)) {
                    this.X0 = L1;
                    return;
                }
                return;
            }
            Rect rect = new Rect();
            if (this.X0.f6302a.getGlobalVisibleRect(rect)) {
                i10 = rect.height();
            } else {
                i10 = 0;
            }
            ExoPlayer exoPlayer = this.V0;
            if (exoPlayer != null) {
                if (i10 >= 400) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    exoPlayer.setPlayWhenReady(false);
                } else if (this.X0.j0()) {
                    this.V0.setPlayWhenReady(true);
                }
            }
        }
    }

    public void Q1() {
        ExoPlayer exoPlayer = this.V0;
        if (exoPlayer != null) {
            exoPlayer.stop();
            this.V0.release();
            this.V0 = null;
        }
        this.X0 = null;
        this.Y0 = null;
    }

    public void S1() {
        ExoPlayer exoPlayer = this.V0;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        this.X0 = null;
    }
}
