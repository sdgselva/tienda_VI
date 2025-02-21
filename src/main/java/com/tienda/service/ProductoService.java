package com.tienda.service;

import com.tienda.domain.Producto;
import com.tienda.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos){
        var lista = productoRepository.findAll();
        return lista;
    }
    
    //Se crea los métodos para un CRUD
    
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto){
        producto = productoRepository.findById(producto.getIdProducto()).orElse(null);
        return producto;
    }
    
    @Transactional
    public void delete (Producto producto){
        productoRepository.delete(producto);
    }
    
    public void save (Producto producto){
        //Esta producto crea un nuevo registro si no se encuentra el id
        //Si ya existe el registro, se actualiza
        productoRepository.save(producto);
    }
    
    
}
