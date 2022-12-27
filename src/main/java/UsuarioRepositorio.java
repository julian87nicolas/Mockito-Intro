public interface UsuarioRepositorio {
    UsuarioDto crearUsuario(String nombre);

    UsuarioDto obtenerUsuario(long id);
}
