package org.apache.commons.digester;

public interface StackAction {
    Object onPop(Digester digester, String str, Object obj);

    Object onPush(Digester digester, String str, Object obj);
}
