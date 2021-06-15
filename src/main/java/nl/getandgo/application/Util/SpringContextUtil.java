package nl.getandgo.application.Util;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Get spring Bean Object Util
 */
@Component
public class SpringContextUtil  implements ApplicationContextAware {
    /**
     *  Spring Context
     */
    private static ApplicationContext applicationContext;

    /**
     * Set ApplicationContextAware callback method
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    /**
     * get Object Bean
     */
    public static Object getBean(String beanId) throws BeansException {
        return applicationContext.getBean(beanId);
    }
}
