package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ParameterCategory {
        private String code;
        private String name;
        public ParameterCategory(String code, String name) {
            checkCodeRules(code);
            checkNameRules(name);
            this.code = code;
            this.name = name;
        }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        checkCodeRules(code);
            this.code = code;
    }

    public void setName(String name) {
            checkNameRules(name);
            this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkCodeRules(String code) {

            if (StringUtils.isBlank(code))
                throw new IllegalArgumentException("Code cannot be blank.");
            if ( code.length() != 5)
                throw new IllegalArgumentException("Code must have 5 chars.");
        }


        private void checkNameRules(String name){

            if (StringUtils.isBlank(name))
                throw new IllegalArgumentException("Name cannot be blank.");
            if ( name.length() >10)
                throw new IllegalArgumentException("Name must have less than 10 chars.");
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterCategory that = (ParameterCategory) o;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @Override
    public String toString() {
        return "ParameterCategory{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
