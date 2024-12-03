package com.coffeemeetsbagel.new_user_experience.gender_inference;

import com.coffeemeetsbagel.models.ProfileDtoImplementationKt;
import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.enums.InferredGenderOptions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import x6.d;

final class GenderInferenceInteractor$getGenderFromProfile$2 extends Lambda implements Function1<d<ProfileDataContract>, InferredGenderOptions> {
    final /* synthetic */ GenderInferenceInteractor this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35030a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.models.entities.GenderType[] r0 = com.coffeemeetsbagel.models.entities.GenderType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.entities.GenderType r1 = com.coffeemeetsbagel.models.entities.GenderType.FEMALE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.entities.GenderType r1 = com.coffeemeetsbagel.models.entities.GenderType.MALE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f35030a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.gender_inference.GenderInferenceInteractor$getGenderFromProfile$2.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInferenceInteractor$getGenderFromProfile$2(GenderInferenceInteractor genderInferenceInteractor) {
        super(1);
        this.this$0 = genderInferenceInteractor;
    }

    /* renamed from: a */
    public final InferredGenderOptions invoke(d<ProfileDataContract> dVar) {
        GenderType genderType;
        int i10;
        j.g(dVar, "resultState");
        this.this$0.j2(ProfileDtoImplementationKt.profileDtoToImplementation(dVar.d()));
        ProfileDataContract d10 = dVar.d();
        if (d10 != null) {
            genderType = d10.getGender();
        } else {
            genderType = null;
        }
        if (genderType == null) {
            i10 = -1;
        } else {
            i10 = a.f35030a[genderType.ordinal()];
        }
        if (i10 == 1) {
            return InferredGenderOptions.WOMEN;
        }
        if (i10 != 2) {
            return InferredGenderOptions.NULL;
        }
        return InferredGenderOptions.MEN;
    }
}
