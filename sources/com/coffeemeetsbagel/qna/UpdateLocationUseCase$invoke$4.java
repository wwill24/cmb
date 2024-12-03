package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Location;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Session;

final class UpdateLocationUseCase$invoke$4 extends Lambda implements Function1<Optional<QuestionWAnswers>, Location> {

    /* renamed from: a  reason: collision with root package name */
    public static final UpdateLocationUseCase$invoke$4 f36226a = new UpdateLocationUseCase$invoke$4();

    UpdateLocationUseCase$invoke$4() {
        super(1);
    }

    /* renamed from: a */
    public final Location invoke(Optional<QuestionWAnswers> optional) {
        Location location;
        j.g(optional, Session.Feature.OPTIONAL_ELEMENT);
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(optional.get().d());
        if (answer != null && (location = answer.getLocation()) != null) {
            return location;
        }
        throw new Exception("Missing Location.");
    }
}
