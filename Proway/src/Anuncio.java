import java.util.Scanner;

public class Anuncio {
    private String nomeAnuncio = new String();
    private String cliente = new String();
    private Data dataInicio = new Data();
    private Data dataFim = new Data();
    private float verba;
    private int views;
    private int shares;
    private int cliques;


    //construtor

    public Anuncio(){
        this.verba = 0;
    }

    public Anuncio(String nomeAnuncio, String cliente, Data dataInicio, Data dataFim, float verba) {
        this.nomeAnuncio = nomeAnuncio;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.verba = verba;
        this.calculaViews();
    }
    //getters and setters

    public float getVerba() {
        return verba;
    }

    public void setVerba(float verba) {
        this.verba = verba;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getCliques() {
        return cliques;
    }

    public void setCliques(int cliques) {
        this.cliques = cliques;
    }

    public String getNomeAnuncio() {
        return nomeAnuncio;
    }

    public void setNomeAnuncio(String nomeAnuncio) {
        this.nomeAnuncio = nomeAnuncio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Data getDataFim() {
        return dataFim;
    }

    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    //funções

    public void calculaViews(){
        int viewsAux = 0;
        int shareAux = 0;
        int cliques=0;
        //100 = 30 - 10 = 3
        int contador = Math.round(getVerba()*30);//views esperadas ao disponibilizar a verba
        int auxiliaCliques=2;
        for(int i = 1;i<=contador;i++){

            viewsAux++;//somando as views pagas(garantidas)
            if((viewsAux%100)==0){ //a cada 100 pessoas que visualizam o anúncio 12 clicam nele
                cliques+=12;
                if(cliques>=(auxiliaCliques*12)){
                    shareAux+=3;
                    viewsAux+=120;
                    auxiliaCliques+=2;
                }
            }


        }
        this.setCliques(cliques);
        this.setViews(viewsAux);
        this.setShares(shareAux);

    }

    public void imprime(){
        System.out.println("Anuncio: "+this.getNomeAnuncio());
        System.out.println("Anunciante: "+this.getCliente());
        System.out.println("Valor investido: "+this.getVerba());
        System.out.println("Views: "+this.getViews());
        System.out.println("Shares: "+getShares());
        System.out.println("Cliques: "+getCliques());
        int dif = this.getDataInicio().diferencaDatas(this.getDataInicio(),this.getDataFim());
        System.out.println("Anúncio funcionará por "+dif+" dias");
    }

    public void usuarioInsereAnuncio(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Preencha os dados do seu anuncio: ");
        System.out.print("Nome do Anuncio: ");
        String nome = teclado.nextLine();
        System.out.print("Anunciante: ");
        String cliente = teclado.nextLine();
        System.out.print("Verba para anúncio: ");
        float verba = teclado.nextFloat();

        System.out.print("Data de inicio: ");
        Data dataInicio = new Data();
        dataInicio.dataEntrada();
        System.out.print("Data final: ");
        Data dataFim = new Data();
        dataFim.dataEntrada();

        this.nomeAnuncio = nome;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.verba = verba;
        this.calculaViews();
    }
}
