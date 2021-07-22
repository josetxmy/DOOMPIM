/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinpin;


        
public class Classis {
    public int anoatual,anonasc,meses,mesatual,diaAtual,dia;
    
    public int idade(){
        return anoatual-anonasc;
    
}
    public int dia(){
        return anonasc-365;
    }
     public int mes(){
         return mesatual-meses;
     }
     public int diad(){
         return dia-diaAtual;
    }
    
}
