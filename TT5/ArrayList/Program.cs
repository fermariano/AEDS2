using System;
using System.Collections;

public class Program {
    public static void Main() {

        ArrayList vetor = new ArrayList();

        Console.WriteLine("Capacidade: " + vetor.Capacity);
        Console.WriteLine("Número de elementos: " + vetor.Count);

        Console.WriteLine("------------");

        vetor.Add(4);

        Console.WriteLine("Capacidade: " + vetor.Capacity);
        Console.WriteLine("Número de elementos: " + vetor.Count);

    }
}
