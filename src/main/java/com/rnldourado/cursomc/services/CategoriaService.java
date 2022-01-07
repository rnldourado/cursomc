package com.rnldourado.cursomc.services;

import com.rnldourado.cursomc.domain.Categoria;
import com.rnldourado.cursomc.repositories.CategoriaRepository;
import com.rnldourado.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

//    public Categoria buscar(Integer id){
//        Optional<Categoria> obj = repo.findById(id);
//        if (obj == null){
//            throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id+"Tipo: "+Categoria.class.getName());
//        }
//        return obj.orElse(null);
//    }

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
