package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class Parameter {
    private String code;
    private String name;
    private String desc;
    private ParameterCategory parameterCategory;
    public Parameter(){
        this.code=null;
        this.desc=null;
        this.name=null;
    }
    public Parameter(String code, String name, String desc, ParameterCategory parameterCategory){
        checkParameterNameRules(name);
        checkParameterCodeRules(code);
        checkDescriptionRules(desc);
        this.code=code;
        this.name=name;
        this.desc=desc;
        this.setParameterCategory(parameterCategory);
    }


    public ParameterCategory getParameterCategory() {
        return parameterCategory;
    }

    public void setParameterCategory(ParameterCategory parameterCategory) {
        this.parameterCategory = parameterCategory;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        checkParameterCodeRules(code);
        this.code = code;
    }

    public void setDesc(String desc) {
        checkDescriptionRules(desc);
        this.desc = desc;
    }

    public void setName(String name) {
        checkParameterNameRules(name);
        this.name = name;
    }

    private void checkParameterCodeRules(String code) {
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ( code.length() !=5)
            throw new IllegalArgumentException("Code must have 5 chars.");
    }

    private void checkParameterNameRules(String name){
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if ( name.length() >8)
            throw new IllegalArgumentException("Name must have less than 8 chars.");
    }
    private void checkDescriptionRules(String description){
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Name cannot be blank.");
        if ( description.length() >20)
            throw new IllegalArgumentException("Name must have less than 20 chars.");
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", category code='" + parameterCategory.getCode() +'\'' +
                ", category name='" + parameterCategory.getName() +'\'' +
                '}';
    }
}
