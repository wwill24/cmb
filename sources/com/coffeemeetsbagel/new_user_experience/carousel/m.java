package com.coffeemeetsbagel.new_user_experience.carousel;

import com.leanplum.messagetemplates.MessageTemplateConstants;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

public final class m {
    public final int a(long j10, long j11, double d10, long j12) {
        return (int) (((double) j12) + (((double) ((j10 / 1000) - j11)) * d10));
    }

    public final long b(double d10) {
        if (d10 <= 0.0d) {
            return 0;
        }
        return ((long) (((double) 1) / d10)) * ((long) j.m(new IntRange(MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT, 750), Random.f32142a));
    }
}
