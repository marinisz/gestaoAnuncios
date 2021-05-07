import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Sistema {
    ArrayList<Anuncio> lista = new ArrayList<Anuncio>();

    public void insereAnuncio(Anuncio anuncio){
        lista.add(anuncio);
    }
    public void imprimeAnuncios(){
        if(lista.size()==0){
            System.out.println("Não há anúncios cadastrados");
        }
        int n = lista.size();
        for(int i = 0;i<n;i++){
            lista.get(i).imprime();
        }
    }

    public void menu(){
        Anuncio anuncio = new Anuncio();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Gestão de anuncios\nO que deseja fazer?");
        int op=0;
        while(op!=5){
            System.out.println("|1) para Cadastrar Anuncio|\n" + "|2) para buscar Cliente|\n"+ "|3) para buscar Data|\n"+ "|4) para listar anuncios|\n"+"|5) para sair|");
            System.out.print("Opcao: ");
            op = teclado.nextInt();
            if(op==1){
                anuncio.usuarioInsereAnuncio();
                lista.add(anuncio);
            }
            if(op==2)this.filtraAnuncioCliente();
            if(op==3)this.filtraDatas();
            if(op==4)this.imprimeAnuncios();
            }

    }

    public void filtraAnuncioCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nome do cliente: ");
        String cliente = teclado.next();
        cliente = cliente.toUpperCase(Locale.ROOT);
        boolean resp = true;
        int n = lista.size();
        int aux = 0;
        for(int i = 0;i<n;i++){
            if(lista.get(i).getCliente().toUpperCase(Locale.ROOT)==cliente){
                resp=true;
                aux = i;
                i=n;
            }else{
                resp=false;
            }
        }
        if(resp=false){
            System.out.println("Não encontramos nada");
        }
        lista.get(aux).imprime();
    }

    public void filtraDatas(){
        Data a = new Data();
        Data b = new Data();
        System.out.print("Data inicio -> ");
        a.dataEntrada();
        System.out.print("Data final -> ");
        b.dataEntrada();
        int dif = a.diferencaDatas(a,b);
        Data recente = a.mostraRecente(a,b);
        int i = 0;
        boolean achou = false;
        while(i <dif){
            for(int j = 0;j<lista.size();j++){
                if(lista.get(j).getDataInicio().igualData(lista.get(j).getDataInicio(),recente)) {
                    lista.get(j).imprime();
                    i++;
                    recente.adicionaDias(1);
                    achou = true;
                }
            }
        }
        if(achou=false){
            System.out.println("Não encontramos nada");
        }
    }
}
