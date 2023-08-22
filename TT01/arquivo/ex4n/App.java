import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        RandomAccessFile arq = new RandomAccessFile("teste.txt", "rw");

        arq.writeInt(7);
        arq.writeDouble(6.8);
        arq.writeChar('F');
        arq.writeBoolean(false);
        arq.writeBytes("Testando");

        arq.seek(0); 
        System.out.println(arq.readInt()); 
        arq.seek(12); // 12 = 4 do int + 8 do double
        System.out.println(arq.readChar());
        arq.seek(12); 
        arq.writeChar('Z'); //Substituindo o caractere
        arq.seek(12);
        System.out.println(arq.readChar());


        arq.close();



    }
}
