package com.karen.quadbike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.quadbike.model.Quadbike;
import com.karen.quadbike.repository.QuadbikeRepository;

@Service
public class QuadbikeService {
    @Autowired
    public QuadbikeRepository quadbikeRepository;

    public List<Quadbike> obtenerQuadbikeCompleta(){
        return quadbikeRepository.obtenerQuadbikeCompleta();

    }

    public Optional<Quadbike> obtenerQuadbikeId(Integer id){
        return quadbikeRepository.obtenerQuadbikeId(id);
    }

    public Quadbike salvarQuadbike(Quadbike quadbike){
        if(quadbike.getId()==null){
            return quadbikeRepository.salvarQuadbike(quadbike);
        }
        else{
            Optional <Quadbike> quadbikeAuxiliar = quadbikeRepository.obtenerQuadbikeId(quadbike.getId());
            if(quadbikeAuxiliar.isEmpty()){
                return quadbikeRepository.salvarQuadbike(quadbike);
            }
            else{
                return quadbike;
            }
        }

    }
}
