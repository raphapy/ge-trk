/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.web.resources.globals;

import com.guaraniexpress.tracking.boundary.globals.LocalidadService;
import com.guaraniexpress.tracking.entities.globals.Localidad;
import com.guaraniexpress.tracking.web.ReadableResource;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author raphapy
 */
@Path("paises/localidades")
public class LocalidadResource extends ReadableResource<Localidad, Short, LocalidadService>{

    @Inject
    private LocalidadService localidadService;
    
    @Override
    protected LocalidadService getDelegatedDao() {
        return this.localidadService;
    }

    @Override
    protected Class<Localidad> getEntityBeanType() {
        return Localidad.class;
    }

    @Override
    protected Class<Short> getEntityKeyType() {
        return Short.class;
    }
}
