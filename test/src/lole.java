

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class lole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        pogchamp pc = new pogchamp ();
        Scanner ler = new Scanner (System.in);
        
        int contador;
      for (contador = 0; contador < 10; contador = contador+1){
          System.out.println("Informe um numero:");
          pc.numero=ler.nextInt();
      }
      pc.Menor();
        System.out.println("A soma dos numeros e "+pc.soma());
        System.out.println("A media dos numeros e"+pc.media());
    }
    
}
