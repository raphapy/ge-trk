package com.guaraniexpress.tracking.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManager;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.hibernate.HibernateMetadataUtil;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import com.guaraniexpress.tracking.i18n.Messages;

public abstract class AbstractDao<T, ID extends Serializable> implements GenericDao<T, ID>{
	
    public AbstractDao() {
    }
    
    protected abstract EntityManager getEntityManager();
    
    protected abstract Class<T> getEntityBeanType();

    private EntityManager getEm() {
        if (getEntityManager() == null) {
            throw new IllegalStateException(Messages.getString("AbstractDao.NO_ENTITY_MANAGER_MESSAGE"));
        }
        return getEntityManager();
    }

    private SessionFactory getSessionFactory() {
        if (this.getEm().getDelegate() instanceof HibernateEntityManager) {
            return ((HibernateEntityManager) this.getEm().getDelegate()).getSession().getSessionFactory();
        } else {
            return ((Session) this.getEm().getDelegate()).getSessionFactory();
        }
    }

    @Override
    public T get(ID id) {
        return (T) getEm().find(getEntityBeanType(), id);
    }

    @Override
    public T getLocked(ID id) {
        T t = (T) getEm().getReference(getEntityBeanType(), id);
        getEm().lock(t, LockModeType.WRITE);
        return t;
    }

    @Override
    public T get(T example) {
        List<T> list = this.list(example, 0, 2);

        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        }

