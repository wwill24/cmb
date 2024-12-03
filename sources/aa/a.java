package aa;

import com.leanplum.ActionContext;
import com.leanplum.actions.LeanplumActions;
import com.leanplum.actions.MessageDisplayChoice;
import com.leanplum.actions.MessageDisplayController;
import com.leanplum.actions.internal.ActionsTrigger;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0003a f219a = new C0003a((DefaultConstructorMarker) null);

    /* renamed from: aa.a$a  reason: collision with other inner class name */
    public static final class C0003a {

        /* renamed from: aa.a$a$a  reason: collision with other inner class name */
        public static final class C0004a implements MessageDisplayController {
            C0004a() {
            }

            public List<ActionContext> prioritizeMessages(List<? extends ActionContext> list, ActionsTrigger actionsTrigger) {
                j.g(list, "actions");
                return list;
            }

            public MessageDisplayChoice shouldDisplayMessage(ActionContext actionContext) {
                j.g(actionContext, "action");
                return MessageDisplayChoice.Companion.delayIndefinitely();
            }
        }

        private C0003a() {
        }

        public /* synthetic */ C0003a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z10) {
            C0004a aVar;
            if (z10) {
                aVar = new C0004a();
            } else {
                LeanplumActions.triggerDelayedMessages();
                aVar = null;
            }
            LeanplumActions.setMessageDisplayController(aVar);
        }
    }
}
