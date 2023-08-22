import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

            RandomAccessFile arq = new RandomAccessFile("teste.txt", "rw");
            arq.writeInt(1);
            arq.writeBoolean(true);
            arq.writeChars("Testando");
            arq.writeDouble(7.84);


            arq.close();
    }
}
