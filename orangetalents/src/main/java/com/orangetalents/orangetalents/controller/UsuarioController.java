package com.orangetalents.orangetalents.controller;

import com.orangetalents.orangetalents.models.Usuario;
import com.orangetalents.orangetalents.repository.UsuarioRepository;
import com.orangetalents.orangetalents.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService usuarioService;

    @PostMapping("/")
    public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "usuarioId") Long usuarioId){
        return new ResponseEntity(usuarioRepository.findById(usuarioId), HttpStatus.OK);
    }
}