        throw new NonUniqueResultException(Messages.getString("AbstractDao.NON_UNIQUE_MESSAGE", this.getEntityBeanType().getCanonicalName()));
    }
    
    @Override
    public T getLocked(T example) {
        List<T> list = this.list(example, 0, 2);

        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            T t = list.get(0);
            // BLOQUEAR REGISTRO
            getEm().lock(t, LockModeType.WRITE);
            return t;
        }

        throw new NonUniqueResultException(Messages.getString("AbstractDao.NON_UNIQUE_MESSAGE", this.getEntityBeanType().getCanonicalName()));
    }

    @Override
    public Map<String, Object> getAttributes(T example, String[] attributes) {
        List<Map<String, Object>> lista = this.listAttributes(example, attributes, 0, 2);

        if (lista.isEmpty()) {
            return null;
        }

        if (lista.size() == 1) {
            return lista.get(0);
        }

        throw new NonUniqueResultException(Messages.getString("AbstractDao.NON_UNIQUE_MESSAGE", this.getEntityBeanType().getCanonicalName()));
    }

    @Override
    public T save(T entity) throws Exception {
        this.getEm().persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) throws Exception {
        this.getEm().merge(entity);
        return entity;
    }

    @Override
    public void delete(ID id) throws Exception {
        T entity = this.get(id);
        this.delete(entity);
    }

    @Override
    public void delete(T entity) throws Exception {
        this.getEm().remove(entity);
    }

    @Override
    public Integer count(String[] orderBy, String[] dir) {
    	return this.count(null, false, null, null, orderBy, dir, false);
    }
    
    @Override
    public Integer count(Integer firstResult, Integer cantResultado, String[] orderBy, String[] dir) {
    	return this.count(null,false,firstResult,cantResultado,orderBy,dir,false);
    }
    
    @Override
    public Integer count() {
        return this.count(null, true, null, null, null, null, false);
    }

    @Override
    public Integer count(Integer firstResult, Integer cantResultado) {
        return this.count(null, false, firstResult, cantResultado, null, null, false);
    }

    @Override
    public Integer count(T example) {
        return this.count(example, true, null, null, null, null, false);
    }

    @Override
    public Integer count(T example, boolean like) {
        return this.count(example, true, null, null, null, null, like);
    }

    @Override
    public Integer count(T example, String orderByAttrList, String orderByDirList) {
        return this.count(example, true, null, null, new String[]{orderByAttrList}, new String[]{orderByDirList}, false);
    }

    @Override
    public Integer count(T example, String orderByAttrList, String orderByDirList, boolean like) {
        return this.count(example, true, null, null, new String[]{orderByAttrList}, new String[]{orderByDirList}, like);
    }

    @Override
    public Integer count(T example, String[] orderByAttrList, String[] orderByDirList) {
        return this.count(example, true, null, null, orderByAttrList, orderByDirList, false);
    }

    @Override
    public Integer count(T example, String[] orderByAttrList, String[] orderByDirList, boolean like) {
        return this.count(example, true, null, null, orderByAttrList, orderByDirList, like);
    }

    @Override
    public Integer count(T example, Integer firstResult, Integer numberOfResult) {
        return this.count(example, false, firstResult, numberOfResult, null, null, false);
    }

    @Override
    public Integer count(T example, Integer firstResult, Integer numberOfResult, boolean like) {
        return this.count(example, false, firstResult, numberOfResult, null, null, like);
    }

    @Override
    public Integer count(T example, Integer firstResult, Integer numberOfResult, String orderByAttrList, String orderByDirList) {
        return this.count(example, false, firstResult, numberOfResult, new String[]{orderByAttrList}, new String[]{orderByDirList}, false);
    }

    @Override
    public Integer count(T example, Integer firstResult, Integer numberOfResult, String orderByAttrList, String orderByDirList, boolean like) {
        return this.count(example, false, firstResult, numberOfResult, new String[]{orderByAttrList}, new String[]{orderByDirList}, like);
    }

    @Override
    public Integer count(T example, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList) {
        return this.count(example, false, firstResult, numberOfResult, orderByAttrList, orderByDirList, false);
    }

    @Override
    public Integer count(T example, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList, boolean like) {
        return this.count(example, false, firstResult, numberOfResult, orderByAttrList, orderByDirList, like);
    }

    @Override
    public Integer count(T example, boolean all, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList, boolean like) {
        JPASearchProcessor jpaSP = new JPASearchProcessor(HibernateMetadataUtil.getInstanceForSessionFactory(this.getSessionFactory()));
        Search searchConfig = this.getSearchConfig(jpaSP, example, null, true, null, null, null, null, like);
        return jpaSP.count(getEm(), searchConfig);
    }
    
    @Override
    public List<T> list(String[] orderBy, String[] dir) {
    	return this.list(null, false, null, null, orderBy, dir, false);
    }
    
    @Override
    public List<T> list(Integer firstResult, Integer cantResultado, String[] orderBy, String[] dir) {
    	return this.list(null,false,firstResult,cantResultado,orderBy,dir,false);
    }
    
    @Override
    public List<T> list() {
        return this.list(null, true, null, null, null, null, false);
    }

    @Override
    public List<T> list(Integer firstResult, Integer cantResultado) {
        return this.list(null, false, firstResult, cantResultado, null, null, false);
    }

    @Override
    public List<T> list(T example) {
        return this.list(example, true, null, null, null, null, false);
    }

    @Override
    public List<T> list(T example, boolean like) {
        return this.list(example, true, null, null, null, null, like);
    }

    @Override
    public List<T> list(T example, String orderByAttrList, String orderByDirList) {
        return this.list(example, true, null, null, new String[]{orderByAttrList}, new String[]{orderByDirList}, false);
    }

    @Override
    public List<T> list(T example, String orderByAttrList, String orderByDirList, boolean like) {
        return this.list(example, true, null, null, new String[]{orderByAttrList}, new String[]{orderByDirList}, like);
    }

    @Override
    public List<T> list(T example, String[] orderByAttrList, String[] orderByDirList) {
        return this.list(example, true, null, null, orderByAttrList, orderByDirList, false);
    }

    @Override
    public List<T> list(T example, String[] orderByAttrList, String[] orderByDirList, boolean like) {
        return this.list(example, true, null, null, orderByAttrList, orderByDirList, like);
    }

    @Override
    public List<T> list(T example, Integer firstResult, Integer numberOfResult) {
        return this.list(example, false, firstResult, numberOfResult, null, null, false);
    }

    @Override
    public List<T> list(T example, Integer firstResult, Integer numberOfResult, boolean like) {
        return this.list(example, false, firstResult, numberOfResult, null, null, like);
    }

    @Override
    public List<T> list(T example, Integer firstResult, Integer numberOfResult, String orderByAttrList, String orderByDirList) {
        return this.list(example, false, firstResult, numberOfResult, new String[]{orderByAttrList}, new String[]{orderByDirList}, false);
    }

    @Override
    public List<T> list(T example, Integer firstResult, Integer numberOfResult, String orderByAttrList, String orderByDirList, boolean like) {
        return this.list(example, false, firstResult, numberOfResult, new String[]{orderByAttrList}, new String[]{orderByDirList}, like);
    }

    @Override
    public List<T> list(T example, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList) {
        return this.list(example, false, firstResult, numberOfResult, orderByAttrList, orderByDirList, false);
    }

    @Override
    public List<T> list(T example, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList, boolean like) {
        return this.list(example, false, firstResult, numberOfResult, orderByAttrList, orderByDirList, like);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<T> list(T example, boolean all, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList, boolean like) {
        JPASearchProcessor jpaSP = new JPASearchProcessor(HibernateMetadataUtil.getInstanceForSessionFactory(this.getSessionFactory()));
        Search searchConfig = this.getSearchConfig(jpaSP, example, null, all, firstResult, numberOfResult, orderByAttrList, orderByDirList, like);
        return jpaSP.search(getEm(), searchConfig);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes) {
        return this.listAttributes(example, attributes,
                true, null, null,
                null, null, false);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, boolean like) {
        return this.listAttributes(example, attributes, true, null, null, null, null, like);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult) {
        return this.listAttributes(example, attributes, false, firstResult, numberOfResult, null, null, false);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, boolean like) {
        return this.listAttributes(example, attributes, false, firstResult, numberOfResult, null, null, like);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, String orderByAttrList, String orderByDirList) {
        return this.listAttributes(example, attributes, true, null, null, new String[]{orderByAttrList}, new String[]{orderByDirList}, false);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, String orderByAttrList, String orderByDirList, boolean like) {
        return this.listAttributes(example, attributes, true, null, null, new String[]{orderByAttrList}, new String[]{orderByDirList}, like);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, String[] orderByAttrList, String[] orderByDirList) {
        return this.listAttributes(example, attributes, true, null, null, orderByAttrList, orderByDirList, false);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, String[] orderByAttrList, String[] orderByDirList, boolean like) {
        return this.listAttributes(example, attributes, true, null, null, orderByAttrList, orderByDirList, like);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, String orderByAttrList, String orderByDirList) {
        return this.listAttributes(example, attributes, false, firstResult, numberOfResult, new String[]{orderByAttrList}, new String[]{orderByDirList}, false);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, String orderByAttrList, String orderByDirList, boolean like) {
        return this.listAttributes(example, attributes, false, firstResult, numberOfResult, new String[]{orderByAttrList}, new String[]{orderByDirList}, like);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList) {
        return this.listAttributes(example, attributes, false, firstResult, numberOfResult, orderByAttrList, orderByDirList, false);
    }

    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList, boolean like) {
        return this.listAttributes(example, attributes, false, firstResult, numberOfResult, orderByAttrList, orderByDirList, like);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> listAttributes(T example, String[] attributes, boolean all, Integer firstResult, Integer numberOfResult, String[] orderByAttrList, String[] orderByDirList, boolean like) {
        if (attributes == null || attributes.length == 0) {
            throw new RuntimeException(Messages.getString("AbstractDao.REQUIRED_ATTRIBUTES_LIST_MESSAGE"));
        }

        JPASearchProcessor jpaSP = new JPASearchProcessor(HibernateMetadataUtil.getInstanceForSessionFactory(this.getSessionFactory()));
        Search searchConfig = this.getSearchConfig(jpaSP, example, attributes, all, firstResult, numberOfResult, orderByAttrList, orderByDirList, like);
        return jpaSP.search(getEm(), searchConfig);
    }

    private Search getSearchConfig(JPASearchProcessor jpaSP, T example, String[] attributes, boolean all, Integer firstResult, Integer numberOfResult,
            String[] orderByAttrList, String[] orderByDirList, boolean like) {


        Search searchConfig = new Search(this.getEntityBeanType());

        if (example != null) {
            ExampleOptions exampleOptions = new ExampleOptions();
            exampleOptions.setExcludeNulls(true);

            if (like) {
                exampleOptions.setIgnoreCase(true);
                exampleOptions.setLikeMode(ExampleOptions.ANYWHERE);
            }

            searchConfig.addFilter(jpaSP.getFilterFromExample(example, exampleOptions));
        }

        if (!all) {
            searchConfig.setFirstResult(firstResult);
            searchConfig.setMaxResults(numberOfResult);
        }

        if (orderByAttrList != null && orderByDirList != null && orderByAttrList.length == orderByDirList.length) {
            for (int i = 0; i < orderByAttrList.length; i++) {
                if (orderByDirList[i].equalsIgnoreCase("desc")) {
                    searchConfig.addSortDesc(orderByAttrList[i]);
                } else {
                    searchConfig.addSortAsc(orderByAttrList[i]);
                }
            }
        } else if ((orderByAttrList != null && orderByDirList == null) || (orderByAttrList == null && orderByDirList != null)) {
            throw new RuntimeException(Messages.getString("AbstractDao.REQUIRED_ORDER_LIST_ORDER_DIR_MESSAGE"));
        } else if (orderByAttrList != null && orderByDirList != null && orderByAttrList.length != orderByDirList.length) {
            throw new RuntimeException(Messages.getString("AbstractDao.ORDER_LIST_ORDER_DIR_LENGHT_NO_MATCH_MESSAGE")); 
        }


        if (attributes != null && attributes.length > 0) {
            for (String a : attributes) {
                searchConfig.addField(a);
            }
            searchConfig.setResultMode(Search.RESULT_MAP);
        }

        return searchConfig;
    }
    
}
