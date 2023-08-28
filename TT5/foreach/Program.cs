using System;
using System.Collections;

public class Program {

    public static void Main (String[] args) {

        ArrayList vetor = new ArrayList(5);
        int soma = 0;

        for (int i = 0; i < vetor.Capacity; i++) {
            Console.WriteLine("Digite o número: ");
            int valor = int.Parse(Console.ReadLine());
            vetor.Add(valor);
            soma += valor;
        } 

        float media = soma/5;

        foreach (int num in vetor) 
        if (num > media) {
            Console.WriteLine(num);

        }

        

        

    }

}
