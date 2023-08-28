using System;
using System.Collections;
public class Program {
    public static void Main (String[] args) {

        Queue fila = new Queue();

        fila.Enqueue(1);
        fila.Enqueue(2);
        fila.Enqueue(3);
        fila.Enqueue(4);
        fila.Enqueue(5);

        Console.WriteLine(fila.Count);

        fila.Dequeue();

        Console.WriteLine(fila.Contains(1));
        Console.WriteLine(fila.Contains(5));

        Console.WriteLine(fila.Peek());

        for (int i = 6; i <= 10; i++) {
            fila.Enqueue(i);
        }

        Console.WriteLine(fila.Dequeue());
        Console.WriteLine(fila.Dequeue());

        fila.Clear();

        Console.WriteLine(fila.Count);

    }
}
