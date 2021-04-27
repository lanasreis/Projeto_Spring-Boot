package com.orangetalents.orangetalents.controller;

import com.orangetalents.orangetalents.models.Endereco;
import com.orangetalents.orangetalents.models.Usuario;
import com.orangetalents.orangetalents.models.ViaCep;
import com.orangetalents.orangetalents.repository.EnderecoRepository;
import com.orangetalents.orangetalents.repository.UsuarioRepository;
import com.orangetalents.orangetalents.repository.ViaCepRepository;
import com.orangetalents.orangetalents.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    public EnderecoRepository enderecoRepository;

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Autowired
    public ViaCepRepository viaCepRepository;

    @Autowired
    public EnderecoService enderecoService;

    @PostMapping("/{usuarioId}")
    public ResponseEntity<Endereco> postEndereco(@Valid @RequestBody Endereco endereco, @PathVariable(value = "usuarioId") Long usuarioId){
        try{
            Usuario usuario = usuarioRepository.findById(usuarioId).get();
            endereco.setUsuario(usuario);
            return new ResponseEntity(enderecoRepository.save(endereco), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity("Erro, verifique se todos os elementos estão no formato correto", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{cep}")
    public ResponseEntity<ViaCep> getCep(@PathVariable(value = "cep") String cep){
        return new ResponseEntity(viaCepRepository.buscaEnderecoPorCep(cep), HttpStatus.OK);
    }
}
