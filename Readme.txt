根据 springside4-4.2.2.GA 项目生成，下载地址
https://github.com/springside/springside4/releases/tag/v4.2.2.GA

将数据库调整为 postgresql数据库。

生成的新项目时需要修改的内容：
1. 修改generate-project.bat文件，将
   call mvn archetype:generate -DarchetypeGroupId=org.springside.examples
     -DarchetypeArtifactId=quickstart-archetype  -DarchetypeVersion=4.1.1-SNAPSHOT
         内容的版本调整为“4.2.2.GA”
   call mvn archetype:generate -DarchetypeGroupId=org.springside.examples
     -DarchetypeArtifactId=quickstart-archetype  -DarchetypeVersion=4.2.2.GA

2. 生成项目后，导入eclipse项目，修改pom.xml后，使用mvn install，部署相应jar依赖。
	<!-- 依赖项定义 -->
	<dependencies>
		。。。。
    	<!-- my add liuy add s-->
    	<!-- postgre数据库 -->
    	<dependency>
        	<groupId>postgresql</groupId>
        	<artifactId>postgresql</artifactId>
        	<version>9.1-901.jdbc4</version>
    	</dependency>
    	<!-- 运行过程会报缺少此jar包，需加入mvn依赖中-->
    	<dependency>
			<groupId>commons-codec</groupId>
				<artifactId>commons-codec</artifactId>
		<version>1.10</version>
		</dependency>
     	<!-- my add liuy add e-->
     	。。。。 	
	</dependencies>
   

3. 修改src/main/resources下的 application.properties 文件，输入
   #postgresql
   jdbc.driver=org.postgresql.Driver
   #注意数据库名后面不要有空格
   jdbc.url=jdbc:postgresql://localhost:5432/yourdatabase
   jdbc.username=postgres
   jdbc.password=*******
         并注掉H2的内容
         
 4.修改src/main/resources下的 applicationContext.xml  (其他修改可参见文件)
 	<!-- 1 -->
    <!-- Jpa Entity Manager 配置 -->
	<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"> 
		<property name="dataSource" ref="dataSource"/>
		<property name="jpaVendorAdapter" ref="hibernateJpaVendorAdapter"/>
		<property name="packagesToScan" value="com.fycoder"/>
		<property name="jpaProperties">
			<props>
				<!-- 命名规则 My_NAME->MyName -->
				<prop key="hibernate.ejb.naming_strategy">org.hibernate.cfg.ImprovedNamingStrategy</prop>
				<!-- ***liuy add***  控制数据库更新形势等-->
				<prop key="hibernate.hbm2ddl.auto">update</prop>
				<!-- ***liuy add***  下面需要加断言-->
				<prop key="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</prop>
				<!-- 
				<prop key="hibernate.hbm2ddl.auto">update</prop>
				<prop key="hibernate.hbm2ddl.auto">create</prop>
				 -->				 
			</props>         
		</property>
	</bean>
	
	<!-- 2 -->
	<bean id="hibernateJpaVendorAdapter" class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
		<property name="databasePlatform">
			<bean factory-method="getDialect" class="org.springside.modules.persistence.Hibernates">
				<constructor-arg ref="dataSource"/>
			</bean>
		</property>		
		<!-- ***liuy add***  显示sql语句 -->
		<property name="showSql" value="true" />       
	</bean>
	
5.AOP配置Ok
    a.调整 yste\src\main\webapp\WEB-INF\spring-mvc.xml （负责链接处）这个文件，加入
        xmlns:aop="http://www.springframework.org/schema/aop"
        ...
        http://www.springframework.org/schema/aop  http://www.springframework.org/schema/aop/spring-aop-4.0.xsd">
    	和 
        <!-- 使用注解配置切面 add-->
        <!-- <aop:aspectj-autoproxy /> -->
        <aop:aspectj-autoproxy proxy-target-class="true"/>
        
    b.调整 yste\src\main\resources\applicationContext.xml （负责后面的类mvc的m和c）文件，加入
       <!-- 使用注解配置切面  add-->
       <!-- <aop:aspectj-autoproxy /> -->
       <aop:aspectj-autoproxy proxy-target-class="true"/>
        

	         

