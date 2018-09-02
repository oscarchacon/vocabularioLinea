package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class archivos {

	public void CrearVocabularioLinea(File ArchivoIn, File ArchivoOut)
	{
		long i = 1;
		String linea;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(ArchivoIn));
			while((linea=br.readLine())!=null)
			{
				System.out.println("Leyendo Archivo: "+i);
				Map<String, Integer> vocabularioLinea = new HashMap<String, Integer>();
				String[] lineaCompleta = linea.trim().split(";");
				String nombreDoc = lineaCompleta[0].trim();
				
				vocabularioLinea = this.Vocabulario(lineaCompleta[1]);
				
				this.EscribirVocabularioArchivo(vocabularioLinea, nombreDoc, ArchivoOut);
				//this.EscribirVocabularioMapaArchivo(vocabularioLinea, i, ArchivoOut);
				i++;
				//Runtime.getRuntime().exec("cls");
				//break;
			}
			br.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Map<String, Integer> Vocabulario(String Linea)
	{
		Map<String, Integer> nuevoVoc = new HashMap<String, Integer>();
		if(!Linea.isEmpty())
		{				
			List<String> lista = Arrays.asList(Linea.trim().split("\\s+"));
			
			for(String palabra : lista)
			{
				if(nuevoVoc.containsKey(palabra.trim()))
				{
					nuevoVoc.replace(palabra.trim(), nuevoVoc.get(palabra.trim())+1);
				}
				else
				{
					nuevoVoc.put(palabra.trim(), 1);
				}
			}
		}
		Map<String,Integer> nuevoVocOrdenado = new TreeMap<String, Integer>(nuevoVoc);
		//return nuevoVoc;
		return nuevoVocOrdenado;
	}
	
	public void EscribirVocabularioArchivo(Map<String, Integer> Voc, String nombreDoc, File ArchivoOut)
	{
		if(ArchivoOut.exists() && Voc.size() > 0)
		{
			int freqMax = Collections.max(Voc.values());
			for(Map.Entry<String, Integer> entrada : Voc.entrySet())
			{
				BufferedWriter out = null;				
				try {
					out = new BufferedWriter(new FileWriter(ArchivoOut, true));
					//out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ArchivoOut, true), "UTF8"));
					out.write(entrada.getKey()+" "+nombreDoc+","+entrada.getValue()+","+freqMax);					
				    out.newLine();
				    out.flush();					 
				    out.close();	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}
	
	public void EscribirVocabularioMapaArchivo(Map<String, Integer> Voc, String NombreDoc, File ArchivoOut)
	{
		if(ArchivoOut.exists() && Voc.size() > 0)
		{
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(ArchivoOut,true);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				
				oos.writeObject(Voc);
				oos.flush();
				oos.close();
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
	}

}
