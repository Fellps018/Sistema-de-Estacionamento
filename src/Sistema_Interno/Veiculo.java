package Sistema_Interno;

///////////Importações da biblioteca/////////
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
///////////////////////////////////////////

public class Veiculo{
/////////HashMap para o fluxo dos dados//////////
    private Map<String, List<String>> info = new HashMap<>();
    
////////Função para adcionar um veiculo novo////////
    public  void adcionarVeiculos(String placa, String type, String hours){
          addVec(placa, type, hours);
    }
////////////////////////////////////////////////////

/////////////Função para remover um veiculo/////////
    public  void removerVeiculos(String Placa){
        remVec(Placa);
    }
///////////////////////////////////////////////////


//////////////Função privada para controle dos dados////////
private void addVec(String Placa, String Type, String hours){
    List<String> novaLista = new ArrayList<>();
    novaLista.add(Type);  
    novaLista.add(hours); 
    info.put(Placa, novaLista);
}
///////////////////////////////////////////////////

////////Função privada para retirada dos dados////////
private void remVec(String Placa){
    info.remove(Placa);
   
}
//////////////////////////////////////////////////////

////Retorna o tipo de veiculo + a validação da placa////////
public String getType(String placa) {
    if (info.containsKey(placa)) {
        List<String> dados = info.get(placa);
        return dados.get(0); 
    }
    return null;
}
///////////////////////////////////////////////////

//////////////Retorna a hora estacionada////////////
   public String getHours(String placa) {
        if (info.containsKey(placa)) {
            return info.get(placa).get(1);
        }
        return null;
    }
///////////////////////////////////////////////////
}

