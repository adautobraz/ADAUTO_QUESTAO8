import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
	
	private String _nome;
	private int idCatalogo = 0;
	private ArrayList<Livro> listaLivros = new ArrayList<Livro>();
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private HashMap<Usuario,Integer> usuariosBloqueados = new HashMap<Usuario, Integer>();

	public Biblioteca(String nome) {
		_nome = nome;
	}
	
	public void registrarEmprestimo(Usuario user, String titulo, String data){
		boolean found = false;
		int i;
		for(i=0; i<listaLivros.size() && !found; i++){
			if(listaLivros.get(i).getTitle() == titulo)
				found = true;
		}
		i--;
		if(found){
			Livro livro = listaLivros.get(i);
			user.borrowLivro(livro.getNumCatalogo(), data);
			livro.registrarEmprestimo(user.getName(), data);
		}
		else
			System.out.println("Livro não consta nos registros");
	}
	
	public void registrarDevoluacao(String titulo){
		boolean found = false;
		int i;
		for(i=0; i<listaLivros.size() && !found; i++){
			if(listaLivros.get(i).getTitle() == titulo)
				found = true;
		}
		i--;
		if(found){
			Livro livro = listaLivros.get(i);
			livro.registrarDevolucao();
		}
	}	
	
	public void addLivro(String titulo, String autor){
		Livro livro = new Livro();
		livro.addInfoLivro(titulo, autor, idCatalogo++);
		listaLivros.add(livro);
	}
	
	public void addUsuario(Usuario novoUsuario){
		listaUsuarios.add(novoUsuario);
	}
	
	public void blockUsuario(Usuario user, int dias){
		usuariosBloqueados.put(user, dias);
	}
	
	public void regularizarUsuario(Usuario user){
		usuariosBloqueados.remove(user);
	}
	
	public void removeUsuario(Usuario user){
		listaUsuarios.remove(user);
		usuariosBloqueados.remove(user);
	}
	
	public boolean usuarioCadastrado(Usuario user){
		return listaUsuarios.contains(user);
	}
	
	public boolean usuarioRegularizado(Usuario user){
		return !usuariosBloqueados.containsKey(user);
	}

	public boolean livroDisponivel(String titulo) {
		boolean found = false;
		int i;
		for(i=0; i<listaLivros.size() && !found; i++){
			if(listaLivros.get(i).getTitle() == titulo)
				found = true;
		}
		i--;
		if(found){
			Livro livro = listaLivros.get(i);
			return livro.isAvaliable();
		}
		return false;
	}
	
	
}
