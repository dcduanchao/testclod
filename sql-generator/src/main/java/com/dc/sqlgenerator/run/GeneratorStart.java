package com.dc.sqlgenerator.run;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duanchao
 * @CreateDate: 2019/9/10 0010 18:38
 */
public class GeneratorStart {

    public static void main(String[] args) throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //获取类加载器
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        //类加载器在classpach：下获取配置文件
        InputStream is = classloader.getResourceAsStream("generator-config.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

        myBatisGenerator.generate(null);
        System.out.println("结束");

    }
}
