package com.sport.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

/**
 * @author macos
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:application-test.properties", ignoreResourceNotFound = true)
public class DruidDataSourceConfiguration {
    @Value("${jdbc.datasource.driver}")
    private String driver;
    @Value("${jdbc.datasource.url}")
    private String url;
    @Value("${jdbc.datasource.username}")
    private String username;
    @Value("${jdbc.datasource.password}")
    private String password;
    @Value("${jdbc.datasource.initialSize}")
    private int initialSize;
    @Value("${jdbc.datasource.minIdle}")
    private int minIdle;
    @Value("${jdbc.datasource.maxActive}")
    private int maxActive;
    @Value("${jdbc.datasource.maxWait}")
    private int maxWait;
    @Value("${jdbc.datasource.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${jdbc.datasource.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${jdbc.datasource.validationQuery}")
    private String validationQuery;
    @Value("${jdbc.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${jdbc.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${jdbc.datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${jdbc.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${jdbc.datasource.filters}")
    private String filters;
    @Value("${jdbc.datasource.connectionProperties}")
    private String connectionProperties;

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setFilters(filters);
        druidDataSource.setConnectionProperties(connectionProperties);
        return druidDataSource;
    }

    @Value("${stat.servlet}")
    private String statServlet;
    @Value("${stat.allow}")
    private String statAllow;
    @Value("${stat.deny}")
    private String statDeny;
    @Value("${stat.loginUsername}")
    private String statLoginUsername;
    @Value("${stat.loginPassword}")
    private String statLoginPassword;
    @Value("${stat.resetEnable}")
    private String statResetEnable;
    @Value("${stat.urlPatterns}")
    private String statUrlPatterns;
    @Value("${stat.exclusions}")
    private String statExclusions;

    /**
     * 注册一个 StatViewServlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        //org.springframework.boot.context.embedded.ServletRegistrationBean 提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), statServlet);
        //添加初始化参数：initParams
        //白名单：
        servletRegistrationBean.addInitParameter("allow", statAllow);
        //IP 黑名单 (存在共同时，deny 优先于 allow) : 如果满足 deny 的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", statDeny);
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", statLoginUsername);
        servletRegistrationBean.addInitParameter("loginPassword", statLoginPassword);
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", statResetEnable);
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns(statUrlPatterns);

        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", statExclusions);
        return filterRegistrationBean;
    }


    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        DruidStatInterceptor dsInterceptor = new DruidStatInterceptor();
        return dsInterceptor;
    }

    @Bean
    @Scope("prototype")
    public JdkRegexpMethodPointcut druidStatPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        System.out.println("---------------------");
        pointcut.setPattern("com.sport.service.*");
        return pointcut;
    }

    @Bean
    public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut druidStatPointcut) {
        DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
        defaultPointAdvisor.setPointcut(druidStatPointcut);
        defaultPointAdvisor.setAdvice(druidStatInterceptor);
        return defaultPointAdvisor;
    }

    public static void main(String[] args) {
        try {
            com.alibaba.druid.filter.config.ConfigTools.main(new String[]{"123456"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
