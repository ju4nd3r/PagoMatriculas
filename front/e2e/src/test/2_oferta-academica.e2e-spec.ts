import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { OfertaAcademicaPage } from '../page/oferta-academica/oferta-academica.po';

describe('workspace-project Oferta Academica', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let ofertaAcademica: OfertaAcademicaPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        ofertaAcademica = new OfertaAcademicaPage();
    });

    it('Deberia crear Oferta Academica', () => {
        const NIVEL_ACADEMICO = 'Secundaria';
        const FECHA_LIMITE_PAGO = '05/04/2021';
        const VALOR = 50000;

        page.navigateTo();
        navBar.clickBotonOfertaAcademica();
        ofertaAcademica.clickLinkCrearOfertaAcademica();
        ofertaAcademica.sleep(3000);
        ofertaAcademica.ingresarNivelAcademico(NIVEL_ACADEMICO);
        ofertaAcademica.ingresarFechaLimitePago(FECHA_LIMITE_PAGO);
        ofertaAcademica.ingresarValor(VALOR);
        ofertaAcademica.clickBotonCrearOfertaAcademica();
        ofertaAcademica.sleep(3000);
        

        expect(ofertaAcademica.alertaTexto()).toEqual('Se creó la oferta academica correctamente');
        ofertaAcademica.alertaAceptar();
        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
    });

    it('Deberia listar Ofertas Academicas', () => {
        page.navigateTo();
        navBar.clickBotonOfertaAcademica();
        ofertaAcademica.clickLinkListarOfertasAcademicas();

        expect(1).toBe(ofertaAcademica.contarOfertasAcademicas());
    });
});
