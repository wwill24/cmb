package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;

public abstract class AbstractChainedDescriptor<E> extends Descriptor<E> implements ChainedDescriptor<E> {
    private Descriptor<? super E> mSuper;

    public final void getAttributes(E e10, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(e10, attributeAccumulator);
        onGetAttributes(e10, attributeAccumulator);
    }

    public final void getChildren(E e10, Accumulator<Object> accumulator) {
        this.mSuper.getChildren(e10, accumulator);
        onGetChildren(e10, accumulator);
    }

    public void getComputedStyles(E e10, ComputedStyleAccumulator computedStyleAccumulator) {
        this.mSuper.getComputedStyles(e10, computedStyleAccumulator);
        onGetComputedStyles(e10, computedStyleAccumulator);
    }

    public final String getLocalName(E e10) {
        return onGetLocalName(e10);
    }

    public final String getNodeName(E e10) {
        return onGetNodeName(e10);
    }

    public final NodeType getNodeType(E e10) {
        return onGetNodeType(e10);
    }

    public final String getNodeValue(E e10) {
        return onGetNodeValue(e10);
    }

    public final void getStyleRuleNames(E e10, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        this.mSuper.getStyleRuleNames(e10, styleRuleNameAccumulator);
        onGetStyleRuleNames(e10, styleRuleNameAccumulator);
    }

    public final void getStyles(E e10, String str, StyleAccumulator styleAccumulator) {
        this.mSuper.getStyles(e10, str, styleAccumulator);
        onGetStyles(e10, str, styleAccumulator);
    }

    /* access modifiers changed from: package-private */
    public final Descriptor<? super E> getSuper() {
        return this.mSuper;
    }

    public final void hook(E e10) {
        verifyThreadAccess();
        this.mSuper.hook(e10);
        onHook(e10);
    }

    /* access modifiers changed from: protected */
    public void onGetAttributes(E e10, AttributeAccumulator attributeAccumulator) {
    }

    /* access modifiers changed from: protected */
    public void onGetChildren(E e10, Accumulator<Object> accumulator) {
    }

    /* access modifiers changed from: protected */
    public void onGetComputedStyles(E e10, ComputedStyleAccumulator computedStyleAccumulator) {
    }

    /* access modifiers changed from: protected */
    public String onGetLocalName(E e10) {
        return this.mSuper.getLocalName(e10);
    }

    /* access modifiers changed from: protected */
    public String onGetNodeName(E e10) {
        return this.mSuper.getNodeName(e10);
    }

    /* access modifiers changed from: protected */
    public NodeType onGetNodeType(E e10) {
        return this.mSuper.getNodeType(e10);
    }

    public String onGetNodeValue(E e10) {
        return this.mSuper.getNodeValue(e10);
    }

    /* access modifiers changed from: protected */
    public void onGetStyleRuleNames(E e10, StyleRuleNameAccumulator styleRuleNameAccumulator) {
    }

    /* access modifiers changed from: protected */
    public void onGetStyles(E e10, String str, StyleAccumulator styleAccumulator) {
    }

    /* access modifiers changed from: protected */
    public void onHook(E e10) {
    }

    /* access modifiers changed from: protected */
    public void onSetAttributesAsText(E e10, String str) {
        this.mSuper.setAttributesAsText(e10, str);
    }

    /* access modifiers changed from: protected */
    public void onSetStyle(E e10, String str, String str2, String str3) {
    }

    /* access modifiers changed from: protected */
    public void onUnhook(E e10) {
    }

    public final void setAttributesAsText(E e10, String str) {
        onSetAttributesAsText(e10, str);
    }

    public final void setStyle(E e10, String str, String str2, String str3) {
        this.mSuper.setStyle(e10, str, str2, str3);
        onSetStyle(e10, str, str2, str3);
    }

    public void setSuper(Descriptor<? super E> descriptor) {
        Util.throwIfNull(descriptor);
        Descriptor<? super E> descriptor2 = this.mSuper;
        if (descriptor == descriptor2) {
            return;
        }
        if (descriptor2 == null) {
            this.mSuper = descriptor;
            return;
        }
        throw new IllegalStateException();
    }

    public final void unhook(E e10) {
        verifyThreadAccess();
        onUnhook(e10);
        this.mSuper.unhook(e10);
    }
}
