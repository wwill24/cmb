package org.jivesoftware.smack.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.Objects;

public interface MessageView extends StanzaView {
    Set<Message.Body> getBodies() {
        List<ExtensionElement> extensions = getExtensions(Message.Body.QNAME);
        HashSet hashSet = new HashSet(extensions.size());
        Iterator<ExtensionElement> it = extensions.iterator();
        while (it.hasNext()) {
            hashSet.add((Message.Body) it.next());
        }
        return hashSet;
    }

    String getBody() {
        return getBody(getLanguage());
    }

    List<String> getBodyLanguages() {
        Message.Body messageBody = getMessageBody((String) null);
        ArrayList arrayList = new ArrayList();
        for (Message.Body next : getBodies()) {
            if (!next.equals(messageBody)) {
                arrayList.add(next.getLanguage());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    Message.Body getMessageBody(String str) {
        String determineLanguage = Stanza.determineLanguage(this, str);
        for (Message.Body next : getBodies()) {
            if (Objects.equals(determineLanguage, next.getLanguage()) || (determineLanguage != null && determineLanguage.equals(getLanguage()) && next.getLanguage() == null)) {
                return next;
            }
        }
        return null;
    }

    Message.Subject getMessageSubject(String str) {
        String determineLanguage = Stanza.determineLanguage(this, str);
        for (Message.Subject next : getSubjects()) {
            if (Objects.equals(determineLanguage, next.getLanguage()) || (next.getLanguage() == null && Objects.equals(getLanguage(), determineLanguage))) {
                return next;
            }
        }
        return null;
    }

    String getSubject() {
        return getSubject((String) null);
    }

    List<String> getSubjectLanguages() {
        Message.Subject messageSubject = getMessageSubject((String) null);
        ArrayList arrayList = new ArrayList();
        for (E e10 : getExtensions(Message.Subject.class)) {
            if (!e10.equals(messageSubject)) {
                arrayList.add(e10.getLanguage());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    Set<Message.Subject> getSubjects() {
        List<E> extensions = getExtensions(Message.Subject.class);
        HashSet hashSet = new HashSet(extensions.size());
        hashSet.addAll(extensions);
        return hashSet;
    }

    String getThread() {
        Message.Thread thread = (Message.Thread) getExtension(Message.Thread.class);
        if (thread == null) {
            return null;
        }
        return thread.getThread();
    }

    Message.Type getType();

    String getBody(String str) {
        Message.Body messageBody = getMessageBody(str);
        if (messageBody == null) {
            return null;
        }
        return messageBody.getMessage();
    }

    String getSubject(String str) {
        Message.Subject messageSubject = getMessageSubject(str);
        if (messageSubject == null) {
            return null;
        }
        return messageSubject.getSubject();
    }
}
