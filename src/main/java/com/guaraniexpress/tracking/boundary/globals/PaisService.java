/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.boundary.globals;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entities.globals.Pais;
import javax.ejb.Stateless;

/**
 *
 * @author raphapy
 */
@Stateless
public class PaisService extends GuaraniExpressDao<Pais, Short>{

    @Override
    protected Class<Pais> getEntityBeanType() {
        return Pais.class;
    }
    
}
