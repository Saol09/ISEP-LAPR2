package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class TypeOfTest {

    private String code;
    private String description;
    private String collectingMethods;
    private ParameterCategory parameterCategory;

    public TypeOfTest(){
        this.code=null;
        this.description=null;
        this.collectingMethods=null;
    }

    public TypeOfTest(String code, String description, String collectingMethods){
        this.code=code;
        this.description=description;
        this.collectingMethods=collectingMethods;
    }

    public TypeOfTest(String code, String description, String collectingMethods, ParameterCategory parameterCategory){
        this.code=code;
        this.description=description;
        this.collectingMethods=collectingMethods;
        this.parameterCategory=parameterCategory;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getCollectingMethods() {
        return collectingMethods;
    }

    public ParameterCategory getParameterCategory() {
        return parameterCategory;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCollectingMethods(String collectingMethods) {
        this.collectingMethods = collectingMethods;
    }

    public void setParameterCategory(ParameterCategory parameterCategory) {
        this.parameterCategory = parameterCategory;
    }

    @Override
    public String toString() {
        return "TypeOfTest{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", collectingMethods='" + collectingMethods + '\'' +
                '}';
    }
}
