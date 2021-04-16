export class Matricula {
    usuarioId: number;
    ofertaAcademicaId: number;

    constructor(usuarioId: number, ofertaAcademicaId: number) {
        this.usuarioId = usuarioId;
        this.ofertaAcademicaId = ofertaAcademicaId;
    }
}