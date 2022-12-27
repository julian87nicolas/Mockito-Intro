import org.junit.*;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServicioTest {

    @Mock
    private UsuarioRepositorio usuarioRepositorio;  // Dependencia
    @InjectMocks
    private UsuarioServicio usuarioServicio;        // Dependiente
    @Test
    public void dadoUsuarioParaCrearEsperamosUnUsuarioCreado(){
        UsuarioDto esperado = new UsuarioDto(1L, "Prueba");
        UsuarioDto incorrecto = new UsuarioDto(2L, "Pruebas");

        Mockito.when(usuarioRepositorio.crearUsuario("Prueba"))
                .thenReturn(esperado);

        final UsuarioDto resultado = usuarioServicio.crearUsuario("Prueba");

        Assert.assertEquals(esperado.id, resultado.id);
        Assert.assertEquals(esperado.name, resultado.name);
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void testObtenerUsuarioConMockito() {
        UsuarioDto objetoSimulado = new UsuarioDto(1L, "Juan");
        UsuarioDto esperado = new UsuarioDto(1L, "Juan");

        Mockito.when(usuarioRepositorio.obtenerUsuario(1L))
                .thenReturn(esperado);

        final UsuarioDto resultado = usuarioServicio.obtenerUsuario(1L);
        Assert.assertEquals(esperado, resultado);
        Mockito.verify(usuarioRepositorio).obtenerUsuario(1L);
    }
}
