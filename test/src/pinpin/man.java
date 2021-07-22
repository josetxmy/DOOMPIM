/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinpin;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class man {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Classis  ss = new Classis();
       Scanner ler =new Scanner(System.in);
       
        System.out.println("Seu ano de nascimento:");
        ss.anonasc = ler.nextInt();
        System.out.println("Ano atual:");
        ss.anoatual=ler.nextInt();
        System.out.println("Mes de nascimento:");
        ss.meses=ler.nextInt();
        System.out.println("Mes atual");
        ss.mesatual=ler.nextInt();
        System.out.println("Dia de nascimento:");
        ss.dia=ler.nextInt();
        System.out.println("Dia Atual:");
        ss.diaAtual=ler.nextInt();
        System.out.println("ano"+ss.idade());
        System.out.println("meses"+ss.mes());
        System.out.println("dia"+ss.diad());
        System.out.println("Faz"+ss.dia());
        
    }
    
}
