class MainClass {
    public static void Main (String[] args) {

        int n; 
        float soma = 0;

        Console.WriteLine("Digite o tamanho: ");
        n = int.Parse(Console.ReadLine());

        float[] nota = new float[n];
        String[] nome = new String[n];

        for (int i = 0; i < n; i++) {
            Console.WriteLine("Aluno " + i + ": ");

            Console.WriteLine("Nome: ");
            nome[i] = Console.ReadLine();

            Console.WriteLine("Nota: ");
            nota[i] = float.Parse(Console.ReadLine());
            soma += nota[i];

        }

        float media = soma/n;

        for (int i = 0; i < n; i++) {
            if (nota[i] >= media) {
                Console.WriteLine("Aluno " + nome[i] + ": " + nota[i]);
            }
        }


    }
}
