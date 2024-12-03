package com.withpersona.sdk2.inquiry;

import com.withpersona.sdk2.inquiry.internal.fallbackmode.LocalStaticInquiryTemplate;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.StaticInquiryTemplate;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class StaticInquiryTemplateKt {
    public static final StaticInquiryTemplate to(StaticInquiryTemplate staticInquiryTemplate) {
        j.g(staticInquiryTemplate, "<this>");
        if (staticInquiryTemplate instanceof LocalStaticInquiryTemplate) {
            return new LocalStaticInquiryTemplate(((LocalStaticInquiryTemplate) staticInquiryTemplate).getResourceId());
        }
        throw new NoWhenBranchMatchedException();
    }
}
