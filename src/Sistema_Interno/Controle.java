package Sistema_Interno;
/*Sistema Interno de funcionamento de Vagas e controle de Veiculos */

///////Importações de bibliotecas/////
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
//////////////////////////////////////

public class Controle {
///////controle da quantidade de vagas////////
   private int total_de_vagas = 10;//Valor mutavel e privado
   

///////Instancias do programa///////
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");
    Veiculo veiculo = new Veiculo();


/////////////Entrada de Veiculos + proteção/////////
    public void EnterVec(String placa,String type){
      entrada(placa, type);
    }
//////////////////////

/////////////Entrada de Veiculos + proteção/////////
    private void entrada(String placa,String type){
      ////////Instancias/////////
      LocalTime agora = LocalTime.now();
      String hours = agora.format(formatador);
      //////////////////////
      
      /////////Lógica para a validação///////////
      boolean TypeCarro = ("Carro".equalsIgnoreCase(type)) || ("Moto".equalsIgnoreCase(type));
      boolean TypeCaminhao = ("Caminhão".equalsIgnoreCase(type));
      boolean ComRegistro = (Objects.nonNull(veiculo.getType(placa)));
      boolean Carros = (1 <= total_de_vagas);
      boolean Caminhao = (2 <= total_de_vagas);
      /////////////////////////////////////

      //////////Controle para carros e caminhões/////////
      if(ComRegistro){
         System.out.println("Essa placa já está registrada.");
      }else if (Carros && TypeCarro && !ComRegistro){
            entradaCarro();
            veiculo.adcionarVeiculos(placa, type, hours);
            msn(placa, hours);
         }
         else if(Caminhao && TypeCaminhao && !ComRegistro){
            entradaCaminhao();
            veiculo.adcionarVeiculos(placa, type, hours);
             msn(placa, hours);
         }else{
            System.out.println("Não temos vagas disponíveis.");
         }
    }
   ///////////////////////////////////////////////
   

  /////////////Saída de Veiculos + proteção////////////////
   public void RemVec(String placa){
         saida(placa);
   }
////////////////////////////

   /////////////Saída de Veiculos + proteção////////////////
   private void saida(String placa){
        if (Objects.isNull(veiculo.getType(placa))) {
         System.out.println("Erro, placa não registrada.");
         return ; // O return joga o fluxo para fora do método imediatamente
      }

   /////////Lógica para saida///////////
   boolean TypeSaida = (veiculo.getType(placa).equalsIgnoreCase("Carro")  || (veiculo.getType(placa).equalsIgnoreCase("Moto")));
   boolean TypeSaidaCaminhao = (veiculo.getType(placa).equalsIgnoreCase("Caminhão"));
   /////////////////////////////////////

   ///////////validação da saída////////////////
         if((TypeSaida)){
            saidaCarro();
            pagamento(placa);
            veiculo.removerVeiculos(placa);
            System.out.println("Saída com sucesso.");
         }else if((TypeSaidaCaminhao)){
            saidaCaminhao();
            pagamento(placa);
            veiculo.removerVeiculos(placa);
             System.out.println("Saída com sucesso.");
         }else{
            System.out.println("Erro.");
         }
   }
   //////////////////////////////////////////////

   ///////////Mensagem Para a Confirmação de Sucesso/////////////
    private void msn(String placa, String hours){
      System.out.println("|==================================================================================|");
      System.out.println("   Veiculo com a placa: " + placa + " estacionado com sucesso, no horario: " + hours);
      System.out.println("|==================================================================================|");
    }
    ///////////////////////////////////////////////////

    ////////////////Mensagem Valor total para Pagar///////////////
    private void pagamento(String placa){
      LocalTime inicio = LocalTime.parse(veiculo.getHours(placa));
      LocalTime fim = LocalTime.now();
      String fims = fim.format(formatador);
      long minutosTotais = ChronoUnit.MINUTES.between(inicio, fim);
      double valorPagar = minutosTotais * 5.40;
      System.out.println("   |==================================================================================|");
      System.out.printf("   |- Horario da Entrada: %s |- Horario da Retirada: %s\n", veiculo.getHours(placa), fims);
      System.out.printf("   |- Tempo Total: %d minutos       |- Total a pagar: R$ %.2f\n", minutosTotais, valorPagar);
      System.out.println("   |==================================================================================|");
   }
    ///////////////////////////////////////////////////////////////

////////Entrada de veiculos///////
private void entradaCarro(){total_de_vagas -= 1;}
/////////////////////////////////

///Entrada do caminhao(-2 vagas)////
private void entradaCaminhao(){total_de_vagas -= 2;}
////////////////////////////////////

////////Saida de veiculos///////
private void saidaCarro(){total_de_vagas += 1;}
////////////////////////////////////

////////Retirada do caminhao(+2 vagas)///////
private void saidaCaminhao(){total_de_vagas += 2;}
//////////////////////////////////////

///Retorna o total de vagas disponiveis////
public int quantidadeVagas(){return getQuantVagas();}
private int getQuantVagas(){return total_de_vagas;}
//////////////////////////////////////////
}
