package net.bytebuddy.description.field;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;

public interface FieldList<T extends FieldDescription> extends FilterableList<T, FieldList<T>> {

    public static abstract class AbstractBase<S extends FieldDescription> extends FilterableList.AbstractBase<S, FieldList<S>> implements FieldList<S> {
        public FieldList<FieldDescription.InDefinedShape> asDefined() {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((FieldDescription) it.next()).asDefined());
            }
            return new Explicit(arrayList);
        }

        public ByteCodeElement.Token.TokenList<FieldDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((FieldDescription) it.next()).asToken(elementMatcher));
            }
            return new ByteCodeElement.Token.TokenList<>(arrayList);
        }

        /* access modifiers changed from: protected */
        public FieldList<S> wrap(List<S> list) {
            return new Explicit(list);
        }
    }

    public static class Empty<S extends FieldDescription> extends FilterableList.Empty<S, FieldList<S>> implements FieldList<S> {
        public FieldList<FieldDescription.InDefinedShape> asDefined() {
            return this;
        }

        public ByteCodeElement.Token.TokenList<FieldDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
            return new ByteCodeElement.Token.TokenList<>((S[]) new FieldDescription.Token[0]);
        }
    }

    public static class Explicit<S extends FieldDescription> extends AbstractBase<S> {
        private final List<? extends S> fieldDescriptions;

        public Explicit(S... sArr) {
            this(Arrays.asList(sArr));
        }

        public int size() {
            return this.fieldDescriptions.size();
        }

        public Explicit(List<? extends S> list) {
            this.fieldDescriptions = list;
        }

        public S get(int i10) {
            return (FieldDescription) this.fieldDescriptions.get(i10);
        }
    }

    public static class ForLoadedFields extends AbstractBase<FieldDescription.InDefinedShape> {
        private final List<? extends Field> fields;

        public ForLoadedFields(Field... fieldArr) {
            this((List<? extends Field>) Arrays.asList(fieldArr));
        }

        public int size() {
            return this.fields.size();
        }

        public ForLoadedFields(List<? extends Field> list) {
            this.fields = list;
        }

        public FieldDescription.InDefinedShape get(int i10) {
            return new FieldDescription.ForLoadedField((Field) this.fields.get(i10));
        }
    }

    public static class ForTokens extends AbstractBase<FieldDescription.InDefinedShape> {
        private final TypeDescription declaringType;
        private final List<? extends FieldDescription.Token> tokens;

        public ForTokens(TypeDescription typeDescription, FieldDescription.Token... tokenArr) {
            this(typeDescription, (List<? extends FieldDescription.Token>) Arrays.asList(tokenArr));
        }

        public int size() {
            return this.tokens.size();
        }

        public ForTokens(TypeDescription typeDescription, List<? extends FieldDescription.Token> list) {
            this.declaringType = typeDescription;
            this.tokens = list;
        }

        public FieldDescription.InDefinedShape get(int i10) {
            return new FieldDescription.Latent(this.declaringType, (FieldDescription.Token) this.tokens.get(i10));
        }
    }

    public static class TypeSubstituting extends AbstractBase<FieldDescription.InGenericShape> {
        private final TypeDescription.Generic declaringType;
        private final List<? extends FieldDescription> fieldDescriptions;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic generic, List<? extends FieldDescription> list, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
            this.declaringType = generic;
            this.fieldDescriptions = list;
            this.visitor = visitor2;
        }

        public int size() {
            return this.fieldDescriptions.size();
        }

        public FieldDescription.InGenericShape get(int i10) {
            return new FieldDescription.TypeSubstituting(this.declaringType, (FieldDescription) this.fieldDescriptions.get(i10), this.visitor);
        }
    }

    FieldList<FieldDescription.InDefinedShape> asDefined();

    ByteCodeElement.Token.TokenList<FieldDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher);
}
