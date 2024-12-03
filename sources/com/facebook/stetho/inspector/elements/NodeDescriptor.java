package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ThreadBound;

public interface NodeDescriptor<E> extends ThreadBound {
    void getAttributes(E e10, AttributeAccumulator attributeAccumulator);

    void getChildren(E e10, Accumulator<Object> accumulator);

    void getComputedStyles(E e10, ComputedStyleAccumulator computedStyleAccumulator);

    String getLocalName(E e10);

    String getNodeName(E e10);

    NodeType getNodeType(E e10);

    String getNodeValue(E e10);

    void getStyleRuleNames(E e10, StyleRuleNameAccumulator styleRuleNameAccumulator);

    void getStyles(E e10, String str, StyleAccumulator styleAccumulator);

    void hook(E e10);

    void setAttributesAsText(E e10, String str);

    void setStyle(E e10, String str, String str2, String str3);

    void unhook(E e10);
}
