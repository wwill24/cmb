package ca;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import ba.e;
import ca.g;
import com.coffeemeetsbagel.like_pass.view.LikePassButtonsCenterDLSView;

public class h extends g<a> {

    /* renamed from: a  reason: collision with root package name */
    Activity f8019a;

    interface a extends g.a<h> {
    }

    public interface b {
        Activity i();
    }

    public h(b bVar) {
        b.a().b(bVar).a().a(this);
    }

    public com.coffeemeetsbagel.like_pass.view.b a(ViewGroup viewGroup) {
        return (LikePassButtonsCenterDLSView) LayoutInflater.from(this.f8019a).inflate(e.like_pass_buttons_center_dls, viewGroup, false);
    }
}
