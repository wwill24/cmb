package o5;

import android.app.Activity;
import androidx.appcompat.app.c;
import b6.b;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.feature.chat.header.a;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import kotlin.jvm.internal.j;

public interface a extends b<ChatActivity>, e.a, a.c {

    /* renamed from: o5.a$a  reason: collision with other inner class name */
    public static final class C0182a {

        /* renamed from: a  reason: collision with root package name */
        private ChatActivity f16820a;

        public C0182a(ChatActivity chatActivity) {
            j.g(chatActivity, "activity");
            this.f16820a = chatActivity;
        }

        public final Activity a() {
            return this.f16820a;
        }

        public final c b() {
            return this.f16820a;
        }
    }

    void R(d dVar);
}
