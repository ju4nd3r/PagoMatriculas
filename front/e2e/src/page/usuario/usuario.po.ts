import { browser, by, element } from 'protractor';

export class UsuarioPage {
    private linkCrearUsuario = element(by.id('linkCrearUsuario'));
    private linkListarUsuarios = element(by.id('linkListarUsuario'));
    private inputIdUsuario = element(by.id('idUsuario'));
    private inputNombreUsuario = element(by.id('nombreUsuario'));
    private buttonCrearUsuario = element(by.id('crearUsuario'));
    private listaUsuarios = element.all(by.css('ul.usuarios li'));

    async clickLinkCrearUsuario() {
        await this.linkCrearUsuario.click();
    }

    async clickBotonListarUsuarios() {
        await this.linkListarUsuarios.click();
    }

    async ingresarId(IdUsuario) {
        await this.inputIdUsuario.sendKeys(IdUsuario);
    }

    async ingresarNombre(nombreUsuario) {
        await this.inputNombreUsuario.sendKeys(nombreUsuario);
    }

    async clickBotonCrearUsuario() {
        await this.buttonCrearUsuario.click();
    }

    async contarUsuarios() {
        return this.listaUsuarios.count();
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