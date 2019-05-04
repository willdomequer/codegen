package [=package]

public class [=pojoName] {

[#list fieldList as field]
    //[#if field.comment ??] [=field.comment] [/#if]
    private [=field.dataType] [=field.name]
[/#list]


[#list fieldList as field]
    public [=field.dataType] get[=field.name ? cap_first]() {
        return [=field.name]
    }

    public void set[=field.name ? cap_first]([=field.dataType] [=field.name]) {
        this.[=field.name] = [=field.name];
    }

[/#list]
}