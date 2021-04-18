import { by, element } from 'protractor';

export class NavbarPage {
    linkHome = element(by.xpath('/html/body/app-root/app-navbar/nav/a[1]'));
    linkProducto = element(by.xpath('/html/body/app-root/app-navbar/nav/a[2]'));
    linkUsuario = element(by.xpath('/html/body/app-root/app-navbar/nav/a[3]'));
    linkOfertaAcademica = element(by.xpath('/html/body/app-root/app-navbar/nav/a[4]'));
    linkMatricula = element(by.xpath('/html/body/app-root/app-navbar/nav/a[5]'));

    async clickBotonProductos() {
        await this.linkProducto.click();
    }

    async clickBotonUsuario() {
        await this.linkUsuario.click();
    }

    async clickBotonOfertaAcademica() {
        await this.linkOfertaAcademica.click();
    }

    async clickBotonMatricula() {
        await this.linkMatricula.click();
    }


}
