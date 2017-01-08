package com.sdll18.rougenoir.be.dao;


/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-11-04
 */
public interface BaseSqlDao<E, K> {

    K save(E entity);

    E findById(K id);

    void update(E entity);

    void delete(E entity);

    void deleteById(K id);

}
