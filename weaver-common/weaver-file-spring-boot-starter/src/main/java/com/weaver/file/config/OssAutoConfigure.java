package com.weaver.file.config;

import com.weaver.file.properties.FileServerProperties;
import com.weaver.file.template.FdfsTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * @author zlt
 * @date 2021/2/13
 * <p>
 * Blog: http://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
@EnableConfigurationProperties(FileServerProperties.class)
@Import({FdfsTemplate.class})
public class OssAutoConfigure {

}
