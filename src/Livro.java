
public class Livro {
	
	private String _titulo, _autor;
	private int _numCatalogo;
	boolean isAvaliable = true;
	String ultimoUsuario;
	String dataUltimoEmprestimo;
	
	public void addInfoLivro(String titulo, String autor, int numCatalogo){
		_titulo = titulo;
		_autor = autor;
		_numCatalogo = numCatalogo;
	}
	
	public boolean registrarEmprestimo(String userName, String data){
		if(isAvaliable){
			ultimoUsuario = userName;
			dataUltimoEmprestimo = data;
			isAvaliable = false;
			return true;
		}
		else
			return false;
	}
	
	public void registrarDevolucao(){
		isAvaliable = true;
	}
	
	public int getNumCatalogo(){
		return _numCatalogo;
	}
	
	public String getTitle(){
		return _titulo;
	}
	
	public boolean isAvaliable(){
		return isAvaliable;
	}
	
	public String getUltimoUsuario(){
		return ultimoUsuario;
	}
}
