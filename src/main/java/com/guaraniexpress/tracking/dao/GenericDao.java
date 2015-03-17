package com.guaraniexpress.tracking.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<T, ID extends Serializable> {

    public T get(ID id);

    public T getLocked(ID id);

    public T get(T example);
    
    public T getLocked(T example);

    public Map<String, Object> getAttributes(T example, String[] attributes);

    public void save(T entity) throws Exception;

    public void update(T entity) throws Exception;

    public void delete(ID id) throws Exception;

    public void delete(T entity) throws Exception;

    public Integer count();

    public Integer count(Integer firstResult, Integer cantResultado);

    public Integer count(String[] orderBy, String[] dir);
    
    public Integer count(Integer firstResult, Integer cantResultado, String[] orderBy, String[] dir);
    
    public Integer count(T example);

    public Integer count(T example, boolean like);

    public Integer count(T example, String orderBy, String dir);

    public Integer count(T example, String orderBy, String dir, boolean like);

    public Integer count(T example, String[] orderBy, String[] dir);

    public Integer count(T example, String[] orderBy, String[] dir, boolean like);

    public Integer count(T example, Integer firstResult, Integer numberOfResult);

    public Integer count(T example, Integer firstResult, Integer numberOfResult, boolean like);

    public Integer count(T example, Integer firstResult, Integer numberOfResult, String orderBy, String dir);

    public Integer count(T example, Integer firstResult, Integer numberOfResult, String orderBy, String dir, boolean like);

    public Integer count(T example, Integer firstResult, Integer numberOfResult, String[] orderBy, String[] dir);

    public Integer count(T example, Integer firstResult, Integer numberOfResult, String[] orderBy, String[] dir, boolean like);

    public Integer count(T example, boolean all, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList, boolean like);

    public List<T> list();

    public List<T> list(Integer firstResult, Integer cantResultado);

    public List<T> list(String[] orderBy, String[] dir);
    
    public List<T> list(Integer firstResult, Integer cantResultado, String[] orderBy, String[] dir);
    
    public List<T> list(T example);

    public List<T> list(T example, boolean like);

    public List<T> list(T example, String orderBy, String dir);

    public List<T> list(T example, String orderBy, String dir, boolean like);

    public List<T> list(T example, String[] orderBy, String[] dir);

    public List<T> list(T example, String[] orderBy, String[] dir, boolean like);

    public List<T> list(T example, Integer firstResult, Integer numberOfResult);

    public List<T> list(T example, Integer firstResult, Integer numberOfResult, boolean like);

    public List<T> list(T example, Integer firstResult, Integer numberOfResult, String orderBy, String dir);

    public List<T> list(T example, Integer firstResult, Integer numberOfResult, String orderBy, String dir, boolean like);

    public List<T> list(T example, Integer firstResult, Integer numberOfResult, String[] orderBy, String[] dir);

    public List<T> list(T example, Integer firstResult, Integer numberOfResult, String[] orderBy, String[] dir, boolean like);

    public List<T> list(T example, boolean all, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList, boolean like);
    
    public List<Map<String, Object>> listAttributes(T example, String[] attributes);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, boolean like);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, boolean like);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, String orderBy, String dir);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, String orderBy, String dir, boolean like);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, String[] orderBy, String[] dir);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, String[] orderBy, String[] dir, boolean like);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, String orderBy, String dir);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, String orderBy, String dir, boolean like);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, String[] orderBy, String[] dir);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, String[] orderBy, String[] dir, boolean like);

    public List<Map<String, Object>> listAttributes(T example, String[] attributes, boolean all, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList, boolean like);

}
