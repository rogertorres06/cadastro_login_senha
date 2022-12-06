import java.util.Scanner;

import model.Usuario;

public class App {
    public static void main(String[] args) {
        int contador = 1;

        Scanner leia = new Scanner(System.in);

        System.out.println("*** TELA DE CADASTRO ***");
        System.out.println("");

        System.out.println("Digite o nome: ");
        String nome = leia.nextLine();
        System.out.println("Genero: ");
        String genero = leia.nextLine();
        System.out.println("Data de nascimento: ");
        String dataNasc = leia.nextLine();
        System.out.println("Digite o CPF: ");
        String cpf = leia.nextLine();
        System.out.println("Telefone: ");
        String telefone = leia.nextLine();
        System.out.println("Email: ");
        String email = leia.nextLine();
        System.out.println("Senha: ");
        String senha = leia.nextLine();

        Usuario usuario = new Usuario(nome, genero, dataNasc, cpf, telefone, email, senha);
        System.out.println("");

        do {
            limpa();
            System.out.println("*** TELA DE LOGIN ***");
            System.out.println();

            // 1) Informe o seu login
            System.out.println("Login/E-mail: ");
            email = leia.nextLine();
            // 2) Informe a sua senha
            System.out.println("Senha: ");
            senha = leia.nextLine();

            if (usuario.autenticar(email, senha) == true) {
                System.out.printf("Usuário:  %s logado com sucesso.", email);
                System.out.println("\nSeja bem vindo " + usuario.getNome() + "!!");

            } else if (!usuario.autenticar(email, senha) && contador != 3) {
                System.out.println(
                        "Email ou senha invalida, tente novamente: \n Tentativas restantes " + (3 - contador)
                                + " de 3");
                contador++;

            } else {
                contador++;
                System.out.println("Acesso BLOQUEADO (EMAIL ou SENHA incorreta!)");
            }
        } while ((usuario.autenticar(email, senha) == false) && (contador != 4));

        leia.close();
    }

    public static void limpa() {
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}