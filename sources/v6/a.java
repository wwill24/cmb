package v6;

import com.coffeemeetsbagel.models.entities.ActionCardEntity;
import com.coffeemeetsbagel.models.responses.ResponseActionCard;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18073a = new a();

    private a() {
    }

    public final ActionCardEntity a(ResponseActionCard responseActionCard) {
        j.g(responseActionCard, "network");
        return new ActionCardEntity(responseActionCard.getId(), responseActionCard.getAction(), responseActionCard.getActionText(), responseActionCard.getHeaderText(), responseActionCard.getImageUrl(), responseActionCard.getMessageText());
    }
}
