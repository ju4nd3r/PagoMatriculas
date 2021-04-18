import { browser, by, element } from 'protractor';

export class OfertaAcademicaPage {
    private linkCrearOfertaAcademica = element(by.id('linkCrearOfertaAcademica'));
    private linkListarOfertasAcademicas = element(by.id('linkListarOfertasAcademicas'));
    private inputNivelAcademico = element(by.id('nivelAcademico'));
    private inputFechaLimitePago = element(by.id('fechaLimitePago'));
    private inputValor = element(by.id('valor'));
    private buttonCrearOfertaAcademica = element(by.id('crearOfertaAcademica'));
    private listaOfertasAcademicas = element.all(by.css('ul.ofertas-academicas li'));

    async clickLinkCrearOfertaAcademica() {
        await this.linkCrearOfertaAcademica.click();
    }

    async clickLinkListarOfertasAcademicas() {
        await this.linkListarOfertasAcademicas.click();
    }

    async ingresarNivelAcademico(nivelAcademico) {
        await this.inputNivelAcademico.sendKeys(nivelAcademico);
    }

    async ingresarFechaLimitePago(fechaLimitePago) {
        await this.inputFechaLimitePago.sendKeys(fechaLimitePago);
    }

    async ingresarValor(valor) {
        await this.inputValor.sendKeys(valor);
    }

    async clickBotonCrearOfertaAcademica() {
        await this.buttonCrearOfertaAcademica.click();
    }

    async contarOfertasAcademicas() {
        return this.listaOfertasAcademicas.count();
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