package com.marleidealves;

import org.junit.jupiter.api.Test;

import com.marleidealves.service.CadastroUsuarioService;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testCadastroUsuarioValido() {
        CalculadoraFrete frete = new CalculadoraFrete(70.0, 100.0);
        Usuario usuario = new Usuario("Carlos", "carlos@email.com", "12345678901", frete);
        assertEquals("Carlos", usuario.getNome());
        assertEquals("12345678901", usuario.getCpf());
    }

    @Test
    public void testUsuarioComEmailInvalido() {
        CalculadoraFrete frete = new CalculadoraFrete(50.0, 20.0);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Maria", "mariaemail.com", "12345678902", frete);
        });
        assertEquals("E-mail inválido.", ex.getMessage());
    }

    @Test
    public void testUsuarioComCpfInvalido() {
        CalculadoraFrete frete = new CalculadoraFrete(50.0, 20.0);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("João", "joao@email.com", "12345", frete);
        });
        assertEquals("CPF deve conter 11 dígitos.", ex.getMessage());
    }

    @Test
public void testUsuarioComNomeNaoInformado() {
    // Passo 1: Criar a calculadora de frete com dados válidos
    CalculadoraFrete frete = new CalculadoraFrete(80.0, 10.0);

    // Passo 2: Tentar criar o usuário com nome vazio
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
        new Usuario("", "ana@email.com", "12345678903", frete);
    });

    // Passo 3: Verificar se a mensagem da exceção está correta
    assertEquals("Nome do usuário é obrigatório.", ex.getMessage());
}

@Test
public void testCadastroUsuarioDuplicado() {
    CadastroUsuarioService cadastro = new CadastroUsuarioService();

    CalculadoraFrete frete1 = new CalculadoraFrete(100.0, 50.0);
    Usuario usuario1 = new Usuario("Paulo", "paulo@email.com", "12345678904", frete1);
    cadastro.cadastrar(usuario1); // primeiro cadastro válido

    CalculadoraFrete frete2 = new CalculadoraFrete(70.0, 20.0);
    Usuario usuarioDuplicado = new Usuario("Paulo Silva", "paulo.silva@email.com", "12345678904", frete2);

    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
        cadastro.cadastrar(usuarioDuplicado); // tentativa duplicada
    });

    assertEquals("Usuário com este E-mail e CPF já está cadastrado.", ex.getMessage());
}



}

    

