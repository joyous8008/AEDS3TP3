import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//Classe extendida do Arquivo genérico
public class ArquivoLivro extends Arquivo<Livro> {

    ArquivoLivro(String na) throws Exception {
        super(na, Livro.class.getConstructor());
    }

    public int createLivro(Livro novo) {
        int resp = -1;
        try {

            // Código original
            resp = this.create(novo);

        } catch (Exception e) {
            System.out.println(e);
        }
        return resp;
    }

    public boolean updateLivro(Livro novoLivro) {

        boolean resp = false;

        try {
            // Código original
            resp = this.update(novoLivro);

        } catch (Exception e) {
            System.out.println(e);
        }

        return resp;
    }

    public boolean deleteLivro(int id) {
        boolean resp = false;
        try {
            // Código original
            resp = this.delete(id);

        } catch (Exception e) {
            System.out.println(e);
        }
        return resp;
    }

    public String comprime() {

        String timeStamp = "";
        try {

            // Primeiro pega a data e hora atuais
           timeStamp  = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            timeStamp += ".bd";
            // Cria o arquivo de backupnull
            RandomAccessFile backup = new RandomAccessFile("backups/" + timeStamp, "rw");
            byte[] conteudo = new byte[(int) (arquivo.length() - TAM_CABECALHO)];

            // Pega todos os registros do arquivo (sem cabeçalho)
            arquivo.seek(TAM_CABECALHO);
            arquivo.readFully(conteudo);

            // Comprime em LZW
            byte[] comprimido = LZW.codifica(conteudo);

            // Coloca no arquivo backup
            backup.write(comprimido);

            backup.close();
        } catch (Exception e) {
            MyIO.println("" + e);
        }
        return timeStamp;
    }

    public void descomprime(String backup) {
        //Primeiro cria o acesso do backup
        RandomAccessFile ler_bp;
        //Depois o array para o resultado descompactado e o conteudo do arquivo
        byte[] result = new byte[1];
        byte[] bp;
        try {
            //Lê o arquivo de backup
            ler_bp = new RandomAccessFile("backups/" + backup , "rw");
            bp = new byte[(int)ler_bp.length()];
            ler_bp.readFully(bp);
            //Decodifica e pega o resultado
            result = LZW.decodifica(bp);
            ler_bp.close();

            //Escreve o backup sobre o arquivo atual (preferencialmente vazio)
            arquivo.seek(TAM_CABECALHO);
            arquivo.write(result);

        } catch (Exception e) {
            MyIO.println("" + e);
        }
        
    }

}