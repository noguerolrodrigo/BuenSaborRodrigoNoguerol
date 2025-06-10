package DAO;

import Entities.Empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpresaDAO {
    private List<Empresa> empresas = new ArrayList<>();

    public void guardar(Empresa empresa) {
        empresas.add(empresa);
    }

    public List<Empresa> obtenerTodas() {
        return empresas;
    }

    public Optional<Empresa> buscarPorCuil(Integer cuil) {
        return empresas.stream()
                .filter(e -> e.getCuil().equals(cuil))
                .findFirst();
    }

    public boolean eliminarPorCuil(Integer cuil) {
        return empresas.removeIf(e -> e.getCuil().equals(cuil));
    }
}