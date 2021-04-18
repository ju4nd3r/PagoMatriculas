import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { MatriculaPage } from '../page/matricula/matricula.po';

describe('workspace-project Matricula', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let matricula: MatriculaPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        matricula = new MatriculaPage();
    });

    it('Deberia crear Matricula', () => {
        const ID_USUARIO = '1098123456';
        const OFERTA_ACADEMICA_ID = '1';

        page.navigateTo();
        navBar.clickBotonMatricula();
        matricula.clickLinkCrearMatricula();
        matricula.sleep(3000);
        matricula.ingresarUsuarioId(ID_USUARIO);
        matricula.seleccionarOfertaAcademica(OFERTA_ACADEMICA_ID);
        matricula.clickBotonCrearMatricula();
        matricula.sleep(3000);
        

        expect(matricula.alertaTexto()).toEqual('Se creó la matricula correctamente');
        matricula.alertaAceptar();
        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
    });

    
});
