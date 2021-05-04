import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Sistema {
    ArrayList<Anuncio> lista = new ArrayList<Anuncio>();

    public void insereAnuncio(Anuncio anuncio){
        lista.add(anuncio);
    }
    public void imprimeAnuncios(){
        int n = lista.size();
        for(int i = 0;i<n;i++){
            lista.get(i).imprime();
        }
    }

    public void menu(){
        Anuncio anuncio = new Anuncio();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Gestão de anuncios");
        System.out.println("Digite 1 para Cadastrar Anuncio\n" + "Digite 2 para buscar Cliente\n"+ "Digite 3 para buscar Data\n"+ "Digite 4 para listar anuncios\n"+"Digite 5 para sair\n");
        int op = teclado.nextInt();
        if (op == 5) {
            System.out.print("\nAté logo!");
            teclado.close();
        }
        switch (op){
            case 1: anuncio.usuarioInsereAnuncio();
                break;
            case 2: this.filtraAnuncioCliente();
                break;
            case 3: this.filtraDatas();
                break;
            case 4: this.imprimeAnuncios();
                break;
            default:
                System.out.println("Numéro inválido!");
                break;
        }
    }

    public void filtraAnuncioCliente(){
        Scanner teclado = new Scanner(System.in);
        String cliente = teclado.next();
        cliente = cliente.toUpperCase(Locale.ROOT);
        boolean resp = false;
        int n = lista.size();
        int aux = 0;
        for(int i = 0;i<n;i++){
            if(lista.get(i).getCliente().toUpperCase(Locale.ROOT)==cliente){
                resp=true;
                aux = i;
                i=n;
            }
        }
        lista.get(aux).imprime();
    }

    public void filtraDatas(){
        Data a = new Data();
        Data b = new Data();
        a.dataEntrada();
        b.dataEntrada();
        int dif = a.diferencaDatas(a,b);
        Data recente = a.mostraRecente(a,b);
        int i = 0;
        while(i <dif){
            for(int j = 0;j<lista.size();i++){
                if(lista.get(j).getDataInicio().igualData(lista.get(j).getDataInicio(),recente)){
                    lista.get(j).imprime();
                    i++;
                    recente.adicionaDias(1);
                }
            }
        }
    }
}
