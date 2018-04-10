package oiasso.systems.spring4mavenbaseweb.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import oiasso.systems.spring4mavenbasecorelib.config.Spring4MavenBaseCoreLIBConfig;


public class Spring4MavenBaseWebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { Spring4MavenBaseWebConfig.class, Spring4MavenBaseCoreLIBConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { Spring4MavenBaseWebMvc.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}
