import java.io.File;

//Código usado para teste
//Deve ser ignorado ou iniciado a partir da pasta TP2
public class Principal {
    public static void main(String[] args) {

        File f = new File("dados/livros.db");
        f.delete();
        ArquivoLivro arqTeste;
        ArquivoLivro arqTeste2;
        Livro l1 = new Livro(-1, "9788563560278", "Bleach CFYW", 15.99F);
        Livro l2 = new Livro(-1, "9788584290482", "Ensino Híbrido", 39.90F);
        Livro l3 = new Livro(-1, "9786559790005", "Bleach vol 14", 48.1F);
        Livro l4 = new Livro(-1, "9788582714911", "Memoria", 55.58F);
        Livro l5 = new Livro(-1, "9786587150062", "Memoria moderno", 48.9F);
        Livro l6 = new Livro(-1, "9786587150063", "Bleach vol1", 65.0F);
        Livro l7 = new Livro(-1, "9786587150063", "Bleach Thousand Year Blood War", 65.0F);
        Livro livre;
        int id1, id2, id3, id4, id5, id6, id7;

        try {
            arqTeste = new ArquivoLivro("dados/livros.db");
            arqTeste2 = new ArquivoLivro("dados/backas.db");

            id1 = arqTeste.createLivro(l1);
            MyIO.println("Livro criado com o ID: " + id1);

            id2 = arqTeste.createLivro(l2);
            MyIO.println("Livro criado com o ID: " + id2);

            id7 = arqTeste.createLivro(l7);
            MyIO.println("Livro criado com o ID: " + id7);

            id4 = arqTeste.createLivro(l4);
            MyIO.println("Livro criado com o ID: " + id4);

            id5 = arqTeste.createLivro(l5);
            MyIO.println("Livro criado com o ID: " + id5);

            l4.setTitulo("A Memoria");
            if (arqTeste.updateLivro(l4))
                MyIO.println("Livro de ID " + l4.getID() + " alterado!");
            else
                MyIO.println("Livro de ID " + l4.getID() + " não encontrado!");

            id3 = arqTeste.createLivro(l3);
            MyIO.println("Livro criado com o ID: " + id3);

            id6 = arqTeste.createLivro(l6);

            MyIO.println("Livro criado com o ID: " + id6);

            livre = arqTeste.read(id7);
            MyIO.println(livre.toString());
            
            String ende = arqTeste.comprime();

            arqTeste2.descomprime(ende);

            livre = arqTeste2.read(id1);
            MyIO.println(livre.toString());
            livre = arqTeste2.read(id2);
            MyIO.println(livre.toString());
            livre = arqTeste2.read(id3);
            MyIO.println(livre.toString());
            livre = arqTeste2.read(id4);
            MyIO.println(livre.toString());
            livre = arqTeste2.read(id5);
            MyIO.println(livre.toString());
            livre = arqTeste2.read(id6);
            MyIO.println(livre.toString());

            arqTeste.close();
            arqTeste2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
