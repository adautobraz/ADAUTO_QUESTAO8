import java.util.HashMap;

public class Usuario {
	
	private String _nome;
	private HashMap<Integer, String> historico = new HashMap<Integer, String>();
	
	public void borrowLivro(int numCatalogo, String data){
		historico.put(numCatalogo, data);
	}
	
	public String getName(){
		return _nome;
	}
	
	public Usuario(String nome) {
		_nome = nome;
	}

}
