import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class Main 
{
  public static void main(String[] args) 
  {
    System.out.println("#########FILE#########");
    File archivo = new File("archivo.txt");
    System.out.println(archivo.exists());
    if(!archivo.exists())
    {
      try
      {
        boolean seCreo = archivo.createNewFile();
        System.out.println(seCreo);
        System.out.println(archivo.exists());
      }
      catch(IOException ex)
      {
        System.out.println(ex.getMessage());
      }
    }

    System.out.println("#########File Writer#########");
    try
    {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Escriba texto para el archivo");
      String texto = br.readLine();
      String texto2 = "Hola Mundo";

      FileWriter fw = new FileWriter("fw.csv");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter salida = new PrintWriter(bw);
      salida.println(texto);
      salida.println(texto2);
      salida.println("Texto de la linea 3");
      for(int i=0; i<10; i++){
        salida.println("Linea:"+i+" del for");
      }
      String[] arrayCadena = {"a","e","i","o","u"};
      for(int i=0; i<arrayCadena.length; i++){
        salida.println(arrayCadena[i]);
      }
      for(int i=0; i<10; i++){
        salida.println("Brayan,Aldair,Cova,Rosario,999999999,21,50");
      }

      salida.close();
    }
    catch(IOException ex)
    {
      System.out.println(ex.getMessage());
    }


    System.out.println("#########File Reader#########");

    try
    {
      FileReader fr = new FileReader("fw.csv");
      BufferedReader br = new BufferedReader(fr);
      String linea = br.readLine();
      while(linea != null)
      {
        System.out.println(linea);
        linea = br.readLine();
      }
    }
    catch(FileNotFoundException ex)
    {
      System.out.println(ex.getMessage());
    }
    catch(IOException ex)
    {
      System.out.println(ex.getMessage());
    }


    System.out.println("#########String Tokenizer#########");

    String linea = "Brayan,Cova,Rosario,999999,21,50";
    StringTokenizer tokenizador = new StringTokenizer(linea, ",");

    int count=0;
    String nombre=null, apPaterno=null, apMaterno=null;
    int numCuenta=0, edad=0;
    float creditos=0;

    while(tokenizador.hasMoreTokens())
    {
      String aux = tokenizador.nextToken();
      System.out.println(aux);
      if(count==0)
        nombre=aux;
      else if(count==1)
        apPaterno=aux;
      else if(count==2)
        apMaterno=aux;
      else if(count==3)
        numCuenta=Integer.parseInt(aux);
      else if(count==4)
        edad=Integer.parseInt(aux);
      else if(count==5)
        creditos=Float.parseFloat(aux);
      count++;
    }

    System.out.println("El alumno es:");
    System.out.println(nombre+" "+apPaterno+" "+apMaterno+" "+numCuenta+" "+edad+" "+creditos);
    count=0;

  }
}