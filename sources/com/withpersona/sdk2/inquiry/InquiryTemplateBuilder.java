package com.withpersona.sdk2.inquiry;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class InquiryTemplateBuilder {
    private String accountId;
    private Boolean enableErrorLogging;
    private Environment environment;
    private Fields fields;
    private String referenceId;
    private Boolean returnCollectedData;
    private Boolean shouldAutoFallback;
    private final StaticInquiryTemplate staticInquiryTemplate;
    private final String templateId;
    private final String templateVersion;
    private Integer theme;
    private Boolean useServerStyles;

    public InquiryTemplateBuilder() {
        this((String) null, (String) null, (StaticInquiryTemplate) null, 7, (DefaultConstructorMarker) null);
    }

    public InquiryTemplateBuilder(String str, String str2, StaticInquiryTemplate staticInquiryTemplate2) {
        this.templateId = str;
        this.templateVersion = str2;
        this.staticInquiryTemplate = staticInquiryTemplate2;
    }

    public final InquiryTemplateBuilder accountId(String str) {
        this.referenceId = null;
        this.accountId = str;
        return this;
    }

    public final Inquiry build() {
        return new Inquiry(this.templateId, this.templateVersion, (String) null, (String) null, this.referenceId, this.accountId, this.fields, this.theme, this.environment, this.enableErrorLogging, this.returnCollectedData, this.shouldAutoFallback, this.useServerStyles, this.staticInquiryTemplate);
    }

    public final InquiryTemplateBuilder enableErrorLogging(boolean z10) {
        this.enableErrorLogging = Boolean.valueOf(z10);
        return this;
    }

    public final InquiryTemplateBuilder environment(Environment environment2) {
        j.g(environment2, "environment");
        this.environment = environment2;
        return this;
    }

    public final InquiryTemplateBuilder fields(Fields fields2) {
        this.fields = fields2;
        return this;
    }

    public final InquiryTemplateBuilder fromTemplateId(String str) {
        j.g(str, "templateId");
        return new InquiryTemplateBuilder(str, (String) null, (StaticInquiryTemplate) null, 6, (DefaultConstructorMarker) null);
    }

    public final InquiryTemplateBuilder referenceId(String str) {
        this.accountId = null;
        this.referenceId = str;
        return this;
    }

    public final InquiryTemplateBuilder returnCollectedData(boolean z10) {
        this.returnCollectedData = Boolean.valueOf(z10);
        return this;
    }

    @ExperimentalFallbackMode
    public final InquiryTemplateBuilder shouldAutoFallback(boolean z10) {
        this.shouldAutoFallback = Boolean.valueOf(z10);
        return this;
    }

    public final InquiryTemplateBuilder theme(int i10) {
        this.theme = Integer.valueOf(i10);
        this.useServerStyles = Boolean.FALSE;
        return this;
    }

    public final InquiryTemplateBuilder theme(ThemeSource themeSource) {
        j.g(themeSource, "themeSource");
        this.theme = themeSource.getTheme();
        this.useServerStyles = Boolean.valueOf(themeSource instanceof ServerThemeSource);
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InquiryTemplateBuilder(String str, String str2, StaticInquiryTemplate staticInquiryTemplate2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : staticInquiryTemplate2);
    }
}
