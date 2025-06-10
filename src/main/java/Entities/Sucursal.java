package Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.LinkedHashSet;

@Data
@NoArgsConstructor
@SuperBuilder

public class Sucursal extends Base {

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Empresa empresa;
    private Domicilio domicilio;
    private LinkedHashSet<Promocion> promociones = new LinkedHashSet<>();
    private LinkedHashSet<Categoria> categorias = new LinkedHashSet<>();


    public Sucursal(String nombre, LocalTime horarioApertura, LocalTime horarioCierre) {
        this.nombre = nombre;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void agregarPromocion(Promocion promocion) {
        promociones.add(promocion);
    }

}

