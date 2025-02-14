package com.tienda.service;

import com.tienda.domain.Categoria;
import com.tienda.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos){
        var lista = categoriaRepository.findAll();
        return lista;
    }
    
    //Se crea los métodos para un CRUD
    
    @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria){
        categoria = categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
        return categoria;
    }
    
    @Transactional
    public void delete (Categoria categoria){
        categoriaRepository.delete(categoria);
    }
    
    public void save (Categoria categoria){
        //Esta categoria crea un nuevo registro si no se encuentra el id
        //Si ya existe el registro, se actualiza
        categoriaRepository.save(categoria);
    }
    
    
}
