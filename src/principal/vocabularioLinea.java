package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class vocabularioLinea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long totalTiempo;
        long tiempoInicio;
		
        archivos arch = new archivos();
        
        tiempoInicio = System.currentTimeMillis();
		//String rutaArchivo = "/home/ochacon/pan-plagiarism-corpus-2010/Documentos.txt"; //RUTA SERVIDOR
		String rutaArchivo = "/home/marcusfenix/Escritorio/corpus/DocumentosPS.txt"; //RUTA LINUX NOTEBOOK
		//String rutaArchivo = "C:/Users/oschacon/pan-plagiarism-corpus-2010/Documentos.txt"; //RUTA WINDOWS TRABAJO
		//String rutaArchivo = "/mnt/c/Users/oschacon/pan-plagiarism-corpus-2010/Documentos.txt"; //RUTA LINUX VIRTUAL TRABAJO
		//String rutaArchivo = "/Users/marcusfenix/Documents/Corpus/corpus pan10/Documentos.txt"; //RUTA MAC
		File nombreArchivo = new File(rutaArchivo);
		if(nombreArchivo.exists() && nombreArchivo.isFile())
		{
			//String rutaArchivoDestino = "/home/ochacon/pan-plagiarism-corpus-2010/VocabularioLinea.txt"; //RUTA SERVIDOR
			String rutaArchivoDestino = "/home/marcusfenix/Escritorio/corpus/VocabularioLineaPS.txt"; //RUTA LINUX NOTEBOOK
			//String rutaArchivoDestino = "C:/Users/oschacon/pan-plagiarism-corpus-2010/VocabularioLinea.txt"; //RUTA WINDOWS TRABAJO
			//String rutaArchivoDestino = "/mnt/c/Users/oschacon/pan-plagiarism-corpus-2010/VocabularioLinea.txt"; //RUTA LINUX VIRTUAL TRABAJO
			//String rutaArchivoDestino = "/Users/marcusfenix/Documents/Corpus/corpus pan10/VocabularioLinea.txt"; //RUTA MAC
			File nombreArchivoDestino = new File(rutaArchivoDestino);
			if(nombreArchivoDestino.exists())
			{
				nombreArchivoDestino.delete();
			}
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(nombreArchivoDestino));
				//bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivoDestino), "UTF8"));
				//bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivo)));
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			arch.CrearVocabularioLinea(nombreArchivo, nombreArchivoDestino);
		}
		
		totalTiempo = System.currentTimeMillis() - tiempoInicio;
		
		System.out.println("Tiempo demorado: " + (float) totalTiempo/1000 + " Segundos.");
	}

}
