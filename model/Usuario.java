
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Usuario {
    // atributos
    private String nome;
    private String genero;
    private LocalDate dataNasc;
    private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String cpf;
    private String telefone;
    private String email;
    private String senha;

    // construtor
    public Usuario(String nome, String genero, String dataNasc, String cpf, String telefone, String email,
            String senha) {
        this.nome = nome;
        this.genero = genero;
        setDataNasc(dataNasc);
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    // metodos publicos
    public boolean autenticar(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            return true;
        } else {
            return false;
        }
    }

    // metodos encapsulados
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNasc() {
        return dataNasc.format(df);
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = LocalDate.parse(dataNasc, df);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}.")) {
            throw new InputMismatchException("O CPF precisa conter 11 digitos.");
        }
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (!telefone.matches("\\d{11}")) {
            throw new InputMismatchException("O Telefone precisa conter 11 digitos.");
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
