1、添加maven 文件
    <!--shiro 必备包-->
        <!-- https://mvnrepository.com/artifact/org.apache.shiro/shiro-all -->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-all</artifactId>
            <version>${shiro-version}</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.apache.shiro/shiro-core -->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-core</artifactId>
            <version>${shiro-version}</version>
            <exclusions>
                <exclusion>
                    <artifactId>slf4j-api</artifactId>
                    <groupId>org.slf4j</groupId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.apache.shiro/shiro-ehcache -->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-ehcache</artifactId>
            <version>${shiro-version}</version>
            <exclusions>
                <exclusion>
                    <artifactId>ehcache-core</artifactId>
                    <groupId>net.sf.ehcache</groupId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.apache.shiro/shiro-web -->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-web</artifactId>
            <version>${shiro-version}</version>
        </dependency>
2、servlet