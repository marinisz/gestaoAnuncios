import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Sistema {
    ArrayList<Anuncio> lista = new ArrayList<Anuncio>();

    public void insereAnuncio(Anuncio anuncio) {
        Arquivo arquivo = new Arquivo();
        arquivo.writeFile(anuncio);
    }

    public void imprimeAnuncios() {
        Arquivo arq = new Arquivo();
        arq.readFile(lista);
        for(Anuncio a : lista){
            a.imprime();
        }
    }

    public void menu() {
        Anuncio anuncio = new Anuncio();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Gestão de anuncios\nO que deseja fazer?");
        int op = 0;
        while (op != 5) {
            System.out.println("|1) para Cadastrar Anuncio|\n" + "|2) para buscar Cliente|\n" + "|3) para buscar Data|\n" + "|4) para listar anuncios|\n" + "|5) para sair|");
            System.out.print("Opcao: ");
            op = teclado.nextInt();
            if (op == 1) {
                anuncio.usuarioInsereAnuncio();
                insereAnuncio(anuncio);
            }
            if (op == 2) this.filtraAnuncioCliente();
            if (op == 3) this.filtraDatas();
            if (op == 4) this.imprimeAnuncios();
        }

    }

    public void filtraAnuncioCliente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nome do cliente: ");
        String cliente = teclado.next();
        cliente = cliente.toUpperCase(Locale.ROOT);
        boolean resp = false;
        Arquivo arq = new Arquivo();
        arq.readFile(lista);
        int n = lista.size();
        int aux = 0;
        for (int i = 0; i < n; i++) {
            String momento = lista.get(i).getCliente().toUpperCase(Locale.ROOT);
            if (momento.equals(cliente)) {
                resp = true;
                aux = i;
                i = n;
            }
        }
        if (resp = false) {
            System.out.println("Não encontramos nada");
        }else{
            lista.get(aux).imprime();
        }

    }

    public void filtraDatas() {
        Arquivo arq = new Arquivo();
        arq.readFile(lista);
        Data a = new Data();
        Data b = new Data();
        System.out.print("Data inicio -> ");
        a.dataEntrada();
        System.out.print("Data final -> ");
        b.dataEntrada();
        int dif = a.diferencaDatas(a, b);
        Data antiga = a.mostraAntiga(a, b);
        antiga.imprimeData();
        int cont = 0;
        int j = 0;
        while (j < dif) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getDataInicio().igualData(antiga, a)==true) {
                    lista.get(i).imprime();
                    cont++;
                } else if (lista.get(i).getDataInicio().igualData(antiga, a)==true) {
                    lista.get(i).imprime();
                    cont++;
                }
                antiga.adicionaDias(1);
            }
            j++;
        }
        if (cont == 0) {
            System.out.println("Não encontramos nenhum anuncio nessa data!");
        }
    }
    }


