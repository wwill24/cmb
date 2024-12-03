package ca;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import ba.e;
import ca.g;

public class j extends g<a> {

    /* renamed from: a  reason: collision with root package name */
    Activity f8020a;

    interface a extends g.a<j> {
    }

    public interface b {
        Activity i();
    }

    public j(b bVar) {
        e.a().b(bVar).a().a(this);
    }

    public com.coffeemeetsbagel.like_pass.view.b a(ViewGroup viewGroup) {
        return (com.coffeemeetsbagel.like_pass.view.b) LayoutInflater.from(this.f8020a).inflate(e.like_pass_buttons_spread, viewGroup, false);
    }
}
