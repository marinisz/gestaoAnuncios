import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public String path = "C:\\Users\\Vinicius\\Desktop\\Importantes\\github\\gestaoAnuncios\\anunciosLista.txt";

    public void writeFile(Anuncio anuncio){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
            bw.append(anuncio.getCliente()+",");
            bw.append(anuncio.getNomeAnuncio()+",");
            bw.append(anuncio.getDataInicio().getDia()+"/"+anuncio.getDataInicio().getMes()+"/"+anuncio.getDataInicio().getAno()+",");
            bw.append(anuncio.getDataFim().getDia()+"/"+anuncio.getDataFim().getMes()+"/"+anuncio.getDataFim().getAno()+",");
            bw.append(anuncio.getViews()+",");
            bw.append(anuncio.getShares()+",");
            bw.append(anuncio.getCliques()+",");
            bw.append(anuncio.getVerba()+",");
            bw.append("\n");
            bw.close();
        }catch (Exception ex){
            System.out.println("error");
            ex.printStackTrace();
        }
    }

    public void readFile(ArrayList<Anuncio> anuncioLista){
        Anuncio anuncio = new Anuncio();
        try{
            FileReader fw = new FileReader(path);
            BufferedReader br = new BufferedReader(fw);
            String s;
            int cont=0;
            int i = 0;
            while((s = br.readLine())!=null){
                String[] a =s.split(",");
                anuncio.setNomeAnuncio(a[0]);
                anuncio.setCliente(a[1]);
                Data inicio=new Data();
                inicio = inicio.transformaString(a[2]);
                anuncio.setDataFim(inicio);
                Data fim =new Data();
                fim = fim.transformaString(a[3]);
                anuncio.setDataFim(fim);
                anuncio.setViews(Integer.parseInt(a[4]));
                anuncio.setShares(Integer.parseInt(a[5]));
                anuncio.setCliques(Integer.parseInt(a[6]));
                anuncio.setVerba(Float.parseFloat(a[6]));
                anuncioLista.add(anuncio);
            }
            br.close();
            for(Anuncio a : anuncioLista){
                a.imprime();
            }
        }catch (Exception ex){
            return;
        }
    }

}