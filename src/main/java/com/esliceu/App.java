package com.esliceu;

import com.esliceu.config.AppConfig;
import com.esliceu.config.HibernateConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Code created by: mmonteirocl
 * Email: miguelmonteiroclaveri@gmail.com
 * Date: 27/01/2020
 * Package: com.esliceu
 * Project: MonteiroClaveriMiguel-Practica-tema3
 */

public class App extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
     * Toda la configuracion de clases raiz (como hibernate)
     * */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

