import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { UsuarioPage } from '../page/usuario/usuario.po';

describe('workspace-project Usuario', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let usuario: UsuarioPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        usuario = new UsuarioPage();
    });

    it('Deberia crear Usuario', () => {
        const ID_USUARIO = '1098123456';
        const NOMBRE_USUARIO = 'Usuario de pruebas';

        page.navigateTo();
        navBar.clickBotonUsuario();
        usuario.clickLinkCrearUsuario();
        usuario.sleep(3000);
        usuario.ingresarId(ID_USUARIO);
        usuario.ingresarNombre(NOMBRE_USUARIO);
        usuario.clickBotonCrearUsuario();
        usuario.sleep(3000);
        

        expect(usuario.alertaTexto()).toEqual('Se creó el usuario correctamente');
        usuario.alertaAceptar();
        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
    });

    it('Deberia listar usuarios', () => {
        page.navigateTo();
        navBar.clickBotonUsuario();
        usuario.clickBotonListarUsuarios();

        expect(1).toBe(usuario.contarUsuarios());
    });
});
