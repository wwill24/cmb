package com.withpersona.sdk2.inquiry;

@ExperimentalInquiryTemplate
public final class LocalStaticInquiryTemplate implements StaticInquiryTemplate {
    private final int resourceId;

    public LocalStaticInquiryTemplate(int i10) {
        this.resourceId = i10;
    }

    public final int getResourceId() {
        return this.resourceId;
    }
}
