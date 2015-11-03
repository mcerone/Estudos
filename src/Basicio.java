/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author murilo.nascimento
 */
import java.io.*;
import java.util.Scanner;

   
public class Basicio {
    
    public static void main(String[] args) throws IOException {

       
   
        String[] letras = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String busca=null;
            // cenário 1: Buscar palavra que o usuário digita
            busca=readTerminal();
            
            //cenário 2: Estatíticas das letras
            for(int i=0;i<letras.length;i++){
                busca=letras[i];
                runSearch(busca);
            }
          
    }
    
    private static String readTerminal () throws IOException{
        String entrada=null;
        System.out.println("Digite a palavra: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        entrada = br.readLine();
        return entrada;
    }//fim do método que lê a entrada do usuário

    private static void runSearch(String busca) throws FileNotFoundException{
        
         Scanner s = null;
         int palavras=0;
         int match=0;
         
         try {
            s = new Scanner(new BufferedReader(new FileReader("wiki_index.txt")));
            String palavra;
            System.out.println("Buscando: "+busca);
            while (s.hasNext()) {
                palavras++;
                palavra=s.next();
                
                if(palavra.toUpperCase().contains(busca.toUpperCase())){
                //System.out.println(palavra);
                match++;}
                                
            }
        } finally {
            if (s != null) {
                s.close();
            }}
        
         System.out.println("Matches para '"+busca+"': "+match+"\tPORCENTAGEM: "+(float) match*100/palavras+"%");
         
    }// fim do método que faz a busca
            
            
}
