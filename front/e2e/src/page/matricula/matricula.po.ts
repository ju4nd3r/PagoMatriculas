import { browser, by, element } from 'protractor';

export class MatriculaPage {
    private linkCrearMatricula = element(by.id('linkCrearMatricula'));
    private linkListarMatriculas = element(by.id('linkListarMatricula'));
    private selectOfertaAcademica = element(by.id('ofertaAcademicaId'));
    private inputUsuarioId = element(by.id('usuarioId'));
    private buttonCrearMatricula = element(by.id('crearMatricula'));

    async clickLinkCrearMatricula() {
        await this.linkCrearMatricula.click();
    }

    async clickLinkListarUsuarios() {
        await this.linkListarMatriculas.click();
    }

    async seleccionarOfertaAcademica(ofertaAcademicaId) {
        await this.selectOfertaAcademica.$(`[value="${ofertaAcademicaId}"]`).click();
    }

    async ingresarUsuarioId(IdUsuario) {
        await this.inputUsuarioId.sendKeys(IdUsuario);
    }

    async clickBotonCrearMatricula() {
        await this.buttonCrearMatricula.click();
    }

    alertaTexto = function () {
        return browser.switchTo().alert().getText();
    }
    
    alertaAceptar = function () {
        browser.switchTo().alert().accept();
    }


    sleep = function (tiempo) {
        browser.sleep(tiempo);
    }



}