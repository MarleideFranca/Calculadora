package com.marleidealves.service;

import java.util.HashMap;
import java.util.Map;
import com.marleidealves.Usuario;


public class CadastroUsuarioService {
    private Map<String, Usuario> usuariosCadastrados = new HashMap<>();

    public void cadastrar(Usuario usuario) {
        if (usuariosCadastrados.containsKey(usuario.getCpf())) {
            throw new IllegalArgumentException("Usuário com este E-mail e CPF já está cadastrado!");
        }
        usuariosCadastrados.put(usuario.getCpf(), usuario);
    }

    public Usuario buscarPorCpf(String cpf) {
        return usuariosCadastrados.get(cpf);
    }
}
