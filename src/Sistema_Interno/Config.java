package Sistema_Interno;
//////////////Bibliotecas///////////////
import java.util.InputMismatchException;
import java.util.Scanner;
////////////////////////////////////////

/////Classe de configuração do menu e chamada de objetos.
public class Config {
    ///////Instancia de Objetos///////
    Scanner input = new Scanner(System.in);
    Controle controle = new Controle();

    //////////Menu de Escolha/////////
    /// //Loop Infinito////////
    public void start() {
        while (true) {
            System.out.println("|===================================|");
            System.out.println("|=============Bem-Vindo=============|");
            System.out.println("|+++++++++++++++++++++++++++++++++++|");
            System.out.println("|++ O Que Gostaria?               ++|");
            System.out.println("|+++++++++++++++++++++++++++++++++++|");
            System.out.println("|1 - Estacionar                     |");
            System.out.println("|2 - Retirar                        |");
            System.out.println("|3 - Total de Vagas                 |");
            System.out.println("|4 - Fechar o sistema               |");
            System.out.println("|+++++++++++++++++++++++++++++++++++|");
            System.out.println("|===================================|");

        //////Tratamento de Erros///////////
            int opcao;
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção Inválida. Por favor, insira 1, 2, 3 ou 4.");
                input.nextLine(); 
                continue;
            }

            switch (opcao) {
                case 1:
                    estacionarCarro();
                    break;
                case 2:
                    retirarCarro();
                    break;
                case 3:
                    System.out.println("Total de Vagas: " + controle.quantidadeVagas());
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
        }
    }

////////////Função Para Estacionar(inserir) o Veículo///////////
    private void estacionarCarro() {
        System.out.print("Adicione a placa do seu Veiculo: ");
        String placa = input.next();
        System.out.print("O seu veiculo é um carro, caminhão ou moto? ");
        String type = input.next();
        controle.EnterVec(placa, type);
    }
//////////////////////////////////////////////////////////////////

////////////Função Para Retirar o Veículo///////////
    private void retirarCarro() {
        System.out.print("Qual a placa do seu veiculo? ");
        String placa = input.next();
        controle.RemVec(placa);
    }
////////////////////////////////////////////////////
}
