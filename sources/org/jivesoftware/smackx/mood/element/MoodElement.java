package org.jivesoftware.smackx.mood.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.mood.Mood;

public class MoodElement implements ExtensionElement {
    public static final String ELEMENT = "mood";
    public static final String ELEM_TEXT = "text";
    public static final String NAMESPACE = "http://jabber.org/protocol/mood";
    public static final QName QNAME = new QName("http://jabber.org/protocol/mood", ELEMENT);
    private final MoodSubjectElement mood;
    private final String text;

    public static class MoodSubjectElement implements FullyQualifiedElement {
        private final MoodConcretisation concretisation;
        private final Mood mood;

        public MoodSubjectElement(Mood mood2, MoodConcretisation moodConcretisation) {
            this.mood = (Mood) Objects.requireNonNull(mood2);
            this.concretisation = moodConcretisation;
        }

        public MoodConcretisation getConcretisation() {
            return this.concretisation;
        }

        public String getElementName() {
            return this.mood.toString();
        }

        public Mood getMood() {
            return this.mood;
        }

        public String getNamespace() {
            return "http://jabber.org/protocol/mood";
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            if (this.concretisation == null) {
                return xmlStringBuilder.closeEmptyElement();
            }
            xmlStringBuilder.rightAngleBracket().append((Element) this.concretisation).closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public MoodElement(MoodSubjectElement moodSubjectElement, String str) {
        if (moodSubjectElement != null || str == null) {
            this.mood = moodSubjectElement;
            this.text = str;
            return;
        }
        throw new IllegalArgumentException("If <mood/> is null, text MUST be null too.");
    }

    public static MoodElement fromMessage(Message message) {
        return (MoodElement) message.getExtension(MoodElement.class);
    }

    public static boolean hasMoodElement(Message message) {
        return message.hasExtension(ELEMENT, "http://jabber.org/protocol/mood");
    }

    public String getElementName() {
        return ELEMENT;
    }

    public Mood getMood() {
        MoodSubjectElement moodSubjectElement = this.mood;
        if (moodSubjectElement != null) {
            return moodSubjectElement.getMood();
        }
        return null;
    }

    public MoodConcretisation getMoodConcretisation() {
        MoodSubjectElement moodSubjectElement = this.mood;
        if (moodSubjectElement != null) {
            return moodSubjectElement.getConcretisation();
        }
        return null;
    }

    public String getNamespace() {
        return "http://jabber.org/protocol/mood";
    }

    public String getText() {
        return this.text;
    }

    public boolean hasConcretisation() {
        return getMoodConcretisation() != null;
    }

    public boolean hasText() {
        return getText() != null;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        if (this.mood == null && this.text == null) {
            return xmlStringBuilder.closeEmptyElement();
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optAppend((Element) this.mood);
        if (this.text != null) {
            xmlStringBuilder.openElement("text").append((CharSequence) this.text).closeElement("text");
        }
        return xmlStringBuilder.closeElement(getElementName());
    }
}
