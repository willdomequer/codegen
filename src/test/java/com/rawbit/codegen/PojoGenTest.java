package com.rawbit.codegen;

import com.rawbit.codegen.db.TableInfo;
import com.rawbit.codegen.util.DBType;
import com.rawbit.codegen.util.DBUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PojoGenTest {

    public static void main(String[] args) throws Exception {

        Configuration config = new Configuration(Configuration.VERSION_2_3_28);
        config.setDefaultEncoding("utf-8");
        config.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX);
        config.setInterpolationSyntax(Configuration.SQUARE_BRACKET_INTERPOLATION_SYNTAX);

        // String tempath = PojoGenTest.class.getClassLoader().getResource("D:\\03.老鲍\\00.source\\00.willdomequer\\codegen\\").getPath();

        // System.out.println(tempath);

        config.setDirectoryForTemplateLoading(new File("D:\\03.老鲍\\00.source\\00.willdomequer\\codegen\\src\\main\\resources\\templates\\java"));
        Template template = config.getTemplate("pojo.ftl");

        List<TableInfo> tableInfoList = DBUtils.getTableInfo(DBType.MYSQL, "127.0.0.1", "3306", "test", Arrays.asList("tuser"), "root", "test");

        for (TableInfo table : tableInfoList) {

            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("package", "com.rawbit.test");
            dataMap.put("pojoName", table.getName());
            dataMap.put("fieldList", table.getFieldList());

            Writer out = new FileWriter(new File(table.getName() + ".java"));

            template.process(dataMap, out);
        }
    }
}
