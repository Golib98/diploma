package kz.greetgo.diploma.register.dao;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;
import kz.greetgo.diploma.register.beans.all.DaoImplFactory;

@BeanScanner
@BeanConfig(factory = DaoImplFactory.class)
public class BeanConfigPostgresDao {
}
