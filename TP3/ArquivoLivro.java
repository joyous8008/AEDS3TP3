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

    public void comprime(){
        
        try {

            //Primeiro pega a data e hora atuais
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            //Cria o arquivo de backup
            RandomAccessFile backup = new RandomAccessFile("backups/"+ timeStamp, nomeArquivo);
            byte[] conteudo = new byte[(int)(arquivo.length() - TAM_CABECALHO)];

            //Pega todos os registros do arquivo (sem cabeçalho)
            arquivo.seek(TAM_CABECALHO);
            arquivo.readFully(conteudo);

            //Comprime em LZW
            byte[] comprimido = LZW.codifica(conteudo);

            //Coloca no arquivo backup
            backup.write(comprimido);

            backup.close();
        } catch (Exception e) {
            MyIO.println("" + e);
        }
    }

}
