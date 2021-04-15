export class OfertaAcademica {
    ofertaAcademicaId : number;
    nivelAcademico: string;
    fechaLimitePago: Date;
    fechaExtraordinariaPago: Date;
    valor: number;

    constructor(ofertaAcademicaId : number, nivelAcademico: string, fechaLimitePago: Date,fechaExtraordinariaPago: Date, valor: number) {
        this.ofertaAcademicaId = ofertaAcademicaId;
        this.nivelAcademico = nivelAcademico;
        this.fechaLimitePago = fechaLimitePago;
        this.fechaExtraordinariaPago = fechaExtraordinariaPago;
        this.valor = valor;
    }
}