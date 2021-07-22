/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacotao;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PacoteNumero pn =new PacoteNumero ();
        Scanner ler= new Scanner(System.in);
        
        System.out.println("Coloque um numero:");
        pn.num=ler.nextInt();
    }
    
}
