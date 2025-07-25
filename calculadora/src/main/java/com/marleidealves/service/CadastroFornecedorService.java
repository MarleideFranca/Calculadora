package com.marleidealves.service;


import java.util.HashSet;
import java.util.Set;
import com.marleidealves.Empresa;




public class CadastroFornecedorService {
    private Set<String> cnpjsCadastrados = new HashSet<>();

    public void cadastrarFornecedor(Empresa fornecedor) {
        if (cnpjsCadastrados.contains(fornecedor.getCnpj())) {
            throw new IllegalArgumentException("Fornecedor já está cadastrado.");
        }
        cnpjsCadastrados.add(fornecedor.getCnpj());
    }

    public void limpar() {
        cnpjsCadastrados.clear();
    }
}
